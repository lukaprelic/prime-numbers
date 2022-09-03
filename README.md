# Technical Assessment - Prime Numbers

## Outline
Write a RESTful service which calculates and returns all the prime numbers up to and including a number provided.
 
## Requirements

- The project must be written in Java 8 or 11;
- The project must use Maven OR Gradle to build, test and run;
- The project must have unit and integration tests;
- The project must be built upon Spring Boot;
- The API must respond with valid JSON;
- The API must be appropriately (to your discretion) documented;
- You may use any other frameworks or libraries for support e.g. Lombok, Rest Assured etc.;
- The project must be accessible from Github – if you do not wish to make it public, please add these users to the repository: `garyjohnson-nwg` & `akionet`. 
 
## Optional Extensions
- Deploy the solution to a chosen platform that we can access;
- Consider supporting varying return content types such as XML based, that should be configurable using the requested media type;
- Consider ways to improve overall performance e.g. caching results, concurrent algorithm;
- Consider supporting multiple algorithms that can be switched based on optional parameters.

## Implemented
Implemented prime number endpoint with caching and concurrent calculation

## Run Application
1. build using `mvn clean package`
2. run using java -jar prime-numbers.jar

## Test Application
```curl -X GET --location "http://localhost:8080/api/v1/primeNumbers?maxValue=-100" -H "Accept: application/json"```