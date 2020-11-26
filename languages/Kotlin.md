# Kotlin

- statically-typed language, developed by JetBrains

- it's a language that it's compiled to bytecode using the JVM

- conventionally, semicolons are not needed, but they can be used at the end of a statement

#
## Code snippet
```kt
val top_level_name = "Global_Example"

fun getSomething(something: String): String = println("getting $something")
	
fun main() {
	var mutable_name: String? = "Example"
	val immutable_name: String = "Example2"

	println("Hello Kotlin" + immutable_name)

	if(mutable_name != null) {
		println(mutable_name);
	}

	when(argument) {
		first_equals_condition -> println("hi when first condition")
		second_equals_condition -> println("hi when second condition")
		else -> { 
			println("hi when null")
		}
	}

	getSomething("sweet")

	val arr = arrayOf("Kotlin", "World")
	val ls = listOf("something", "else")
	val mp = mapOf(1 to "a", 2 to "b")
}

class Animal {
	override fun toString(): String = println("to string implementation")
}
```

# 
## Variables & types
- they can be mutable or immutable
	- var - a mutable variable

	- val - local, immutable variables, produces and error when updated

- they can be declared outside functions and classes
	- they are called "Top Level Variables"


- by default, variables are non-nullable, and will throw an error when a null is assigned
	- to be nullable, the definition types should have a ? after it
		```kt
		var t: String? = null
		```
	
- an easier way to declare variables is to let Kotlin detect variable type
	- the variables declared this way are always non-nullable (standard syntax should be used for nullable) 
		```kt
		val immutable_name = "Example"
		```

- Special Types
	- Any - represents the root of every non-nullable class hierarchy (similar to Object in Java)
		    - nulls can be stored using the general notation Any?	
	
	- Unit - represents the void notation and it's optional when declaring functions
	
	- Nothing - it's used for the functions that will never return a normal value (eg: throwing an exception without being caught)

#
## Control Instructions

- `if`
	```kt
	if(condition) {
		println("write something")
	} else if(condition2) {
		println("write something else")
	} else {
		println("last time to write something")
	}
	```

- `one-liner if`
	```kt
	val result = if(condition) true else false
	```

- `when`
	```kt
    when(argument) {
        first_equals_condition -> println("hi when first condition")
        second_equals_condition -> println("hi when second condition")
        else -> { 
        	println("hi when null")
        }
    }
	```

- `for`
	```kt
    for (item in items) {
        println(item)
    }
	```

- `foreach`
	- `it` is the default name for looped elements iterators

		```kt
      	someArray.forEach {
        	println(it)
      	}

      	someArray.forEach { element ->
        	println(element)
      	}
		```

- `foreach with index`
	```kt
    someArray.forEachIndexed{ index, element -> 
        	println("$element on $index")
    }
	```

- `==`
	- checks if two instances have equal attributes values

- `===`
	- checks if two instances are, actually, the same instance

#
## Functions
- functions can be defined outside classes and are called "top level functions"
- functions can accept both positional arguments and named arguments that can have different positions (but they cannot be mixed)
	```kt
	fun getSomething(name: String, age: Int) = print("$name: $age")
			
	getSomething("Alex", 22)
	getSomething(age=22, name="Alex")
	```

- functions accepts a default parameter value
	```kt
	fun getSomething(name: String = "Alex") = print("$name")
			getSomething()
	```

- basic functions
	```kt
	fun getSomething(something: String): String {
        return "getting $something"
    }
    
	println(getSomething())
	```

- lambdas
	```kt
	val funct: () -> Unit = { println("Hello world") }
	funct()

	val funct = () -> println("Hello world")
	funct()
	```

- single expression function
	```kt
	fun getSomething(): String = "getting something'"
	```

#
## Collections
- are immutable by default
	
- Immutable Collections
	- Array
		```kt
		val iarr = arrayOf("Kotlin", "World")
		```
					
	- List
		```kt
		val ils = listOf("something", "else")
		```
	
	- Map
		```kt
		val imp = mapOf(1 to "a", 2 to "b")
		```

- Mutable Collections
	- the declarations are the same as for immuttable collections, but they contains the "mutable" word in the beginning
		```kt
		val marr = mutableArrayOf("Kotlin", "World")
		val mls = mutableListOf("something", "else")
		val mmp = mutableMapOf(1 to "a", 2 to "b")
		```

#
## Keywords
- `vararg`
	- similar to Java's ... notation
	- allows a function to take a variable number of parameters as input
		```kt
		function getSomething(vararg items: String) = println(items.size)
		```

- `*arrayVariable`
	- the spread variable, similar to JavaScripts' ... notation

- `super`
	- the same as in Java

- `is`
	- the same as Java's instanceof

