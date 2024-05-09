### SPRING FRAMEWORK

Spring-Framework is a lightweight open-source framework for building enterprise java applications that aims to simplify
the complex enterprise java application development.

## Core features

1. Inversion on Control Container (IOC)- It creates the objects, configures and assembles their dependencies, manages
   their entire life cycle. The Container uses Dependency Injection(DI) to manage the components that make up the
   application.
   It gets the information about the objects from a configuration file(XML) or Java Code or Java Annotations and Java
   POJO class.
   These objects are called Beans. Since the Controlling of Java objects and their lifecycle is not done by the
   developers,
   hence the name Inversion Of Control. The followings are some of the main features of Spring IoC,

- Creating Object for us,
- Managing our objects,
- Helping our application to be configurable,
- Managing dependencies.

2. Aspect oriented programming (AOP) - This is a programming paradigm that enables the modularization of cross-cutting
   concerns in software applications. Cross-cutting concerns are aspects of your application that affect multiple parts
   of the codebase. These can include logging, security, transactions,authentication and error handling. AOP allows you
   to separate
   these
   concerns from the core application logic, making your code more maintainable and less cluttered.
3. Data Access Framework (DAF) - This is concerned with data access and the interaction between the data access layer
   and the business service layer. it is used for data manipulation and other integration.
   it covers the transactions modules which helps maintain transactions in programmatic and declarative manner and also
   supports ORM and JDBC modules.
4. Spring MVC Framework - simplifies the development of web applications by providing a robust framework with
   well-defined patterns and best practices, allowing developers to focus on building business logic rather than dealing
   with infrastructure concerns. Spring MVC is specifically designed to support the development of web applications,
   providing a clean separation of concerns and promoting good design practices. Here's a breakdown of its components:

- Model: Represents the application's data and business logic. In Spring MVC, the model usually consists of POJOs (Plain
  Old Java Objects) or JavaBeans.
- View: Represents the presentation layer of the application. Spring MVC supports various view technologies, such as
  JSP (
  JavaServer Pages), Thymeleaf, FreeMarker, etc.
- Controller: Acts as an intermediary between the Model and the View, handling user requests, processing input, and
  providing responses. In Spring MVC, controllers are typically implemented as Java classes annotated with @Controller.

## BEAN

Java beans are reusable chunks of code that make it easy to use and connect together.
A spring bean is essentially an object that is managed by the Spring IoC (Inversion of Control) container. This
container is responsible for instantiating, configuring, and managing these beans throughout the application lifecycle.
The life cycle of an object means when and how it behaves throughout its life, and when and how it dies.
@Configuration is an annotation used to declare that a class provides bean definitions. When a class is
annotated with @Configuration, it indicates to Spring that this class will be used to configure the application context
by defining beans.
@Configuration declares a class as "full" configuration class. The class must be non-final and public.
@Bean declares a bean configuration inside configuration class. The method must be "non-final" and "non-private" (i.e.
public, protected or packaged-private)

## SPRING COMPONENT SAMPLE

@Component contains a class-level annotation that marks a class as a spring component. It's a way of telling spring that
this class is a spring managed container, and it can be injected into another spring managed component.
@Autowired injects the constructor parameter into spring manged beans. This is optional if there is only one
constructor.

## BEAN NAMING

Bean takes the name of the provided method. If a name is provided, the bean takes the name of that name, (e.g. @Bean("
bs) -> The name of this bean is ds).

## BEAN INJECTION

The @Qualifier annotation in Spring is used to disambiguate bean injection when multiple beans of the same type are
available in the Spring application context. It helps Spring identify which specific bean should be injected when there
are multiple candidates.

@RestController - This is an annotation used to define a RESTful web service. When you annotate a class with
@RestController, it's essentially a specialized version of @Controller that's specifically tailored for RESTful web
services.

# NOTE:

