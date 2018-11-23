FROM opensuse/leap:42.3 AS prepare

# Set up Java by copying it to /usr/local
ADD --chown=root:root jdk.tar.gz /usr/local

# Copy everything we need from / to /stage
RUN set -x \
 && mkdir -p /stage/lib64 \
 && mkdir -p /stage/usr/local \
 && cp    /lib64/ld-linux-x86-64.so.2 /stage/lib64/ \
 && cp    /lib64/libc.so.6            /stage/lib64/ \
 && cp    /lib64/libpthread.so.0      /stage/lib64/ \
 && cp    /lib64/libdl.so.2           /stage/lib64/ \
 && cp    /lib64/libm.so.6            /stage/lib64/ \
 && cp -r /usr/local/jdk*             /stage/usr/local/jdk

###############################################################################

FROM scratch

# Copy root filesystem from /stage of previous image
COPY --from=prepare /stage /
ENV PATH /usr/local/jdk/bin

# Copy application and define command
WORKDIR /usr/local/application/
COPY Minimal.class .
CMD ["java", "Minimal"]
