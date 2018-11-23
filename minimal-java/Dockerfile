FROM opensuse/leap:42.3 AS prepare

# Set up Java by copying it to /usr/local and creating symlinks in /usr/local/bin
ADD --chown=root:root dependencies/jdk-8u181-linux-x64.tar.gz /usr/local

RUN set -x \
 && ln -s -t /usr/local/bin /usr/local/jdk1.8.0_181/bin/java \
 && ln -s -t /usr/local/bin /usr/local/jdk1.8.0_181/bin/javac \
#&& ln -s -t /lib64         /usr/local/jdk1.8.0_181/lib/amd64/jli/libjli.so \
#&& ln -s -t /lib64         /usr/local/jdk1.8.0_181/jre/lib/amd64/libjava.so \
 && echo OK

# Copy everything we need from / to /stage
RUN set -x \
 && mkdir -p /stage/lib64 \
 && mkdir -p /stage/usr/local/bin \
 && cp    /lib64/ld-linux-x86-64.so.2 /stage/lib64/ \
 && cp    /lib64/libc.so.6            /stage/lib64/ \
 && cp    /lib64/libpthread.so.0      /stage/lib64/ \
#&& cp    /lib64/libjli.so            /stage/lib64/ \
#&& cp    /lib64/libjava.so           /stage/lib64/ \
 && cp    /lib64/libdl.so.2           /stage/lib64/ \
 && cp    /lib64/libm.so.6            /stage/lib64/ \
 && cp -r /usr/local/jdk1.8.0_181     /stage/usr/local/ \
 && cp    /usr/local/bin/java         /stage/usr/local/bin/ \
 && cp    /usr/local/bin/javac        /stage/usr/local/bin/\
 && echo OK

###############################################################################

FROM scratch

# Copy root filesystem from /stage of previous image
COPY --from=prepare /stage /

# Define some environment stuff (just for fun)
ENV APPLICATION Minimal Stuff

# Copy application and define command
WORKDIR /usr/local/application/
COPY Minimal.class .
CMD ["/usr/local/jdk1.8.0_181/bin/java", "Minimal"]
