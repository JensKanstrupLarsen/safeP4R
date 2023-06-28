package switchTypes1

import genericFP4.{FP4_Exact, FP4_LPM, FP4_Optional, FP4_Range, FP4_Ternary, FP4TableEntry}
import com.google.protobuf.ByteString
import p4.v1.p4runtime.FieldMatch
import p4.v1.p4runtime.FieldMatch.FieldMatchType
import p4.v1.p4runtime.TableAction
import p4.v1.p4runtime.Action
import p4.v1.p4runtime.P4RuntimeGrpc.P4RuntimeStub
import p4.v1.p4runtime.TableEntry
import io.grpc.ManagedChannelBuilder
import p4.v1.p4runtime.StreamMessageRequest
import p4.v1.p4runtime.MasterArbitrationUpdate
import p4.v1.p4runtime.Uint128
import io.grpc.CallOptions
import apiFP4.FP4RuntimeObserver
import p4.v1.p4runtime.StreamMessageResponse
/*
import Console.print
import scala.io.Source._
import zio._
//import zio.Console._
import scalapb.zio_grpc.{ServerMain, ServiceList}
import p4.v1.p4runtime.*
//import p4.v1.p4runtime.ZioP4Runtime.*
import zio.stream.ZStream
import p4.v1.p4runtime.GetForwardingPipelineConfigRequest.ResponseType.ALL
import p4.v1.p4runtime.FieldMatch.FieldMatchType
import com.google.protobuf.ByteString
import org.checkerframework.checker.guieffect.qual.UI
import p4.v1.p4runtime.ZioP4Runtime.P4RuntimeClient.ZService
import p4.v1.p4runtime.DigestEntry.Config
import p4.config.v1.p4types.P4DataTypeSpec.TypeSpec.Bool
import p4.v1.p4runtime.P4RuntimeGrpc.P4RuntimeStub
import io.grpc.stub.StreamObserver
import io.grpc.CallOptions
import concurrent.ExecutionContext.Implicits.global
import p4.config.v1.p4info.P4Info
import scala.util.Success
import scala.util.Failure
import java.io.FileInputStream
import java.io.InputStreamReader
import com.google.protobuf.TextFormat
import p4.config.v1.p4info.P4InfoProto
import com.google.protobuf.CodedInputStream
import com.google.protobuf.CodedOutputStream
import java.io.OutputStream
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import scalapb.json4s.{JsonFormat, Parser}
import org.json4s.Reader
import p4.config.v1.p4info.{Action => P4InfoAction, _}
import p4.config.v1.p4info.MatchField.MatchType.EXACT
import p4.config.v1.p4info.MatchField.MatchType.LPM
import p4.config.v1.p4info.MatchField.MatchType.OPTIONAL
import p4.config.v1.p4info.MatchField.MatchType.RANGE
import p4.config.v1.p4info.MatchField.MatchType.TERNARY
import p4.config.v1.p4info.Action.Param
import p4.v1.p4runtime.GetForwardingPipelineConfigRequest.ResponseType
import scala.compiletime.ops.string
import scala.concurrent.Await
import scala.concurrent.duration.SECONDS
import scala.concurrent.duration.FiniteDuration
*/

// ===========================================================


// ===========================================================
//type FP4TableName = "MyIngress.ipv4_lpm" | "MyIngress.myTunnel_exact" | genericFP4.Wildcard

// ===========================================================
  /*
case class FP4Table[XN <: String](name : XN) extends genericFP4.FP4Table:
  def toProto() : Int = ???
  def fromProto(tableId : Int) : FP4Table[XN] = ???

case class FP4MatchFields[XN <: String](params : FP4TableMatchFields[XN]) extends genericFP4.FP4MatchFields:
  def toProto() = ???
  def fromProto(matches : Seq[FieldMatch]) = ???
/*
  def toProto() =
    params match
      case (x0 : Option[genericFP4.MatchField[1,"hdr.ipv4.dstAddr",FP4_LPM]]) => x0.map(_.toProto()).toList
      case (x0 : genericFP4.MatchField[1,"hdr.myTunnel.tunnelId",FP4_Exact]) => List(x0.toProto())
      case _ => List()
  def fromProto(params : List[p4.v1.p4runtime.FieldMatch]) =
    params match
      case List(x0) =>
        x0.fieldId match
          case 1 =>
            x0.matchType match
              case p4.v1.p4runtime.MatchField.MatchType.LPM =>
                FP4MatchFields(Some(genericFP4.MatchField[1,"hdr.ipv4.dstAddr",FP4_LPM](x0.lpm)))
              case p4.v1.p4runtime.MatchField.MatchType.EXACT =>
                FP4MatchFields(genericFP4.MatchField[1,"hdr.myTunnel.tunnelId",FP4_Exact](x0.exact))
              case _ => FP4MatchFields(None)
          case _ => FP4MatchFields(None)
      case _ => FP4MatchFields(None)
*/

