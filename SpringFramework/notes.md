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
      