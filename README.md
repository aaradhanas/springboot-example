# Spring Boot application
This application uses Spring Boot to develop a REST service for FAQs. The service contains the following functionalities:

- /faq GET all FAQs
- /faq/{id} GET FAQ by id
- /faq POST new FAQ
- /faq/{id} DELETE FAQ by id

## MongoDB Integration

- MongoConfig to provide MongoDB instance, port and database
- MongoRepository interface to perform CRUD operations

## Security - TODO
- Enforce Basic Auth / JWT authentication
- Set security context for retrieving authorities

## References

- [Spring Boot Documentation](https://spring.io/guides/gs/spring-boot/)
- https://www.journaldev.com/4144/spring-data-mongodb-example
- http://www.baeldung.com/spring-data-mongodb-tutorial
- JHipster application

