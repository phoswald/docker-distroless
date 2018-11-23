
minimal : minimal.go
	go build minimal.go

image : Dockerfile minimal 
	docker build -t minimal-go . 

run : image
	docker run -it --rm -e CALLER=Makefile minimal-go minimal arg1 arg2

clean :
	rm -f minimal
	docker image prune -f