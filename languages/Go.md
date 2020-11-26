# Go
- a relatively new, very fast, compiled language coined by Google

- uses structures instead of classes

- doesn't have exceptions or an exception handling mechanism

- every .go file must start with the package definition, resembling Java

- every project must have a main package

- after the package declaration, the import() zone can be defined
        
- imports examples
    - fmt - standard I/O methods
    - error - used for error generation
    - math - mathematical functions

- "Hello world" example
    ```go
    package main

    import (
        "fmt"
    )

    fnc main() {
        fmt.Println("Hello world!")
    }

    fnc otherFunction(x int, y int) (int) { }
    ```

- to compile a .go file use the "go build"

- to compile all the .go files from a directory, use `"go install"`

to compile and run a .go file use `"go run filename"`
    
- declaring a variable
    - explicit form: var x int = 5
    - short form: x := 5
        - when using the short form, Go will autodetect the variable type
    
- branching
    ```go
    if x > 6 {
        //do something
    } else if {
        //do something else
    } else {
        //last something
    }
    ```

- declaring an array 
    - explicit form: 
        ```go
        var a [5]int
        a[1] = 5
        ```
        
    - short form:
        ```go
        a := [5]int{1,2,3,4,5}
        ```

- slices - creates an array with variable length
    ```go
    a := []int{5,4,3,2,1}
    a = append(a, 13)
    ```
        
- map
    - syntax: newMap := make(map[key]values)
        ```go
        newMap := make(map[string]int)
        newMap["test"] = 5
        delete(newMap, "testing")
        ```
    
- loops
    - `for syntax` 
        ```go
        for i := 0; i < 5; i++ { fmt.Println(i) }
        ```

    - the while instruction doesn't exist, but for can be used instead using a particular structure
        ```go
        i := 0
        for i < 5 {
            fmt.Println(i)
            i++
        }
        ```

    - usage of `range` with `for`
        ```go
        arr := []string("a", "b", "c")

        for index, value := range arr {
            fmt.Println("index: ", index, "value", value)
        }
        ```
    
- functions can have multiple return values
    ```go
    func main() {
        result, err := someFnc(25)

        if err != nil {
            fmt.Println(err)
        } else {
            fmt.Println(result)
        }
    }

    func someFnc(x int) (int, error) { 
        if x < 0 {
            return 0, erors.New("Undefined for negative numbers")
        }

        return math.Sqrt(x), nil
    }
    ```

- structures
    - they are used instead of classes
    - they contain only fields
        ```go
        type person struct {
            name string,
            age int
        }

        func main() {
            p := person{name: "Jake", age: 23}
            fmt.Println(p.age)
        }
        ```

- pointers
    - referenced using `&`
    - dereferenced using `*`
    - similar to `C` pointers
        ```go 
        package main
        import "fmt"

        func changeByValue(val int) {
            val = 5
        }

        func changeByAddress(val *int) {
            *val = 5
        }

        func main() {
            i := 1
            pt := new(int)

            changeByValue(i)

            *pt = i

            fmt.Println(i)

            changeByAddress(&i)
            fmt.Println(i)

            fmt.Println(*pt)
        }
        ```
