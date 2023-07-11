package safeP4R

import p4.v1.p4runtime.FieldMatch
import p4.v1.p4runtime.TableAction
import com.google.protobuf.ByteString
import p4.v1.p4runtime.FieldMatch.FieldMatchType
import p4.v1.p4runtime.Action
import p4.v1.p4runtime.Action.Param
import p4.v1.p4runtime.P4RuntimeGrpc.P4RuntimeStub
import io.grpc.stub.StreamObserver
import p4.v1.p4runtime.ReadRequest
import p4.v1.p4runtime.ReadResponse
import p4.v1.p4runtime.Entity
import p4.v1.p4runtime.WriteRequest
import p4.v1.p4runtime.Update
import p4.v1.p4runtime.Uint128
import scala.concurrent.Await
import scala.concurrent.duration.FiniteDuration
import scala.concurrent.duration.SECONDS
import io.grpc.ManagedChannel

type Wildcard = "*"

case class Exact(v : ByteString)
case class LPM(v : ByteString, pl : Int)
case class Range(l : ByteString, h : ByteString)
case class Ternary(v : ByteString, m : ByteString)
case class Optional(v : ByteString)

type MatchFieldType = Exact | LPM | Range | Ternary | Optional

def matchFieldToProto(fieldId : Int, mf : MatchFieldType) : FieldMatch =
  mf match
    case Exact(v)      => FieldMatch(fieldId, FieldMatchType.Exact(FieldMatch.Exact(value = v)))
    case LPM(v, pl)    => FieldMatch(fieldId, FieldMatchType.Lpm(FieldMatch.LPM(value = v, prefixLen = pl)))
    case Range(l, h)   => FieldMatch(fieldId, FieldMatchType.Range(FieldMatch.Range(low = l, high = h)))
    case Ternary(v, m) => FieldMatch(fieldId, FieldMatchType.Ternary(FieldMatch.Ternary(value = v, mask = m)))
    case Optional(v)   => FieldMatch(fieldId, FieldMatchType.Optional(FieldMatch.Optional(value = v)))

def double (x : Int) = x * 2

def hmm(x : Option[Int]) : Seq[Int] =
  x.map(double(_)).toSeq

case class TableEntry [TM[_], TA[_], TP[_], XN, XA <: TA[XN]] private (table : XN, matches : TM[XN], action : XA, params : TP[XA], priority : Int)

object TableEntry:
  def apply[TM[_], TA[_], TP[_]] (table : String, matches : TM[table.type], action : TA[table.type], params : TP[action.type], priority : Int) : TableEntry[TM, TA, TP, table.type, action.type] =
    TableEntry[TM, TA, TP, table.type, action.type](table, matches, action, params, priority)

abstract class Chan[TM[_], TA[_], TP[_]] (deviceId : Int, socket : P4RuntimeStub, channel : ManagedChannel):
  def getDeviceId() : Int = deviceId
  def getSocket() : P4RuntimeStub = socket
  def toProto(te : TableEntry[TM, TA, TP, _, _]) : p4.v1.p4runtime.TableEntry
  def fromProto[TM[_], TA[_], TP[_], XN <: String, XA <: TA[XN]](te : p4.v1.p4runtime.TableEntry) : TableEntry[TM, TA, TP, XN, XA]
  def disconnect() : Unit =
    channel.shutdownNow()

class SafeP4RRuntimeObserver[O](lock : Object) extends StreamObserver[O] {
  private var log : Seq[O] = Seq()
  def getLog() : Seq[O] = log
  override def onNext(value: O): Unit =
    log = log :+ value
  override def onCompleted(): Unit =
    lock.synchronized {
      lock.notify()
    }
  override def onError(t: Throwable): Unit =
    print("[ERROR] " + t.toString() + "\n")
}

def read[TM[_], TA[_], TP[_]]
  (c : Chan[TM, TA, TP], tableEntry : TableEntry[TM, TA, TP, _, _]) : Seq[TableEntry[TM, TA, TP, _, _]] =
  val lock = Object()
  val read_observer = new SafeP4RRuntimeObserver[p4.v1.p4runtime.ReadResponse](lock)
  c.getSocket().read(
    request = ReadRequest(
      deviceId = c.getDeviceId(),
      entities = List(
        Entity (
          entity = Entity.Entity.TableEntry(c.toProto(tableEntry))
        )
      )
    ),
    read_observer
  )
  lock.synchronized {
    lock.wait()
  }
  read_observer.getLog().last.entities.foldLeft(List[TableEntry[TM, TA, TP, _, _]]())((acc, e) => {
    e.entity.tableEntry match
      case None => acc
      case Some(te) => acc :+ c.fromProto(te)
  })

def write [TM[_], TA[_], TP[_]]
  (c : Chan[TM, TA, TP], tableEntry : TableEntry[TM, TA, TP, _, _], ut : Update.Type) : Boolean =
  val resp = c.getSocket().write(WriteRequest(
    deviceId = c.getDeviceId(),
    electionId = Some(Uint128(high=0,low=1)),
    updates = List(Update(
      `type` = ut,
      entity = Some(Entity(
        entity = Entity.Entity.TableEntry(
          value = c.toProto(tableEntry)
        )
      ))
    ))
  ))
  try
    Await.ready(resp, FiniteDuration(10, SECONDS))
    true
  catch
    case _ =>
      false

def insert [TM[_], TA[_], TP[_]]
  (c : Chan[TM, TA, TP], tableEntry : TableEntry[TM, TA, TP, _, _]) : Boolean =
  write(c, tableEntry, Update.Type.INSERT)

def modify [TM[_], TA[_], TP[_]]
  (c : Chan[TM, TA, TP], tableEntry : TableEntry[TM, TA, TP, _, _]) : Boolean =
  write(c, tableEntry, Update.Type.MODIFY)

def delete [TM[_], TA[_], TP[_]]
  (c : Chan[TM, TA, TP], tableEntry : TableEntry[TM, TA, TP, _, _]) : Boolean =
  write(c, tableEntry, Update.Type.DELETE)

def bytes (a : Byte*) : ByteString = ByteString.copyFrom(a.toArray)
