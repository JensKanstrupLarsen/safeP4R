// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package p4.config.v1.p4types

/** Location of code relative to a given source file.
  *
  * @param file
  *   Path to the source file (absolute or relative to the working directory).
  * @param line
  *   Line and column numbers within the source file, 1-based.
  */
@SerialVersionUID(0L)
final case class SourceLocation(
    file: _root_.scala.Predef.String = "",
    line: _root_.scala.Int = 0,
    column: _root_.scala.Int = 0,
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[SourceLocation] {
    @transient
    private[this] var __serializedSizeMemoized: _root_.scala.Int = 0
    private[this] def __computeSerializedSize(): _root_.scala.Int = {
      var __size = 0
      
      {
        val __value = file
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(1, __value)
        }
      };
      
      {
        val __value = line
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(2, __value)
        }
      };
      
      {
        val __value = column
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(3, __value)
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
        val __v = file
        if (!__v.isEmpty) {
          _output__.writeString(1, __v)
        }
      };
      {
        val __v = line
        if (__v != 0) {
          _output__.writeInt32(2, __v)
        }
      };
      {
        val __v = column
        if (__v != 0) {
          _output__.writeInt32(3, __v)
        }
      };
      unknownFields.writeTo(_output__)
    }
    def withFile(__v: _root_.scala.Predef.String): SourceLocation = copy(file = __v)
    def withLine(__v: _root_.scala.Int): SourceLocation = copy(line = __v)
    def withColumn(__v: _root_.scala.Int): SourceLocation = copy(column = __v)
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = file
          if (__t != "") __t else null
        }
        case 2 => {
          val __t = line
          if (__t != 0) __t else null
        }
        case 3 => {
          val __t = column
          if (__t != 0) __t else null
        }
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PString(file)
        case 2 => _root_.scalapb.descriptors.PInt(line)
        case 3 => _root_.scalapb.descriptors.PInt(column)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion: p4.config.v1.p4types.SourceLocation.type = p4.config.v1.p4types.SourceLocation
    // @@protoc_insertion_point(GeneratedMessage[p4.config.v1.SourceLocation])
}

object SourceLocation extends scalapb.GeneratedMessageCompanion[p4.config.v1.p4types.SourceLocation] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[p4.config.v1.p4types.SourceLocation] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): p4.config.v1.p4types.SourceLocation = {
    var __file: _root_.scala.Predef.String = ""
    var __line: _root_.scala.Int = 0
    var __column: _root_.scala.Int = 0
    var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 10 =>
          __file = _input__.readStringRequireUtf8()
        case 16 =>
          __line = _input__.readInt32()
        case 24 =>
          __column = _input__.readInt32()
        case tag =>
          if (_unknownFields__ == null) {
            _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
          }
          _unknownFields__.parseField(tag, _input__)
      }
    }
    p4.config.v1.p4types.SourceLocation(
        file = __file,
        line = __line,
        column = __column,
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[p4.config.v1.p4types.SourceLocation] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      p4.config.v1.p4types.SourceLocation(
        file = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        line = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Int]).getOrElse(0),
        column = __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).map(_.as[_root_.scala.Int]).getOrElse(0)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = P4TypesProto.javaDescriptor.getMessageTypes().get(20)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = P4TypesProto.scalaDescriptor.messages(20)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = p4.config.v1.p4types.SourceLocation(
    file = "",
    line = 0,
    column = 0
  )
  implicit class SourceLocationLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, p4.config.v1.p4types.SourceLocation]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, p4.config.v1.p4types.SourceLocation](_l) {
    def file: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.file)((c_, f_) => c_.copy(file = f_))
    def line: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.line)((c_, f_) => c_.copy(line = f_))
    def column: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.column)((c_, f_) => c_.copy(column = f_))
  }
  final val FILE_FIELD_NUMBER = 1
  final val LINE_FIELD_NUMBER = 2
  final val COLUMN_FIELD_NUMBER = 3
  def of(
    file: _root_.scala.Predef.String,
    line: _root_.scala.Int,
    column: _root_.scala.Int
  ): _root_.p4.config.v1.p4types.SourceLocation = _root_.p4.config.v1.p4types.SourceLocation(
    file,
    line,
    column
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[p4.config.v1.SourceLocation])
}
