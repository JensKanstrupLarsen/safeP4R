import safeP4R._
import com.google.protobuf.ByteString
import scala.annotation.switch

@main def bridge() =
  val s1 = config1.connect(0, "127.0.0.1", 50051)
  val s2 = config1.connect(1, "127.0.0.1", 50052)
  val s3 = config2.connect(2, "127.0.0.1", 50053)
  val s4 = config2.connect(3, "127.0.0.1", 50054)

  insert(s1, TableEntry(
    "Process.ipv4_lpm",
    Some("hdr.ipv4.dstAddr", LPM(bytes(10,0,3,3), 32)),
    "Process.ipv4_forward",
    (("dstAddr", bytes(8,0,0,0,3,51)), ("port", bytes(3))), 1
  ))

  insert(s1, TableEntry(
    "Process.ipv4_lpm",
    Some("hdr.ipv4.dstAddr", LPM(bytes(10,0,4,4), 32)),
    "Process.ipv4_forward",
    (("dstAddr", bytes(8,0,0,0,4,68)), ("port", bytes(4))), 1
  ))

  insert(s3, TableEntry(
    "Process.ipv4_table",
    Some("hdr.ipv4.dstAddr", LPM(bytes(10,0,1,1), 32)),
    "Process.forward_packet",
    (("dstAddr", bytes(8,0,0,0,1,17)), ("port", bytes(1))), 1
  ))

  insert(s3, TableEntry(
    "Process.ipv4_table",
    Some("hdr.ipv4.dstAddr", LPM(bytes(10,0,2,2), 32)),
    "Process.forward_packet",
    (("dstAddr", bytes(8,0,0,0,2,34)), ("port", bytes(2))), 1
  ))

  val s1_all_entries = read(s1,TableEntry("Process.ipv4_lpm", "*", "*", "*", 0))
  for (entry <- s1_all_entries) yield
    insert(s2, entry)

  val s3_all_entries = read(s3,TableEntry("Process.ipv4_table", "*", "*", "*", 0))
  for (entry <- s3_all_entries) yield
    insert(s4, entry)

  s1.disconnect()
  s2.disconnect()
  s3.disconnect()
  s4.disconnect()
