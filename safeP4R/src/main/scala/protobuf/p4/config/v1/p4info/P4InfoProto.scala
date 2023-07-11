// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package p4.config.v1.p4info

object P4InfoProto extends _root_.scalapb.GeneratedFileObject {
  lazy val dependencies: Seq[_root_.scalapb.GeneratedFileObject] = Seq(
    com.google.protobuf.any.AnyProto,
    p4.config.v1.p4types.P4TypesProto
  )
  lazy val messagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] =
    Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]](
      p4.config.v1.p4info.P4Info,
      p4.config.v1.p4info.Documentation,
      p4.config.v1.p4info.PkgInfo,
      p4.config.v1.p4info.P4Ids,
      p4.config.v1.p4info.Preamble,
      p4.config.v1.p4info.Extern,
      p4.config.v1.p4info.ExternInstance,
      p4.config.v1.p4info.MatchField,
      p4.config.v1.p4info.Table,
      p4.config.v1.p4info.ActionRef,
      p4.config.v1.p4info.Action,
      p4.config.v1.p4info.ActionProfile,
      p4.config.v1.p4info.CounterSpec,
      p4.config.v1.p4info.Counter,
      p4.config.v1.p4info.DirectCounter,
      p4.config.v1.p4info.MeterSpec,
      p4.config.v1.p4info.Meter,
      p4.config.v1.p4info.DirectMeter,
      p4.config.v1.p4info.ControllerPacketMetadata,
      p4.config.v1.p4info.ValueSet,
      p4.config.v1.p4info.Register,
      p4.config.v1.p4info.Digest
    )
  private lazy val ProtoBytes: _root_.scala.Array[Byte] =
      scalapb.Encoding.fromBase64(scala.collection.immutable.Seq(
  """ChlwNC9jb25maWcvdjEvcDRpbmZvLnByb3RvEgxwNC5jb25maWcudjEaGWdvb2dsZS9wcm90b2J1Zi9hbnkucHJvdG8aGnA0L
  2NvbmZpZy92MS9wNHR5cGVzLnByb3RvIpsICgZQNEluZm8SPgoIcGtnX2luZm8YASABKAsyFS5wNC5jb25maWcudjEuUGtnSW5mb
  0IM4j8JEgdwa2dJbmZvUgdwa2dJbmZvEjgKBnRhYmxlcxgCIAMoCzITLnA0LmNvbmZpZy52MS5UYWJsZUIL4j8IEgZ0YWJsZXNSB
  nRhYmxlcxI8CgdhY3Rpb25zGAMgAygLMhQucDQuY29uZmlnLnYxLkFjdGlvbkIM4j8JEgdhY3Rpb25zUgdhY3Rpb25zElkKD2Fjd
  Glvbl9wcm9maWxlcxgEIAMoCzIbLnA0LmNvbmZpZy52MS5BY3Rpb25Qcm9maWxlQhPiPxASDmFjdGlvblByb2ZpbGVzUg5hY3Rpb
  25Qcm9maWxlcxJACghjb3VudGVycxgFIAMoCzIVLnA0LmNvbmZpZy52MS5Db3VudGVyQg3iPwoSCGNvdW50ZXJzUghjb3VudGVyc
  xJZCg9kaXJlY3RfY291bnRlcnMYBiADKAsyGy5wNC5jb25maWcudjEuRGlyZWN0Q291bnRlckIT4j8QEg5kaXJlY3RDb3VudGVyc
  1IOZGlyZWN0Q291bnRlcnMSOAoGbWV0ZXJzGAcgAygLMhMucDQuY29uZmlnLnYxLk1ldGVyQgviPwgSBm1ldGVyc1IGbWV0ZXJzE
  lEKDWRpcmVjdF9tZXRlcnMYCCADKAsyGS5wNC5jb25maWcudjEuRGlyZWN0TWV0ZXJCEeI/DhIMZGlyZWN0TWV0ZXJzUgxkaXJlY
  3RNZXRlcnMSgwEKGmNvbnRyb2xsZXJfcGFja2V0X21ldGFkYXRhGAkgAygLMiYucDQuY29uZmlnLnYxLkNvbnRyb2xsZXJQYWNrZ
  XRNZXRhZGF0YUId4j8aEhhjb250cm9sbGVyUGFja2V0TWV0YWRhdGFSGGNvbnRyb2xsZXJQYWNrZXRNZXRhZGF0YRJFCgp2YWx1Z
  V9zZXRzGAogAygLMhYucDQuY29uZmlnLnYxLlZhbHVlU2V0Qg7iPwsSCXZhbHVlU2V0c1IJdmFsdWVTZXRzEkQKCXJlZ2lzdGVyc
  xgLIAMoCzIWLnA0LmNvbmZpZy52MS5SZWdpc3RlckIO4j8LEglyZWdpc3RlcnNSCXJlZ2lzdGVycxI8CgdkaWdlc3RzGAwgAygLM
  hQucDQuY29uZmlnLnYxLkRpZ2VzdEIM4j8JEgdkaWdlc3RzUgdkaWdlc3RzEjwKB2V4dGVybnMYZCADKAsyFC5wNC5jb25maWcud
  jEuRXh0ZXJuQgziPwkSB2V4dGVybnNSB2V4dGVybnMSRQoJdHlwZV9pbmZvGMgBIAEoCzIYLnA0LmNvbmZpZy52MS5QNFR5cGVJb
  mZvQg3iPwoSCHR5cGVJbmZvUgh0eXBlSW5mbyJlCg1Eb2N1bWVudGF0aW9uEiAKBWJyaWVmGAEgASgJQgriPwcSBWJyaWVmUgVic
  mllZhIyCgtkZXNjcmlwdGlvbhgCIAEoCUIQ4j8NEgtkZXNjcmlwdGlvblILZGVzY3JpcHRpb24iuQQKB1BrZ0luZm8SHQoEbmFtZ
  RgBIAEoCUIJ4j8GEgRuYW1lUgRuYW1lEiYKB3ZlcnNpb24YAiABKAlCDOI/CRIHdmVyc2lvblIHdmVyc2lvbhI3CgNkb2MYAyABK
  AsyGy5wNC5jb25maWcudjEuRG9jdW1lbnRhdGlvbkII4j8FEgNkb2NSA2RvYxIyCgthbm5vdGF0aW9ucxgEIAMoCUIQ4j8NEgthb
  m5vdGF0aW9uc1ILYW5ub3RhdGlvbnMSaQoUYW5ub3RhdGlvbl9sb2NhdGlvbnMYCiADKAsyHC5wNC5jb25maWcudjEuU291cmNlT
  G9jYXRpb25CGOI/FRITYW5ub3RhdGlvbkxvY2F0aW9uc1ITYW5ub3RhdGlvbkxvY2F0aW9ucxIdCgRhcmNoGAUgASgJQgniPwYSB
  GFyY2hSBGFyY2gSNQoMb3JnYW5pemF0aW9uGAYgASgJQhHiPw4SDG9yZ2FuaXphdGlvblIMb3JnYW5pemF0aW9uEiYKB2NvbnRhY
  3QYByABKAlCDOI/CRIHY29udGFjdFIHY29udGFjdBIaCgN1cmwYCCABKAlCCOI/BRIDdXJsUgN1cmwSdQoWc3RydWN0dXJlZF9hb
  m5vdGF0aW9ucxgJIAMoCzIiLnA0LmNvbmZpZy52MS5TdHJ1Y3R1cmVkQW5ub3RhdGlvbkIa4j8XEhVzdHJ1Y3R1cmVkQW5ub3Rhd
  GlvbnNSFXN0cnVjdHVyZWRBbm5vdGF0aW9ucyKJBAoFUDRJZHMi/wMKBlByZWZpeBIhCgtVTlNQRUNJRklFRBAAGhDiPw0SC1VOU
  1BFQ0lGSUVEEhcKBkFDVElPThABGgviPwgSBkFDVElPThIVCgVUQUJMRRACGgriPwcSBVRBQkxFEh0KCVZBTFVFX1NFVBADGg7iP
  wsSCVZBTFVFX1NFVBItChFDT05UUk9MTEVSX0hFQURFUhAEGhbiPxMSEUNPTlRST0xMRVJfSEVBREVSEi0KEVBTQV9FWFRFUk5TX
  1NUQVJUEBAaFuI/ExIRUFNBX0VYVEVSTlNfU1RBUlQSJwoOQUNUSU9OX1BST0ZJTEUQERoT4j8QEg5BQ1RJT05fUFJPRklMRRIZC
  gdDT1VOVEVSEBIaDOI/CRIHQ09VTlRFUhInCg5ESVJFQ1RfQ09VTlRFUhATGhPiPxASDkRJUkVDVF9DT1VOVEVSEhUKBU1FVEVSE
  BQaCuI/BxIFTUVURVISIwoMRElSRUNUX01FVEVSEBUaEeI/DhIMRElSRUNUX01FVEVSEhsKCFJFR0lTVEVSEBYaDeI/ChIIUkVHS
  VNURVISFwoGRElHRVNUEBcaC+I/CBIGRElHRVNUEjIKE09USEVSX0VYVEVSTlNfU1RBUlQQgAEaGOI/FRITT1RIRVJfRVhURVJOU
  19TVEFSVBISCgNNQVgQ/wEaCOI/BRIDTUFYIrMDCghQcmVhbWJsZRIXCgJpZBgBIAEoDUIH4j8EEgJpZFICaWQSHQoEbmFtZRgCI
  AEoCUIJ4j8GEgRuYW1lUgRuYW1lEiAKBWFsaWFzGAMgASgJQgriPwcSBWFsaWFzUgVhbGlhcxIyCgthbm5vdGF0aW9ucxgEIAMoC
  UIQ4j8NEgthbm5vdGF0aW9uc1ILYW5ub3RhdGlvbnMSaQoUYW5ub3RhdGlvbl9sb2NhdGlvbnMYByADKAsyHC5wNC5jb25maWcud
  jEuU291cmNlTG9jYXRpb25CGOI/FRITYW5ub3RhdGlvbkxvY2F0aW9uc1ITYW5ub3RhdGlvbkxvY2F0aW9ucxI3CgNkb2MYBSABK
  AsyGy5wNC5jb25maWcudjEuRG9jdW1lbnRhdGlvbkII4j8FEgNkb2NSA2RvYxJ1ChZzdHJ1Y3R1cmVkX2Fubm90YXRpb25zGAYgA
  ygLMiIucDQuY29uZmlnLnYxLlN0cnVjdHVyZWRBbm5vdGF0aW9uQhriPxcSFXN0cnVjdHVyZWRBbm5vdGF0aW9uc1IVc3RydWN0d
  XJlZEFubm90YXRpb25zIswBCgZFeHRlcm4SNwoOZXh0ZXJuX3R5cGVfaWQYASABKA1CEeI/DhIMZXh0ZXJuVHlwZUlkUgxleHRlc
  m5UeXBlSWQSPQoQZXh0ZXJuX3R5cGVfbmFtZRgCIAEoCUIT4j8QEg5leHRlcm5UeXBlTmFtZVIOZXh0ZXJuVHlwZU5hbWUSSgoJa
  W5zdGFuY2VzGAMgAygLMhwucDQuY29uZmlnLnYxLkV4dGVybkluc3RhbmNlQg7iPwsSCWluc3RhbmNlc1IJaW5zdGFuY2VzIogBC
  g5FeHRlcm5JbnN0YW5jZRJBCghwcmVhbWJsZRgBIAEoCzIWLnA0LmNvbmZpZy52MS5QcmVhbWJsZUIN4j8KEghwcmVhbWJsZVIIc
  HJlYW1ibGUSMwoEaW5mbxgCIAEoCzIULmdvb2dsZS5wcm90b2J1Zi5BbnlCCeI/BhIEaW5mb1IEaW5mbyLOBgoKTWF0Y2hGaWVsZ
  BIXCgJpZBgBIAEoDUIH4j8EEgJpZFICaWQSHQoEbmFtZRgCIAEoCUIJ4j8GEgRuYW1lUgRuYW1lEjIKC2Fubm90YXRpb25zGAMgA
  ygJQhDiPw0SC2Fubm90YXRpb25zUgthbm5vdGF0aW9ucxJpChRhbm5vdGF0aW9uX2xvY2F0aW9ucxgKIAMoCzIcLnA0LmNvbmZpZ
  y52MS5Tb3VyY2VMb2NhdGlvbkIY4j8VEhNhbm5vdGF0aW9uTG9jYXRpb25zUhNhbm5vdGF0aW9uTG9jYXRpb25zEikKCGJpdHdpZ
  HRoGAQgASgFQg3iPwoSCGJpdHdpZHRoUghiaXR3aWR0aBJTCgptYXRjaF90eXBlGAUgASgOMiIucDQuY29uZmlnLnYxLk1hdGNoR
  mllbGQuTWF0Y2hUeXBlQg7iPwsSCW1hdGNoVHlwZUgAUgltYXRjaFR5cGUSPwoQb3RoZXJfbWF0Y2hfdHlwZRgHIAEoCUIT4j8QE
  g5vdGhlck1hdGNoVHlwZUgAUg5vdGhlck1hdGNoVHlwZRI3CgNkb2MYBiABKAsyGy5wNC5jb25maWcudjEuRG9jdW1lbnRhdGlvb
  kII4j8FEgNkb2NSA2RvYxJFCgl0eXBlX25hbWUYCCABKAsyGS5wNC5jb25maWcudjEuUDROYW1lZFR5cGVCDeI/ChIIdHlwZU5hb
  WVSCHR5cGVOYW1lEnUKFnN0cnVjdHVyZWRfYW5ub3RhdGlvbnMYCSADKAsyIi5wNC5jb25maWcudjEuU3RydWN0dXJlZEFubm90Y
  XRpb25CGuI/FxIVc3RydWN0dXJlZEFubm90YXRpb25zUhVzdHJ1Y3R1cmVkQW5ub3RhdGlvbnMipwEKCU1hdGNoVHlwZRIhCgtVT
  lNQRUNJRklFRBAAGhDiPw0SC1VOU1BFQ0lGSUVEEhUKBUVYQUNUEAIaCuI/BxIFRVhBQ1QSEQoDTFBNEAMaCOI/BRIDTFBNEhkKB
  1RFUk5BUlkQBBoM4j8JEgdURVJOQVJZEhUKBVJBTkdFEAUaCuI/BxIFUkFOR0USGwoIT1BUSU9OQUwQBhoN4j8KEghPUFRJT05BT
  EIHCgVtYXRjaCLJBgoFVGFibGUSQQoIcHJlYW1ibGUYASABKAsyFi5wNC5jb25maWcudjEuUHJlYW1ibGVCDeI/ChIIcHJlYW1ib
  GVSCHByZWFtYmxlEk0KDG1hdGNoX2ZpZWxkcxgCIAMoCzIYLnA0LmNvbmZpZy52MS5NYXRjaEZpZWxkQhDiPw0SC21hdGNoRmllb
  GRzUgttYXRjaEZpZWxkcxJJCgthY3Rpb25fcmVmcxgDIAMoCzIXLnA0LmNvbmZpZy52MS5BY3Rpb25SZWZCD+I/DBIKYWN0aW9uU
  mVmc1IKYWN0aW9uUmVmcxJQChdjb25zdF9kZWZhdWx0X2FjdGlvbl9pZBgEIAEoDUIZ4j8WEhRjb25zdERlZmF1bHRBY3Rpb25JZ
  FIUY29uc3REZWZhdWx0QWN0aW9uSWQSQgoRaW1wbGVtZW50YXRpb25faWQYBiABKA1CFeI/EhIQaW1wbGVtZW50YXRpb25JZFIQa
  W1wbGVtZW50YXRpb25JZBJGChNkaXJlY3RfcmVzb3VyY2VfaWRzGAcgAygNQhbiPxMSEWRpcmVjdFJlc291cmNlSWRzUhFkaXJlY
  3RSZXNvdXJjZUlkcxIdCgRzaXplGAggASgDQgniPwYSBHNpemVSBHNpemUSdQoVaWRsZV90aW1lb3V0X2JlaGF2aW9yGAkgASgOM
  icucDQuY29uZmlnLnYxLlRhYmxlLklkbGVUaW1lb3V0QmVoYXZpb3JCGOI/FRITaWRsZVRpbWVvdXRCZWhhdmlvclITaWRsZVRpb
  WVvdXRCZWhhdmlvchI3Cg5pc19jb25zdF90YWJsZRgKIAEoCEIR4j8OEgxpc0NvbnN0VGFibGVSDGlzQ29uc3RUYWJsZRJVChBvd
  Ghlcl9wcm9wZXJ0aWVzGGQgASgLMhQuZ29vZ2xlLnByb3RvYnVmLkFueUIU4j8REg9vdGhlclByb3BlcnRpZXNSD290aGVyUHJvc
  GVydGllcyJfChNJZGxlVGltZW91dEJlaGF2aW9yEh8KCk5PX1RJTUVPVVQQABoP4j8MEgpOT19USU1FT1VUEicKDk5PVElGWV9DT
  05UUk9MEAEaE+I/EBIOTk9USUZZX0NPTlRST0wi+QMKCUFjdGlvblJlZhIXCgJpZBgBIAEoDUIH4j8EEgJpZFICaWQSPwoFc2Nvc
  GUYAyABKA4yHS5wNC5jb25maWcudjEuQWN0aW9uUmVmLlNjb3BlQgriPwcSBXNjb3BlUgVzY29wZRIyCgthbm5vdGF0aW9ucxgCI
  AMoCUIQ4j8NEgthbm5vdGF0aW9uc1ILYW5ub3RhdGlvbnMSaQoUYW5ub3RhdGlvbl9sb2NhdGlvbnMYBSADKAsyHC5wNC5jb25ma
  WcudjEuU291cmNlTG9jYXRpb25CGOI/FRITYW5ub3RhdGlvbkxvY2F0aW9uc1ITYW5ub3RhdGlvbkxvY2F0aW9ucxJ1ChZzdHJ1Y
  3R1cmVkX2Fubm90YXRpb25zGAQgAygLMiIucDQuY29uZmlnLnYxLlN0cnVjdHVyZWRBbm5vdGF0aW9uQhriPxcSFXN0cnVjdHVyZ
  WRBbm5vdGF0aW9uc1IVc3RydWN0dXJlZEFubm90YXRpb25zInwKBVNjb3BlEi0KEVRBQkxFX0FORF9ERUZBVUxUEAAaFuI/ExIRV
  EFCTEVfQU5EX0RFRkFVTFQSHwoKVEFCTEVfT05MWRABGg/iPwwSClRBQkxFX09OTFkSIwoMREVGQVVMVF9PTkxZEAIaEeI/DhIMR
  EVGQVVMVF9PTkxZIo8FCgZBY3Rpb24SQQoIcHJlYW1ibGUYASABKAsyFi5wNC5jb25maWcudjEuUHJlYW1ibGVCDeI/ChIIcHJlY
  W1ibGVSCHByZWFtYmxlEj8KBnBhcmFtcxgCIAMoCzIaLnA0LmNvbmZpZy52MS5BY3Rpb24uUGFyYW1CC+I/CBIGcGFyYW1zUgZwY
  XJhbXMagAQKBVBhcmFtEhcKAmlkGAEgASgNQgfiPwQSAmlkUgJpZBIdCgRuYW1lGAIgASgJQgniPwYSBG5hbWVSBG5hbWUSMgoLY
  W5ub3RhdGlvbnMYAyADKAlCEOI/DRILYW5ub3RhdGlvbnNSC2Fubm90YXRpb25zEmkKFGFubm90YXRpb25fbG9jYXRpb25zGAggA
  ygLMhwucDQuY29uZmlnLnYxLlNvdXJjZUxvY2F0aW9uQhjiPxUSE2Fubm90YXRpb25Mb2NhdGlvbnNSE2Fubm90YXRpb25Mb2Nhd
  GlvbnMSKQoIYml0d2lkdGgYBCABKAVCDeI/ChIIYml0d2lkdGhSCGJpdHdpZHRoEjcKA2RvYxgFIAEoCzIbLnA0LmNvbmZpZy52M
  S5Eb2N1bWVudGF0aW9uQgjiPwUSA2RvY1IDZG9jEkUKCXR5cGVfbmFtZRgGIAEoCzIZLnA0LmNvbmZpZy52MS5QNE5hbWVkVHlwZ
  UIN4j8KEgh0eXBlTmFtZVIIdHlwZU5hbWUSdQoWc3RydWN0dXJlZF9hbm5vdGF0aW9ucxgHIAMoCzIiLnA0LmNvbmZpZy52MS5Td
  HJ1Y3R1cmVkQW5ub3RhdGlvbkIa4j8XEhVzdHJ1Y3R1cmVkQW5ub3RhdGlvbnNSFXN0cnVjdHVyZWRBbm5vdGF0aW9ucyKBBAoNQ
  WN0aW9uUHJvZmlsZRJBCghwcmVhbWJsZRgBIAEoCzIWLnA0LmNvbmZpZy52MS5QcmVhbWJsZUIN4j8KEghwcmVhbWJsZVIIcHJlY
  W1ibGUSKgoJdGFibGVfaWRzGAIgAygNQg3iPwoSCHRhYmxlSWRzUgh0YWJsZUlkcxI2Cg13aXRoX3NlbGVjdG9yGAMgASgIQhHiP
  w4SDHdpdGhTZWxlY3RvclIMd2l0aFNlbGVjdG9yEh0KBHNpemUYBCABKANCCeI/BhIEc2l6ZVIEc2l6ZRI3Cg5tYXhfZ3JvdXBfc
  2l6ZRgFIAEoBUIR4j8OEgxtYXhHcm91cFNpemVSDG1heEdyb3VwU2l6ZRKFAQoXc2VsZWN0b3Jfc2l6ZV9zZW1hbnRpY3MYBiABK
  A4yMS5wNC5jb25maWcudjEuQWN0aW9uUHJvZmlsZS5TZWxlY3RvclNpemVTZW1hbnRpY3NCGuI/FxIVc2VsZWN0b3JTaXplU2VtY
  W50aWNzUhVzZWxlY3RvclNpemVTZW1hbnRpY3MiaQoVU2VsZWN0b3JTaXplU2VtYW50aWNzEicKDlNVTV9PRl9XRUlHSFRTEAAaE
  +I/EBIOU1VNX09GX1dFSUdIVFMSJwoOU1VNX09GX01FTUJFUlMQARoT4j8QEg5TVU1fT0ZfTUVNQkVSUyK+AQoLQ291bnRlclNwZ
  WMSPQoEdW5pdBgBIAEoDjIeLnA0LmNvbmZpZy52MS5Db3VudGVyU3BlYy5Vbml0QgniPwYSBHVuaXRSBHVuaXQicAoEVW5pdBIhC
  gtVTlNQRUNJRklFRBAAGhDiPw0SC1VOU1BFQ0lGSUVEEhUKBUJZVEVTEAEaCuI/BxIFQllURVMSGQoHUEFDS0VUUxACGgziPwkSB
  1BBQ0tFVFMSEwoEQk9USBADGgniPwYSBEJPVEgi/AEKB0NvdW50ZXISQQoIcHJlYW1ibGUYASABKAsyFi5wNC5jb25maWcudjEuU
  HJlYW1ibGVCDeI/ChIIcHJlYW1ibGVSCHByZWFtYmxlEjgKBHNwZWMYAiABKAsyGS5wNC5jb25maWcudjEuQ291bnRlclNwZWNCC
  eI/BhIEc3BlY1IEc3BlYxIdCgRzaXplGAMgASgDQgniPwYSBHNpemVSBHNpemUSVQoPaW5kZXhfdHlwZV9uYW1lGAQgASgLMhkuc
  DQuY29uZmlnLnYxLlA0TmFtZWRUeXBlQhLiPw8SDWluZGV4VHlwZU5hbWVSDWluZGV4VHlwZU5hbWUiyAEKDURpcmVjdENvdW50Z
  XISQQoIcHJlYW1ibGUYASABKAsyFi5wNC5jb25maWcudjEuUHJlYW1ibGVCDeI/ChIIcHJlYW1ibGVSCHByZWFtYmxlEjgKBHNwZ
  WMYAiABKAsyGS5wNC5jb25maWcudjEuQ291bnRlclNwZWNCCeI/BhIEc3BlY1IEc3BlYxI6Cg9kaXJlY3RfdGFibGVfaWQYAyABK
  A1CEuI/DxINZGlyZWN0VGFibGVJZFINZGlyZWN0VGFibGVJZCKlAQoJTWV0ZXJTcGVjEjsKBHVuaXQYASABKA4yHC5wNC5jb25ma
  WcudjEuTWV0ZXJTcGVjLlVuaXRCCeI/BhIEdW5pdFIEdW5pdCJbCgRVbml0EiEKC1VOU1BFQ0lGSUVEEAAaEOI/DRILVU5TUEVDS
  UZJRUQSFQoFQllURVMQARoK4j8HEgVCWVRFUxIZCgdQQUNLRVRTEAIaDOI/CRIHUEFDS0VUUyL4AQoFTWV0ZXISQQoIcHJlYW1ib
  GUYASABKAsyFi5wNC5jb25maWcudjEuUHJlYW1ibGVCDeI/ChIIcHJlYW1ibGVSCHByZWFtYmxlEjYKBHNwZWMYAiABKAsyFy5wN
  C5jb25maWcudjEuTWV0ZXJTcGVjQgniPwYSBHNwZWNSBHNwZWMSHQoEc2l6ZRgDIAEoA0IJ4j8GEgRzaXplUgRzaXplElUKD2luZ
  GV4X3R5cGVfbmFtZRgEIAEoCzIZLnA0LmNvbmZpZy52MS5QNE5hbWVkVHlwZUIS4j8PEg1pbmRleFR5cGVOYW1lUg1pbmRleFR5c
  GVOYW1lIsQBCgtEaXJlY3RNZXRlchJBCghwcmVhbWJsZRgBIAEoCzIWLnA0LmNvbmZpZy52MS5QcmVhbWJsZUIN4j8KEghwcmVhb
  WJsZVIIcHJlYW1ibGUSNgoEc3BlYxgCIAEoCzIXLnA0LmNvbmZpZy52MS5NZXRlclNwZWNCCeI/BhIEc3BlY1IEc3BlYxI6Cg9ka
  XJlY3RfdGFibGVfaWQYAyABKA1CEuI/DxINZGlyZWN0VGFibGVJZFINZGlyZWN0VGFibGVJZCKGBQoYQ29udHJvbGxlclBhY2tld
  E1ldGFkYXRhEkEKCHByZWFtYmxlGAEgASgLMhYucDQuY29uZmlnLnYxLlByZWFtYmxlQg3iPwoSCHByZWFtYmxlUghwcmVhbWJsZ
  RJaCghtZXRhZGF0YRgCIAMoCzIvLnA0LmNvbmZpZy52MS5Db250cm9sbGVyUGFja2V0TWV0YWRhdGEuTWV0YWRhdGFCDeI/ChIIb
  WV0YWRhdGFSCG1ldGFkYXRhGsoDCghNZXRhZGF0YRIXCgJpZBgBIAEoDUIH4j8EEgJpZFICaWQSHQoEbmFtZRgCIAEoCUIJ4j8GE
  gRuYW1lUgRuYW1lEjIKC2Fubm90YXRpb25zGAMgAygJQhDiPw0SC2Fubm90YXRpb25zUgthbm5vdGF0aW9ucxJpChRhbm5vdGF0a
  W9uX2xvY2F0aW9ucxgHIAMoCzIcLnA0LmNvbmZpZy52MS5Tb3VyY2VMb2NhdGlvbkIY4j8VEhNhbm5vdGF0aW9uTG9jYXRpb25zU
  hNhbm5vdGF0aW9uTG9jYXRpb25zEikKCGJpdHdpZHRoGAQgASgFQg3iPwoSCGJpdHdpZHRoUghiaXR3aWR0aBJFCgl0eXBlX25hb
  WUYBSABKAsyGS5wNC5jb25maWcudjEuUDROYW1lZFR5cGVCDeI/ChIIdHlwZU5hbWVSCHR5cGVOYW1lEnUKFnN0cnVjdHVyZWRfY
  W5ub3RhdGlvbnMYBiADKAsyIi5wNC5jb25maWcudjEuU3RydWN0dXJlZEFubm90YXRpb25CGuI/FxIVc3RydWN0dXJlZEFubm90Y
  XRpb25zUhVzdHJ1Y3R1cmVkQW5ub3RhdGlvbnMiqAEKCFZhbHVlU2V0EkEKCHByZWFtYmxlGAEgASgLMhYucDQuY29uZmlnLnYxL
  lByZWFtYmxlQg3iPwoSCHByZWFtYmxlUghwcmVhbWJsZRI6CgVtYXRjaBgCIAMoCzIYLnA0LmNvbmZpZy52MS5NYXRjaEZpZWxkQ
  griPwcSBW1hdGNoUgVtYXRjaBIdCgRzaXplGAMgASgFQgniPwYSBHNpemVSBHNpemUijQIKCFJlZ2lzdGVyEkEKCHByZWFtYmxlG
  AEgASgLMhYucDQuY29uZmlnLnYxLlByZWFtYmxlQg3iPwoSCHByZWFtYmxlUghwcmVhbWJsZRJICgl0eXBlX3NwZWMYAiABKAsyH
  C5wNC5jb25maWcudjEuUDREYXRhVHlwZVNwZWNCDeI/ChIIdHlwZVNwZWNSCHR5cGVTcGVjEh0KBHNpemUYAyABKAVCCeI/BhIEc
  2l6ZVIEc2l6ZRJVCg9pbmRleF90eXBlX25hbWUYBCABKAsyGS5wNC5jb25maWcudjEuUDROYW1lZFR5cGVCEuI/DxINaW5kZXhUe
  XBlTmFtZVINaW5kZXhUeXBlTmFtZSKVAQoGRGlnZXN0EkEKCHByZWFtYmxlGAEgASgLMhYucDQuY29uZmlnLnYxLlByZWFtYmxlQ
  g3iPwoSCHByZWFtYmxlUghwcmVhbWJsZRJICgl0eXBlX3NwZWMYAiABKAsyHC5wNC5jb25maWcudjEuUDREYXRhVHlwZVNwZWNCD
  eI/ChIIdHlwZVNwZWNSCHR5cGVTcGVjQi1aK2dpdGh1Yi5jb20vcDRsYW5nL3A0cnVudGltZS9nby9wNC9jb25maWcvdjFiBnByb
  3RvMw=="""
      ).mkString)
  lazy val scalaDescriptor: _root_.scalapb.descriptors.FileDescriptor = {
    val scalaProto = com.google.protobuf.descriptor.FileDescriptorProto.parseFrom(ProtoBytes)
    _root_.scalapb.descriptors.FileDescriptor.buildFrom(scalaProto, dependencies.map(_.scalaDescriptor))
  }
  lazy val javaDescriptor: com.google.protobuf.Descriptors.FileDescriptor = {
    val javaProto = com.google.protobuf.DescriptorProtos.FileDescriptorProto.parseFrom(ProtoBytes)
    com.google.protobuf.Descriptors.FileDescriptor.buildFrom(javaProto, _root_.scala.Array(
      com.google.protobuf.any.AnyProto.javaDescriptor,
      p4.config.v1.p4types.P4TypesProto.javaDescriptor
    ))
  }
  @deprecated("Use javaDescriptor instead. In a future version this will refer to scalaDescriptor.", "ScalaPB 0.5.47")
  def descriptor: com.google.protobuf.Descriptors.FileDescriptor = javaDescriptor
}