case class FP4Action[XN <: String, XA <: String](name : XA & FP4TableAction[XN]) extends genericFP4.FP4Action:
  def toProto() = ???
  def fromProto(actionId : Int) = ??? /*
    name match
      case "MyIngress.ipv4_forward" =>
        val (x0,x1) = params
        p4.v1.p4runtime.Action(
          actionId = 0,
          params = List(
            p4.v1.p4runtime.Action.Param(paramId = 0, value = x0),
            p4.v1.p4runtime.Action.Param(paramId = 1, value = x1)
          )
        )
      case "MyIngress.myTunnel_ingress" =>
        val x0 = params
        p4.v1.p4runtime.Action(
          actionId = 1,
          params = List(
            p4.v1.p4runtime.Action.Param(paramId = 0, value = x0)
          )
        )
      case "MyIngress.drop" =>
        p4.v1.p4runtime.Action(
          actionId = 2,
          params = List()
        )
      case "NoAction" =>
        p4.v1.p4runtime.Action(
          actionId = 3,
          params = List()
        )
      case "MyIngress.myTunnel_forward" =>
        val x0 = params
        p4.v1.p4runtime.Action(
          actionId = 4,
          params = List(
            p4.v1.p4runtime.Action.Param(paramId = 0, value = x0)
          )
        )
      case "MyIngress.myTunnel_egress" =>
        val (x0,x1) = params
        p4.v1.p4runtime.Action(
          actionId = 5,
          params = List(
            p4.v1.p4runtime.Action.Param(paramId = 0, value = x0),
            p4.v1.p4runtime.Action.Param(paramId = 1, value = x1)
          )
        )
      case _ => p4.v1.p4runtime.Action() */

case class FP4Params[XA <: String](params : FP4ActionParams[XA]) extends genericFP4.FP4Params:
  def toProto() = ???
  def fromProto(params : Seq[Action.Param]) = ???
// ===========================================================*/
/*
case class `NoAction`()
case class `MyIngress.drop`()
case class `MyIngress.ipv4_forward`(`dstAddr` : ByteString, `port` : ByteString)
case class `MyIngress.myTunnel_ingress`(`dst_id` : ByteString)
case class `MyIngress.myTunnel_forward`(`port` : ByteString)
case class `MyIngress.myTunnel_egress`(`dstAddr` : ByteString, `port` : ByteString)
*/



