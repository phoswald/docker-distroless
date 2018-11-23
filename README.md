# docker-distroless

Experiments with minimalistic Docker images

## Build and run image (C)

    $ cd minimal-c
    $ make run

## Inspect base image and built image

    $ docker save -o opensuse-leap-42.3.tar opensuse/leap:42.3
    $ docker save -o minimal-c.tar minimal-c:latest
