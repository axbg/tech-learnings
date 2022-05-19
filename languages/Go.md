# Go

### Introduction
- a relatively new, fast, compiled language coined by Google

- uses structures instead of classes

- doesn't have exceptions or an exception handling mechanism

- every *.go* file must start with the package definition, resembling Java

- every project must have a main package

- after the package declaration, the import() zone can be defined
        
- imports examples
    - fmt - standard I/O methods
    - error - used for error generation
    - math - mathematical functions

#
### Hello world
```go
package main

import (
    "fmt"
)

func main() {
    fmt.Println("Hello world!")
}
```

#
### CLI commands
- to compile a .go file use the `"go build <<filename>>"`

- to compile and run a .go file use `"go run <<filename>>"`
    
- to create a project that can compile multiple sources which are imported in a main file run `"go mod init <<project_name>>"`, to initialize a project, and `"go mod tidy"` to realign the configuration with the codebase

#
### Packaging
- each subpackage has to be stored in a different subdirectory with the same name as the subpackage declared in the .go file

- to make a structure accessible from the outside of the package, its name has to start with a capital letter
    - `func doSomethingPrivate()` - accessible only inside the package where it's declared
    - `func doSomethingPublic()` - accessible in imports 

#
### Basic Go
- Variables
    - declaring a variable
        - explicit form
            ```go
            var x int = 5
            ```
        - short form
            - with the short form, Go will use type inference to detect the variable type
            ```go
            x := 5
            ```

- Constants
    - declaring a constant
        ```go
        const x = 5
        ```
    
    - cannot be declared using the `:=` syntax

- Operators
    - the basic operators in go are common to the ones used in C
        - arithmetic: `+, -, *, /, %, ++, --`
        - assignment: `=, +=, -=, *=, /=, %=, &=, |=, ^=, >>=, <<=`
        - comparison: `==, !=, >, <, >=, <=`
        - logical: `&&, ||, !`
        - bitwise: `&, |, ^, <<, >>`

- Data types
    - the basic data types are:
        - `bool`
        - `byte` - alias for `uint8`
        - `uint`
            - `uint` - represents the default value
            - `uint8`
            - `uint16`
            - `uint32` - default on 32bits systems
            - `uint64` - default on 64bits systems
        - `int`
            - `int` - represents the default value
            - `int8`
            - `int16`
            - `int32` - default on 32bits systems
            - `int64` - default on 64bits systems
        - `float`
            - `float32`
            - `float64` - default
        - `complex`
            - `complex32`
            - `complex64`
        - `string`

    - the conversion from one type to another must be explicitly declared, and it has the format Type(value)
        ```go
        x : = 3
        y := float64(3)
        ```

    - to print the type of an interface the `%T` format can be used
        ```go
        v := 42
        fmt.Printf("v is of type %T\n", v)
        ```

- Branching
    - if
        - syntax
            ```go
            if x > 6 {
                //do something
            } else if {
                //do something else
            } else {
                //last something
            }
            ```

        - the if statement can start with a short assig statement that is executed before the condition is checked
            ```go
            if x := 5; x == 5 {
                fmt.Printf("it's 5: %d\n", x)
            } else {
                // the value declared in the if assign statement is also available in the branches
                fmt.Printf("it's not 5: %d\n", x)
            }
            ```
    - switch
        - unlike other popular languages, the `break` keyword is not used, as the execution targets only the identified case
            ```go
            a := 5

            switch a {
                case 5:
                    fmt.Println("it's 5")
                case 6:
                    fmt.Println("it's 6")
                // multi-case condition
                case 7,8:
                    fmt.Println("it's 7 or 8")
                default:
                    fmt.Println("it's something else :(")
            }
            ```

        - switch with no condition is the same as writing `switch true` and it can be useful to write cleaner if/else conditions
    
    - Defer
        - it postpones the execution of a function until the functions surrounding it finish running
            ```go
            func main() {
	            defer fmt.Println("world")

	            fmt.Println("hello")
            }
            ```
        
        - even though the call itself is delayed, the deferred call arguments are evaluated immediately

        - if multiple deferred calls are present in the same scope, they will be executed in a `last-in first-out` order, as they are organized using a stack

- Arrays
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

- Slices 
    - are similar to a reference to an array
    - an array with variable length
        ```go
        a := []int{}
        a = append(a, 13)

        // creating a slice from an array
        array := [5]int{1, 2, 3, 4, 5}
        slice := array[0:4]

        // a slice can be accessed using the index operator
        fmt.Println(slice[0])

        // modifying the value inside a slice
        slice[0] = 100

        // a slice can be appended to another slice using the ... append format
        slice2 := append(a, slice...)
        ```

    - the length and the cap of a slice can be obtained using the built-in functions *len* and *cap*
        ```go
        s := [6]int{1, 2, 3, 4, 5, 6}
        // prints 6, 6
        fmt.Println(len(s))
        fmt.Println(cap(s))

        x := s[:0]
        // prints 0, 6
        fmt.Println(len(x))
        fmt.Println(cap(x))

        t := []int{}
        // prints 0, 0
        fmt.Println(len(t))
        fmt.Println(cap(t))
        ```
        
    - slices can also be created using the *make* built-in function
        ```go
        // make(type, len, cap)
	    // 	the slice is initialized with 0 values equal to the len parameter
	    // 	the short version can omit the cap value: make([]int, 5)
	    b := make([]int, 1, 5)
	    fmt.Println(b, len(b), cap(b))
        ```

    - a slice can also be composed of other slices
        ```go
	    x := [][]int{[]int{1, 2, 3}, []int{4, 5, 6}}
	    fmt.Println(x)

	    y := make([][]int, 5)
	    fmt.Println(y)
        ```

