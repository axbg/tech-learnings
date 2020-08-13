# Rust
### Based on (Tour of Rust)[https://tourofrust.com]

* associated with the .rs file extension
* is a system-level language, with multiple tools dedicated to memory management and safety

## Hello world
```rust
fn main() {
    let x = "Hello world";
    println!("{}", x);
}
```
# 
## Variables
* are declared using the let keyword and types are usually infered
    * ```let x = 13;```

* but they can also be explicitly declared
    * ```let x: f64 = 3.14```

* by default de variables are **immutable** but they can be declared as mutable using the **mut** keyword
    * ```let mut x = 42;```
#
## Types
* Rust have a lot of types which are suitable in multiple contexts
    * boolean - bool
    * unsigned integer - u8, u16, u32, u64, u128
    * signed integers - i8, i16, i32, i64, i128
    * pointer sized integers - usize, isize
    * floating point - f32, f64
    * tuples - (value, value, ...)
    * arrays - [value, value, ...]
    * string - str
    * slices - &str[0...5]
#
## Keywords
* let - used to declare a variable
* mut - declares a mutable variable
* as - used for type conversion
    * ```let c = 13u8 as u32 + 13u32;```
* const - used to declare a constant value
    * ```const PI: f32 = 3.14;```
* // - commentary
* type - used to declare a type alias
* 0..5 - used to create an iterator that generates numbers from the start number until the end number, without including it
* 0..=5 - used to create an iterator that generates numbers from the start number until the end number, including the it
* :: - used to call static methods
* . - used to call instance methods
* ::<T> - turbofish operator - used to explicitly declare type of a generic struct
* || - used to define an anonymous function, also known as lambda or, specifically to Rust, closure
* None - represents the absence of something, generally replacing the *null* in other languages
* ? - used in error handling to evaluate the content of a Result
* impl - used to associate a struct with methods
* pub - used to expose struct fields and methods outside of the module
* \* - used to dereference a reference
* use - used to import a module
* mod - written in a parent module to reference sub-modules
* crate - reference to the root module
* super - reference to the parent module of the current module
* self - reference to the current module
#
## Arrays
* always have a fixed size and are declared as [TYPE; LENGTH]
    * ```let nums: [i32, 3] = [1, 2, 3];```
* like in many other languages, values from an array can be retrieved using the index operator []
    * ```let x = nums[2];```
* a whole array can be printed using the following structure
    * ```println!("{:?}", nums);```
#
## Functions
* example
```rust
fun add(x: i32, y: i32) -> i32 {
    return x + y;
}

add(42, 13);
```

* if a function has to return multiple parameters, a tuple can be used
```rust
fn swap(x: i32, y: i32) -> (i32, i32) {
    return (y, x);
}

let result = swap(31, 32);
println!("{} {}", result.0, result.1);
```

* if a function's return type is not specified it will return an empty tuple, known as a *unit*
```rust
fn empty_function() -> () {
    return ();
}

```

* values can be returned without the explicit **return** keyword
```rust
// will return x + 1
fn example() -> i32 {
    let x = 1;

    x + 1
}
```
#
## Control Flow
### **if/else if/else**

* without paranthesis around the evaluated expression
```rust
if x < 2 {
    println!("less than 2");
} else if x > 3 {
    println!("bigger than 3");
} else {
    println!("3!");
}
```
* can be used to achieve ternary expressions
```rust
let x = 1;
let v = if x > 5 { -1 } else { 1 }; 
```

### **loop**
* break should be explicitly used to end a loop
```rust
loop {
    x += 1;

    if x == 3 {
        break;
    }
}
```
- when a loop breaks on a value, the value is returned
```rust
let mut x = 0;
let y = loop {
    x += 1;

    if x > 5 {
        break x;
    }

// will print 6
println!("{}", y);
}
```

### **while**
```rust
let mut x = 0;

while x < 3{
    x += 1;
}
```

### **for .. in ..**
* it iterates over values from any expression that evaluates into an iterator
```rust
for x in 0..5 {
    println!("{}", x);
}

for x in 0..=5 {
    println!("{}", x);
}
```

