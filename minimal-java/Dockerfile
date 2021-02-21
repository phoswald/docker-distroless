FROM opensuse/leap:15.1 AS prepare

# Install required packages
RUN zypper --non-interactive install -n glibc-locale

# Set up Java by copying it to /usr/local
ADD --chown=root:root jre.tar.gz /usr/local

# Copy everything we need from / to /stage
RUN set -x \
 && mkdir -p /stage/lib64 \
 && mkdir -p /stage/usr/lib/locale \
#&& mkdir -p /stage/usr/share/locale \
 && mkdir -p /stage/usr/local \
 && mkdir -p /stage/etc \
 && cp    /lib64/ld-linux-x86-64.so.2 /stage/lib64/ \
 && cp    /lib64/libc.so.6            /stage/lib64/ \
 && cp    /lib64/libpthread.so.0      /stage/lib64/ \
 && cp    /lib64/libz.so.1            /stage/lib64/ \
 && cp    /lib64/libdl.so.2           /stage/lib64/ \
 && cp    /lib64/libm.so.6            /stage/lib64/ \
#&& cp    /lib64/librt.so.1           /stage/lib64/ \
 && cp -r /usr/lib/locale/de_CH.utf8  /stage/usr/lib/locale/ \
#&& cp -r /usr/share/locale/de        /stage/usr/share/locale/ \
#&& cp -r /usr/share/locale/de_CH     /stage/usr/share/locale/ \
 && cp -r /usr/local/jdk*             /stage/usr/local/jre \
 && echo "Europe/Zurich"           >  /stage/etc/timezone

###############################################################################

FROM scratch

# Copy root filesystem from /stage of previous image
COPY --from=prepare /stage /

ENV TZ                Europe/Zurich
ENV LANG              de_CH.UTF-8
ENV LC_ALL            de_CH.UTF-8
ENV PATH              /usr/local/jre/bin
ENV JAVA_TOOL_OPTIONS -XX:MaxRAMPercentage=50 -Dcaller=Docker

# Define user/group (optional, does NOT require /etc/passwd)
USER 1001:1002

# Copy application and define command
WORKDIR /usr/local/application/
COPY Minimal.class .
CMD ["java", "Minimal"]