- By default, when you create a class and print it, the output is the class name and memory address of the class.
  However,
  to get meaningful information about that class, we have to override the string class and provide info about it. To do
  this,
  we use the @Override annotation. The @Override annotation in Java is used to indicate that a method is intended to
  override a method of a superclass or interface.
  This annotation ensures that the method signature matches the one it's supposed to override and helps prevent errors
  due
  to incorrect method names or signatures.
    - Serialization: Serialization is the process of converting an object into a format that can be easily stored or
      transmitted and later reconstructed back into an object. In other words, it's the process of converting an object
      from
      its in-memory representation to a format that can be stored persistently in a file, database, or transmitted over
      a network. it's important for:
        * Persistence - allows objects to be saved to a file or database and later retrieved,
          enabling persistent storage of application data.
        * Data Transfer - Serialized objects can be transmitted over a network between different applications or
          systems.
        * Object Copying - Serialization can be used to create deep copies of objects. By serializing an object and then
          deserializing it, you essentially create a new copy of the original object.
        * Caching: Serialized objects can be cached in memory or on disk to improve performance and reduce the need for
          expensive computations or database queries.
    - Deserialization is the process of reconstructing an object from its serialized form. Serialized objects are
      typically stored in files, databases, or transmitted over a network in the form of a stream of bytes.
      Deserialization involves reading these bytes and converting them back into an object, restoring its state to what
      it was before serialization.

    - Accessors, often referred to as getter and setter methods, are methods used to access and modify the private
      fields (instance variables) of a class. They provide controlled access to the fields, allowing external classes to
      retrieve or modify the values of these fields indirectly, according to the rules defined within the class.
        * Getter Methods: Getter methods are used to retrieve the value of a private field from an object. These methods
          are used to get the current state of the object with the values retrieved written in serialized format. They
          typically have the following characteristics:
            - They are public methods.
            - They have a return type that matches the type of the field they are retrieving.
            - They have a name prefixed with "get" followed by the name of the field (in camelCase).
            - They do not take any parameters.
            - They simply return the value of the field.
        * Setter Methods: Setter methods are used to modify the value of a private field in an object. During
          deserialization, setters are used to populate the fields of newly created objects with data from the
          serialized format. They typically have the following characteristics:
            - They are public methods.
            - They have a void return type.
            - They have a name prefixed with "set" followed by the name of the field (in camelCase).
            - They take a single parameter whose type matches the type of the field they are modifying.
            - They set the value of the field to the value provided as the parameter.

The @JsonProperty annotation is used in Java with frameworks like Jackson, which is a popular JSON parsing library. It
allows you to customize the JSON property name for a field or getter/setter method in a Java class when serializing or
deserializing objects to and from JSON.

# JAVA RECORDS

- Java Records: Java records are a new feature introduced in Java 14 as a preview feature and made stable in Java 16. A
  record is a special kind of class introduced primarily to model immutable data, making it concise, readable, and
  easier to work with. They are better than Plain Old Java Objects (POJOs) since they are
    - Concise: They require less boilerplate since you don't need to explicitly define constructors, accessor methods (
      getters and setters), equals(), hashCode(), or toString() methods. The compiler generates these methods
      automatically based on the record components.
    - Readability: Records improve code readability by providing a clear and concise representation of data classes.
    - Immutability by Default:meaning that their state cannot be changed after initialization.
    - Semantic Equality:Records redefine the equals() and hashCode() methods to use structural equality based on the
      values of their components, rather than object references. This ensures that two record instances with the same
      component values are considered equal, even if they are different instances.
      This behavior is often desired when working with data classes, as it aligns with the notion of equality based on
      the data content rather than object identity.

- PathVariables: refer to variables that are part of the URL path in a RESTful API endpoint. These variables are
  placeholders within the URL pattern that are replaced with actual values when a request is made to the server.
    - Exmaple:  GET /api/users/{id}, When a request is made to retrieve information about a specific user, the actual
      user ID would replace {id} in the URL path.
    - @PathVariable annotation is used to bind the value of the {id} path variable from the URL to the id parameter of
      the getUserById method.