/*
case class FP4TableName[TN <: FP4TableNameString](name : TN) extends genericFP4.FP4TableName:
  def toProto() =
    name match
      case "MyIngress.ipv4_lpm" => 0
      case "MyIngress.myTunnel_exact" => 1
  def fromProto(id : Int) =
    id match
      case 0 => FP4TableName("MyIngress.ipv4_lpm")
      case 1 => FP4TableName("MyIngress.myTunnel_exact")
import FP4TableName.*

type FP4TableMatchField[TN <: FP4TableNameString] =
  TN match
    case "MyIngress.ipv4_lpm" => (Option[FP4_LPM[1]])
    case "MyIngress.myTunnel_exact" => (FP4_Exact[1])

case class FP4MatchFields[TN <: FP4TableNameString] (params : FP4TableMatchField[TN]) extends genericFP4.FP4MatchFields:
  def toProto() =
    params match
      case (x0 : Option[FP4_LPM[1]]) => List(x0.get.toProto())
      case (x0 : FP4_Exact[1]) => List(x0.toProto())
      case (_,_) => List()
  def fromProto(matches : Seq[FieldMatch]) : FP4MatchFields[TN] =
    params match
      case (x0 : Option[FP4_LPM[1]]) => FP4MatchFields[TN](Some(`FP4_LPM`[1](1, matches(0).getLpm.value, matches(0).getLpm.prefixLen)).asInstanceOf[FP4TableMatchField[TN]])
      case (x0 : FP4_Exact[1]) => FP4MatchFields[TN](`FP4_Exact`[1](1, matches(0).getExact.value).asInstanceOf[FP4TableMatchField[TN]])

class FP4Action() extends genericFP4.FP4Action:
  def toProto() : TableAction = TableAction()
  def fromProto(action : Action) : FP4Action =
    action.actionId match
      case 21257015 => `NoAction`()
      case 25652968 => `MyIngress.drop`()
      case 28792405 => `MyIngress.ipv4_forward`(action.params(0).value, action.params(1).value)
      case 28800041 => `MyIngress.myTunnel_ingress`(action.params(0).value)
      case _ => `NoAction`()

case class `NoAction`() extends FP4Action:
  override def toProto() =
    TableAction(TableAction.Type.Action(p4.v1.p4runtime.Action(
      actionId = 21257015,
      params = List()
    )))

case class `MyIngress.drop`() extends FP4Action:
  override def toProto() =
    TableAction(TableAction.Type.Action(p4.v1.p4runtime.Action(
      actionId = 25652968,
      params = List()
    )))

case class `MyIngress.ipv4_forward`(`dstAddr` : ByteString, `port` : ByteString) extends FP4Action:
  override def toProto() =
    TableAction(TableAction.Type.Action(p4.v1.p4runtime.Action(
      actionId = 28792405,
      params = List(
        Action.Param(
          paramId = 1,
          value = `dstAddr`
        ),
        Action.Param(
          paramId = 2,
          value = `port`
        ))
    )))

case class `MyIngress.myTunnel_ingress`(`dst_id` : ByteString) extends FP4Action:
  override def toProto() =
    TableAction(TableAction.Type.Action(p4.v1.p4runtime.Action(
      actionId = 24181246,
      params = List(
        Action.Param(
          paramId = 1,
          value = `dst_id`
        ))
    )))

case class `MyIngress.myTunnel_forward`(`port` : ByteString) extends FP4Action:
  override def toProto() =
    TableAction(TableAction.Type.Action(p4.v1.p4runtime.Action(
      actionId = 27454791,
      params = List(
        Action.Param(
          paramId = 1,
          value = `port`
        ))
    )))

case class `MyIngress.myTunnel_egress`(`dstAddr` : ByteString, `port` : ByteString) extends FP4Action:
  override def toProto() =
    TableAction(TableAction.Type.Action(p4.v1.p4runtime.Action(
      actionId = 33029817,
      params = List(
        Action.Param(
          paramId = 1,
          value = `dstAddr`
        ),

        Action.Param(
          paramId = 2,
          value = `port`
        ))
    )))

type FP4TableAction[TN <: FP4TableNameString] <: FP4Action =
  TN match
    case "MyIngress.ipv4_lpm" => `MyIngress.ipv4_forward` | `MyIngress.myTunnel_ingress` | `MyIngress.drop` | `NoAction`
    case "MyIngress.myTunnel_exact" => `MyIngress.myTunnel_forward` | `MyIngress.myTunnel_egress` | `NoAction`

*/

/*
type IdTableMatch[I <: Int] <: FP4TableName =
  I match
    case 37375156 => `MyIngress.ipv4_lpm`.type
    case 35862311 => `MyIngress.myTunnel_exact`.type

def fromProtoTableName(tableId : Int) : FP4TableName =
  tableId match
    case 37375156 => `MyIngress.ipv4_lpm`
    case 35862311 => `MyIngress.myTunnel_exact`

def fromProtoMatchFields(table : FP4TableName, matches : Seq[FieldMatch]) : FP4TableMatchField[table.type] =
  table match
    case `MyIngress.ipv4_lpm` => (Some(`FP4_LPM`[1](1, matches(0).getLpm.value, matches(0).getLpm.prefixLen)).asInstanceOf[FP4TableMatchField[table.type]])
    case `MyIngress.myTunnel_exact` => (`FP4_Exact`[1](1, matches(0).getExact.value).asInstanceOf[FP4TableMatchField[table.type]])

def fromProtoAction(action : p4.v1.p4runtime.Action) : FP4Action =
  action.actionId match
    case 21257015 => `NoAction`()
    case 25652968 => `MyIngress.drop`()
    case 28792405 => `MyIngress.ipv4_forward`(action.params(0).value, action.params(1).value)
    case 24181246 => `MyIngress.myTunnel_ingress`(action.params(0).value)
    case 27454791 => `MyIngress.myTunnel_forward`(action.params(0).value)
    case 33029817 => `MyIngress.myTunnel_egress`(action.params(0).value, action.params(1).value)

def fromProtoTableEntry(tableId : Int, matches : Seq[FieldMatch], action : p4.v1.p4runtime.Action) : FP4TableEntry[IdTableMatch[tableId.type]] = (
  fromProtoTableName(tableId).asInstanceOf[IdTableMatch[tableId.type]],
  fromProtoMatchFields(fromProtoTableName(tableId), matches).asInstanceOf[FP4TableMatchField[IdTableMatch[tableId.type]]],
  fromProtoAction(action).asInstanceOf[FP4TableAction[IdTableMatch[tableId.type]]]
)

// ===========================================================
// ===========================================================
*/


