import safeP4R._
import com.google.protobuf.ByteString
import scala.annotation.switch

@main def firewall() =
  val s1 = config1.connect(0, "127.0.0.1", 50051)
  val s2 = config1.connect(1, "127.0.0.1", 50052)
  val s3 = config2.connect(2, "127.0.0.1", 50053)

  for (s <- List(s1, s2, s3))
    insert(s1, TableEntry(
      "Process.firewall",
      Some("hdr.ipv4.dstAddr", LPM(bytes(10,0,4,4), 32)),
      "Process.drop",
      (), 1
    ))

  /*
  val s1_all_entries = read(s1,TableEntry("*", "*", "*", "*", 0))
  for (entry <- s1_all_entries) yield
    entry.table match
      case "Process.firewall" => insert(s2, TableEntry("Process.firewall", entry.matches, "*", "*", 0))
      case _ => true
  */
  s1.disconnect()
  s2.disconnect()