- RequestParams:Request parameters are the key-value pairs that are sent along with an HTTP request. They are typically
  included in the URL query string for GET requests or in the request body for POST requests.
    - @RequestParam is an annotation used to bind request parameters to method parameters in your controller methods.
      Request parameters are the key-value pairs that are sent along with an HTTP request, typically in the URL query
      string or in a form submitted by the client.

  # NOTE:
  PathVariable and RequestParam are use for extracting data from the URL fo an HTTP request in the spring MVC handle.
  They differ in that PathVariable extracts data from the URI path in restful web services where URi contains a value or
  type of resource identifier(the path variable is part of the URI). RequestParam is used to extract query params from
  the URL that carry context information
  for the request and are separated from the URI by a '?' and chained with the '&' symbols. (Example is a search or
  filter text).

@RestController annotation shows that the annotated class is a controller. Rem, controllers are responsible for handling
incoming HTTP requests, processing them, and producing an appropriate response. They typically receive requests,
interact with the necessary components (such as services or repositories) to perform business logic, and then return a
response to the client. Spring detects these classes annotated with it and creates beans of them in the application
context.
@RequestMapping is an annotation used to map HTTP requests to specific handler methods in your controller classes.
Request mapping at method level tells spring that the annotated method should handle a http request of a certain type.
When used at class level, it specifies a base URL path for all handler methods within that class. Meaning that if a
class is annotated with @RequestMapping("/api"), then all methods within that class will handle requests starting with
/api

# DTO:

Data Transfer Object. It's a design pattern used to transfer data between software application subsystems or layers.DTOs
are often used to encapsulate data exchanged between the frontend and backend, or between different layers of the
backend.DTOs serve several purposes:

- Encapsulation: DTOs encapsulate the data to be transferred, providing a clear boundary between different parts of the
  application.
- Data Transformation: DTOs can be used to transform data from one format to another, for example, from database
  entities
  to a format suitable for presentation in the frontend.
- Reduced Coupling: By using DTOs, you can reduce coupling between different layers of your application. For example,
  changes to the database schema don't necessarily affect the frontend as long as the DTOs remain unchanged.
- Security: DTOs can also be used to restrict the data that is transferred between layers, ensuring that sensitive
  information is not exposed unnecessarily.

# SERVICE LAYER

The service layer in the restAPI plays an important role in separating concerns of handling business concerns of
business login and application specific operations from the presentation layer which is the controoler and the data
access layer which is the repository.
it serves as an intermediary between the controller and the repository and encapsulating the business logic and
providing a reusable and modular and testable codebase.

# Importance of the service layer

- Business Logic Encapsulation: The service layer encapsulates the business logic of the application. This separation
  ensures that business rules and operations are isolated from the presentation layer (controllers) and the data access
  layer (repositories), promoting better code organization and maintainability.
- Reusability: By centralizing business logic in the service layer, you can easily reuse the same logic across different
  parts of your application. This reduces code duplication and ensures consistency in how business rules are applied
  throughout the system.
- Testability: Since the service layer contains most of the application's logic, it becomes easier to test. Unit tests
  can
  be written specifically for service methods, mocking any dependencies such as repositories or external services. This
  helps ensure that the business logic behaves as expected under various conditions.
- Transaction Management: Spring's declarative transaction management is often applied at the service layer. By
  annotating
  service methods with transactional annotations, you can define transactional boundaries around business operations.
  This
  ensures that operations either complete successfully or fail as a whole, maintaining data integrity.
- Abstraction: The service layer provides an abstraction over the underlying data access layer. This allows you to
  switch
  data access technologies (e.g., switching from JDBC to JPA) without affecting the service layer or the rest of the
  application.
- Security: Security-related concerns can be addressed at the service layer. This includes authentication,
  authorization,
  and other access control mechanisms. By centralizing security logic in the service layer, you can ensure consistent
  enforcement of security policies across the application.
- Scalability: The service layer can help improve scalability by allowing you to distribute workload across multiple
  service instances or nodes. With proper design, you can scale individual services independently based on the specific
  demands of your application.

## APPROACHES TO FORMAT YOUR CODE STRUCTURE

