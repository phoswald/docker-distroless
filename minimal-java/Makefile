
Minimal.class : Minimal.java
	javac *.java

jre.tar.gz : 
	curl -L -o jre.tar.gz https://github.com/AdoptOpenJDK/openjdk15-binaries/releases/download/jdk-15.0.2%2B7/OpenJDK15U-jre_x64_linux_hotspot_15.0.2_7.tar.gz

image : Dockerfile Minimal.class jre.tar.gz
	docker build -t minimal-java . 

run : image
	docker run -it --rm -e CALLER=Makefile minimal-java

clean :
	rm -f *.class
	rm -f jre.tar.gz
	docker image prune -f
