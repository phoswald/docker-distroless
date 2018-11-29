FROM opensuse/leap:42.3 AS prepare

# Copy everything we need from / to /stage
RUN set -x \
 && mkdir -p /stage/lib64 \
 && cp /lib64/ld-linux-x86-64.so.2 /stage/lib64/ \
 && cp /lib64/libc.so.6            /stage/lib64/

###############################################################################

FROM scratch

# Copy root filesystem from /stage of previous image
COPY --from=prepare /stage /

# Define user/group (optional, does NOT require /etc/passwd)
USER 1001:1002

# Copy application and define command
ENV PATH /usr/local/application
WORKDIR /usr/local/application
COPY minimal .
CMD ["minimal"]
