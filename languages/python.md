# Python Basics

## Operators
- `\#` - one line comment operator

- `"""text"""`- block of lines comment operator

- `2**2` - mathematical power operator

- `%s` - operator for string interpolation
	```py
	print("hello %s" % "you there")
	```

- `%d` - operator for integer interpolation

- operators binding order - `not > and > or`
	- 1 or 0 and 0 results 1

- `\` - used to break the current line of code
	```py
	if i > 1 and \
		i < 5:
	``` 

#
## Basic Methods
- `print("something")` 
	- prints a line to the console

- `len(string)`
	- returns the length of a string

- `str(string)` 
	- used to convert a variable to the String type

- `string.lower()` 
	- converts a string into lowercase

- `string.upper()`
	- converts a string into uppercase

- `string.isalpha()` 
	- checks if a string contains only letters

- `string1 = string1 + string2`  
	- concatenation of two strings

- `variable = input("text")` 
	- prints the given text and reads a keyboard input which will be stored inside the variable
	- supports typecasting: variable = int(raw_input("insert a number"))

#
## Date & Time
- `from datetime import datetime`
	- importing datetime library 
		
- `datetime.now()`
	- retrieving the current datetime

- elements composing the datetime can be accessed separately
	```py
	from datetime import datetime

	simple_date = datetime.now()

	print(simple_date.year)
	print(simple_date.month)
	print(simple_date.hour)
	print(simple_date.second)
	```

#
## Keywords 
- `elif` 
	- equivalent for "else if" in other languages

- `def function_name(parameters):` 
	- function declarations

- `import library` 
	- imports a whole library
	- to use a method from the imported library, the method name has to be prefixed: library.method

- `from library import function` 
	- imports a method that doesn't need to be prefixed

- `from library import *` 
	- imports a whole library and the methods doesn't need to be prefixed

#
## List
- Common methods
	- `my_list = ["tralala", 2, "tralala2"]` 
		- instantiating a list

	- `my_list.append(3)`   
		- adds a new value to a list

	- `my_list.index(element)` 
		- returns the index of the given element or an error if it's not found

	- `my_list.insert(index, element)` 
			- inserts an element on the given index
			
	- `my_list.sort()` 
		- sorts the list
			
	- `my_list.pop(index)` 
		- removes from the list the element placed on the given index position

	- `my_list.remove(element)` 
		- deletes the given element from the list

	- `for element in my_list:`  
		- alternative syntax to parse a list

	- `enumerate(my_list)` 
		- extract both the index and the value from a list
			```py
			for index, element in enumerate(my_list):
			```

	- `zip(list1, list2)` 
		- usually used to parse two lists at once
			```py
			for element1, element2 in zip(list1, list2):
			```
		- can be used to transform two lists into a zip object that can be transformed into an array of lists
			```py 
			my_zip = zip((1,2,3),(4, 5, 6))
			
			my_list = list(my_zip)
			
			# my_list will contain [(1,4), (2,5), (3,6)]
			```

- Slicing - used to substract elements from a list
	- `my_list[0:n]` 
		- returns the first n-1 elements

	- `my_list[:3]` 
		- returns the first 3 elements

	- `my_list[1:]` 
		- returns all the elements starting from the second one

	- `my_list[start:stop:step]`  
		- returns the elements from the start position to the stop, using a step
		- if the step is negative the list is parsed in reverse

- List Comprehension 
	- generates a list based on a specific computation
		```py
		# my_list will contain a list of squares with all the numbers lower than 12 which are divisible with 3
		my_list = [x**2 for x in range(12) if x % 3 == 0]
		```

#
## Dictionary
- similar to a map, has a key associated to every value
	```py 
	lloyd = {
		"name": "Lloyd",
		"homework": [90.0, 97.0, 75.0, 92.0],
		"quizzes": [88.0, 40.0, 94.0],
		"tests": [75.0, 90.0]
	}
	```

- Common methods
	- `lloyd.items()` 
		- get all key:value tuples as an array of lists

	- `lloyd.keys()` 
		- get all keys

	- `lloyd.values()` 
		- get all values

	- `dct = {"key": value, "key2": value2}` 
		- creating a new dictionnary

	- `dct[new_key] = new_value`
		- adding a new value to a dictionnary
		
	- `del dct[key]` 
		- deleting an element from a dictionnary

#
## Lambda Functions
- are annonymous functions declared locally
	```py
	fc = lambda x : print(x+2)
	
	print((fc(3))) will print 5
	```

- lambda functions can be sent as a parameter to other functions
	```py
	print(filter(lambda x : x == "Python", languages))
	```

# 
## OOP Concepts

- `class class_name(parent_class):`
	- the first parameter of a class function is always self, even though it's hidden

- `__init__(self, atr1, atr2):`
	- constructor

- `__del__(self):`
	- destructor

- `__str__(self):`
	- to string

- `inheritance`
	```py
	class Animal:                                
		def __init__(self, name, weight):
			self.name = nume
			self.weight = weight
				
		def makeSound(self):
			return self.name + ": Arghh!"

	class Dog(Animal):                      
		def makeSound(self):
			return self.name + ": Woof!"
	```	 
