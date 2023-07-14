# SafeP4R artifact instructions

This repository contains:

  * In `safeP4R/`: The code for the SafeP4R API and type generator, as well as examples that use the SafeP4R API.
  * In `vm/`: A virtual machine that sets up a simulation network using mininet, which can be used to test the API.

## Prerequisites

__This artifact requires:__

  * [sbt](https://www.scala-sbt.org/) (for building the SafeP4R API and type generator)
  * [VirtualBox](https://www.virtualbox.org/wiki/Downloads) (for running the examples)
  * [Vagrant](https://www.vagrantup.com/) (for running the examples)

## Kick-the-Tires Guide

From now on, we write `$ROOT` to denote the root directory of the artifact.

  1. Navigate to the `$ROOT/vm/` directory.
  3. Run `vagrant up` to build and run the VM. Building the VM will take 10-15 minutes.
  4. When the `vagrant` building procedure is complete, the VM will reboot.
     (From now on, you can launch the VM from VirtualBox, without using `vagrant` again.)
  5. When the VM presents a graphical log-in prompt:
      1. Log on as user __safeP4R__ with the password `safeP4R`.
      2. Open a terminal in the VM and run `make test` (in the home directory of the user safeP4R).
         This will start the mininet network simulation with four hosts and four switches `s1`..`s4`
         (see the `topology.json` file for the layout).
         It also applies the P4 configuration `config1` to `s1` and `s2`, and `config2` to `s3` and `s4`.
         You will see the `mininet>` prompt and the message `Ready to receive requests!`.
  6. Now, on the **host** machine that is running the VM, navigate to the `$ROOT/safeP4R/` directory.
  7. Run `sbt "runMain safeP4Rtest"`. This will compile and run the program
     `src/main/scala/examples/safeP4Rtest.scala`, which connects to the mininet network in the VM and
     sends some test queries to the `s1` switch.

If everything goes well, after the last step you will see `Test successful!` followed by `[success]`.
**NOTE**: you may also see the following message, that **you can ignore**:

    [ERROR] io.grpc.StatusRuntimeException: UNAVAILABLE: Channel shutdown

At this point, the artifact should be working.

## Project layout

The source code directory `$ROOT/safeP4R/src/main/scala/` contains several subfolders:

  * `protobuf/`: The "untyped" P4Runtime API code, generated by [ScalaPB](https://scalapb.github.io/docs/installation)
    from the protobuf specification (which itself is found in `safeP4R/src/protobuf/`).
  * `typegen/`: The SafeP4R type generator, which parses a given P4info file and outputs corresponding Scala 3 types
    (as per the encoding described in Definition 5.2 of the companion paper)
  * `api/`: The type-parametric SafeP4R API used for making P4Runtime queries, outlined in Section 7 of the companion paper.
  * `examples/`: Examples that use the SafeP4R API with generated types. All these examples require the SafeP4R VM to be running.

## Type generation

The following instructions must be followed from inside the directory `$ROOT/safeP4R/`.

To compile a P4info file into a Scala 3 package, use

    sbt "runMain parseP4info <p4info-file> <package-name>"

where `<p4info-file>` is the relative path of the P4info file to be compiled, and
`<package-name>` is the name of the package to be generated.
The generated Scala package is written to stdout.

As an example of how to generate a package, navigate to the `$ROOT/safeP4R/` directory and run:

    sbt "runMain parseP4info src/main/scala/examples/config1.p4info.json config1"

This will generate a Scala package based on the configuration in the `config1.p4info.json` file
and write it to stdout.  The generated Scala package contains:

* A set of match types capturing the dependencies between P4Runtime entities (tables, actions, ...)
* A `connect` function, which establishes a connection to a P4Runtime server and returs a `Chan`nel
* A `Chan` class, usable to perform the P4Runtime operations (insert, delete, ...) supported by
  our SafeP4R API.

### Generated match types

This section outlines the match types generated by our tool, which are also described in the paper.

As an example, consider a P4Info file with these tables and actions:

    "tables": [
      {
        "preamble": {
          "id": 50014192,
          "name": "Process.ipv4_lpm",
          "alias": "ipv4_lpm"
        },
        "matchFields": [
          {
            "id": 1,
            "name": "hdr.ipv4.dstAddr",
            "bitwidth": 32,
            "matchType": "LPM"
          }
        ],
        "actionRefs": [
          { "id": 26706864 },
          { "id": 22338797 }
        ],
        "size": "1024"
      }
    ],
    "actions": [
      {
        "preamble": {
          "id": 22338797,
          "name": "Process.drop",
          "alias": "drop"
        }
      },
      {
        "preamble": {
          "id": 26706864,
          "name": "Process.ipv4_forward",
          "alias": "ipv4_forward"
        },
        "params": [
          {
            "id": 1,
            "name": "dstAddr",
            "bitwidth": 48
          },
          {
            "id": 2,
            "name": "port",
            "bitwidth": 9
          }
        ]
      }
    ]

This would produce the following types:

    type TableMatchFields[TN] =
      TN match
        case "Process.ipv4_lpm" => (Option[("hdr.ipv4.dstAddr", LPM)]) | "*"
        case "*" => "*"
    type ActionName = "Process.drop" | "Process.ipv4_forward" | "*"

    type TableAction[TN] <: ActionName =
      TN match
        case "Process.ipv4_lpm" => "Process.ipv4_forward" | "Process.drop" | "*"
        case "*" => "*"

    type ActionParams[AN] =
      AN match
        case "Process.drop" => Unit
        case "Process.ipv4_forward" => (("dstAddr", ByteString), ("port", ByteString))
        case "*" => "*"

### The `connect` function

The `connect` function connects the controller to a target (i.e. a device that
supports P4 and P4Runtime, e.g. a network switch), returning a `Chan` object
representing the connection (see below).

Why is the `connect` function generated as part of a package, and not
type-parametric like the other SafeP4R API functions? This is done to instantiate
the type parameters of `Chan` objects with the aforementioned match types, according
to the P4Info of the target device.  This way, we can hide the complexity from the user
--- who is only required to invoke `<package>.connect(...)` (where `<package>` is
tenerated from the P4 configuration of the switch they are trying to connect to).

### The `Chan` class

A `Chan` object represents a connection between a target (i.e. a device that
supports P4 and P4Runtime, e.g. a network switch) and a controller (the program
acting as P4Runtime client). The `Chan` class generated by our tool inherits from
an abstract `Chan` class in the `safeP4R` package, which is type-parametric.
The generated `Chan` class is always instantiated with the match types from its
own package. By doing this, the type-parametric SafeP4R API functions that
take `Chan` objects (e.g. `insert`, `delete`, ...) will have their types
constrained by the types from the associated package: this ensures the correctness
of API calls, and also helps the Scala compiler infer the type arguments whitout
the user having to provide them explicitly.

Internally, the `Chan` class contains two functions, `toProto` and `fromProto`,
which convert table entries from their strongly-typed SafeP4R representation to
their underlying "loosely-typed" protobuf representations, and vice versa.

## Reproducing the examples in the companion paper

The following instructions must be followed from inside the directory `$ROOT/safeP4R/`.

The instructions for running all examples are given below.  In general, each example can be run by launching:

    sbt "runMain <main-function>"

where `<main-function>` is the `@main` function to be run
(usually named the same as the example file itself).

**NOTE**: when execution of an example terminates, the connection to each target device is closed,
which causes the following message that **you can ignore**:

    [ERROR] io.grpc.StatusRuntimeException: UNAVAILABLE: Channel shutdown

### IMPORTANT: before you try any of the examples below

All provided examples require the SafeP4R VM to be running.  **Moreover**, each example assumes
a clean configuration where the network switches have no preconfigured table entries.

For this reason, **before and in-between running any of the examples below**, you need to perform
the following steps **on the VM**:
1. if the mininet network simulation is already running, close it (Ctrl+d);
2. run `make clean`;
3. run `make build`;
4. run `make network`.

### Testing the effect of running the examples

All of the examples described below affect the connectivity of the network to some degree.
To verify that the examples have had any effect, you can use e.g. a `ping` command at the
`mininet>` prompt on the VM, such as:

    h1 ping h2

With this command, host `h1` will then attempt to periodically send packets to `h2`. The
sending of packets can be stopped with Ctrl+c.

If you attempt a `ping` command _before_ running one of the examples below, you will see
no output: this is because there is no route between any of the hosts in the virtual network
simulated by `mininet`.

After you run one of the examples below, the P4 tables of the devices in the virtual network
will be updated, and packets will be able to flow (at least along some routes)  As a
consequence, a `ping` command like the one above will produce an output similar to:

    mininet> h1 ping h2
    PING 10.0.2.2 (10.0.2.2) 56(84) bytes of data.
    64 bytes from 10.0.2.2: icmp_seq=1 ttl=62 time=6.15 ms
    64 bytes from 10.0.2.2: icmp_seq=2 ttl=62 time=3.43 ms
    64 bytes from 10.0.2.2: icmp_seq=3 ttl=62 time=3.27 ms
    ...

### Simple IPv4 table update (Fig. 1 in the companion paper)

The example can be found in `$ROOT/safeP4R/src/main/scala/examples/forward_c1.scala`
(with the erroneous, non-compiling code commented out) and can be executed by running
(on the host machine, from inside the directory `$ROOT/safeP4R/`):

    sbt "runMain forward_c1"

__Effect__: The program will insert table entries for `s1` and `s2` such that
`h1` and `h2` can communicate with (ping) each other.

### Second simple table update

The example can be found in `$ROOT/safeP4R/src/main/scala/examples/forward_c2.scala`
and can be executed by running (on the host machine, from inside the directory
`$ROOT/safeP4R/`):

    sbt "runMain forward_c2"

__Effect__: The program will insert table entries for `s3` and `s4` such that
`h3` and `h4` can communicate with (ping) each other.

### Multi-switch update (Fig. 16 in the companion paper)

The example can be found in `$ROOT/safeP4R/src/main/scala/examples/firewall.scala`
and can be executed by running (on the host machine, from inside the directory
`$ROOT/safeP4R/`):

    sbt "runMain firewall"

__Effect__: The program will insert table entries into the `firewall` table in
each switch, causing packets with destination addresses to `h1` or `h4` to be
dropped. Effectively, this means that communication is only possible between
`h2` and `h3`.

### Full connectivity

The example can be found in `$ROOT/safeP4R/src/main/scala/examples/bridge.scala` and
can be executed by using

    sbt "runMain bridge"

__Effect__: The program will insert table entries for all switches such that
each host can communicate with any other host.

## Creating a new scenario

We now provide an small example to demonstrate how updating/extending a P4 configuration can cause
existing P4Runtime programs to "go out of sync".  Our SafeP4R API can detect these
situations and produce type errors, thus preventing incorrect P4Runtime programs from compiling and running.

  1. In the VM, open the file `config1.p4` (in the home directory of the user safeP4R), and
     rename the `ipv4_forward` action on line 95 and 119 to `ipv4_transfer`.
  2. In the VM, recompile the P4 file and P4Info file by running `make clean` followed by `make build`.
     This will generate a new P4Info file in `build/config1.p4.p4info.json`.
  3. Copy the contents of the new P4Info file onto a file in your host machine, such as
     `$ROOT/safeP4R/src/main/scala/examples/config1_new.p4info.json`.
  4. On the host machine, generate new types from the updated P4info file. If you use the file name above,
     the command is:

         sbt "runMain parseP4info src/main/scala/examples/config1_new.p4info.json config1_new"

  5. On the host machine, create a new Scala file `$ROOT/safeP4R/src/main/scala/examples/config1_new.scala`,
     and copy&paste there the Scala code produced by the command at point 4.
  6. On the host machine, edit the file `$ROOT/safeP4R/src/main/scala/examples/forward_c1.scala` by
     replacing the package name `config1` in lines 6 and 7 with `config1_new`.
  7. On the host machine, try to compile and run the modified program above by running:

         sbt "runMain forward_c1"

     The compilation should fail, reporting an error around line 12: this reflects the fact that the
     code does not match the updated P4 configuration (it is accessing a table called `ipv4_forward`,
     but the table is now called `ipv4_transfer`).
  8. Fix the program by changing `"Process.ipv4_forward"` in line 12 to `"Process.ipv4_transfer"`.
     The program now compile and run.

If you are familiar with the P4 language, you can follow the steps above to try more experiments: you
can apply other changes to the file `config1.p4` (e.g. rename actions, change their parameter types,
modify the associations between tables and actions...) and observe how the changes are reflected in
the types generated by SafeP4R, and how a program using the SafeP4R API must be updated in order to
type-check and compile after such changes.
