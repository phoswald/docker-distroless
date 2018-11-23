
minimal : minimal.c
	gcc -D_GNU_SOURCE -o minimal minimal.c

image : Dockerfile minimal 
	docker build -t minimal-c . 

run : image
	docker run -it --rm -e CALLER=Makefile minimal-c arg1 arg2

clean :
	rm -f minimal
	docker image prune -f