# docker-distroless

Experiments with minimalistic Docker images

## Build and run image (C)

    $ cd minimal-c
    $ make run

## Build and run image (Java)

Manually download Oracle JDK from Oracle 
into `minimal-java/dependencies/jdk-8u181-linux-x64.tar.gz`

    $ cd minimal-java
    $ make run

## Inspect base image and built image

    $ docker save -o opensuse-leap-42.3.tar opensuse/leap:42.3
    $ docker save -o minimal-c.tar minimal-c:latest