### **match**
* resembles a classic switch statement, but with additional features
```rust
let x = 3;

match x {
    0 => {
        println!("zero");
    },
    // matching multiple values
    1 | 2 => {
        println!("one or two");
    },
    // matching a range
    3..9 => {
        println!("range");
    },
    // binding the matched value to a variable
    num @ 10..=100 {
        println!("Found {} between 10 and 100", num);
    },
    // the default case
    _ => {
        println!("Number was not found");
    },
}
```
### **scope blocks**
* can be used to return a value
```rust
// v will be equal to a + b
let v = {
    let a = 1;
    let b = 2;
    a + b;
};
```
#
## Data Structures
* just like Go, Rust is not OO, but structures can be used to achieve some points of this paradigm
```rust
struct Animal {
    name: String,
    legs: u8,
    teeth: u8
}
```
* when a function is associated with a specific data type, it becomes a **method**
    * **static methods** can be called using the **::** operator
    * **instance methods** can be called using the **.** operator

* instantiation of a struct is done by specifying all its field values
```rust
fn main() {
    let x = Animal {
        name: String::from("Cat")
        legs: 4,
        teeth: 35
    };
}
```
* structs can also be created using the tuple format
```rust
struct Location(i32, i32)

fn main() {
    let loc = Location(41, 42);
    println!("{} {}", loc.0, loc.1);
}
```
### Enums
* **enums** are present in Rust and they behave like in every other programming language
```rust
enum Species {
    Dog,
    Cat,
    Parrot
}

struct Animal {
    name: String,
    species: Species
}

fn main() {
    let dog = Animal {
        name: "Dog",
        species: Species::Dog
    }

    match dog.species {
        Species::Dog => println!("It's a dog"),
        Species::Cat | Species::Parrot => println!("It's something else"),
        _ => println!("It doesn't look like anything to me"),
    }
}
```
* enums can also have one or more data types to describe their content, behaving like a C *union*
```rust
enum Species { Crab, Octopus, Fish, Clam }
enum PoisonType { Acidic, Painful, Lethal }
enum Size { Big, Small }
enum Weapon {
    Claw(i32, Size),
    Poison(PoisonType),
    None
}

struct SeaCreature {
    species: Species,
    name: String,
    arms: i32,
    legs: i32,
    weapon: Weapon,
}

fn main() {
    let ferris = SeaCreature {
        species: Species::Crab,
        name: String::from("Ferris"),
        arms: 2,
        legs: 4,
        weapon: Weapon::Claw(2, Size::Small),
    };

    match ferris.species {
        Species::Crab => {
            match ferris.weapon {
                Weapon::Claw(num_claws,size) => {
                    let size_description = match size {
                        Size::Big => "big",
                        Size::Small => "small"
                    };
                    println!("ferris is a crab with {} {} claws", num_claws, size_description)
                },
                _ => println!("ferris is a crab with some other weapon")
            }
        },
        _ => println!("ferris is some other animal"),
    }
}
```
#
## Generic Types
* allow partial definition of a struct or enum, just like in common OOP languages
* the type T is usually infered by the compiler, but the ::<> operator can also be used to explicitly declare the type
```rust
struct BagOfHolding<T> {
    item: T,
}

fn main() {
    let i32_bag = BagOfHolding::<i32> { item: 42 };
    let bool_bag = BagOfHolding { item: true };
}
```
### Option
```rust
enum Option<T> {
    None, 
    Some(T),
}
```
* it's a built-in generic enum that allow the representation of nullable values without using null
```rust
struct BagOfHolding<T> {
    item: Option<T>,
}

fn main() {
    let bag = BagOfHolding::<i32> { item: None };

    if bag.item.is_none() {
        println!("nothing in the bag");
    }

    if(bag.item.is_some()) {
        println!("something in the bag!")
    }

    match bag.item {
        None => println!("nothing in the bag"),
        Some(v) => println!("something in the bag {}", v),
    }
}
```
* using lambda functions, also known as closures, higher order functions can be easily achieved
```rust
fn run<F>(f: F) where F: Fn() {
    println!("Running function received as parameter");
    f();
}

fn main() {
    // declaring a closure
    let x = || println!("closure function");
    run(x);
}
```
### Result
```rust
enum Result<T, E> {
    Ok(T),
    Err(E)
}
```
* a built-in generic enum used to return a value that has the possibility of failing
* it's the accepted way of handling errors
```rust
fn something_that_can_fail(i: i32) -> Result<f32, String> {
    if i == 2 {
        Ok(2.0)
    } else {
        Err(String::from("other number"));
    }
}

fn main() {
    let result = something_that_can_fail(3);

    match result {
        Ok(v) => println!("found {}", v),
        Err(e) => println!("error {}", e),
    }
}
```
* the main function is able to return an error in form of a Result
```rust
fn main() -> Result<(), String> {
    let x = 3;

    if x == 2:
        return Err(String::from("an error occurred"))
    
    // represents that everything went fine
    Ok(())
}
```
* to simplify error handling, Rust uses a dedicated operator: **?**
```rust
fn something_that_can_fail(i: i32) -> Result<f32, String> {
    if i == 2 {
        Ok(2.0)
    } else {
        Err(String::from("other number"));
    }
}

fn main() {
    let result = something_that_can_fail(3)?;
    println!("found {}", result)
    Ok(())
}
```
* instead of matching an Option/Result, the **.unwrap()** method can be used
```rust
my_option.unwrap()
// equivalent with
match my_option {
    Some(v) => v,
    None => panic!("some error message generated by Rust!"),
}

my_result. unwrap()
// equivalent with
match my_result {
    Ok(v) => v,
    Err(e) => panic!("some error message generated by Rust!"),
}
```
* can be used to gracefully handle previous matching cases, but it's  usage is not recommended as the code becomes less clear
```rust
fn do_something_that_might_fail(i: i32) -> Result<f32, String> {
    if i == 42 {
        Ok(13.0)
    } else {
        Err(String::from("this is not the right number"))
    }
}

fn main() -> Result<(), String> {
    // concise but assumptive and gets ugly fast
    let v = do_something_that_might_fail(42).unwrap();
    println!("found {}", v);
    
    // this will panic!
    let v = do_something_that_might_fail(1).unwrap();
    println!("found {}", v);
    
    Ok(())
}
```
### Vectors
* represents variably sized collections, which are, actually, a generic struct that allocated memory in the heap
* can be instantiated in multiple ways
```rust
fn main() {
    // We can be explicit with type
    let mut i32_vec = Vec::<i32>::new();
    i32_vec.push(1);
    i32_vec.push(2);
    i32_vec.push(3);

    // determining the type automatically
    let mut float_vec = Vec::new();
    float_vec.push(1.3);
    float_vec.push(2.3);
    float_vec.push(3.4);

    // using the vec! macro
    let string_vec = vec![String::from("Hello"), String::from("World")];

    for word in string_vec.iter() {
        println!("{}", word);
    }

    // the first 10 elements will be added without reallocating memory
    let w_capacity_vec = Vec::with_capacity(10);
}
```
# 
## Ownership
* the ownership of a variable is scope based
* when a variable is passed to a function, the ownership is transfered and the variable cannot be used in the initial scope unless the function returns it
```rust
struct Foo {
    x: i32,
}

fn do_something_else(f: Foo) {
    Foo { x: 42 }
    // ownership is moved out
}

fn do_something(f: Foo) {
    println!("{}", f.x);
    // f is dropped here
}

fn main() {
    let foo = Foo { x: 42 };
    let mut bar = Foo { x : 35};
    // foo is moved to do_something
    do_something(foo);
    // foo can no longer be used

    bar = do_something_else(bar);
    // bar can be used here
}

```
* the borrowing of ownership returns the ownership to the initial owner after the scope that borrowed is exited
* can be done using references **&**
```rust
struct Foo {
    x: i32,
}

fn main() {
    let foo = Foo { x: 42 };

    // while a resource is borrowed, it cannot be moved or modified
    let f = &foo;

    println!("{}", f.x);
    // f is dropped here
    // foo is dropped here
}
```
* dereferencing is also possible using a combination of **&mut** and **\*** operators
```rust
fn main() {
    let mut foo = 42;
    let f = &mut foo;
    let bar = *f; // get a copy of the owner's value
    *f = 13;      // set the reference's owner's value
    println!("{}", bar);
    println!("{}", foo);
}
```
### Lifetimes
* used to ensure that the a reference never outlives its owner 
* declaration of explicit lifetimes is allowed as specifiers that always start with '
```rust
struct Foo {
    x: i32,
}

// the parameter foo and return value share the same lifetime
fn do_something<'a>(foo: &'a Foo) -> &'a i32 {
    return &foo.x;
}

fn main() {
    let mut foo = Foo { x: 42 };
    let x = &mut foo.x;
    *x = 13;
    // x is dropped here, allowing us to create a non-mutable reference
    let y = do_something(&foo);
    println!("{}", y);
}
```
* if a variable has a **static** lifetime, it will live from the start of the program until the end
```rust
static PI: f64 = 3.1415;

fn main() {
    // static variables can also be scoped to a function
    static mut SECRET: &'static str = "swordfish";

    // string literals have a 'static lifetime
    let msg: &'static str = "Hello World!";
    let p: &'static f64 = &PI;
    println!("{} {}", msg, p);
}
```
* explicit lifetime can also be used inside structures to ensure that the containing data structure of the references never lasts longer than the owners its references point to
```rust
struct Foo<'a> {
    i:&'a i32
}

fn main() {
    let x = 42;
    let foo = Foo {
        i: &x
    };
    println!("{}",foo.i);
}

```
#
## Handling Text
### String literals
* their type is &'static str
* are declared in the data segment of memory and are available throughout the whole execution of the program
```rust
fn main() {
    let a: &'static str = "Ferris says:\t\"hello\"";
    println!("{}",a);
}
```
* characters can be escaped using common escape codes
* multi-line string literals are separated using the \ notation
```rust
fn main() {
    let haiku: &'static str = "
        I write, erase, rewrite
        Erase again, and then
        A poppy blooms.
        - Katsushika Hokusai";
    println!("{}", haiku);
    
    
    println!("hello \
    world") // notice that the spacing before w is ignored
}
```
* string literals that don't require escaping can be written using the **r#"string"#** notation and are called raw string literals
```rust
fn main() {
    let a: &'static str = r#"
        <div class="advice">
            Raw strings are useful for some situations.
        </div>
        "#;
    println!("{}", a);
}
```
* string literals can also be imported from files using the **include_str!** macro
```rust
let 00_html = include_str!("00_en.html");
```
* the most common methods available on string objects are 
    * len
    * starts_with / ends_with
    * is_empty
    * find
