# SportService
Spring Boot implementation of a Sport Event backend webservice

**16.02.2022**  
**Szymon Garbień**

### Reguirements:
For building and running the application you need:
- [JDK](https://www.oracle.com/java/technologies/downloads/)
- [Gradle](https://gradle.org/install/)

### Running the application locally

Simplest way of running the application is to execute the `main` method in the `dorg.example.Application`
class from your IDE.

After the application executes it will enable you to access a couple of addresses:
- http://localhost:8080/swagger-ui/  
here you will be able to read some details about the API
- http://localhost:8080/h2-console/  
here you can access the h2 in-memory database, useful for seeing the results of your DB manipulation actions

### Manual testing

It's recommended to use [Postman](https://www.postman.com/downloads/) to test the available endpoints.  
Test data can be found in the [/input](https://github.com/Al-drin/SportService/tree/master/input) subcatalog.

### TODO
- Unit Tests
- refactoring and code cleaning
- exception handling with bad data