/*
object P4RuntimeTester extends zio.ZIOAppDefault {
  val conn = P4RuntimeClient.streamChannel(
        ZStream(
          StreamMessageRequest(
            StreamMessageRequest.Update.Arbitration(
              value = MasterArbitrationUpdate(
                deviceId = 0,
                electionId = Some(Uint128(high=0,low=42)),
                role = Some(Role(0,"one",None))
              )
            )
          )
        ))

  val clientLayer: Layer[Throwable, P4RuntimeClient] =
    P4RuntimeClient.live(
      ZManagedChannel(
        ManagedChannelBuilder.forAddress("127.0.0.1", 50051).usePlaintext()
      )
    )

  def myAppLogic : ZIO[ZService[Any, Any], Object, Unit]=
    for {
      _ <- conn.take(0).foreach(x => printLine(x))
//      _ <- writeFromClient(0, List(updateTableEntry(100),updateTableEntry(200)))
//      _ <- writeFromClient(1, List(updateTableEntry(100),updateTableEntry(200)))
    } yield ()

  final def run =
    myAppLogic.provideLayer(clientLayer)
}


//def buildWriteRequest()

def buildTableAction(action_id : Int, params : List[(Int, ByteString)]) =
  Some(TableAction(
    `type` = TableAction.Type.Action(
      value = p4.v1.p4runtime.Action(
        actionId = action_id,
        params.map((pid, v) =>
          p4.v1.p4runtime.Action.Param(
            paramId = pid,
            value = v
          ))
      )
    )
  ))
*/

/*
enum FieldMatchType:
  case Exact
  case Ternary
  case LPM
  case Range
  case Optional
import FieldMatchType.*

type FieldMatchParams[T <: FieldMatchType] =
  T match
    Exact    => ByteString
    Ternary  => (ByteString, ByteString)
    LPM      => (ByteString, Int)
    Range    => (ByteString, ByteString)
    Optional => ByteString


def buildFieldMatch
  FieldMatch(
        fieldId = 1,
        fieldMatchType = FieldMatchType.Exact(
          value = FieldMatch.Exact(
            value = src_ip_addr
          )
        )
      ),

def writeFromClient(device_id : Int, upds : List[Update]) : WriteRequest =//ZIO[P4RuntimeClient.ZService[Any, Any], io.grpc.Status, Unit] =
  WriteRequest(
    deviceId = device_id,
    electionId = Some(Uint128(high=0,low=42)),
    role="one",
    updates = upds
  )

def updateTableEntry(writeType : Update.Type, src_ip_addr : ByteString, tunnel_id : Int, dst_ip_addr : ByteString, dst_eth_addr : ByteString) : Update =
  Update(
    `type` = writeType,
    entity = Some(
      Entity(
        entity = Entity.Entity.TableEntry(
          value = actualTableEntry(src_ip_addr, tunnel_id, dst_ip_addr, dst_eth_addr)
        )
      )
    )
  )

TableEntry(
  37375156,
  List(
    FieldMatch(
      1,
      Lpm(
        LPM(
          <ByteString@6d8c63e size=4 contents="\n\000\002\002">,
          32,
          UnknownFieldSet(Map())
        )
      ),
      UnknownFieldSet(Map())
    )
  ),
  Some(
    TableAction(
      Action(
        Action(
          24181246,
          List(
            Param(
              1,
              <ByteString@4cc4bc73 size=1 contents="d">,
              UnknownFieldSet(Map())
            )
          ),
          UnknownFieldSet(Map())
        )
      ),
      UnknownFieldSet(Map())
    )
  ),
  0,
  0,
  None,
  None,
  None,
  false,
  0,
  None,
  <ByteString@2c2bf681 size=0 contents="">,
  UnknownFieldSet(Map())
)

def actualTableEntry(src_ip_addr : ByteString, tunnel_id : Int, dst_ip_addr : ByteString, dst_eth_addr : ByteString) : TableEntry =
  TableEntry(
    tableId = 37375156,
    `match` = List(
      FieldMatch(
        fieldId = 1,
        fieldMatchType = FieldMatchType.Exact(
          value = FieldMatch.Exact(
            value = src_ip_addr
          )
        )
      ),
      FieldMatch(
        fieldId = 2,
        fieldMatchType = FieldMatchType.Lpm(
          value = FieldMatch.LPM(
            value = dst_ip_addr,
            prefixLen = 32
          )
        )
      )
    ),
    action = Some(TableAction(
      `type` = TableAction.Type.Action(
        value = p4.v1.p4runtime.Action(
          actionId = 28792405,
          params = List(
            p4.v1.p4runtime.Action.Param(
              paramId = 1,
              value = dst_eth_addr
            ),
            p4.v1.p4runtime.Action.Param(
              paramId = 2,
              value = ByteString.copyFrom(
                Array(tunnel_id.toByte)
              )
            )
          )
        )
      )
    ))
  )

*/