### String Slices
* represents a sub slice of a string
```rust
fn main() {
    let a = "hi 🦀";
    println!("{}", a.len());
    let first_word = &a[0..2];
    let second_word = &a[3..7];
    println!("{} {}", first_word, second_word);
}
```
### Chars
* a char is always 4 bytes long
```rust
fn main() {
    // collect the characters as a vector of char
    let chars = "hi 🦀".chars().collect::<Vec<char>>();
    println!("{}", chars.len()); // should be 4
    // since chars are 4 bytes we can convert to u32
    println!("{}", chars[3] as u32);
}
```
### Strings
* it's a struct that owns a sequence of utf-8 bytes allocated in the heap memory
* because it's allocated on heap, a string can be modified while a string literal cannot
* common methods
    * push_str
    * replace
    * to_lowercase / to_upercase
    * trim
```rust
fn main() {
    let mut helloworld = String::from("hello");
    helloworld.push_str(" world");
    helloworld = helloworld + "!";
    println!("{}", helloworld);
}
```
#
## Achieving OOP without OOP
### Encapsulation with methods
* relies on the **impl** keyword
```rust
struct SeaCreature {
    noise: String,
}

impl SeaCreature {
    fn get_sound(&self) -> &str {
        &self.noise
    }
}

fn main() {
    let creature = SeaCreature {
        noise: String::from("blub"),
    };
    println!("{}", creature.get_sound());
}
```
* the references to the instance can be immutable, like in the previous example, or mutable (&mut self)
### Abstraction with selective exposure
* relies on the **pub** keyword to expose struct fields and methods outside the module
```rust
struct SeaCreature {
    pub name: String,
    noise: String,
}

impl SeaCreature {
    pub fn get_sound(&self) -> &str {
        &self.noise
    }
}

fn main() {
    let creature = SeaCreature {
        name: String::from("Ferris"),
        noise: String::from("blub"),
    };
    println!("{}", creature.get_sound());
}
```
### Polymorphism with traits
* relies on the **trait** keyword to establish a contract based on which a set of methods can be associated with a struct type
* using the **&dyn Trait** notation interaction with the inital struct can be achieved through the trait, without even knowing the real type
```rust
struct SeaCreature {
    pub name: String,
    noise: String,
}

impl SeaCreature {
    pub fn get_sound(&self) -> &str {
        &self.noise
    }
}

trait NoiseMaker {
    fn make_noise(&self);
}

impl NoiseMaker for SeaCreature {
    fn make_noise(&self) {
        println!("{}", &self.get_sound());
    }
}

fn main() {
    let creature = SeaCreature {
        name: String::from("Ferris"),
        noise: String::from("blub"),
    };
    
    let _sea_creature: &dyn NoiseMaker = &creature;
    
    _sea_creature.make_noise();
}
```
* traits can also have implemented methods, but they don't have access to the inner fields of a struct
```rust
struct SeaCreature {
    pub name: String,
    noise: String,
}

impl SeaCreature {
    pub fn get_sound(&self) -> &str {
        &self.noise
    }
}

trait NoiseMaker {
    fn make_noise(&self);
    
    fn make_alot_of_noise(&self){
        self.make_noise();
        self.make_noise();
        self.make_noise();
    }
}

impl NoiseMaker for SeaCreature {
    fn make_noise(&self) {
        println!("{}", &self.get_sound());
    }
}

fn main() {
    let creature = SeaCreature {
        name: String::from("Ferris"),
        noise: String::from("blub"),
    };
    creature.make_alot_of_noise();
}
```
* unlike structs, traits can inherit methods from other traits
```rust
struct SeaCreature {
    pub name: String,
    noise: String,
}

impl SeaCreature {
    pub fn get_sound(&self) -> &str {
        &self.noise
    }
}

trait NoiseMaker {
    fn make_noise(&self);
}

trait LoudNoiseMaker: NoiseMaker {
    fn make_alot_of_noise(&self) {
        self.make_noise();
        self.make_noise();
        self.make_noise();
    }
}

impl NoiseMaker for SeaCreature {
    fn make_noise(&self) {
        println!("{}", &self.get_sound());
    }
}

impl LoudNoiseMaker for SeaCreature {}

fn main() {
    let creature = SeaCreature {
        name: String::from("Ferris"),
        noise: String::from("blub"),
    };
    creature.make_alot_of_noise();
}
```
* when traits are used, a dynamic dispatch takes place because the real type is not inherently known
```rust
impl SeaCreature {
    pub fn get_sound(&self) -> &str {
        &self.noise
    }
}

trait NoiseMaker {
    fn make_noise(&self);
}

impl NoiseMaker for SeaCreature {
    fn make_noise(&self) {
        println!("{}", &self.get_sound());
    }
}

fn static_make_noise(creature: &SeaCreature) {
    // we know the real type
    creature.make_noise();
}

fn dynamic_make_noise(noise_maker: &dyn NoiseMaker) {
    // we don't know the real type
    noise_maker.make_noise();
}

fn main() {
    let creature = SeaCreature {
        name: String::from("Ferris"),
        noise: String::from("blub"),
    };
    static_make_noise(&creature);
    dynamic_make_noise(&creature);
}
```
#
## Pointers
### Raw Pointers
* references can be converted into a more primitive type called a *raw pointer*
* there are 2 kinds of raw pointers:
    * *const T - a constant raw pointer
    * *mut T - a raw pointer that can change
