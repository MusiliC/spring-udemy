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

### Spring Container primary functions
- Create and manage objects(inversion of control)
- Inject object dependencies (dependency injection)

#### Dependency Injection overview
- injecting helper components for a given object

```
Injection Types
1. Constructor Injection - used when you have required dependencies
2. Setter Injection - optional dependencies
```

### Spring Auto wiring
For dependency injection, spring uses auto wiring

```
@Component  - Marks the class as spring bean
            - Makes the bean available for dependency injection
            - Spring looks for this annotations and registers them in the container
            
```

```
@SpringBootApplication 
- @EnableAutoConfiguration
- @ComponentScan
- @Configuration
- creates application context, starts the beans and enables the server

- Component scanning works better if its under main application package

- For packages outside, you explicitly tell spring to scan in the @SpringBootApplication
            
```

### Setter Injection
- If dependency not provided, you can provide reasonable default logic

### Auto wiring and Qualifiers
```
@Qualifier - when an interface is implemented by many beans
- When you want to use a given bean at a moment

eg
@Qualifier("id_name")
```

### Primary Annotation
Specifies primary implementation that should be used
Alternative way to use @Qualifier

Mixing primary and qualifier, the qualifier annotation is given the highest priority