/*
message Update {
  [Cannot be done at compile time]
  // The P4Runtime server must return RESOURCE_EXHAUSTED when a table entry cannot be inserted because of a size limitation.
  [Match types]
  // The only write updates allowed for constant tables are `MODIFY` operations on direct resources, and the default action.
  // Since the action of a const entry cannot be modified, a MODIFY on a constant table may not specify an action.
  enum Type {
    UNSPECIFIED = 0;
    INSERT = 1;
    MODIFY = 2;
    DELETE = 3;
  }
  Type type = 1;
  Entity entity = 2;
}

% : Cannot be modelled with types OR depends on backend implementation
? : Can likely be modelled with types, but not with this example
X : Can and is modelled with types

message TableEntry {
  // Determined by P4Info
  uint32 table_id = 1;
% [Not checkable / needed to check at compile-time]
  // Each element is used to provide a value for the corresponding element in the `key` property of the P4 table declaration
  // Clients must allow multiple entries to be added with the same priority value. If a packet can match multiple entries with
  // the same priority, it is not deterministic in the data plane which entry a packet will match. If a client wishes to make
  // the matching behavior deterministic, it must use different priority values for any pair of table entries that the same packet
  // matches.
% [Cannot be checked at compile-time (since no way to tell if entry already exists)]
  // The `match` and `priority` fields are used to uniquely identify an entry within a table; therefore, these fields cannot
  // be modified after insertion and must be provided for MODIFY/DELETE.
? [Match types]
  // In the case of a keyless-table (empty match key), the server must reject all attempts to INSERT an entry and return an INVALID_ARGUMENT
  // error.
X [Option types probably]
  // For "don't care" matches, the P4Runtime client must omit the field's entire `FieldMatch` entry when building the `match` field.
% [Implementation / backend-related, not relevant]
  // For PSA match types, a "don't care" match is defined as:
    - For a TERNARY match, equivalent to a mask of zeros
    - For an OPTIONAL match, equivalent to a wildcard
    - For an LPM match, equivalent to a prefix_len of zero
    - For a RANGE match, equvalent to a range which includes all possible values for the field
X [Can be checked with types]
  // There is no "don't care" for EXACT matches, so exact match fields must never be omitted from the `TableEntry` message.
X [Checkable with types]
  // For every member of the `match` field:
    - field_id must be a valid ID for the table as per the P4info
    - One of the fields in `field_match_type` must be set
  repeated FieldMatch match = 2;

X [Match types (only an `Option` for some types)]
  // Must be set for every INSERT update, but may be left unset for MODIFY updates
  TableAction action = 3;

X [Match types]
  // Should only be set if the match implies a TCAM lookup, i.e. at least one of
  // the match fields is Optional, Ternary or Range.
  int32 priority = 4;

  // Metadata (cookie) opaque to the target. There is no requirement of where
  // this is stored, as long as it is returned with the rest of the entry in
  // a Read RPC. This is deprecated in favor of the more flexible metadata
  // field.
  uint64 controller_metadata = 5 [deprecated=true];

  // meter_config, counter_data and meter_counter_data are convenience fields
  // that enable the controller to configure the direct resources associated
  // with the table at the same time as a match-action entry is inserted or
  // modified.
  // Table write:
        [Match types]
  //   - If the table does not contain a direct resource, then setting the
  //     corresponding direct resource field in any table write operation will
  //     return an error.]
  //   - When inserting a new table entry, leaving these fields unset means that
  //     the direct resources of this table (if any) will assume default values.
  //     For counters, the default value is 0, and for meters, the default value
  //     is always green.
  //   - When updating a table entry, leaving meter_config unset will reset the
  //     meter (if any) to its default configuration, while leaving counter_data
  //     or meter_counter_data unset means that the counter (if any) will not be
  //     updated.
  // Table read:
  //   - If the table does not contain a direct resource, then the corresponding
  //     field will not be set in the read table entry.
  //   - If meter_config is unset in the request, or if the meter has a default
  //     configuration, meter_config will not be set in the response.
  //   - If counter_data or meter_counter_data is unset in the request, it will
  //     be unset in the response as well.
  MeterConfig meter_config = 6;

  CounterData counter_data = 7;

  // Per color counters for tables with a direct meter.
  MeterCounterData meter_counter_data = 12;

  [Checkable with types]
  // Set to true if the table entry is being used to update the non-const
  // default action of the table. If true, the "match" field must be empty and
  // the "action" field must be populated with a valid direct action.
  [Match types]
  // Can only be modified if not declared as `const` (otherwise PERMISSION_DENIED).
  [Match types]
  // INSERT and DELETE updates are not allowed on the default entry.
  // If this is set to true, the `match` field must be empty and `priority` must be
  // set to 0.
  // If performing a MODIFY action, the client can either provide a valid action or
  // leave the field unset, in which case it resets to its original value (as per the P4 program).
  // In the current release, default actions are restricted for indirect tables to a
  // constant NoAction entry.
  bool is_default_action = 8;

  // The TTL for the entry, in nanoseconds. A value of 0 means that the table
  // entry never "expires".
  int64 idle_timeout_ns = 9;

  message IdleTimeout {
    // Time elapsed - in nanoseconds - since the table entry was last "hit" as
    // part of a data plane table lookup.
    int64 elapsed_ns = 1;
  }

  // Table write: this field should be left unset.
  // Table read: if the table supports idle timeout and time_since_last_hit is
  // set in the request, this field will be set in the response.
  IdleTimeout time_since_last_hit = 10;

  // Arbitrary metadata from the controller that is opaque to the target.
  bytes metadata = 11;
}

// The `bytes` must follow the format described in ByteStrings (8.4 p4runtime spec)
// field_match_type ::= exact | ternary | lpm | range | optional
message FieldMatch {
  uint32 field_id = 1;

  // Matches can be performed on arbitrarily-large inputs; the protobuf type
  // 'bytes' is used to model arbitrarily-large values.
  // Must conform to ByteStrings encoding requirements
  message Exact {
    bytes value = 1;
  }

  // Must conform to ByteStrings encoding requirements
  // "Don't care" match must be omitted
  // Masked bits must be 0 in value
  message Ternary {
    bytes value = 1;
    bytes mask = 2;
  }

  // Must conform to ByteStrings encoding requirements
  // "Don't care" match must be omitted
  // "Don't care" bits must be 0
  message LPM {
    bytes value = 1;
    int32 prefix_len = 2;  // in bits
  }
  // A Range is logically a set that contains all values numerically between
  // 'low' and 'high' inclusively.
  // Must conform to ByteStrings encoding requirements
  // Low bound must be <= high bound
  // "Don't care" match must be omitted
  message Range {
    bytes low = 1;
    bytes high = 2;
  }
  // If the Optional match should be a wildcard, the FieldMatch must be omitted.
  // Otherwise, this behaves like an exact match.
  // Must conform to ByteStrings encoding requirements
  message Optional {
    bytes value = 1;
  }

  oneof field_match_type {
    Exact exact = 2;
    Ternary ternary = 3;
    LPM lpm = 4;
    Range range = 6;
    Optional optional = 7;
    // Architecture-specific match value; it corresponds to the other_match_type
    // in the P4Info MatchField message.
    .google.protobuf.Any other = 100;
  }
}

// table_actions ::= action_specification | action_profile_specification
// If the `oneof` does not match the table description in P4Info, the server returns an INVALID_ARGUMENT.
message TableAction {
  oneof type {
    Action action = 1;
    uint32 action_profile_member_id = 2;
    uint32 action_profile_group_id = 3;
    ActionProfileActionSet action_profile_action_set = 4;
  }
}

message Action {
  // Determined by the P4Info message and must match one of the possible action choices for the table, or the
  // server must return an INVALID_ARGUMENT.
  // If the client uses a valid action_id but does not respect the `ActionRef` scope, the server must return
  // a PERMISSION_DENIED.
  uint32 action_id = 1;

  // For each parameter, `param_id` must be valid for the action, and the value must adhere to ByteStrings spec.
  // A valid value must be provided for each `param_id` for the action, default values are not supported.
  // The server returns INVALID_ARGUMENT if:
    - a parameter ID is missing
    - an extra parameter is providede
    - a parameter value is missing
    - if the encoding is wrong
  message Param {
    uint32 param_id = 2;
    bytes value = 3;
  }
  repeated Param params = 4;
}
*/