* can be converted to and from numbers (usize)
* can access data with *unsafe* code

* **\*** operator - it's an explicit way to dereference a reference
```rust
let a: i32 = 42;
let ref_ref_ref_a: &&&i32 = &&&a;
let ref_a: &i32 = **ref_ref_ref_a;
let b: i32 = *ref_a;
```

* **.** operator - used to access the fields and methods of a reference even with multiple references in place
```rust
let f = Foo { value: 42 };
let ref_ref_ref_f = &&&f;

println!("{}", ref_ref_ref_f.value);
// equivalent with
println!("{}", (***ref_ref_ref_f).value);
```

### Smart Pointers
* are reference-like structs
* typically implement Deref, DerefMut and Drop traits to declare the logic of what should happen when the structure is dereferenced with * and . operators
```rust
use std::ops::Deref;

struct TattleTell<T> {
    value: T,
}
impl<T> Deref for TattleTell<T> {
    type Target = T;
    fn deref(&self) -> &T {
        println!("{} was used!", std::any::type_name::<T>());
        &self.value
    }
}
fn main() {
    let foo = TattleTell {
        value: "secret message",
    };
    // dereference occurs here immediately 
    // after foo is auto-referenced for the
    // function `len`
    println!("{}", foo.len());
}
```
### Smart Unsafe Code
* in an unsafe scenario, pointers can dereference a zone in memory
* it's usually encountered in smart pointers
```rust
fn main() {
    let a: [u8; 4] = [86, 14, 73, 64];
    // this is a raw pointer. Getting the memory address
    // of something as a number is totally safe
    let pointer_a = &a as *const u8 as usize;
    println!("Data memory location: {}", pointer_a);
    // Turning our number into a raw pointer to a f32 is
    // also safe to do.
    let pointer_b = pointer_a as *const f32;
    let b = unsafe {
        // This is unsafe because we are telling the compiler
        // to assume our pointer is a valid f32 and
        // dereference it's value into the variable b.
        // Rust has no way to verify this assumption is true.
        *pointer_b
    };
    println!("I swear this is a pie! {}", b);
}
```
* it's a mechanism that resembles C's malloc
```rust
use std::alloc::{alloc, Layout};
use std::ops::Deref;

struct Pie {
    secret_recipe: usize,
}

impl Pie {
    fn new() -> Self {
        // let's ask for 4 bytes
        let layout = Layout::from_size_align(4, 1).unwrap();

        unsafe {
            // allocate and save the memory location as a number
            let ptr = alloc(layout) as *mut u8;
            // use pointer math and write a few 
            // u8 values to memory
            ptr.write(86);
            ptr.add(1).write(14);
            ptr.add(2).write(73);
            ptr.add(3).write(64);

            Pie { secret_recipe: ptr as usize }
        }
    }
}
impl Deref for Pie {
    type Target = f32;
    fn deref(&self) -> &f32 {
        // interpret secret_recipe pointer as a f32 raw pointer
        let pointer = self.secret_recipe as *const f32;
        // dereference it into a return value &f32
        unsafe { &*pointer }
    }
}
fn main() {
    let p = Pie::new();
    // "make a pie" by dereferencing our 
    // Pie struct smart pointer
    println!("{:?}", *p);
}
```

