// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package p4.v1.p4runtime

/** Used by the server to asynchronously report errors which occur when
  * processing StreamMessageRequest messages.
  *
  * @param canonicalCode
  *   gRPC canonical error code (see
  *   https://developers.google.com/maps-booking/reference/grpc-api/status_codes)
  * @param message
  *   Optional. An explanation of the error.
  * @param space
  *   Optional. Target and architecture specific space to which this error
  *   belongs.
  *   We encourage using triplet: &lt;target&gt;-&lt;arch&gt;-&lt;vendor&gt;,
  *   e.g."targetX-psa-vendor1" or "targetY-psa-vendor2".
  * @param code
  *   Optional. Numeric code drawn from target-specific error space above.
  */
@SerialVersionUID(0L)
final case class StreamError(
    canonicalCode: _root_.scala.Int = 0,
    message: _root_.scala.Predef.String = "",
    space: _root_.scala.Predef.String = "",
    code: _root_.scala.Int = 0,
    details: p4.v1.p4runtime.StreamError.Details = p4.v1.p4runtime.StreamError.Details.Empty,
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[StreamError] {
    @transient
    private[this] var __serializedSizeMemoized: _root_.scala.Int = 0
    private[this] def __computeSerializedSize(): _root_.scala.Int = {
      var __size = 0
      
      {
        val __value = canonicalCode
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(1, __value)
        }
      };
      
      {
        val __value = message
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(2, __value)
        }
      };
      
      {
        val __value = space
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(3, __value)
        }
      };
      
      {
        val __value = code
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(4, __value)
        }
      };
      if (details.packetOut.isDefined) {
        val __value = details.packetOut.get
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
      };
      if (details.digestListAck.isDefined) {
        val __value = details.digestListAck.get
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
      };
      if (details.other.isDefined) {
        val __value = details.other.get
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
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
        val __v = canonicalCode
        if (__v != 0) {
          _output__.writeInt32(1, __v)
        }
      };
      {
        val __v = message
        if (!__v.isEmpty) {
          _output__.writeString(2, __v)
        }
      };
      {
        val __v = space
        if (!__v.isEmpty) {
          _output__.writeString(3, __v)
        }
      };
      {
        val __v = code
        if (__v != 0) {
          _output__.writeInt32(4, __v)
        }
      };
      details.packetOut.foreach { __v =>
        val __m = __v
        _output__.writeTag(5, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      details.digestListAck.foreach { __v =>
        val __m = __v
        _output__.writeTag(6, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      details.other.foreach { __v =>
        val __m = __v
        _output__.writeTag(7, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      unknownFields.writeTo(_output__)
    }
    def withCanonicalCode(__v: _root_.scala.Int): StreamError = copy(canonicalCode = __v)
    def withMessage(__v: _root_.scala.Predef.String): StreamError = copy(message = __v)
    def withSpace(__v: _root_.scala.Predef.String): StreamError = copy(space = __v)
    def withCode(__v: _root_.scala.Int): StreamError = copy(code = __v)
    def getPacketOut: p4.v1.p4runtime.PacketOutError = details.packetOut.getOrElse(p4.v1.p4runtime.PacketOutError.defaultInstance)
    def withPacketOut(__v: p4.v1.p4runtime.PacketOutError): StreamError = copy(details = p4.v1.p4runtime.StreamError.Details.PacketOut(__v))
    def getDigestListAck: p4.v1.p4runtime.DigestListAckError = details.digestListAck.getOrElse(p4.v1.p4runtime.DigestListAckError.defaultInstance)
    def withDigestListAck(__v: p4.v1.p4runtime.DigestListAckError): StreamError = copy(details = p4.v1.p4runtime.StreamError.Details.DigestListAck(__v))
    def getOther: p4.v1.p4runtime.StreamOtherError = details.other.getOrElse(p4.v1.p4runtime.StreamOtherError.defaultInstance)
    def withOther(__v: p4.v1.p4runtime.StreamOtherError): StreamError = copy(details = p4.v1.p4runtime.StreamError.Details.Other(__v))
    def clearDetails: StreamError = copy(details = p4.v1.p4runtime.StreamError.Details.Empty)
    def withDetails(__v: p4.v1.p4runtime.StreamError.Details): StreamError = copy(details = __v)
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = canonicalCode
          if (__t != 0) __t else null
        }
        case 2 => {
          val __t = message
          if (__t != "") __t else null
        }
        case 3 => {
          val __t = space
          if (__t != "") __t else null
        }
        case 4 => {
          val __t = code
          if (__t != 0) __t else null
        }
        case 5 => details.packetOut.orNull
        case 6 => details.digestListAck.orNull
        case 7 => details.other.orNull
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PInt(canonicalCode)
        case 2 => _root_.scalapb.descriptors.PString(message)
        case 3 => _root_.scalapb.descriptors.PString(space)
        case 4 => _root_.scalapb.descriptors.PInt(code)
        case 5 => details.packetOut.map(_.toPMessage).getOrElse(_root_.scalapb.descriptors.PEmpty)
        case 6 => details.digestListAck.map(_.toPMessage).getOrElse(_root_.scalapb.descriptors.PEmpty)
        case 7 => details.other.map(_.toPMessage).getOrElse(_root_.scalapb.descriptors.PEmpty)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion: p4.v1.p4runtime.StreamError.type = p4.v1.p4runtime.StreamError
    // @@protoc_insertion_point(GeneratedMessage[p4.v1.StreamError])
}

object StreamError extends scalapb.GeneratedMessageCompanion[p4.v1.p4runtime.StreamError] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[p4.v1.p4runtime.StreamError] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): p4.v1.p4runtime.StreamError = {
    var __canonicalCode: _root_.scala.Int = 0
    var __message: _root_.scala.Predef.String = ""
    var __space: _root_.scala.Predef.String = ""
    var __code: _root_.scala.Int = 0
    var __details: p4.v1.p4runtime.StreamError.Details = p4.v1.p4runtime.StreamError.Details.Empty
    var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 8 =>
          __canonicalCode = _input__.readInt32()
        case 18 =>
          __message = _input__.readStringRequireUtf8()
        case 26 =>
          __space = _input__.readStringRequireUtf8()
        case 32 =>
          __code = _input__.readInt32()
        case 42 =>
          __details = p4.v1.p4runtime.StreamError.Details.PacketOut(__details.packetOut.fold(_root_.scalapb.LiteParser.readMessage[p4.v1.p4runtime.PacketOutError](_input__))(_root_.scalapb.LiteParser.readMessage(_input__, _)))
        case 50 =>
          __details = p4.v1.p4runtime.StreamError.Details.DigestListAck(__details.digestListAck.fold(_root_.scalapb.LiteParser.readMessage[p4.v1.p4runtime.DigestListAckError](_input__))(_root_.scalapb.LiteParser.readMessage(_input__, _)))
        case 58 =>
          __details = p4.v1.p4runtime.StreamError.Details.Other(__details.other.fold(_root_.scalapb.LiteParser.readMessage[p4.v1.p4runtime.StreamOtherError](_input__))(_root_.scalapb.LiteParser.readMessage(_input__, _)))
        case tag =>
          if (_unknownFields__ == null) {
            _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
          }
          _unknownFields__.parseField(tag, _input__)
      }
    }
    p4.v1.p4runtime.StreamError(
        canonicalCode = __canonicalCode,
        message = __message,
        space = __space,
        code = __code,
        details = __details,
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[p4.v1.p4runtime.StreamError] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      p4.v1.p4runtime.StreamError(
        canonicalCode = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Int]).getOrElse(0),
        message = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        space = __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        code = __fieldsMap.get(scalaDescriptor.findFieldByNumber(4).get).map(_.as[_root_.scala.Int]).getOrElse(0),
        details = __fieldsMap.get(scalaDescriptor.findFieldByNumber(5).get).flatMap(_.as[_root_.scala.Option[p4.v1.p4runtime.PacketOutError]]).map(p4.v1.p4runtime.StreamError.Details.PacketOut(_))
            .orElse[p4.v1.p4runtime.StreamError.Details](__fieldsMap.get(scalaDescriptor.findFieldByNumber(6).get).flatMap(_.as[_root_.scala.Option[p4.v1.p4runtime.DigestListAckError]]).map(p4.v1.p4runtime.StreamError.Details.DigestListAck(_)))
            .orElse[p4.v1.p4runtime.StreamError.Details](__fieldsMap.get(scalaDescriptor.findFieldByNumber(7).get).flatMap(_.as[_root_.scala.Option[p4.v1.p4runtime.StreamOtherError]]).map(p4.v1.p4runtime.StreamError.Details.Other(_)))
            .getOrElse(p4.v1.p4runtime.StreamError.Details.Empty)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = P4RuntimeProto.javaDescriptor.getMessageTypes().get(41)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = P4RuntimeProto.scalaDescriptor.messages(41)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = {
    var __out: _root_.scalapb.GeneratedMessageCompanion[_] = null
    (__number: @_root_.scala.unchecked) match {
      case 5 => __out = p4.v1.p4runtime.PacketOutError
      case 6 => __out = p4.v1.p4runtime.DigestListAckError
      case 7 => __out = p4.v1.p4runtime.StreamOtherError
    }
    __out
  }
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = p4.v1.p4runtime.StreamError(
    canonicalCode = 0,
    message = "",
    space = "",
    code = 0,
    details = p4.v1.p4runtime.StreamError.Details.Empty
  )
  sealed trait Details extends _root_.scalapb.GeneratedOneof {
    def isEmpty: _root_.scala.Boolean = false
    def isDefined: _root_.scala.Boolean = true
    def isPacketOut: _root_.scala.Boolean = false
    def isDigestListAck: _root_.scala.Boolean = false
    def isOther: _root_.scala.Boolean = false
    def packetOut: _root_.scala.Option[p4.v1.p4runtime.PacketOutError] = _root_.scala.None
    def digestListAck: _root_.scala.Option[p4.v1.p4runtime.DigestListAckError] = _root_.scala.None
    def other: _root_.scala.Option[p4.v1.p4runtime.StreamOtherError] = _root_.scala.None
  }
  object Details {
    @SerialVersionUID(0L)
    case object Empty extends p4.v1.p4runtime.StreamError.Details {
      type ValueType = _root_.scala.Nothing
      override def isEmpty: _root_.scala.Boolean = true
      override def isDefined: _root_.scala.Boolean = false
      override def number: _root_.scala.Int = 0
      override def value: _root_.scala.Nothing = throw new java.util.NoSuchElementException("Empty.value")
    }
  
    @SerialVersionUID(0L)
    final case class PacketOut(value: p4.v1.p4runtime.PacketOutError) extends p4.v1.p4runtime.StreamError.Details {
      type ValueType = p4.v1.p4runtime.PacketOutError
      override def isPacketOut: _root_.scala.Boolean = true
      override def packetOut: _root_.scala.Option[p4.v1.p4runtime.PacketOutError] = Some(value)
      override def number: _root_.scala.Int = 5
    }
    @SerialVersionUID(0L)
    final case class DigestListAck(value: p4.v1.p4runtime.DigestListAckError) extends p4.v1.p4runtime.StreamError.Details {
      type ValueType = p4.v1.p4runtime.DigestListAckError
      override def isDigestListAck: _root_.scala.Boolean = true
      override def digestListAck: _root_.scala.Option[p4.v1.p4runtime.DigestListAckError] = Some(value)
      override def number: _root_.scala.Int = 6
    }
    @SerialVersionUID(0L)
    final case class Other(value: p4.v1.p4runtime.StreamOtherError) extends p4.v1.p4runtime.StreamError.Details {
      type ValueType = p4.v1.p4runtime.StreamOtherError
      override def isOther: _root_.scala.Boolean = true
      override def other: _root_.scala.Option[p4.v1.p4runtime.StreamOtherError] = Some(value)
      override def number: _root_.scala.Int = 7
    }
  }
  implicit class StreamErrorLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, p4.v1.p4runtime.StreamError]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, p4.v1.p4runtime.StreamError](_l) {
    def canonicalCode: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.canonicalCode)((c_, f_) => c_.copy(canonicalCode = f_))
    def message: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.message)((c_, f_) => c_.copy(message = f_))
    def space: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.space)((c_, f_) => c_.copy(space = f_))
    def code: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.code)((c_, f_) => c_.copy(code = f_))
    def packetOut: _root_.scalapb.lenses.Lens[UpperPB, p4.v1.p4runtime.PacketOutError] = field(_.getPacketOut)((c_, f_) => c_.copy(details = p4.v1.p4runtime.StreamError.Details.PacketOut(f_)))
    def digestListAck: _root_.scalapb.lenses.Lens[UpperPB, p4.v1.p4runtime.DigestListAckError] = field(_.getDigestListAck)((c_, f_) => c_.copy(details = p4.v1.p4runtime.StreamError.Details.DigestListAck(f_)))
    def other: _root_.scalapb.lenses.Lens[UpperPB, p4.v1.p4runtime.StreamOtherError] = field(_.getOther)((c_, f_) => c_.copy(details = p4.v1.p4runtime.StreamError.Details.Other(f_)))
    def details: _root_.scalapb.lenses.Lens[UpperPB, p4.v1.p4runtime.StreamError.Details] = field(_.details)((c_, f_) => c_.copy(details = f_))
  }
  final val CANONICAL_CODE_FIELD_NUMBER = 1
  final val MESSAGE_FIELD_NUMBER = 2
  final val SPACE_FIELD_NUMBER = 3
  final val CODE_FIELD_NUMBER = 4
  final val PACKET_OUT_FIELD_NUMBER = 5
  final val DIGEST_LIST_ACK_FIELD_NUMBER = 6
  final val OTHER_FIELD_NUMBER = 7
  def of(
    canonicalCode: _root_.scala.Int,
    message: _root_.scala.Predef.String,
    space: _root_.scala.Predef.String,
    code: _root_.scala.Int,
    details: p4.v1.p4runtime.StreamError.Details
  ): _root_.p4.v1.p4runtime.StreamError = _root_.p4.v1.p4runtime.StreamError(
    canonicalCode,
    message,
    space,
    code,
    details
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[p4.v1.StreamError])
}