/*
case class Undefined()

enum UpdateType_DSL:
  case UNSPECIFIED_DSL
  case INSERT_DSL
  case MODIFY_DSL
  case DELETE_DSL
import UpdateType_DSL.*

abstract class Update_DSL:
  val `type` : UpdateType_DSL
  val entity : TableEntry_DSL[`type`.type] | Undefined // More types of updates than just table entries

abstract class TableEntry_DSL[U <: UpdateType_DSL]:
  val table_id : TableId_DSL
  val `match` : FieldMatches_DSL[table_id.type]
  val action : TableActions1_DSL[U, table_id.type]
  val priority : Priority_DSL[table_id.type]
  val meter_config : Undefined
  val counter_data : Undefined
  val meter_counter_data : Undefined
  val is_default_action : Bool
  val idle_timeout_ns : Undefined
  val time_since_last_hit : Undefined
  val metadata : Undefined

enum TableId_DSL:
  case MyIngress_ipv4_lpm
  case MyIngress_myTunnel_exact
import TableId_DSL.*

enum FieldMatchType_DSL:
  case EXACT_DSL
  case TERNARY_DSL
  case OPTIONAL_DSL
  case LPM_DSL
  case RANGE_DSL
import FieldMatchType_DSL.*

type Priority_DSL[T <: TableId_DSL] =
  T match
    case MyIngress_ipv4_lpm.type       => Int
    case MyIngress_myTunnel_exact.type => Nothing

enum FieldMatch_DSL:
  case Hdr_ipv4_dstAddr    (value : ByteString, prefix_len : Int)
  case Hdr_myTunnel_dst_id (value : ByteString)
import FieldMatch_DSL.*

type FieldMatches_DSL[T <: TableId_DSL] =
  T match
    case MyIngress_ipv4_lpm.type =>
      Option[Hdr_ipv4_dstAddr] // LPM, so Option[]
    case MyIngress_myTunnel_exact.type =>
      Hdr_myTunnel_dst_id // Exact, so no Option[]

enum TableAction_DSL:
  case NoAction
  case MyIngress_drop
  case MyIngress_ipv4_forward (dstAddr : Int, port : Int) // Bitwidth 48, 9
  case MyIngress_myTunnel_ingress (dst_id : Int) // Bitwidth 16
  case MyIngress_myTunnel_forward (port : Int) // Bitwidth 9
  case MyIngress_myTunnel_egress (dstAddr : Int, port : Int) // Bitwidth 48, 9
import TableAction_DSL.*

type TableActions1_DSL[U <: UpdateType_DSL, T <: TableId_DSL] =
  U match
    case INSERT_DSL.type => TableActions2_DSL[T]
    case _               => Option[TableActions2_DSL[T]]

type TableActions2_DSL[T <: TableId_DSL] =
  T match
    case MyIngress_ipv4_lpm.type =>
        NoAction.type
      | MyIngress_drop.type
      | MyIngress_ipv4_forward
      | MyIngress_myTunnel_ingress
    case MyIngress_myTunnel_exact.type =>
        MyIngress_drop.type
      | MyIngress_myTunnel_forward
      | MyIngress_myTunnel_egress
*/

