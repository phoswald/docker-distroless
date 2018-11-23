FROM opensuse/leap:42.3 AS prepare

# Copy everything we need from / to /stage
RUN set -x \
 && mkdir -p /stage/lib64 \
 && cp /lib64/ld-linux-x86-64.so.2 /stage/lib64/ \
 && cp /lib64/libc.so.6            /stage/lib64/ 

####################################################################3333#######

FROM scratch

COPY --from=prepare /stage /

ENV APPLICATION Minimal Stuff

COPY minimal /usr/local/application/

ENTRYPOINT ["/usr/local/application/minimal"]
CMD []