- By Feature:
  In this approach, you organize your codebase around features or functionalities of your application.
  Each feature or module contains all the layers (such as controller, service, repository) necessary to implement that
  feature.
  This approach promotes high cohesion as related code is grouped together, making it easier to understand and maintain.
- Layer Approach:
  Here, you organize your codebase based on the layers of your application (e.g., presentation layer, service layer,
  data
  access layer).
  All components related to a particular layer are grouped together.
  This approach emphasizes separation of concerns and is particularly useful for larger applications with complex
  business
  logic.
- Domain:
  This approach organizes code around the domain model or business entities of your application.
  Each domain entity has its own set of components (controller, service, repository) that operate on it.
  This approach promotes a clear understanding of the business domain and encourages reusable components.
- By Components:
  In this approach, you organize your codebase based on reusable components or building blocks.
  Each component encapsulates related functionality and can be reused across different features or layers.
  This approach promotes modularity and code reuse, making it easier to maintain and extend the application.

## DATA VALIDATION

Data validation in Spring Boot refers to the process of ensuring that the data entering an application is correct,
consistent, and secure. Here's how it addresses the points you've listed:

- Integrity: Data validation helps maintain data integrity by ensuring that only valid data is accepted by the
  application. This prevents corrupt or inconsistent data from entering the system.
- Preventing Attacks: By validating input data, Spring Boot can prevent various types of attacks such as SQL injection,
  XSS (Cross-Site Scripting), and other security vulnerabilities that exploit improper data handling.
- Error Prevention: Validating data at the input stage helps prevent errors downstream in the application. By catching
  and
  rejecting invalid data early on, it reduces the likelihood of unexpected behavior or crashes later in the
  application's
  execution.
- User Experience (UX): Effective data validation improves the user experience by providing prompt feedback to users
  about
  incorrect input. Instead of submitting a form and waiting for a server response, users are notified immediately if
  they've entered invalid data, allowing them to correct it quickly.
- Performance: Although data validation adds some overhead to the application, the benefits in terms of data integrity
  and
  security outweigh the performance impact. Additionally, Spring Boot provides efficient validation mechanisms that
  minimize any performance degradation.
- Business Logic Compliance: Data validation ensures that the data entering the system complies with the business rules
  and requirements. It helps enforce constraints and conditions specified by the business logic, ensuring that the
  application operates as intended.

# Testing

Testing refers to the process of verifying that the various components and functionalities of your application work as
expected. Testing ensures that your code behaves correctly under different conditions and scenarios, helping to identify
and fix bugs early in the development cycle.
importance of testing 
1. Quality assurance: Testing ensures your software works correctly and meets standards.
2. Regression testing: Ensures new changes don't break existing functionality.
3. Documentation: Tests serve as living documentation of how your code should behave.
4. Code maintainability: Good tests make it easier to change and update your code.
5. Refactoring confidence: Tests give confidence to change code without breaking it.
6. Collaboration: Tests help teams work together by providing a common understanding of code behavior.
7. Continuous integration/deployment (CI/CD): Testing enables automated deployment and ensures only good code goes live.
8. Reduced debugging time: Catching bugs early saves time and effort spent on debugging later.
9. Scalability: Testing ensures your application can handle increased loads and users.
10. Testing helps identify and fix security vulnerabilities in your software.

There are several types of testing commonly used in Spring Boot applications:

- Unit Testing: This involves testing individual components or modules of your application in isolation. In Spring Boot,
  you can use frameworks like JUnit or TestNG along with Mockito or Spring's testing support to write unit tests for
  classes, methods, or beans.
- Integration Testing: Integration testing ensures that the different parts of your application work together correctly.
  In Spring Boot, you can perform integration testing by testing the interactions between various components, such as
  controllers, services, repositories, and external systems.
- Component Testing: Component tests focus on testing a specific component or a group of related components. This can
  involve testing Spring MVC controllers, Spring Data repositories, or other Spring components.
- End-to-End (E2E) Testing: E2E tests verify the behavior of the entire application from end to end. They simulate user
  interactions with the application and test scenarios that involve multiple components and layers. Tools like Selenium
  or Cucumber are often used for E2E testing in Spring Boot.