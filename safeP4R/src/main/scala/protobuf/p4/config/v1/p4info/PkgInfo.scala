// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package p4.config.v1.p4info

/** Top-level package documentation describing the forwarding pipeline config
  * Can be used to manage multiple P4 packages.
  *
  * @param name
  *   a definitive name for this configuration, e.g. switch.p4_v1.0
  * @param version
  *   configuration version, free-format string
  * @param doc
  *   brief and detailed descriptions
  * @param annotations
  *   Miscellaneous metadata, free-form; a way to extend PkgInfo
  * @param annotationLocations
  *   Optional. If present, the location of `annotations[i]` is given by
  *   `annotation_locations[i]`.
  * @param arch
  *   the target architecture, e.g. "psa"
  * @param organization
  *   organization which produced the configuration, e.g. "p4.org"
  * @param contact
  *   contact info for support,e.g. "tech-support&#64;acme.org"
  * @param url
  *   url for more information, e.g.
  *   "http://support.p4.org/ref/p4/switch.p4_v1.0"
  * @param structuredAnnotations
  *   Miscellaneous metadata, structured; a way to extend PkgInfo
  */
@SerialVersionUID(0L)
final case class PkgInfo(
    name: _root_.scala.Predef.String = "",
    version: _root_.scala.Predef.String = "",
    doc: _root_.scala.Option[p4.config.v1.p4info.Documentation] = _root_.scala.None,
    annotations: _root_.scala.Seq[_root_.scala.Predef.String] = _root_.scala.Seq.empty,
    annotationLocations: _root_.scala.Seq[p4.config.v1.p4types.SourceLocation] = _root_.scala.Seq.empty,
    arch: _root_.scala.Predef.String = "",
    organization: _root_.scala.Predef.String = "",
    contact: _root_.scala.Predef.String = "",
    url: _root_.scala.Predef.String = "",
    structuredAnnotations: _root_.scala.Seq[p4.config.v1.p4types.StructuredAnnotation] = _root_.scala.Seq.empty,
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[PkgInfo] {
    @transient
    private[this] var __serializedSizeMemoized: _root_.scala.Int = 0
    private[this] def __computeSerializedSize(): _root_.scala.Int = {
      var __size = 0
      
      {
        val __value = name
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(1, __value)
        }
      };
      
      {
        val __value = version
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(2, __value)
        }
      };
      if (doc.isDefined) {
        val __value = doc.get
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
      };
      annotations.foreach { __item =>
        val __value = __item
        __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(4, __value)
      }
      annotationLocations.foreach { __item =>
        val __value = __item
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
      }
      
      {
        val __value = arch
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(5, __value)
        }
      };
      
      {
        val __value = organization
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(6, __value)
        }
      };
      
      {
        val __value = contact
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(7, __value)
        }
      };
      
      {
        val __value = url
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(8, __value)
        }
      };
      structuredAnnotations.foreach { __item =>
        val __value = __item
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
      }
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
        val __v = name
        if (!__v.isEmpty) {
          _output__.writeString(1, __v)
        }
      };
      {
        val __v = version
        if (!__v.isEmpty) {
          _output__.writeString(2, __v)
        }
      };
      doc.foreach { __v =>
        val __m = __v
        _output__.writeTag(3, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      annotations.foreach { __v =>
        val __m = __v
        _output__.writeString(4, __m)
      };
      {
        val __v = arch
        if (!__v.isEmpty) {
          _output__.writeString(5, __v)
        }
      };
      {
        val __v = organization
        if (!__v.isEmpty) {
          _output__.writeString(6, __v)
        }
      };
      {
        val __v = contact
        if (!__v.isEmpty) {
          _output__.writeString(7, __v)
        }
      };
      {
        val __v = url
        if (!__v.isEmpty) {
          _output__.writeString(8, __v)
        }
      };
      structuredAnnotations.foreach { __v =>
        val __m = __v
        _output__.writeTag(9, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      annotationLocations.foreach { __v =>
        val __m = __v
        _output__.writeTag(10, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      unknownFields.writeTo(_output__)
    }
    def withName(__v: _root_.scala.Predef.String): PkgInfo = copy(name = __v)
    def withVersion(__v: _root_.scala.Predef.String): PkgInfo = copy(version = __v)
    def getDoc: p4.config.v1.p4info.Documentation = doc.getOrElse(p4.config.v1.p4info.Documentation.defaultInstance)
    def clearDoc: PkgInfo = copy(doc = _root_.scala.None)
    def withDoc(__v: p4.config.v1.p4info.Documentation): PkgInfo = copy(doc = Option(__v))
    def clearAnnotations = copy(annotations = _root_.scala.Seq.empty)
    def addAnnotations(__vs: _root_.scala.Predef.String *): PkgInfo = addAllAnnotations(__vs)
    def addAllAnnotations(__vs: Iterable[_root_.scala.Predef.String]): PkgInfo = copy(annotations = annotations ++ __vs)
    def withAnnotations(__v: _root_.scala.Seq[_root_.scala.Predef.String]): PkgInfo = copy(annotations = __v)
    def clearAnnotationLocations = copy(annotationLocations = _root_.scala.Seq.empty)
    def addAnnotationLocations(__vs: p4.config.v1.p4types.SourceLocation *): PkgInfo = addAllAnnotationLocations(__vs)
    def addAllAnnotationLocations(__vs: Iterable[p4.config.v1.p4types.SourceLocation]): PkgInfo = copy(annotationLocations = annotationLocations ++ __vs)
    def withAnnotationLocations(__v: _root_.scala.Seq[p4.config.v1.p4types.SourceLocation]): PkgInfo = copy(annotationLocations = __v)
    def withArch(__v: _root_.scala.Predef.String): PkgInfo = copy(arch = __v)
    def withOrganization(__v: _root_.scala.Predef.String): PkgInfo = copy(organization = __v)
    def withContact(__v: _root_.scala.Predef.String): PkgInfo = copy(contact = __v)
    def withUrl(__v: _root_.scala.Predef.String): PkgInfo = copy(url = __v)
    def clearStructuredAnnotations = copy(structuredAnnotations = _root_.scala.Seq.empty)
    def addStructuredAnnotations(__vs: p4.config.v1.p4types.StructuredAnnotation *): PkgInfo = addAllStructuredAnnotations(__vs)
    def addAllStructuredAnnotations(__vs: Iterable[p4.config.v1.p4types.StructuredAnnotation]): PkgInfo = copy(structuredAnnotations = structuredAnnotations ++ __vs)
    def withStructuredAnnotations(__v: _root_.scala.Seq[p4.config.v1.p4types.StructuredAnnotation]): PkgInfo = copy(structuredAnnotations = __v)
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = name
          if (__t != "") __t else null
        }
        case 2 => {
          val __t = version
          if (__t != "") __t else null
        }
        case 3 => doc.orNull
        case 4 => annotations
        case 10 => annotationLocations
        case 5 => {
          val __t = arch
          if (__t != "") __t else null
        }
        case 6 => {
          val __t = organization
          if (__t != "") __t else null
        }
        case 7 => {
          val __t = contact
          if (__t != "") __t else null
        }
        case 8 => {
          val __t = url
          if (__t != "") __t else null
        }
        case 9 => structuredAnnotations
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PString(name)
        case 2 => _root_.scalapb.descriptors.PString(version)
        case 3 => doc.map(_.toPMessage).getOrElse(_root_.scalapb.descriptors.PEmpty)
        case 4 => _root_.scalapb.descriptors.PRepeated(annotations.iterator.map(_root_.scalapb.descriptors.PString(_)).toVector)
        case 10 => _root_.scalapb.descriptors.PRepeated(annotationLocations.iterator.map(_.toPMessage).toVector)
        case 5 => _root_.scalapb.descriptors.PString(arch)
        case 6 => _root_.scalapb.descriptors.PString(organization)
        case 7 => _root_.scalapb.descriptors.PString(contact)
        case 8 => _root_.scalapb.descriptors.PString(url)
        case 9 => _root_.scalapb.descriptors.PRepeated(structuredAnnotations.iterator.map(_.toPMessage).toVector)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion: p4.config.v1.p4info.PkgInfo.type = p4.config.v1.p4info.PkgInfo
    // @@protoc_insertion_point(GeneratedMessage[p4.config.v1.PkgInfo])
}

object PkgInfo extends scalapb.GeneratedMessageCompanion[p4.config.v1.p4info.PkgInfo] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[p4.config.v1.p4info.PkgInfo] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): p4.config.v1.p4info.PkgInfo = {
    var __name: _root_.scala.Predef.String = ""
    var __version: _root_.scala.Predef.String = ""
    var __doc: _root_.scala.Option[p4.config.v1.p4info.Documentation] = _root_.scala.None
    val __annotations: _root_.scala.collection.immutable.VectorBuilder[_root_.scala.Predef.String] = new _root_.scala.collection.immutable.VectorBuilder[_root_.scala.Predef.String]
    val __annotationLocations: _root_.scala.collection.immutable.VectorBuilder[p4.config.v1.p4types.SourceLocation] = new _root_.scala.collection.immutable.VectorBuilder[p4.config.v1.p4types.SourceLocation]
    var __arch: _root_.scala.Predef.String = ""
    var __organization: _root_.scala.Predef.String = ""
    var __contact: _root_.scala.Predef.String = ""
    var __url: _root_.scala.Predef.String = ""
    val __structuredAnnotations: _root_.scala.collection.immutable.VectorBuilder[p4.config.v1.p4types.StructuredAnnotation] = new _root_.scala.collection.immutable.VectorBuilder[p4.config.v1.p4types.StructuredAnnotation]
    var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 10 =>
          __name = _input__.readStringRequireUtf8()
        case 18 =>
          __version = _input__.readStringRequireUtf8()
        case 26 =>
          __doc = Option(__doc.fold(_root_.scalapb.LiteParser.readMessage[p4.config.v1.p4info.Documentation](_input__))(_root_.scalapb.LiteParser.readMessage(_input__, _)))
        case 34 =>
          __annotations += _input__.readStringRequireUtf8()
        case 82 =>
          __annotationLocations += _root_.scalapb.LiteParser.readMessage[p4.config.v1.p4types.SourceLocation](_input__)
        case 42 =>
          __arch = _input__.readStringRequireUtf8()
        case 50 =>
          __organization = _input__.readStringRequireUtf8()
        case 58 =>
          __contact = _input__.readStringRequireUtf8()
        case 66 =>
          __url = _input__.readStringRequireUtf8()
        case 74 =>
          __structuredAnnotations += _root_.scalapb.LiteParser.readMessage[p4.config.v1.p4types.StructuredAnnotation](_input__)
        case tag =>
          if (_unknownFields__ == null) {
            _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
          }
          _unknownFields__.parseField(tag, _input__)
      }
    }
    p4.config.v1.p4info.PkgInfo(
        name = __name,
        version = __version,
        doc = __doc,
        annotations = __annotations.result(),
        annotationLocations = __annotationLocations.result(),
        arch = __arch,
        organization = __organization,
        contact = __contact,
        url = __url,
        structuredAnnotations = __structuredAnnotations.result(),
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[p4.config.v1.p4info.PkgInfo] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      p4.config.v1.p4info.PkgInfo(
        name = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        version = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        doc = __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).flatMap(_.as[_root_.scala.Option[p4.config.v1.p4info.Documentation]]),
        annotations = __fieldsMap.get(scalaDescriptor.findFieldByNumber(4).get).map(_.as[_root_.scala.Seq[_root_.scala.Predef.String]]).getOrElse(_root_.scala.Seq.empty),
        annotationLocations = __fieldsMap.get(scalaDescriptor.findFieldByNumber(10).get).map(_.as[_root_.scala.Seq[p4.config.v1.p4types.SourceLocation]]).getOrElse(_root_.scala.Seq.empty),
        arch = __fieldsMap.get(scalaDescriptor.findFieldByNumber(5).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        organization = __fieldsMap.get(scalaDescriptor.findFieldByNumber(6).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        contact = __fieldsMap.get(scalaDescriptor.findFieldByNumber(7).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        url = __fieldsMap.get(scalaDescriptor.findFieldByNumber(8).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        structuredAnnotations = __fieldsMap.get(scalaDescriptor.findFieldByNumber(9).get).map(_.as[_root_.scala.Seq[p4.config.v1.p4types.StructuredAnnotation]]).getOrElse(_root_.scala.Seq.empty)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = P4InfoProto.javaDescriptor.getMessageTypes().get(2)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = P4InfoProto.scalaDescriptor.messages(2)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = {
    var __out: _root_.scalapb.GeneratedMessageCompanion[_] = null
    (__number: @_root_.scala.unchecked) match {
      case 3 => __out = p4.config.v1.p4info.Documentation
      case 10 => __out = p4.config.v1.p4types.SourceLocation
      case 9 => __out = p4.config.v1.p4types.StructuredAnnotation
    }
    __out
  }
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = p4.config.v1.p4info.PkgInfo(
    name = "",
    version = "",
    doc = _root_.scala.None,
    annotations = _root_.scala.Seq.empty,
    annotationLocations = _root_.scala.Seq.empty,
    arch = "",
    organization = "",
    contact = "",
    url = "",
    structuredAnnotations = _root_.scala.Seq.empty
  )
  implicit class PkgInfoLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, p4.config.v1.p4info.PkgInfo]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, p4.config.v1.p4info.PkgInfo](_l) {
    def name: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.name)((c_, f_) => c_.copy(name = f_))
    def version: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.version)((c_, f_) => c_.copy(version = f_))
    def doc: _root_.scalapb.lenses.Lens[UpperPB, p4.config.v1.p4info.Documentation] = field(_.getDoc)((c_, f_) => c_.copy(doc = Option(f_)))
    def optionalDoc: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Option[p4.config.v1.p4info.Documentation]] = field(_.doc)((c_, f_) => c_.copy(doc = f_))
    def annotations: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Seq[_root_.scala.Predef.String]] = field(_.annotations)((c_, f_) => c_.copy(annotations = f_))
    def annotationLocations: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Seq[p4.config.v1.p4types.SourceLocation]] = field(_.annotationLocations)((c_, f_) => c_.copy(annotationLocations = f_))
    def arch: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.arch)((c_, f_) => c_.copy(arch = f_))
    def organization: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.organization)((c_, f_) => c_.copy(organization = f_))
    def contact: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.contact)((c_, f_) => c_.copy(contact = f_))
    def url: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.url)((c_, f_) => c_.copy(url = f_))
    def structuredAnnotations: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Seq[p4.config.v1.p4types.StructuredAnnotation]] = field(_.structuredAnnotations)((c_, f_) => c_.copy(structuredAnnotations = f_))
  }
  final val NAME_FIELD_NUMBER = 1
  final val VERSION_FIELD_NUMBER = 2
  final val DOC_FIELD_NUMBER = 3
  final val ANNOTATIONS_FIELD_NUMBER = 4
  final val ANNOTATION_LOCATIONS_FIELD_NUMBER = 10
  final val ARCH_FIELD_NUMBER = 5
  final val ORGANIZATION_FIELD_NUMBER = 6
  final val CONTACT_FIELD_NUMBER = 7
  final val URL_FIELD_NUMBER = 8
  final val STRUCTURED_ANNOTATIONS_FIELD_NUMBER = 9
  def of(
    name: _root_.scala.Predef.String,
    version: _root_.scala.Predef.String,
    doc: _root_.scala.Option[p4.config.v1.p4info.Documentation],
    annotations: _root_.scala.Seq[_root_.scala.Predef.String],
    annotationLocations: _root_.scala.Seq[p4.config.v1.p4types.SourceLocation],
    arch: _root_.scala.Predef.String,
    organization: _root_.scala.Predef.String,
    contact: _root_.scala.Predef.String,
    url: _root_.scala.Predef.String,
    structuredAnnotations: _root_.scala.Seq[p4.config.v1.p4types.StructuredAnnotation]
  ): _root_.p4.config.v1.p4info.PkgInfo = _root_.p4.config.v1.p4info.PkgInfo(
    name,
    version,
    doc,
    annotations,
    annotationLocations,
    arch,
    organization,
    contact,
    url,
    structuredAnnotations
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[p4.config.v1.PkgInfo])
}
