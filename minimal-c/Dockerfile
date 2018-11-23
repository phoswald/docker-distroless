FROM opensuse/leap:42.3 AS prepare

# Copy everything we need from / to /stage
RUN set -x \
 && mkdir -p /stage/lib64 \
 && cp /lib64/ld-linux-x86-64.so.2 /stage/lib64/ \
 && cp /lib64/libc.so.6            /stage/lib64/ 

####################################################################3333#######

FROM scratch

# Copy root filesystem from /stage of previous image
COPY --from=prepare /stage /

# Define some environment stuff (just for fun)
ENV APPLICATION Minimal Stuff

# Copy application and define entrypoint and command
# We use ENTRYPOINT instead of CMD so that both of the following work out of the box:
# `$ docker run <image>`           -> `$ minimal`
# `$ docker run <image> argument`  -> `$ minimal argument`
COPY minimal /usr/local/application/
ENTRYPOINT ["/usr/local/application/minimal"]
CMD []
