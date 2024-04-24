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

### Lazy Initialization

When application loads, all beans are loaded
Through lazy initialization bean will be loaded only:

- Needed for dependency injection
- Explicitly requested

@Lazy


### Lazy initialization - Global
- application.properties
- spring.main.lazy-initialization = true

## Bean scope
By default they are created in singleton

- You can change to prototype where new instance is created

- @Scope(ConfigurationBeanFactory.SCOPE_PROTOTYPE)

### Bean Lifecycle Methods

- Init method configuration
- Use annotation - @PostConstruct  - //init method

- @PreDestroy - when destroying bean - //destroy method

## Use case for @Bean annotation
- They do not @Component annotation
- Make an existing third party class available to the spring framework
- eg when working with aws s3 storage

## JPA
### Id Generation strategies
GenerationType.AUTO  - Picks appropriate strategy for particular db
GenerationType.Identity  - uses db identity column - recommended
GenerationType.SEQUENCE  - uses db sequence
GenerationType.TABLE  - Assign primary key using db table

#### JPQL
Uses entity name and field instead of db columns

#### Named parameters jpql
- Query parameters are a way to build and execute parameterized queries. So, instead of:

```
SELECT * FROM employees e WHERE e.emp_number = '123';
```

- we use

```
SELECT * FROM employees e WHERE e.emp_number = ?;

```

- using jpa named parameters

```
TypedQuery<Employee> query = em.createQuery(
  "SELECT e FROM Employee e WHERE e.empNumber = :number" , Employee.class);

  number - placeholder

String empNumber = "A123";
Employee employee = query.setParameter("number", empNumber).getSingleResult();
```

Updating db column you use "entityManager.merge()"

when writing or creating a query you use  - executeUpdate()

'update' - used when modifying a db

## Http Status Code
```
100 - 199     - Informational
200 - 299     - Success
300 - 399     - Redirectional
400 - 499     - Client error
500 - 599     - Server error
```

## Global exception Handling
### @ControllerAdvice
A controller advice allows you to use exactly the same exception handling techniques but apply them across the whole application, not just to an individual controller. You can think of them as an annotation driven interceptor.

## Api Best Practices
api/employees - GET, POST
api/employees/{employeeId} - PUT, DELETE, GET ONE EMPLOYEE
api/students
 - Always use plural form

 ## Anti Patterns
 api/employees/addEmployee
 api/employees/getEmployees

 ### @Service
 Applied to service implementations
 
 ## Spring Data Rest
 To customize you use application.properties

 ## Spring Security
 ## Restricting Access Roles
 -  requestMatchers(method, path)
 - hasRoles/ hasAnyRole

 ```
 You use SecurityFIlterChain - method declared as bean
 To filter
 ```

 ### Cross-Site Request Forgery(CSFR)
 - Its disabled
 Not required for requests that use POST,PUT, DELETE or PATCH

 When to use: 
 - Any normal browser based web request

 - When building REST API for non browser clients - disable the CSFR

## Thymeleaf
 - Templating engine for generating html views
 - Add its maven dependency
 - You use @controller instead of @RestController
 - Return the html page to view
 - Located in resources under templates


## Spring Validations
- Add validation support dependency
  - Making field REQUIRED - "@NotNull"
  - Size (min = 1, max = 5, message ="Min value is ....")
```angular2html
@initBinder annotation

To convert trim input strings
Removes leading and trailing whitespace
Create a method that accepts Webdatabinder as an argument
The method is created in the controller and is called for all requests in the controller

```

#### Number Validator
- @Min(value = 0, message= "Must be greater than 0')
- @Max(value = 10, message= "Must be less than 10')

#### Regular Expressions
- @Pattern(regexp = '^[a-zA-Z0-9]{5}', message = 'only 5 char/digits')

### Spring Custom Validations
- You create annotation with value and message to hold incase of error


## Advanced Mapping
### Cascading
- Applying same operations to the related entities

- @manytomany - Never use cascade_delete

### Eager vs Lazy
- Eager - retrieves everything
- Lazy - retrieves on request

## Cascade Types
1. Persist
   - If entity is saved related entity also saved

2. Remove
   - If entity is removed related entity also removed

3. Refresh
    - If entity is refreshed related entity also refreshed

4. Merge
    - If entity is merged related entity also merged
5. All
    - Applies to all entity types of the above

### Bidirectional onetoone
- You add @mappedBy(fieldName of foreign key entity)