- Maps
    - syntax
        ```go
        // full syntax declaration
        var newMap = map[string]int{}
        newMap["element1"] = 1

        // declaration and assignment
        newMap2 := map[string]int{"element1": 1}

        // using the make function
        newMap := make(map[string]int)
        newMap["test"] = 5

        // deleting a key:value pair
        delete(newMap, "testing")
        ```
    
    - while maps can store any type as value elements, they can use as keys only types for which the equality operator is defined
        - Booleans
        - Numbers
        - Strings
        - Arrays
        - Pointers
        - Structs
        - Interfaces (as long as the dynamic type supports equality)

- Loops
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

        // values can be skipped using the _ notation
        for _, value := range arr {
            fmt.Println("value", value)
        }
        ```

    - like in most other languages, the `continue` and `break` keywords can be used to skip to the next iteration or break the loop completely

- Functions
    - can have multiple return values
        ```go
        func someFunc(x int) (int, error) { 
            if x < 0 {
                return 0, erors.New("Undefined for negative numbers")
            }

            return math.Sqrt(x), nil
        }

        func main() {
            result, err := someFunc(25)

            if err != nil {
                fmt.Println(err)
            } else {
                fmt.Println(result)
            }
        }
        ```
    
    - the return values may be named, and they will behave like regular variables declared at the top of the function and returned in the end
        ```go
        func someFunc(x int) (y, z int) {
            y = x * 2
            z = x * 4
            return
        }

        func main() {
            y, z := someFunc(2)

            fmt.Println(y)
            fmt.Println(z)
        }
        ```

    - if two or more parameters have the same type, the type can be written only once
        ```go
        func someFnc(x, y, z int) {
            // do smth
        }
        ```

    - functions are first-class citizens, so they can be passed around like any other variables
        ```go
        func calculate(funcParam func(float64, float64) float64) float64 {
            fmt.Println("Executing the received function with parameters 5 and 5")
            return funcParam(5, 5)
        }

        func main() {
            power := func(x float64, y float64) float64 {
                return math.Pow(x, y)
            }

            fmt.Println(power(2, 2))
            fmt.Println(calculate(power))
        }
        ```

    - a function can also be a closure, which means that it will refer to variables defined outside its body, being bound to them
        ```go
        func mySumClosure() func(int) int {
            sum := 0
            return func(x int) int {
                sum += x
                return sum
            }
        }

        func main() {
            myClosure := mySumClosure()

            x := myClosure(1)
            y := myClosure(2)
            z := myClosure(3)

            fmt.Println(x, y, z)
        }
        ```

- Structures
    - they are used instead of classes
    - they contain only fields
        ```go
        package main

        import "fmt"

        type person struct {
            name string
            age int
        }

        func main() {
            p := person{name: "Jake", age: 23}
            fmt.Println(p.age)
        }
        ```

    - to make references to structures easier to read, dereferencing can be made without using explicitly the * symbol
        ```go
        package main

        import "fmt"

        type person struct {
            name string
            age int
        }

        func main() {
            p := person{name: "Jake", age: 23}
            pt := &p

            // transformed automatically to (*pt).age
            fmt.Println(pt.age)
        }  
        ```

    - a structure can be extended with methods
        ```go
        type person struct {
            name string
            age int
        }

        func (p person) GetName() string {
            return p.name
        }

        func main() {
            p := person{name: "Jake", age: 23}
            fmt.Println(p.GetName())
        }
        ```

- Interfaces
    - names collections of method signatures
        ```go
        package main

        import (
            "fmt"
            "math"
        )

        type geometry interface {
            area() float64
            perim() float64
            name() string
        }

        type rectangle struct {
            width, length float64
        }

        func (r rectangle) area() float64 {
            return r.width * r.length
        }

        func (r rectangle) perim() float64 {
            return 2 * r.width + 2 * r.length
        }

        func (r rectangle) name() string {
            return "rectangle"
        }

        type circle struct {
            radius float64
        }

        func (c circle) area() float64 {
            return math.Pi * c.radius * c.radius
        }

        func (c circle) perim() float64 {
            return 2 * math.Pi * c.radius
        }

        func (c circle) name() string {
            return "circle"
        }

        func computeSize(g geometry) {
            fmt.Printf("The area of %s is %f and the perimetre is %f\n", g.name(), g.area(), g.perim())
        }

        func main() {
            r := rectangle{width: 10, length: 5}
            c := circle{5}

            computeSize(r)
            computeSize(c)
        }
        ```

- Pointers
    - similar to `C` pointers
    - referenced using `&`
    - dereferenced using `*`
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
