
Minimal.class : Minimal.java
	javac *.java

image : Dockerfile Minimal.class 
	docker build -t minimal-java . 

run : image
	docker run -it --rm -e CALLER=Makefile minimal-java

clean :
	rm -f *.class
	docker image prune -f