# SafeP4R compiler

This repository contains the sbt project for the SafeP4R compiler: a compiler
that generates Scala 3 type and an API from a p4info file.

## Usage

### Generating the API

The project requires [sbt](https://www.scala-sbt.org/) to run.
Clone the project, then compile it using

    sbt compile

To compile a p4info file into a Scala 3 package, use

    sbt parseP4info <p4info-file> <package-name>

where `p4info-file` is the path of the p4info file to be compiled, and
`package-name` is the name of the package to be generated.
The resulting compilation is written to stdout.

### Using the API

_This section assumes that you are using sbt to manage your project._

First, create the folder `src/main/protobuf/` in your project directory. Then,
place the following files in the appropriate subdirectories:

 * [`any.proto`](https://github.com/protocolbuffers/protobuf/blob/main/src/google/protobuf/any.proto) in `src/main/protobuf/google/protobuf/`
 * [`status.proto`](https://github.com/googleapis/googleapis/blob/master/google/rpc/status.proto) in `src/main/protobuf/google/rpc/`
 * [`p4info.proto`](https://github.com/p4lang/p4runtime/blob/main/proto/p4/config/v1/p4info.proto) in `src/main/protobuf/p4/config/v1/`
 * [`p4types.proto`](https://github.com/p4lang/p4runtime/blob/main/proto/p4/config/v1/p4types.proto) in `src/main/protobuf/p4/config/v1/`
 * [`p4data.proto`](https://github.com/p4lang/p4runtime/blob/main/proto/p4/v1/p4data.proto) in `src/main/protobuf/p4/v1/`
 * [`p4runtime.proto`](https://github.com/p4lang/p4runtime/blob/main/proto/p4/v1/p4runtime.proto) in `src/main/protobuf/p4/v1/`

Now, install [ScalaPB](https://scalapb.github.io/docs/installation) for the
project. Remember to also add the [gRPC](https://scalapb.github.io/docs/grpc/)
dependencies in `build.sbt`. Finally, run `sbt compile` to generate the Scala 3
files.

After completing the API generation step, place the generated code in a file
named `<package-name>.scala`, then place both `safeP4R.scala` and
`<package-name>.scala` in `src/main/scala/`.

### Using the VM

_The VM requires VirtualBox and Vagrant._

To start the VM, simply `cd safeP4R-vm/` and run `vagrant up`. The first time you start the VM, this takes 10-15 minutes.

In the VM, log in to the __safeP4R__ user using the password `safeP4R`.
Then, open a terminal, navigate to `/home/safeP4R` and run `make network`.
This will start mininet with a network of four hosts and four switches (see the `topology.json` file for the layout).
It also applies `config1` to `s1` and `s2`, and `config2` to `s3` and `s4`.
