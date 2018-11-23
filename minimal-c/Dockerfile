FROM opensuse/leap:42.3 AS prepare

# Copy everything we need from / to /stage
# Also define symlinks for application binary 
RUN set -x \
 && mkdir -p /stage/lib64 \
 && mkdir -p /stage/usr/local/bin \
 && cp /lib64/ld-linux-x86-64.so.2 /stage/lib64/ \
 && cp /lib64/libc.so.6            /stage/lib64/ \
 && ln -s -t /stage/usr/local/bin  /usr/local/application/minimal

####################################################################3333#######

FROM scratch

# Copy root filesystem from /stage of previous image
COPY --from=prepare /stage /

# Define some environment stuff (just for fun)
ENV APPLICATION Minimal Stuff

# Copy application and define command
WORKDIR /usr/local/application/
COPY minimal .
CMD ["minimal"]
