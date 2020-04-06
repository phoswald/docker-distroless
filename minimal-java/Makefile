
Minimal.class : Minimal.java
	javac *.java

jre.tar.gz : 
	curl -L -o jre.tar.gz https://github.com/AdoptOpenJDK/openjdk11-binaries/releases/download/jdk-11.0.6%2B10/OpenJDK11U-jre_x64_linux_hotspot_11.0.6_10.tar.gz

image : Dockerfile Minimal.class jre.tar.gz
	docker build -t minimal-java . 

run : image
	docker run -it --rm -e CALLER=Makefile minimal-java

clean :
	rm -f *.class
	rm -f jre.tar.gz
	docker image prune -f