### Box
* it's a smart pointer that can move data from stack to heap
* when it's dereferenced, it can be used as the original type
```rust
struct Pie {
    name: u32,
}

impl Pie {
    fn eat(&self) {
        println!("{} tastes better on the heap!", self.name)
    }
}

fn main() {
    let mut heap_pie = Box::new(Pie{ name: 32 });
    heap_pie.name = 102;
    heap_pie.eat();
}
```
* the Box implementation can bring benefits to the concept of failible main introduced eariler
```rust
use core::fmt::Display;
use std::error::Error;

struct Pie;

// shorter form of implementing std::fmt::Debug for NotFreshError
#[derive(Debug)]
struct NotFreshError;

impl Display for NotFreshError {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        write!(f, "This pie is not fresh!")
    }
}

impl Error for NotFreshError {}

impl Pie {
    fn eat(&self) -> Result<(), Box<dyn Error>> {
        Err(Box::new(NotFreshError))
    }
}

fn main() -> Result<(), Box<dyn Error>> {
    let heap_pie = Box::new(Pie);
    heap_pie.eat()?;
    Ok(())
}
``` 
### Reference counting (Rc)
* a smart pointer that moves data from the stack onto the heap
* allows to clone other Rc smart pointers
```rust
use std::rc::Rc;

struct Pie;

impl Pie {
    fn eat(&self) {
        println!("tastes better on the heap!")
    }
}

fn main() {
    let heap_pie = Rc::new(Pie);
    let heap_pie2 = heap_pie.clone();
    let heap_pie3 = heap_pie2.clone();

    heap_pie3.eat();
    heap_pie2.eat();
    heap_pie.eat();

    // all reference count smart pointers are dropped now
    // the heap data Pie finally deallocates
}
```

