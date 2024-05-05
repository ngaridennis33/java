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

