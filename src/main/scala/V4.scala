import p4.v1.p4runtime.{
    Entity,
    ReadRequest,
    ReadResponse,
    WriteRequest,
    WriteResponse,
    SetForwardingPipelineConfigRequest,
    SetForwardingPipelineConfigResponse,
    GetForwardingPipelineConfigRequest,
    GetForwardingPipelineConfigResponse
}

case class ConnSettings(ip : Int, port : Int)

case class Conn()

enum V4[A]:
    case StreamChannel(cs : ConnSettings) extends V4[Conn]
    case Read(c : Conn, e : Entity) extends V4[Entity]
    case Insert(c : Conn, e : Entity) extends V4[Entity]
    case Update(c : Conn, e : Entity) extends V4[Entity]
    case Delete(c : Conn, e : Entity) extends V4[Entity]
    //case SetConfig(c : Conn, cfg : SetForwardingPipelineConfigRequest) extends V4[SetForwardingPipelineConfigResponse]
    //case GetConfig(c : Conn, cfg : GetForwardingPipelineConfigRequest) extends V4[GetForwardingPipelineConfigResponse]
    case End[A](v : A) extends V4[A]
    case Seq[R, R2](ma : V4[R], b : R => V4[R2]) extends V4[R2]

    def read(c : Conn, e : Entity) = Read(c, e)
    def insert(c : Conn, e : Entity) = Insert(c, e)
    def update(c : Conn, e : Entity) = Update(c, e)
    def delete(c : Conn, e : Entity) = Delete(c, e)
    //def setConfig(c : Conn, cfg : SetForwardingPipelineConfigRequest) = SetConfig(c, cfg)
    //def getConfig(c : Conn, cfg : GetForwardingPipelineConfigRequest) = GetConfig(c, cfg)
    def end(v : A) = End(v)
    def `>>`[R2] (cont : A => V4[R2]) = Seq (this, cont)

/*
\x : Bool. {x} match {True => 42; False => 43}

Types and their members:

UpdateType ::=
    unspec
  | insert
  | modify
  | delete

FieldMatchType ::=
    exact
  | ternary
  | optional
  | lpm
  | range

TableId ::=
    MyIngress_ipv4_lpm
  | MyIngress_myTunnel_exact

Update ::=
  Update {
    type :: UpdateType,
    entity :: TableEntry {type}
  }

TableEntry ::= \UT <: UpdateType.
  TableEntry {
    table_id :: TableId
    match :: FieldMatches {table_id}
    action :: TableActions1 UT {table_id}
    priority :: Priority {table_id}
  }

FiedlMatches ::= \T <: TableId.
  T match
    {MyIngress_ipv4_lpm} =>
      Option {Hdr_ipv4_dstAddr}
    {MYIngress_myTunnel_exact} =>
       {Hdr_myTunnel_dst_id}

Priority ::= \T <: TableId.
  T match
    {MyIngress_ipv4_lpm} =>
      Int
    {MyIngress_myTunnel_exact} =>
      Nothing

// Figure out a proper way to represent enum args
FieldMatch ::=
    Hdr_ipv4_dstAddr    {value :: ByteString, prefix_len :: Int)
  | Hdr_myTunnel_dst_id {value :: ByteString}

TableAction_DSL ::=
    NoAction
  | MyIngress_drop
  | MyIngress_ipv4_forward     {dstAddr :: Int, port :: Int} // Bitwidth 48, 9
  | MyIngress_myTunnel_ingress {dst_id :: Int} // Bitwidth 16
  | MyIngress_myTunnel_forward {port : Int} // Bitwidth 9
  | MyIngress_myTunnel_egress  {dstAddr : Int, port : Int) // Bitwidth 48, 9

TableActions1 ::= \UT <: UpdateType. \T <: TableID.
  U match
    case {insert} =>
      TableActions2 T
    case Any =>
      Option (TableActions2 T)

TableActions2 ::= \T <: TableId.
  T match
    {MyIngress_ipv4_lpm} =>
        {NoAction}
      | {MyIngress_drop}
      | {MyIngress_ipv4_forward}
      | {MyIngress_myTunnel_ingress}
    {MyIngress_myTunnel_exact} =>
        {MyIngress_drop.type}
      | {MyIngress_myTunnel_forward}
      | {MyIngress_myTunnel_egress}

Int is a type, 42 and 43 are constructors of that type. {42} and {43} are each distinct types.

S : {T, A}
T are the tables
A are the actions
U : {`insert`, `modify`, `delete`, `undef`}

m : T -> {F}
ta : T -> {A}
F : {N, mt} where N is the bitwidth of the field
mt : {`exact`, `lpm`, `range`, `ternary`, `optional`}

a : A -> N gives the arity of an action

S | StreamChannel(...) -> c     (with fresh c)
S | StreamChannel(...) >> \x.read(x,r) >> \y...
S | c >> \x.read(x,r) >> \y...
S | read(c,r) >> \y...
If S ||- r
    S | S(r) >> \y...
    S | (\y...) (S(r))
If S ||/- r
    S | bot >> \y...
    S | (\y...) bot


*/