- `as`
	- used for explicit casting
		```kt
		Parent parent = child as Parent
		```
- `open`
	- allows a class to be inherited

- `sealed`
	- allows defining strict hierarchical structures

- `data class`
	- defines a class that auto-implements
		- constructor
		- componentN methods that work like accessors
		- toString
		- equals 
		- hashCode
		- copy
	-  methods and attributes of a data class can be defined as an extension, outside class definition
		```kt
		data class Medium(val id: Int)
		
		fun Medium.printInfo(): String = println(id)
		
		val Medium.age: Int
		```

- `copy`
	- creates a shallow copy of an instance

#
## Classes
- private classes are available only inside the file where they are defined

- abstract classes are preceeded by the "abstract" keyword

- the "new" keyword is optional when instantiating a class

- the default constructor can be defined right after the class definition
	```kt
	class Person(firstName: String, lastName: String)
	```

- like functions, the default constructor can accept default parameter values

- the values received through the constructor can be used either inside an init block or directly when defined
	```kt
	//init block
	class Person(_firstName: String, _lastName: String) {
		val firstName: String
		val lastName: String

		init {
			firstName = _firstName
			lastName = _lastNAme
		}
	}

	//at definition
	class Person(_firstName: String, _lastName: String) {
		val firstName: String = _firstName
		val lastName: String = _lastName
	}
	```

- the properties can be defined and map directly in the default constructor
	```kt
	class Person(val firstName: String, val lastName: String) {}
	```

- classes can define secondary constructors using the "constructor" keyword
	```kt
	class Person(val firstName: String, val lastName: String) {
		constructor(): this("Peter", "Parker") {
			println("Secondary constructor")
		}
	}
	```

#
## Getters  & Setters
- are accessed directly using the property name

- are defined directly under field definition
	```kt
	class Person(val firstName: String, val lastName: String) {
		var nickName: String? = null
			set(value) {
				field = value
			}
			get() {
				println("the value of nickName is $field")
			}
	}
	
	p1 = Person("Peter", "Parker")
	p1.nickName = "Spider-Man"
	println(p1.nickName)
	```

# 
## Visibility Modifiers
- `private` - visible for class members only
- `protected` - visible for class members & subclasses
- `internal` - visible for module members
- `public` - default

#
## Class Methods
- declare a simple method inside the class

- the method has access to class members without prior qualifications (eg: no need for this keyword)

#
## Interfaces
- can define both attributes and methods prototypes, but attributes cannot have a default value

- inside the classes, implemented methods and attributes are preceeded by the "override" keyword

- interfaces can provide default implementations for its methods without using any Keyword
	
- are implements using the : notation
	```kt
	class BasicImplementation : BasicInterface
	```

#
## Object Expressions
- allows anonymous inheritance of a class
	```kt
	val provider = object : ParentClass {
		override val name: String

		fun getUpperName(): String = name.toUpperCase()
	}
	
	println(provider.getUpperName())
	```
	
#
## Companion Objects
- it's an object scoped to an instance of another class that can access its properties
	```kt
	class Entity private constructor(val id: String) {
		companion object {
			fun create() = Entity("id")
		}
	}

	fun main() {
		val entity = Entity.create()
	}
	```
			
#
## Object Declarations
- allows anonymous classes instantiation
	```kt
	object AnonObject { 
		name: String
			get() {
				return name
			}
	}

	AnonObject.name
	```

#
## Enums
```kt
enum class EnumType {
	EASY, MEDIUM, HARD
}

EnumType.EASY
```

#
## Sealed classes
- they work like an enum, but can accept different parameters for each type

- all the classes that will inherit a sealed class must be declared in the same file as the sealed class itself
	```kt
	sealed class Entity() {
		data class Easy(val id: String): Entity()
		
		data class Medium(val id: String, val name: String): Entity()
			
		data class Hard(val id: String, val name: String, val age: Int): Entity()
	}
	```

#
## Higher Order Functions
- based on the passing of functions as parameters (as function parameters)
    ```kt
    fun higherOrder(name: String, embeddedFunction: (String) -> Boolean): String {
        return when(embeddedFunction("YES")) {
            true -> "yes"
            false -> "yes"
        }
    }
    
	println(higherOrder("test", {false}))
	```

- if the last parameter of a function is a function parameter, then it could be passed outside function call, inside braces
    ```kt
    println(higherOrder("test"){false})
	```

- if the function parameter is nullable, the .invoke method should be used to check if the function can be safely called
    ```kt
    fun higherOrder(name: String, embeddedFunction: ((String) -> Boolean)?): String {
        return when(embeddedFunction?.invoke() == "YES") {
            true -> "yes"
            false -> "yes"
        }
    }
	```
