// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package p4.v1.p4runtime

/** Modeled as RFC 2698: A Two Rate Three Color Marker (trTCM)
  * The trTCM meters a packet stream and marks its packets based on two rates,
  * Peak Information Rate (PIR) and Committed Information Rate (CIR), and their
  * associated burst sizes to be either green, yellow, or red.  A packet is
  * marked red if it exceeds the PIR.  Otherwise it is marked either yellow or
  * green depending on whether it exceeds or doesn't exceed the CIR.
  *
  * @param cir
  *   Committed information rate (units per sec)
  * @param cburst
  *   Committed burst size
  * @param pir
  *   Peak information rate (units per sec)
  * @param pburst
  *   Peak burst size
  */
@SerialVersionUID(0L)
final case class MeterConfig(
    cir: _root_.scala.Long = 0L,
    cburst: _root_.scala.Long = 0L,
    pir: _root_.scala.Long = 0L,
    pburst: _root_.scala.Long = 0L,
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[MeterConfig] {
    @transient
    private[this] var __serializedSizeMemoized: _root_.scala.Int = 0
    private[this] def __computeSerializedSize(): _root_.scala.Int = {
      var __size = 0
      
      {
        val __value = cir
        if (__value != 0L) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt64Size(1, __value)
        }
      };
      
      {
        val __value = cburst
        if (__value != 0L) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt64Size(2, __value)
        }
      };
      
      {
        val __value = pir
        if (__value != 0L) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt64Size(3, __value)
        }
      };
      
      {
        val __value = pburst
        if (__value != 0L) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt64Size(4, __value)
        }
      };
      __size += unknownFields.serializedSize
      __size
    }
    override def serializedSize: _root_.scala.Int = {
      var __size = __serializedSizeMemoized
      if (__size == 0) {
        __size = __computeSerializedSize() + 1
        __serializedSizeMemoized = __size
      }
      __size - 1
      
    }
    def writeTo(`_output__`: _root_.com.google.protobuf.CodedOutputStream): _root_.scala.Unit = {
      {
        val __v = cir
        if (__v != 0L) {
          _output__.writeInt64(1, __v)
        }
      };
      {
        val __v = cburst
        if (__v != 0L) {
          _output__.writeInt64(2, __v)
        }
      };
      {
        val __v = pir
        if (__v != 0L) {
          _output__.writeInt64(3, __v)
        }
      };
      {
        val __v = pburst
        if (__v != 0L) {
          _output__.writeInt64(4, __v)
        }
      };
      unknownFields.writeTo(_output__)
    }
    def withCir(__v: _root_.scala.Long): MeterConfig = copy(cir = __v)
    def withCburst(__v: _root_.scala.Long): MeterConfig = copy(cburst = __v)
    def withPir(__v: _root_.scala.Long): MeterConfig = copy(pir = __v)
    def withPburst(__v: _root_.scala.Long): MeterConfig = copy(pburst = __v)
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = cir
          if (__t != 0L) __t else null
        }
        case 2 => {
          val __t = cburst
          if (__t != 0L) __t else null
        }
        case 3 => {
          val __t = pir
          if (__t != 0L) __t else null
        }
        case 4 => {
          val __t = pburst
          if (__t != 0L) __t else null
        }
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PLong(cir)
        case 2 => _root_.scalapb.descriptors.PLong(cburst)
        case 3 => _root_.scalapb.descriptors.PLong(pir)
        case 4 => _root_.scalapb.descriptors.PLong(pburst)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion: p4.v1.p4runtime.MeterConfig.type = p4.v1.p4runtime.MeterConfig
    // @@protoc_insertion_point(GeneratedMessage[p4.v1.MeterConfig])
}

object MeterConfig extends scalapb.GeneratedMessageCompanion[p4.v1.p4runtime.MeterConfig] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[p4.v1.p4runtime.MeterConfig] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): p4.v1.p4runtime.MeterConfig = {
    var __cir: _root_.scala.Long = 0L
    var __cburst: _root_.scala.Long = 0L
    var __pir: _root_.scala.Long = 0L
    var __pburst: _root_.scala.Long = 0L
    var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 8 =>
          __cir = _input__.readInt64()
        case 16 =>
          __cburst = _input__.readInt64()
        case 24 =>
          __pir = _input__.readInt64()
        case 32 =>
          __pburst = _input__.readInt64()
        case tag =>
          if (_unknownFields__ == null) {
            _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
          }
          _unknownFields__.parseField(tag, _input__)
      }
    }
    p4.v1.p4runtime.MeterConfig(
        cir = __cir,
        cburst = __cburst,
        pir = __pir,
        pburst = __pburst,
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[p4.v1.p4runtime.MeterConfig] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      p4.v1.p4runtime.MeterConfig(
        cir = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Long]).getOrElse(0L),
        cburst = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Long]).getOrElse(0L),
        pir = __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).map(_.as[_root_.scala.Long]).getOrElse(0L),
        pburst = __fieldsMap.get(scalaDescriptor.findFieldByNumber(4).get).map(_.as[_root_.scala.Long]).getOrElse(0L)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = P4RuntimeProto.javaDescriptor.getMessageTypes().get(18)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = P4RuntimeProto.scalaDescriptor.messages(18)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = p4.v1.p4runtime.MeterConfig(
    cir = 0L,
    cburst = 0L,
    pir = 0L,
    pburst = 0L
  )
  implicit class MeterConfigLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, p4.v1.p4runtime.MeterConfig]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, p4.v1.p4runtime.MeterConfig](_l) {
    def cir: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Long] = field(_.cir)((c_, f_) => c_.copy(cir = f_))
    def cburst: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Long] = field(_.cburst)((c_, f_) => c_.copy(cburst = f_))
    def pir: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Long] = field(_.pir)((c_, f_) => c_.copy(pir = f_))
    def pburst: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Long] = field(_.pburst)((c_, f_) => c_.copy(pburst = f_))
  }
  final val CIR_FIELD_NUMBER = 1
  final val CBURST_FIELD_NUMBER = 2
  final val PIR_FIELD_NUMBER = 3
  final val PBURST_FIELD_NUMBER = 4
  def of(
    cir: _root_.scala.Long,
    cburst: _root_.scala.Long,
    pir: _root_.scala.Long,
    pburst: _root_.scala.Long
  ): _root_.p4.v1.p4runtime.MeterConfig = _root_.p4.v1.p4runtime.MeterConfig(
    cir,
    cburst,
    pir,
    pburst
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[p4.v1.MeterConfig])
}
