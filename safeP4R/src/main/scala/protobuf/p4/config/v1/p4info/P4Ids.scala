// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package p4.config.v1.p4info

/** wrapping the enum in a message to avoid name collisions in C++, where "enum
  * values are siblings of their type, not children of it"
  */
@SerialVersionUID(0L)
final case class P4Ids(
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[P4Ids] {
    @transient
    private[this] var __serializedSizeMemoized: _root_.scala.Int = 0
    private[this] def __computeSerializedSize(): _root_.scala.Int = {
      var __size = 0
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
      unknownFields.writeTo(_output__)
    }
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = throw new MatchError(__fieldNumber)
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = throw new MatchError(__field)
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion: p4.config.v1.p4info.P4Ids.type = p4.config.v1.p4info.P4Ids
    // @@protoc_insertion_point(GeneratedMessage[p4.config.v1.P4Ids])
}

object P4Ids extends scalapb.GeneratedMessageCompanion[p4.config.v1.p4info.P4Ids] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[p4.config.v1.p4info.P4Ids] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): p4.config.v1.p4info.P4Ids = {
    var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case tag =>
          if (_unknownFields__ == null) {
            _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
          }
          _unknownFields__.parseField(tag, _input__)
      }
    }
    p4.config.v1.p4info.P4Ids(
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[p4.config.v1.p4info.P4Ids] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      p4.config.v1.p4info.P4Ids(
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = P4InfoProto.javaDescriptor.getMessageTypes().get(3)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = P4InfoProto.scalaDescriptor.messages(3)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = p4.config.v1.p4info.P4Ids(
  )
  /** ids are allocated in such a way that it is possible based on an id to
    * deduce the resource type (e.g. table, action, counter, ...). The
    * most-significant byte of the 32-bit id encodes the resource type. The
    * purpose of this enum is to define which value is used as the
    * most-significant byte for each resource type. The P4 compiler must use
    * these values when allocating ids for P4 objects. Other users of P4Info can
    * refer to this enum to identify a resource type based on its id.
    */
  sealed abstract class Prefix(val value: _root_.scala.Int) extends _root_.scalapb.GeneratedEnum {
    type EnumType = Prefix
    def isUnspecified: _root_.scala.Boolean = false
    def isAction: _root_.scala.Boolean = false
    def isTable: _root_.scala.Boolean = false
    def isValueSet: _root_.scala.Boolean = false
    def isControllerHeader: _root_.scala.Boolean = false
    def isPsaExternsStart: _root_.scala.Boolean = false
    def isActionProfile: _root_.scala.Boolean = false
    def isCounter: _root_.scala.Boolean = false
    def isDirectCounter: _root_.scala.Boolean = false
    def isMeter: _root_.scala.Boolean = false
    def isDirectMeter: _root_.scala.Boolean = false
    def isRegister: _root_.scala.Boolean = false
    def isDigest: _root_.scala.Boolean = false
    def isOtherExternsStart: _root_.scala.Boolean = false
    def isMax: _root_.scala.Boolean = false
    def companion: _root_.scalapb.GeneratedEnumCompanion[Prefix] = p4.config.v1.p4info.P4Ids.Prefix
    final def asRecognized: _root_.scala.Option[p4.config.v1.p4info.P4Ids.Prefix.Recognized] = if (isUnrecognized) _root_.scala.None else _root_.scala.Some(this.asInstanceOf[p4.config.v1.p4info.P4Ids.Prefix.Recognized])
  }
  
  object Prefix extends _root_.scalapb.GeneratedEnumCompanion[Prefix] {
    sealed trait Recognized extends Prefix
    implicit def enumCompanion: _root_.scalapb.GeneratedEnumCompanion[Prefix] = this
    
    @SerialVersionUID(0L)
    case object UNSPECIFIED extends Prefix(0) with Prefix.Recognized {
      val index = 0
      val name = "UNSPECIFIED"
      override def isUnspecified: _root_.scala.Boolean = true
    }
    
    /** P4 language built-ins
      */
    @SerialVersionUID(0L)
    case object ACTION extends Prefix(1) with Prefix.Recognized {
      val index = 1
      val name = "ACTION"
      override def isAction: _root_.scala.Boolean = true
    }
    
    @SerialVersionUID(0L)
    case object TABLE extends Prefix(2) with Prefix.Recognized {
      val index = 2
      val name = "TABLE"
      override def isTable: _root_.scala.Boolean = true
    }
    
    @SerialVersionUID(0L)
    case object VALUE_SET extends Prefix(3) with Prefix.Recognized {
      val index = 3
      val name = "VALUE_SET"
      override def isValueSet: _root_.scala.Boolean = true
    }
    
    @SerialVersionUID(0L)
    case object CONTROLLER_HEADER extends Prefix(4) with Prefix.Recognized {
      val index = 4
      val name = "CONTROLLER_HEADER"
      override def isControllerHeader: _root_.scala.Boolean = true
    }
    
    /** PSA externs
      */
    @SerialVersionUID(0L)
    case object PSA_EXTERNS_START extends Prefix(16) with Prefix.Recognized {
      val index = 5
      val name = "PSA_EXTERNS_START"
      override def isPsaExternsStart: _root_.scala.Boolean = true
    }
    
    @SerialVersionUID(0L)
    case object ACTION_PROFILE extends Prefix(17) with Prefix.Recognized {
      val index = 6
      val name = "ACTION_PROFILE"
      override def isActionProfile: _root_.scala.Boolean = true
    }
    
    @SerialVersionUID(0L)
    case object COUNTER extends Prefix(18) with Prefix.Recognized {
      val index = 7
      val name = "COUNTER"
      override def isCounter: _root_.scala.Boolean = true
    }
    
    @SerialVersionUID(0L)
    case object DIRECT_COUNTER extends Prefix(19) with Prefix.Recognized {
      val index = 8
      val name = "DIRECT_COUNTER"
      override def isDirectCounter: _root_.scala.Boolean = true
    }
    
    @SerialVersionUID(0L)
    case object METER extends Prefix(20) with Prefix.Recognized {
      val index = 9
      val name = "METER"
      override def isMeter: _root_.scala.Boolean = true
    }
    
    @SerialVersionUID(0L)
    case object DIRECT_METER extends Prefix(21) with Prefix.Recognized {
      val index = 10
      val name = "DIRECT_METER"
      override def isDirectMeter: _root_.scala.Boolean = true
    }
    
    @SerialVersionUID(0L)
    case object REGISTER extends Prefix(22) with Prefix.Recognized {
      val index = 11
      val name = "REGISTER"
      override def isRegister: _root_.scala.Boolean = true
    }
    
    @SerialVersionUID(0L)
    case object DIGEST extends Prefix(23) with Prefix.Recognized {
      val index = 12
      val name = "DIGEST"
      override def isDigest: _root_.scala.Boolean = true
    }
    
    /** externs for other architectures (vendor extensions)
      */
    @SerialVersionUID(0L)
    case object OTHER_EXTERNS_START extends Prefix(128) with Prefix.Recognized {
      val index = 13
      val name = "OTHER_EXTERNS_START"
      override def isOtherExternsStart: _root_.scala.Boolean = true
    }
    
    /** max value for an unsigned 8-bit byte
      * requires protoc &gt;= 3.5.0
      * reserved 0x100 to max;
      */
    @SerialVersionUID(0L)
    case object MAX extends Prefix(255) with Prefix.Recognized {
      val index = 14
      val name = "MAX"
      override def isMax: _root_.scala.Boolean = true
    }
    
    @SerialVersionUID(0L)
    final case class Unrecognized(unrecognizedValue: _root_.scala.Int) extends Prefix(unrecognizedValue) with _root_.scalapb.UnrecognizedEnum
    lazy val values = scala.collection.immutable.Seq(UNSPECIFIED, ACTION, TABLE, VALUE_SET, CONTROLLER_HEADER, PSA_EXTERNS_START, ACTION_PROFILE, COUNTER, DIRECT_COUNTER, METER, DIRECT_METER, REGISTER, DIGEST, OTHER_EXTERNS_START, MAX)
    def fromValue(__value: _root_.scala.Int): Prefix = __value match {
      case 0 => UNSPECIFIED
      case 1 => ACTION
      case 2 => TABLE
      case 3 => VALUE_SET
      case 4 => CONTROLLER_HEADER
      case 16 => PSA_EXTERNS_START
      case 17 => ACTION_PROFILE
      case 18 => COUNTER
      case 19 => DIRECT_COUNTER
      case 20 => METER
      case 21 => DIRECT_METER
      case 22 => REGISTER
      case 23 => DIGEST
      case 128 => OTHER_EXTERNS_START
      case 255 => MAX
      case __other => Unrecognized(__other)
    }
    def javaDescriptor: _root_.com.google.protobuf.Descriptors.EnumDescriptor = p4.config.v1.p4info.P4Ids.javaDescriptor.getEnumTypes().get(0)
    def scalaDescriptor: _root_.scalapb.descriptors.EnumDescriptor = p4.config.v1.p4info.P4Ids.scalaDescriptor.enums(0)
  }
  implicit class P4IdsLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, p4.config.v1.p4info.P4Ids]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, p4.config.v1.p4info.P4Ids](_l) {
  }
  def of(
  ): _root_.p4.config.v1.p4info.P4Ids = _root_.p4.config.v1.p4info.P4Ids(
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[p4.config.v1.P4Ids])
}
