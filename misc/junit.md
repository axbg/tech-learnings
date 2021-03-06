# JUnit Concepts

## General Rules
- methods should always validate their inputs

- it's a best practice to create and throw CustomExceptions

- main should always be part of a class with no other use

#
## JUnit4
- `Asserts` - used to test an actual result to an expected one

- `@Test` - transforms a method into a test case

- `@Before/@After` - runs before/after each test case

- `@BeforeClass/@AfterClass` - runs once before/after all the defined test cases in the current class
    
- `@Test(expected = CustomException.class)` - the test case is passed when the method throws the expected exception 

#
## 'Right - BICEP' approach
- `Right` - tests a method in normal conditions, with normal values

- `B` - Boundary - tests a method using extreme values that are still acceptable

- `I` - Inverse Relationship - tests if a method produces an effect that modifies the previous known state

- `C` - Cross-Check - tests the result of a method against the result of a different method that should resolve the same operation

- `E` - Error - tests if a method throws exceptions when it's supposed to

- `P` - Performance - tests if a method executes before a given period of time elapses

#
## 'Correct' approach
- `Conformance` - tests if the output has an expected format

- `Ordering` - tests a method that operates on an array with ordered inputs

- `Range` - similar to Boundary Testing

- `Refference` - tests if a method depends on others external refferences

- `Existence` - tests if the method throws errors when one of its inputs is null

- `Cardinality` - tests methods that operates with lists with 0, 1 and n elements

- `Time` - similar to Performance Testing

#
## Mocks
- a mock is a class that simulates the behavior of a concrete class or interface in every context, without implementing the logic of its methods

- it's used when objects of the concrete class cannot be obtained

- should implement or override all the concrete class/ interface methods and provide attributes & setters to change their output

- a mock should be able to reproduce the behavior of the mocked class

#
## Fake
- a fake class simulates the behavior of a concrete class or interface in a single context

#
## Test Suites
- are collections of tests run together

- tests can belong to different classes

- tests can be put into categories, using the @Categories annotation

#
## Examples
- Test Suites
    ```java
    @RunWith(Suite.class)
    @Suite.SuiteClasses({TestClass1.class, TestClass1.class})
    public void TestSuite() {}
    ```

- Categories
    ```java
    @Category(CategoryClass.class)
    @Test
    public void testMethod() {}
    ```

- Include/exclude categories
    ```java
    @RunWith(Categories.class)
    @Categories.ExcludeCategory(CategoryClass.class)
    @Suite.SuiteClasses({TestClass1.class, TestClass2.class})
    public void testMethod() {}
    ```
