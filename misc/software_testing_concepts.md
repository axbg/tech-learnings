# Software Testing Concepts

- `Error`
    - is a human error produced by the programmer
    - determines the apparition of a defect

- `Defect/Fault`
    - a variance from the desired product quality
    - are not the errors themselves, but a symptom that an error exists somewhere in the system

- `Failure`
    - incorrect program behavior due to a major fault in the system
    - appears when multiple defects affect an application

#
## Categories of defects

- `Wrong` 
    - the specification has been implemented incorectly
        
- `Missing`
    - a specification requirement was not implemented
    - it's an observable variance from specification 

- `Extra`
    - a faulty feature that was included without being mentioned in the specification
    - it's always a variance from the specification

#
## Testing approaches
- `Static`
    - the application is not run
    - checks syntax and other visible errors by reading code
    - also called "dry run testing"

- `Dynamic`
    - the process of evaluating a system or software component based on its behavior at runtime

- `White Box`
    - tests every line of code and ensures that all the statements and conditions have been executed at least once
    - also called "Glass Box", "Logic Driven Testing", "Path Oriented Testing"
    - done by developers
    - example: Unit Testing                 

- `Black Box`
    - no code access needed
    - tests the output of a service and compares it with the specifications
    - tests the system as a whole
    - also called "Functional Testing", "Behavioral Testing" or "Opaque Testing"
    - done by test engineers                
    - example: Manual Testing

- `Grey Box`
    - placed somewhere in-between white box and black box testing
    - can be done either by a tester who codes or by a developer who knows how to write tests
    - also called "Translucent Testing"
    
#
## Test Case Design Techniques
- determines which combinations of inputs and operations produce expected or unexpected results 

- `Error Guessing`
    - uses a set of data known to be problematic
    - reuses those sets on different releases

    - `Equivalence Partitioning`
        - divides a big data interval in smaller intervals tested separately
        - tests whether good values are valid and bad values are invalid
        - example: intervals for: <5000, 5000-10000, >10000

    - `Boundary Value Analysis`
        - uses mininum and maximum boundary values for a specific functionality
        - based on those values, adds or substracts one or more unities to obtain extreme values
        - example: minumum value minus one, maximum value plus one

#
## Testing Levels
- software testing is usually done in levels

- `Functional Testing`
    - every component is tested individually to verify if it functions accordingly
    - it's also called "Component Testing"
    - it's generally done by using different sets of inputs to test the functionality
    
- `Integration Testing`
    - tests the interaction between different components to see if they function properly together
    - it's divided into two types:
        - `Incremental Integration testing`
            - each unit is integrated one at a time into the system
            - the data flow between the modules is tested as soon as a new module is integrated
            - divided into
                - Top-Down Testing
                    - integrates the components starting from parent to children
                - Bottom-Up Testing
                    - integrates the components starting from children to parent  
        - `Non-Incremental Integration testing`
            - all units are integrated at the same time
            - it's used because it is less time consuming
            - also called the "Bing Bang Method" :)

- `System Testing`
    - verifies if the entire application is working according to the software requirements
    - also called "Product Testing" or "End-to-End Testing"
    - involves the following types of tests:
        - Compatibility testing
        - Usability testing
        - Performance testing
        - Security testing

- `Acceptance Testing`
    - the end user tests the application and verifies if the application meets their requirements
    - it's classified into two types:
        - Alpha Testing
            - the end user tests the application accompanied by the developers
            - done before Beta Testing
        - Beta Testing
            - the end user tests the application without any developer involvement
            - done before publishing the application

# 
## Types of testing

- `Smoke Testing`
    - tests the interface and the functionality of the application at a very high level
    - done before the application goes into the actual testing phase
    - example: testing if the buttons and the hyperlinks work

- `Compatibility Testing`
    - tests if the application works in different environments, with different types of hardware
    - the accent is put on the environments specified by the client

- `Usability Testing`
    - tests the UI & UX

- `Accesibility Testing`
    - tests if the UI & UX are suited for persons with physical handicaps

- `Performance Testing`
    - a group of tests which verifies the following aspects
        - Response time
        - Execution time
        - Volume
        - Scalability
    - types of performance testing:
        - Load Testing
            - tests the application against a fixed number of users to verifies its stability

        - Stress Testing
            - tests the application beyond the limits of its specified requirements

        - Volume Testing
            - tests the stability of the system by processing huge amounts of data

        - Soak Testing
            - done by applying significant load over a extended period of time
        
- `Exploratory Testing`
    - the application is freely tested by the tester

- `Security Testing`
    - tests how well the application is protected from unauthorized requests

- `Recovery Testing`
    - tests how well the application recovers from any type of crash or hardware failure

- `Regression Testing`
    - implies the retesting of the whole application
    - it ensures that new features or the bug fixing process didn't affect the application as a whole
    - it's divided into three types:
        - Unit Regression Testing
        - Regional Regression Testing
        - Full Regression Testing
