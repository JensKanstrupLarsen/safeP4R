# SafeP4R compiler

This repository contains:

  * In `safeP4R/`: The code for the SafeP4R API and type generator, as well as examples that use the API.
  * In `vm/`: A virtual machine that sets up a simulation network using mininet, which can be used to test the API.

## Prerequisites

__This project requires:__

  * [sbt](https://www.scala-sbt.org/) (for building the project)
  * [VirtualBox](https://www.virtualbox.org/wiki/Downloads) (for running the examples)
  * [Vagrant](https://www.vagrantup.com/) (for running the examples)

## Kick-the-Tires Guide

  1. Navigate to the `vm/` directory.
  2. Run `vagrant up` to build and run the VM. Building the VM will take 10-15 minutes.
  4. When the `vagrant` building procedure is complete, the VM will reboot.
     (From now on, you can launch the VM from VirtualBox, without using `vagrant` again.)
  5. When the VM presents a graphical log-in prompt:
      1. Log on as user __safeP4R__ with the password `safeP4R`.
      2. Open a terminal in the VM, navigate to `/home/safeP4R` and run `make test`.
         This will start the mininet network simulation with four hosts and four switches `s1`..`s4`
         (see the `topology.json` file for the layout).
         It also applies the P4 configuration `config1` to `s1` and `s2`, and `config2` to `s3` and `s4`.
  7. Now, navigate to the `safeP4R/` directory on the **host** machine that is running the VM.
  8. Run `sbt "runMain safeP4Rtest"`. This will run the program in `src/main/scala/examples/safeP4Rtest.scala`,
     which connects to the mininet network in the VM and sends some test queries to the `s1` switch.
     If everything goes well, it will print `Test successful!`.

## Project layout

The source code directory `safeP4R/src/main/scala/` contains several subfolders:

  * `protobuf/`: The "untyped" P4Runtime API code, generated by [ScalaPB](https://scalapb.github.io/docs/installation)
    from the protobuf specification (which itself is found in `safeP4R/src/protobuf/`).
  * `typegen/`: The type generator, which parses a given P4info file and outputs "equivalent" Scala 3 types.
  * `api/`: The type-parametric SafeP4R API used for making P4Runtime queries.
  * `examples/`: Examples that use the SafeP4R API with generated types. Requires the VM to be running.

## Type generation

To compile a P4info file into a Scala 3 package, use

    sbt "runMain parseP4info <p4info-file> <package-name>"

where `<p4info-file>` is the absolute path of the P4info file to be compiled, and
`<package-name>` is the name of the package to be generated.
The generated types are written to stdout.

## Reproducing the examples in the companion paper

The instructions for running all examples are given below.  In general, each example can be run by using

    sbt "runMain <main-function>"

where `<main-function>` is the `@main` function to be run
(usually named the same as the example file itself).

### IMPORTANT: before you try any of the examples below

All provided examples require the SafeP4R VM to be running.  **Moreover**, each example assumes
a clean configuration where the network switches have no preconfigured table entries.

For this reason, **before and in-between running any of the examples below**, you need to perform
the following steps on the VM:
1. if the mininet network simulation is already running, close it (Ctrl+d);
2. run `make clean`;
3. run `make network`.

### Simple IPv4 table update (Fig. 1)

The example can be found in `safeP4R/src/main/scala/examples/forward_c1.scala`
(with the non-functional code commented out) and can be run by using

    sbt "runMain forward_c1"

### Multi-switch update (Fig. 16)

The example can be found in `safeP4R/src/main/scala/examples/firewall.scala` and can be run by using

    sbt "runMain firewall"

## Creating a new scenario

We now provide an example to demonstrate how updating/extending a P4 program can cause
existing programs using the API to "go out of sync", i.e. not compile.

  1. In the VM, open the `/home/safeP4R/config1.p4` file, and rename the `ipv4_forward` action
     in line 95 and 119 to `ipv4_transfer` (or make any other structural change of your choice).
  2. Recompile the P4 file and P4Info file by running `make clean` followed by `make build`.
     This will generate a new P4Info file in `/home/safeP4R/build/config1.p4.p4info.json`.
  3. Copy the contents of the new P4Info file onto a file in your host machine, such as
     `safeP4R/safeP4R/src/main/scala/examples/config1_new.p4info.json`.
  4. Generate new types from the P4info file. If you use the file above, the command will look like

      sbt "runMain parseP4info path/to/config1_new.p4info.json config1_new"

  5. Create a new Scala file `config1_new.scala` in the `example/` directory, then place the
     newly generated types in that file.
  6. In `forward_c1.scala`, replace `config1` in line 6 and 7 with `config1_new`.
  7. Try to compile the program. It should fail, reporting an error around line 12.
  8. Fix the program by changing `"Process.ipv4_forward"` in line 12 to `"Process.ipv4_transfer"`.
     The program should then compile.
