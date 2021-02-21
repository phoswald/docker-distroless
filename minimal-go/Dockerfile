FROM scratch

# Define user/group (optional, does NOT require /etc/passwd)
USER 1001:1002

# Copy application and define command
ENV PATH /usr/local/application
WORKDIR /usr/local/application
COPY minimal .
CMD ["minimal"]
