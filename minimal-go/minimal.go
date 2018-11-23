package main

import (
	"fmt"
	"os"
	"strings"
)

func main() {
	fmt.Println("This is MINIMAL (in GO)")

	fmt.Println()
	fmt.Println("Arguments:")
	for _, a := range os.Args {
		fmt.Println("- " + "'" + a + "'")
	}

	fmt.Println()
	fmt.Println("Environment:")
	for _, e := range os.Environ() {
		pair := strings.Split(e, "=")
		fmt.Println("- " + pair[0] + "='" + pair[1] + "'")
	}
}
