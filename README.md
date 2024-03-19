# spring-udemy course

## [Spring Documentation](http://www.spring.io)

### Spring boot actuator
Helps metrics and monitoring application
Endpoints prefixed with /actuator

- /health - checks status of your app
- /info - more information about your application
- To update in application.properties to customize begins with '.info'

### Spring boot security
- Used for securing endpoints

### Running Spring boot from command line 

```dbn-psql
./mvnw package -> creates jar file
./mvnw spring-boot:run - have maven plugin as a dependancy in pom
java -jar "yourappname.jar"
```

### Application Properties File
- inject properties using @value annotation
- To access
```dbn-psql
@Value("${dev.name}")
```

### Spring boot properties
- spring boot props -> documentation
- You can change port eg server.port = 7070
- You can change the base url of your app from "/" eg server.servlet.context-path = /myappdomain
- security properties - you can change username and password
- data source properties