### RefCell
* a container data structure commonly held by smart pointers 
* allows borrowing mutable and immutable references to what they contain, but cannot access the content directly
* allows only one mutable reference or multiple immutable references, but not both, otherwise it will panic
```rust
use std::cell::RefCell;

struct Pie {
    slices: u8
}

impl Pie {
    fn eat(&mut self) {
        println!("tastes better on the heap!");
        self.slices -= 1;
    }
}

fn main() {
    // RefCell validates memory safety at runtime
    // notice: pie_cell is not mut!
    let pie_cell = RefCell::new(Pie{slices:8});
    
    {
        // but we can borrow mutable references!
        let mut mut_ref_pie = pie_cell.borrow_mut();
        mut_ref_pie.eat();
        mut_ref_pie.eat();
        
        // mut_ref_pie is dropped at end of scope
    }
    
    // now we can borrow immutably once our mutable reference drops
     let ref_pie = pie_cell.borrow();
     println!("{} slices left",ref_pie.slices);
}
```
* can be used along Rc to obtain multiple mutable and immutable references to what's inside
```rust
use std::cell::RefCell;
use std::rc::Rc;

struct Pie {
    slices: u8,
}

impl Pie {
    fn eat_slice(&mut self, name: &str) {
        println!("{} took a slice!", name);
        self.slices -= 1;
    }
}

struct SeaCreature {
    name: String,
    pie: Rc<RefCell<Pie>>,
}

impl SeaCreature {
    fn eat(&self) {
        // use smart pointer to pie for a mutable borrow
        let mut p = self.pie.borrow_mut();
        // take a bite!
        p.eat_slice(&self.name);
    }
}

fn main() {
    let pie = Rc::new(RefCell::new(Pie { slices: 8 }));
    // ferris and sarah are given clones of smart pointer to pie
    let ferris = SeaCreature {
        name: String::from("ferris"),
        pie: pie.clone(),
    };
    let sarah = SeaCreature {
        name: String::from("sarah"),
        pie: pie.clone(),
    };
    ferris.eat();
    sarah.eat();

    let p = pie.borrow();
    println!("{} slices left", p.slices);
}
```

