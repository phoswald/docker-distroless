#include <stdio.h>
#include <unistd.h>

int main(int argc, char** argv) {
    puts("This is MINIMAL (in C)");

    puts("");
    printf("Arguments (count: %i):\n", argc);
    for(int i = 0; i < argc; i++) {
        printf("- '%s'\n", argv[i]);
    }

    puts("");
    printf("Environment:\n");
    char** current = environ;
    while(*current) {
        printf("- '%s'\n", *current);
        current++;
    }

    puts("");
    printf("User: real %i:%i, effective %i:%i\n", getuid(), getgid(), geteuid(), getegid());
}
