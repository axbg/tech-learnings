# Java 8 Concepts

## Lambdas
- are anonymous functions that can be stored inside a variable

- syntax: (args) -> methodImplementation

- can be used to process data

- a lambda expression is not an object, but an object without an identity

- can be used to implement methods of functional interfaces
    - a functional interface is an interface that has only one method definition, but can have multiple default implemented methods
    - also the methods inherited from the Object class, such as equals, doesn't count
    - a functional interface can optionally be annotated with `@FunctionalInterface`
    ```java
    @FunctionalInterface
    public interface ExampleInterface {
        void printSomething(String s);
    }

    ExampleInterface example = String s -> System.out.println(s);
    //or, using method reference, also a new concept in Java8
    ExampleImplementatio example2 = System.out::println;

    example1.printSomething("hello");
    ```
        
- examples of `functional interfaces`
    - `Comparator`
    - `FileFilter`
    - `Runnable`
    - `Supplier<T>`
    - `Consumer<T> / BiConsumer<T, R>` 
        - takes one/two objects and does something with them, returning void
    - `Function<T, R> / BiFunction<T, R, U>` 
        - takes one/two objects and returns a third object
    - `Predicate<T> / BiPredicate<T, R>` 
        - takes one/two objects and returns a boolean
    - `UnaryOperator<T>` 
        - takes one object andreturns an object of the same type
    - `BinaryOperator<T>` 
        - takes two objects and returns an object of the same type

    - when applied, they can be chained using methods that resembles logical operations:
        ```java
        List<String> strings = new ArrayList<>();
        List<String> secondStrings = new ArrayList<>();

        strings.addAll(Arrays.asList("one", "two", "three"));

        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = secondStrings::add;

        strings.forEach(c1.andThen(c2));
        System.out.println("secondStrings size: " + secondStrings.size());
         ```

#
## Streams
- is an object that can define operations, doesn't hold any data and doesn't modify the initial object

- are efficient for data processing, because it uses multithreading under the hood

- built by the .stream() method implemented by the Collection interface

- a stream cannot be reused after a final operation was applied to it

- uses the Builder pattern, returning a stream everytime, so it allows chaining

- can implement specific intermediary and terminal operations

- `to trigger the chain of methods invoked by a stream, at least one final operation should be present!`

- intermediate (or lazy) operations:
    - `map(Function T)`
        - returns a list that contains of objects of a different type
        - used to apply transformation from a type to another

    - `flatMap(Function T)`
        -  returns a flattened stream composed of multiple streams

    - `filter(Predicate T)`
        - returns a list containing object of the same type
        - used to filter some object based on a given criteria
        - can take a Predicate as a parameter

    - `peek(Consumer T)`
        - applies a method given as parameter and returns the stream

    - `skip(long n)`
        - skips the first n elements present in the stream
    
    - `limit(long n)` 
        - returns only the first n elements of the stream

    - `sorted()`
        - returns a stream containing natural ordered elements

    - `distinct()`
        - returns a stream with unique elements only (according to Object.equals results)

- terminal operations
    - `forEach(Consumer T)`
        - parses the elements of a stream

    - `forEachOrdered(Consumer T)`
        - used with `parallel()` to ensure that elements are processed in the right order
        ```java
        Stream.of("a", "b", "c").parallel().forEachOrdered(System.out::println)
        ```
                    
    - `reduce(Object o, BinaryOperator<T> t)`
         - the first parameter represents the initial value, if it's needed
    
    - `collect(Collector<? super T, A, R> collector)` / `collect(Supplier<R> supplier,
                  BiConsumer<R, ? super T> accumulator,
                  BiConsumer<R, R> combiner)`
        - after processing, the stream is stored in a collection of a preffered type

    - `toArray()`
        - after processing, the stream is stored in an array of the resulting type

    -  basic operations
        - `min()`
        - `max()` 
        - `sum()`
        - `count()`

    - operations that return booleans
        - `allMatch()`
        - `noneMatch()`
        - `anyMatch()`
    
    - operations that return an optional
        - `findFirst()` 
        - `findAny()`

- methods can be applied by calling the next method directly after the stream
    ```java
    stream().map(p -> p.getLastName()).allMatch(length < 20);

    stream.reduce(0, sum);

    stream.min(Comparator.naturalOrder())
    ``` 

#
## Optionals
- a new wrapper type that wraps an object and resembles the relationship between Integer and int

- the method isPresent() returns true if the optional contains a value

- the method .get() returns the wrapped object

- the method .orElseThrow(Exception::new) throws an exception if an object is not present