### Mutex
* a container data structure commonly held by smart pointers
* allows the borrowing of mutable and immutable references, similar to RefCell, but it's natively thread safe
* the content of a result, called a lock, should be unwraped first because it can fail
```rust
use std::sync::Mutex;

struct Pie;

impl Pie {
    fn eat(&self) {
        println!("only I eat the pie right now!");
    }
}

fn main() {
    let mutex_pie = Mutex::new(Pie);
    // let's borrow a locked immutable reference of pie
    // we have to unwrap the result of a lock
    // because it might fail
    let ref_pie = mutex_pie.lock().unwrap();
    ref_pie.eat();
    // locked reference drops here, and mutex protected value can be used by someone else
}
```
* to increment the number of reference counts, the **Arc** smart pointer can be used to get multiple references to the same Mutex, exactly like **Rc** with **RefCell**

#
## Multithreading
### Threads
* starting and waiting for other threads in the main thread
* the **move** keyword is used to transfer the ownership of the used variables from the main thread to the thread that starts running
```rust
use std::thread;

fn main() {
    let mut v = vec![1, 2, 3];

    for i in 0..10 {
        c.push(thread::spawn(move || {
            println!("thread number {}", i);
        }));
    }

    for j in v {
        j.join();
    }
}
```
* example with channels which explains how to send data from a thread and receive it in another thread
```rust
use std::thread;
use std::sync::mpsc;

fn main() {
    let (tx, rx) = mpsc::channel();

    thread::spawn(move || { tx.send(42).unwrap(); });

    println("received {}", rx.recv().unwrap());
}
```
* example with Arcs and Mutexes which explains how to safely share data between multiple threads
```rust
use std::sync::{Mutex, Arc};
use std::thread;

fn main() {
    let arc = Arc::new(Mutex::new(0));
    let mut v = vec![];
    
    for _ in 0..10 {
        let clone = Arc::clone(&c)
        let t = thread::spawn(move || {
            let mut num = clone.lock().unwrap();
            *num += 1;
        });
        hs.push(t);
    }

    for vs in v {
        vs.join().unwrap();
    }

    println!("Result: {}", *c.lock().unwrap());
}
```