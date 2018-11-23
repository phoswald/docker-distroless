
Minimal.class : Minimal.java
	javac *.java

jre.tar.gz : 
	curl -L -o jre.tar.gz https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u192-b12/OpenJDK8U-jre_x64_linux_hotspot_8u192b12.tar.gz

image : Dockerfile Minimal.class jre.tar.gz
	docker build -t minimal-java . 

run : image
	docker run -it --rm -e CALLER=Makefile minimal-java

clean :
	rm -f *.class
	rm -f jre.tar.gz
	docker image prune -f