/*
 pkg_info {
  arch: "v1model"
}
tables {
  preamble {
    id: 37375156
    name: "MyIngress.ipv4_lpm"
    alias: "ipv4_lpm"
  }
  match_fields {
    id: 1
    name: "hdr.ipv4.dstAddr"
    bitwidth: 32
    match_type: LPM
  }
  action_refs {
    id: 28792405
  }
  action_refs {
    id: 24181246
  }
  action_refs {
    id: 25652968
  }
  action_refs {
    id: 21257015
  }
  size: 1024
}
tables {
  preamble {
    id: 35862311
    name: "MyIngress.myTunnel_exact"
    alias: "myTunnel_exact"
  }
  match_fields {
    id: 1
    name: "hdr.myTunnel.dst_id"
    bitwidth: 16
    match_type: EXACT
  }
  action_refs {
    id: 27454791
  }
  action_refs {
    id: 33029817
  }
  action_refs {
    id: 25652968
  }
  size: 1024
}
actions {
  preamble {
    id: 21257015
    name: "NoAction"
    alias: "NoAction"
    annotations: "@noWarn(\"unused\")"
  }
}
actions {
  preamble {
    id: 25652968
    name: "MyIngress.drop"
    alias: "drop"
  }
}
actions {
  preamble {
    id: 28792405
    name: "MyIngress.ipv4_forward"
    alias: "ipv4_forward"
  }
  params {
    id: 1
    name: "dstAddr"
    bitwidth: 48
  }
  params {
    id: 2
    name: "port"
    bitwidth: 9
  }
}
actions {
  preamble {
    id: 24181246
    name: "MyIngress.myTunnel_ingress"
    alias: "myTunnel_ingress"
  }
  params {
    id: 1
    name: "dst_id"
    bitwidth: 16
  }
}
actions {
  preamble {
    id: 27454791
    name: "MyIngress.myTunnel_forward"
    alias: "myTunnel_forward"
  }
  params {
    id: 1
    name: "port"
    bitwidth: 9
  }
}
actions {
  preamble {
    id: 33029817
    name: "MyIngress.myTunnel_egress"
    alias: "myTunnel_egress"
  }
  params {
    id: 1
    name: "dstAddr"
    bitwidth: 48
  }
  params {
    id: 2
    name: "port"
    bitwidth: 9
  }
}
counters {
  preamble {
    id: 315557958
    name: "MyIngress.ingressTunnelCounter"
    alias: "ingressTunnelCounter"
  }
  spec {
    unit: BOTH
  }
  size: 65536
}
counters {
  preamble {
    id: 312374841
    name: "MyIngress.egressTunnelCounter"
    alias: "egressTunnelCounter"
  }
  spec {
    unit: BOTH
  }
  size: 65536
}
type_info {
}
*/

//type M[T] = T match {
//  case "Hello" => "World" | "Mars"
//  case "Goodbye" => "See you tomorrow"
//  case _ => Int
//}
//Types("Hello", "Hey", 42)
// val test2 = f(42, 43, 12)
//val test3 = f[String, M]("Hello", "Mars", true)

// DOESN'T WORK!
// def f[T](x: (Int, T), y: M[x._2.type]): y.type =
//   y
// val test1 = f((1, "Hello"), "World")
// val test2 = f((2, 42), 43)
// val test3 = f((3, "Hello!"), 43)

// case class Chan[TF[_], TA[_], TP[_]](addr: String)

// val c = Chan[M, M, M2]("127.0.0.1")
// val c2 = Chan[M2, M2, M]("127.0.0.1")

/*
def insert[TF[_], TA[_], TP[_]](c: Chan[TF, TA, TP], table_name: String, table_actions: TA[table_name.type]): Unit = println("yikes")

inline val w = "Wo" + "rld"
val res1 = insert(c, "Hello", w)
val res2 = insert(c, "Goodbye", "See you tomorrow")

val res3 = insert(c2, "World", 42)
val res4 = insert(c2, "Mars", false)
*/
