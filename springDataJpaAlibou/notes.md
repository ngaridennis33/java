## Hibernate vs Spring Data JPA

- spring Data Jpa is an abstraction layer on top of JPA to reduce the amount of boilerplate code required to implement
  data source object.
- JPA is just a specification that facilitates Object Relational Mapping to manage relational data in java applications.
- Hibernate is a JPA implementation. It provides a lightweight framework and is one of the most popular ORM tool used.
- Hibernate generates SQL query and executes using JDBC.

JDBC stands for Java Database Connectivity. JDBC is an API(Application programming interface) used in Java programming
to interact with databases. With JDBC, developers can execute SQL statements, retrieve results, and manipulate databases
programmatically from within Java applications.

JDBC provides a set of interfaces and classes that allow Java applications to connect to different databases, send SQL
queries, retrieve results, and perform database transactions. It acts as a bridge between Java programming language and
databases.

### Advantages of JDBC

- No installation: JDBC comes with every JDK, and you don’t need any additional libraries installed to use it.
- Database Agnostic: JDBC can read any database as long as the connection is with the proper drivers.
- Connection pooling: JDBC connection pooling saves time when opening and closing database connections for every user.
- Easy database access: JDBC low-level database access makes complex SQL queries efficient.

### Project Lombok

Project Lombok is a java library tool that is used to minimize/remove the boilerplate code and save the precious time of
developers during development by just using some annotations. In addition to it, it also increases the readability of
the source code and saves space.

- Without Lombok: A java model class with four private fields and their getters, setters, no-args constructor,
  parameterized construct, and toString method.

```dtd
  public class Employee {

        private Integer employeeId;
        private String name;
        private String company;
        private String emailId;

        public Employee() {}

        public Employee(Integer employeeId, String name,
        String company, String emailId)
        {
        super();
        this.employeeId = employeeId;
        this.name = name;
        this.company = company;
        this.emailId = emailId;
        }

        public Integer getEmployeeId() { return employeeId; }

        public void setEmployeeId(Integer employeeId)
        {
        this.employeeId = employeeId;
        }

        public String getName() { return name; }

        public void setName(String name) { this.name = name; }

        public String getCompany() { return company; }

        public void setCompany(String company)
        {
        this.company = company;
        }

        public String getEmailId() { return emailId; }

        public void setEmailId(String emailId)
        {
        this.emailId = emailId;
        }

        @Override public String toString()
        {
        return "Employee ["
        + "employeeId=" + employeeId + ", name=" + name
        + ", "
        + " company=" + company + ", emailId=" + emailId
        + "]";
        }
        }
```

- With Lombok: A java model class with four private fields and their getters, setters, no-args constructor,
  parameterized construct, and toString method using Lombok annotations.

```dtd
  import lombok.AllArgsConstructor;
        import lombok.Getter;
        import lombok.NoArgsConstructor;
        import lombok.Setter;
        import lombok.ToString;

        @NoArgsConstructor
        @AllArgsConstructor
        @ToString
        public class Employee {
        private @Getter @Setter Integer employeeId;
        private @Getter @Setter String name;
        private @Getter @Setter String company;
        private @Getter @Setter String emailId;
        }
```

#### Lombok annotations:

- Lombok provides a set of annotations to make our coding life easier. Let us look at the few most frequently used
  annotations of Lombok.

1. @Getter and @Setter: These annotations provide the getter and setter methods for a field. These annotations can be
   used at both the levels, field as well as class. @Getter annotation generates a getter method with access type as
   public which simply returns the field and with name getName() if the field name is “Name”. @Setter annotation
   generates a setter method with access type as public which returns void and takes a single parameter to assign the
   value to the field. The default setter will have the name setName() if the field name is “Name”.

```dtd
import lombok.Getter;
        import lombok.Setter;

        public class Employee {
        private @Getter @Setter Integer employeeId;
        private @Getter @Setter String name;
        private @Getter @Setter String company;
        private @Getter @Setter String emailId;
        }
```

2. @NoArgsConstructor: This annotation is used to generate a constructor with no arguments. It has an empty body and
   does nothing. It is generally used in combination with some other parameterized constructor in use. It is required
   when you want to generate an object of the class by passing no arguments in the constructor.

```dtd
import lombok.NoArgsConstructor;

        @NoArgsConstructor
        public class Employee {
        private Integer employeeId;
        private String name;
        private String company;
        private String emailId;
        }
```

3. @AllArgsConstructor: This annotation is used to generate a parameterized constructor which accepts a single parameter
   for each field and initializes them using it. It is required when you want to generate an object of the class by
   passing the initial values of the fields in the constructor.

```dtd
import lombok.AllArgsConstructor;

        @AllArgsConstructor
        public class Employee {
        private Integer employeeId;
        private String name;
        private String company;
        private String emailId;
        }
```

4. @ToString: This annotation is used to override the toString() method and generate a default implementation for it.
   The default implementation prints the class name and the fields in order, separated by commas. You can also skip some
   fields that you don’t want to print by annotating them with @ToString.Exclude.

```dtd
import lombok.ToString;

        @ToString
        public class Employee {
        private Integer employeeId;
        private String name;
        private String company;
        private String emailId;
        }
```

5. @EqualsAndHashCode: This annotation is used to override the equals() and hashCode() methods and provides a default
   implementation for this. The default implementation uses all the non-static fields, and we can modify it and can
   exclude some fields using the annotation @EqualsAndHashCode.Exclude.

```dtd
import lombok.EqualsAndHashCode;

        @EqualsAndHashCode
        public class Employee {
        private Integer employeeId;
        private String name;
        private String company;
        private String emailId;
        }
```

6. @Data: This annotation is a shortcut annotation and bundles @ToString, @Getter, @Setter, @EqualsAndHashCode and
   @RequiredArgsConstructor annotations into a single annotation. This annotation provides all the normally used
   boilerplate code in the model classes of java like getters for all the fields, setter for all the non-final fields, a
   default implementation for toString(), equals() and hashCode() using all the fields of the class and a constructor
   that initializes all the fields of the class.

```dtd
import lombok.Data;

        @Data
        public class Employee {
        private Integer employeeId;
        private String name;
        private String company;
        private String emailId;
        }
```

7. @Builder: This annotation can be used remove boilerplate code involved in setting properties for an object. This is
   useful for POJO’s which have many fields.With this annotation setting properties for an object can be done in a
   single statement of code thereby making it readable and clean.

Example of builder explained:
- suppose you have a phone class as shown below:
```
public class  Phone{
  private String os;
  private int processor;
  private double screenSize;
  private int battery;

  public phone(String os, String processor, double screenSize, int battery){
    super();
    this.os = os;
    this.processor = processor;
    this.screenSize = screenSize;
    this.battery = battery;
  }
}
```
- In order to create an instance of this Phone, we have to pass the parameters and they must be in the correct order as shown below,
```
...
  public static void main(String[]){
    Phone p = new Phone("Android","qwed","2",500)
  }
```
- This approach is complex since we have to specify all the parameters and it cannot be blank. To solve this we use the builder pattern. 

## How builder works
- The builder pattern returns an instance of the object even when all the parameters have not been set.
exmaple:
```
public class  Phone{
  private String os;
  private int processor;
  private double screenSize;
  private int battery;

  public PhoneBuilder setos(String os){
    this.os = os;
    return this;
  }
   public PhoneBuilder setprocessor(String processor){
    this.processor = processor;
    return this;
  }
   public PhoneBuilder setscreenSize(int screenSize){
    this.screenSize = screenSize
    return this;
  }
   public PhoneBuilder setbattery(int battery){
    this.battery = battery;
    return this;
  }

  return Phone getPhone(){
    return new Phone(os, processor, screenSize,battery)
  } 
}
```
To create the instance with some parameters,
```
Phone p = new PhoneBuilder().setos("Android")
```
- This way you are able to create an instance with only the os parameter.

To reduce the boiler plate code, we use lombok @builder as shown below:
```dtd
import lombok.Builder;

        @Builder
        public class Employee {
        private Integer employeeId;
        private String name;
        private String company;
        private String emailId;
        }
```

Example: Using @Builder

```dtd
import java.io.*;

        class LombokTest {
        public static void main (String[] args) {
        Employee employee = Employee.builder().employeeId(21).name("GFG").company("GeeksForGeeks")
        .emailId("gfg@geeks.com").build();
        }
        }
```

@SuperBuilder is placed on the parent class to ensure that builders for subclasses can seamlessly extend the builder of the superclass, allowing for the construction of objects that inherit properties from their parent classes.

@Entity- Typically, an entity represents a table in a relational database, and each entity instance corresponds to a row
in that table. An entity class must follow these requirements.

- The class must be annotated with the javax.persistence.Entity annotation.
- The class must have a public or protected, no-argument constructor. The class may have other constructors.
- The class must not be declared final. No methods or persistent instance variables must be declared final.
- If an entity instance is passed by value as a detached object, such as through a session bean’s remote business
  interface, the class must implement the Serializable interface.
- Entities may extend both entity and non-entity classes, and non-entity classes may extend entity classes.
- Persistent instance variables must be declared private, protected, or package-private and can be accessed directly
  only by the entity class’s methods. Clients must access the entity’s state through accessor or business methods.

@Id - This annotation is inherited from javax.persistence.Id, indicating the member field below is the primary key of
the current entity. It is used to specify the identifier property of an entity used to uniquely identify the entity in
the
database.

## Question: Why use Integer when declaring the primary key instead of int?

- Int value by default is 0 while the Integer value is NULL. This is important because each time spring data JPA's
  hibernate wants to persist a new entry to table, it checks the value of the ID. If the value is NULL, it knows that
  the user wants to persist a new value in the database. Else, it tries to fetch the value in the database with that
  value.

@GeneratedValue - This annotation is generally used in conjunction with @Id annotation to automatically generate unique
values for primary key columns within our database tables.When we apply @GeneratedValue annotation to our primary key
field or property, It will instruct hibernate to automatically generate a unique value for that field during the process
of persisting the entity into the database. The @GeneratedValue annotation provides us with different strategies for the
generation of primary keys which are as follows :

- GenerationType.IDENTITY: This strategy will help us to generate the primary key value by the database itself using the
  auto-increment column option. It relies on the database’s native support for generating unique values.
- GenerationType.AUTO: This is a default strategy and the persistence provider which automatically selects an
  appropriate
  generation strategy based on the database usage.
- GenerationType.TABLE: This strategy uses a separate database table to generate primary key values. The persistence
  provider manages this table and uses it to allocate unique values for primary keys.
- GenerationType.SEQUENCE: This generation-type strategy uses a database sequence to generate primary key values. It
  requires the usage of database sequence objects, which varies depending on the database which is being used.

@Column- This annotation is used to specify the mapping between a persistent field or property of an entity class and a
database column. The @Column annotation is used to customize the mapping of a specific field to a database column. While
JPA automatically maps most fields based on naming conventions, the @Column annotation provides developers with greater
control over the mapping process.
example

```dtd
@Entity
        public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "product_name", nullable = false, length = 100, unique = true)
        private String name;

        @Column(name = "unit_price", precision = 10, scale = 2)
        private double price;

        // Other fields, constructors, getters, setters, etc.
        }
```

* The name attribute of @Column is used to specify the name of the database column. In the example above, the name
  attribute is set to "product_name", which means that the name field in the Product entity will be mapped to the
  product_name column in the database.

* The nullable attribute determines whether the column can contain null values. By setting nullable = false, as shown in
  the example, we are indicating that the name field must have a non-null value in the database.

* The length attribute is used for string-based fields to set the maximum length of the column. In this case, the name
  column will have a maximum length of 100 characters.

* The unique attribute specifies whether the values in the column must be unique across all records. By setting unique =
  true, we are ensuring that each name value in the Product table must be unique.

* The precision and scale attributes are used for decimal-based fields to define the total number of digits and the
  number
  of digits after the decimal point, respectively. In the example, the price column will have a total of 10 digits, with
  2 digits after the decimal point.

@Table annotation - The @Table annotation is used to specify the mapping between a JPA entity and a database table.
This annotation is typically used in conjunction with the @Entity annotation to define the persistence entity class. It
is used for adding the table name in the particular MySQL database. The @Table annotation provides four attributes,
allowing you to override; name, catalogue, schema and unique constraints on columns in the table.

* name: Specifies the name of the database table to which the entity is mapped. This attribute is required and defines
  the
  actual name of the table in the database.
* catalog: Specifies the catalog of the database table. This attribute is optional and specifies the database catalog in
  which the table is located.
* schema: Specifies the schema of the database table. This attribute is optional and specifies the database schema in
  which the table is located.
* uniqueConstraints: Specifies unique constraints on the table. This attribute is optional and allows you to define
  unique
  constraints on one or more columns in the table.

Repository - a repository is a mechanism provided by the Spring Data module for simplifying database access and
interaction with a relational or non-relational database.
Repository abstraction - this is to reduce the amount of boilerplate code needed to implement the DAO (Data Access
Object) to interact with data stores. In spring data Jpa, a repository is java interface to abstract the data access
layer from the business login. it performs CRUD operations and other operations such as paging and sorting.
Here's a brief overview of some commonly used repository interfaces in Spring Boot:

- CrudRepository: Provides CRUD (Create, Read, Update, Delete) operations for entities. Extends the Repository interface
  and adds methods like save, findById, findAll, delete, etc.

- PagingAndSortingRepository: Extends CrudRepository and adds support for pagination and sorting of query results.

- JpaRepository: Extends PagingAndSortingRepository and adds additional JPA-specific features, such as support for named
  queries, flushing changes to the database, and more.

- MongoRepository: Similar to JpaRepository, but designed for MongoDB, providing MongoDB-specific features and
  functionality.

## Database Relationships

Database relationships define how data in different tables are connected or related to each other. These relationships
are crucial for maintaining data integrity and ensuring efficient data retrieval and manipulation. In relational
databases, relationships are typically established using keys (e.g., primary keys and foreign keys). There are several
types of relationships:

- One-to-One (1:1) Relationship: In a one-to-one relationship, each record in one table is associated with exactly one
  record in another table, and vice versa. This relationship is less common but can be useful for splitting data into
  separate tables to reduce redundancy or improve organization.

- One-to-Many (1:N) Relationship: In a one-to-many relationship, a record in one table can be associated with one or
  more
  records in another table, but each record in the second table is associated with only one record in the first table.
  This is the most common type of relationship in relational databases.

- Many-to-One (N:1) Relationship: In a many-to-one relationship, multiple records in one table can be associated with a
  single record in another table. This relationship is essentially the inverse of a one-to-many relationship.

- Many-to-Many (N:M) Relationship: In a many-to-many relationship, multiple records in one table can be associated with
  multiple records in another table, and vice versa. This type of relationship typically requires a junction table or
  associative entity to manage the relationship.

##### Database relationships are established using keys:

* Primary Key: A primary key uniquely identifies each record in a table. It ensures that each record is unique and
  provides a way to access and manipulate individual records.

* Foreign Key: A foreign key is a column or set of columns in one table that refers to the primary key in another table.
  It establishes a link between the two tables and enforces referential integrity, ensuring that the values in the
  foreign
  key column(s) match the values in the primary key column(s) of the referenced table.

- By defining appropriate relationships between tables using primary and foreign keys, database designers can create a
  structured and efficient database schema that accurately represents the relationships between different entities in
  the
  system.

* Unidirectional relationship in database design refers to a connection between two entities where the association is
  only defined in one direction. In relational databases, this is often implemented using foreign key constraints. In a
  one-to-many unidirectional relationship, one entity references another, but the reverse is not necessarily true. For
  example, in an "Order" and "Product" scenario, each product belongs to one order, but an order does not directly
  reference its products. Instead, products reference the order they belong to through a foreign key column. This setup
  allows for efficient querying but may require additional queries to retrieve related data in the opposite direction.
* A bidirectional relationship in database design establishes a connection between two entities where the association is
  defined in both directions. This means that each entity is aware of its relationship with the other entity. In
  relational databases, bidirectional relationships are typically implemented using foreign key constraints on both
  sides of the relationship. This allows for efficient querying and navigation of data in both directions. For example,
  in an "Order" and "Product" scenario, each order can contain multiple products, and each product belongs to one order.
  Bidirectional relationships provide flexibility and facilitate data retrieval and manipulation. However, they require
  careful management to ensure data consistency and integrity.

## Inheritance vs Composition

* Inheritance:
  Inheritance is an "is-a" relationship where one class (subclass or derived class) inherits properties and behaviors
  from
  another class (superclass or base class).
  It allows the subclass to reuse code from the superclass, inheriting fields and methods, and optionally overriding or
  extending them.
  Inheritance establishes a hierarchical relationship, often organized as a tree structure.
  It promotes code reuse and can facilitate polymorphism, allowing objects of subclasses to be treated as objects of the
  superclass.
  However, inheritance can lead to tight coupling between classes, making the codebase less flexible and harder to
  maintain if not used carefully.

* Composition:
  Composition is a "has-a" relationship where one class contains an instance of another class as a member.
  It involves creating new functionality by combining existing classes rather than relying on inheritance.
  Composition allows classes to be composed of other classes, delegating specific tasks to these components.
  It promotes loose coupling and modular design, as components can be easily replaced or extended without affecting
  other
  parts of the system.
  Composition is often preferred over inheritance because it offers more flexibility and avoids issues like the fragile
  base class problem and the inability to change behavior at runtime.
  In summary, inheritance is about defining an "is-a" relationship and promoting code reuse through subclassing, while
  composition is about defining a "has-a" relationship and building complex objects by combining simpler components.
  Each
  approach has its strengths and weaknesses, and the choice between them depends on the specific requirements and design
  goals of the software project.

@Mappedsuperclass - The @MappedSuperclass annotation in Java Persistence API (JPA) is used to designate a superclass
whose mapping information is applied to its subclasses. It allows you to define common persistent fields and mappings in
a superclass without creating a corresponding table for that superclass in the database. Instead, the attributes defined
in the superclass are inherited by its subclasses, and their mappings are merged into the mapping of each subclass.

@EqualsAndHashCode(callSuper = true) - The @EqualsAndHashCode(callSuper = true) annotation is used in Java with Lombok
library to automatically generate equals() and hashCode() methods for a class, including fields inherited from its
superclass.

Here's a breakdown of how it works:

@EqualsAndHashCode: This annotation is used to instruct Lombok to generate equals() and hashCode() methods for the
annotated class.

callSuper = true: This parameter specifies that the generated equals() and hashCode() methods should include fields
inherited from the superclass when calculating equality and hash codes.

When you specify callSuper = true, Lombok generates equals() and hashCode() methods that take into account the fields of
both the current class and its superclass. If any superclass has the @EqualsAndHashCode annotation with callSuper =
true, Lombok will recursively include fields from all superclasses in the generated methods.

Here's an example usage:

```dtd
import lombok.EqualsAndHashCode;

        @EqualsAndHashCode(callSuper = true)
        public class Child extends Parent {
        private String childField;

        // Constructor, getters, and setters

        }
```

In this example, Child class inherits from Parent class, and both classes have fields. By annotating Child class with
@EqualsAndHashCode(callSuper = true), Lombok will generate equals() and hashCode() methods for Child class that consider
both Child and Parent class fields.

### Inheritance in the Database

nheritance refers to a data modeling technique where one table (child table) inherits attributes and relationships from
another table (parent table). This concept is often referred to as "table inheritance" or "subclassing" and is commonly
used in object-relational mapping (ORM) frameworks like Hibernate and in some database management systems (DBMS) like
PostgreSQL.

Here's an overview of how inheritance works in the database:

Parent Table: The parent table serves as a template or blueprint for the child tables. It contains common attributes and
relationships that are shared by multiple entities.

Child Table(s): Each child table represents a specific entity or subtype that extends or specializes the parent entity.
Child tables inherit attributes and relationships from the parent table but can also define additional attributes or
relationships specific to the subtype.

Inheritance Strategy: There are different strategies for implementing table inheritance, including:

Single Table Inheritance (STI): All attributes of the parent and child entities are stored in a single database table. A
discriminator column is used to differentiate between different entity types.

Class Table Inheritance (CTI): Each entity type (parent and child) is represented by its own database table. The parent
table contains common attributes, while child tables contain specific attributes. Relationships are typically
established using foreign key constraints.

Joined Table Inheritance (JTI): Each entity type has its own database table, and relationships between parent and child
entities are represented using foreign key constraints. Each table stores only its own attributes, and related
attributes are joined together when querying.

Inheritance in the database allows for data organization and modeling of complex entity hierarchies. It promotes code
reuse, reduces redundancy, and facilitates polymorphic queries where data from multiple entity types can be queried and
retrieved using a common interface.

However, it's important to carefully consider the trade-offs and choose an appropriate inheritance strategy based on
factors such as performance, data integrity, and complexity of queries. Additionally, not all DBMS support native table
inheritance, so alternative approaches or ORM solutions may be necessary in such cases.

# The @DiscriminatorColumn annotation

is used in Java Persistence API (JPA) to specify the column used for discriminating between different types of entities
in a table inheritance hierarchy. It's typically used in conjunction with inheritance mapping strategies such as Single
Table Inheritance (STI), where multiple entity types are stored in the same database table.

Here's how you would typically use @DiscriminatorColumn:

```dtd
import javax.persistence.*;

        @Entity
        @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
        @DiscriminatorColumn(name = "entity_type")
        public abstract class BaseEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        // Other common fields and methods

        }

        @Entity
        @DiscriminatorValue("child1")
        public class ChildEntity1 extends BaseEntity {
        // Specific fields and methods for ChildEntity1
        }

        @Entity
        @DiscriminatorValue("child2")
        public class ChildEntity2 extends BaseEntity {
        // Specific fields and methods for ChildEntity2
        }
```

In this example:

@Inheritance(strategy = InheritanceType.SINGLE_TABLE): Indicates that the inheritance strategy for the hierarchy is
Single Table Inheritance (STI), where all entities in the hierarchy are stored in a single database table.

@DiscriminatorColumn(name = "entity_type"): Specifies the name of the discriminator column in the database table. This
column is used to differentiate between different types of entities in the table.

@DiscriminatorValue("child1") and @DiscriminatorValue("child2"): Specifies the discriminator value for each subclass.
This value is stored in the discriminator column to indicate the type of entity represented by each row in the table.

Using @DiscriminatorColumn and @DiscriminatorValue allows JPA to determine the correct entity type when retrieving data
from the database table and instantiate the corresponding Java objects accordingly. It's important to note that
@DiscriminatorColumn is only applicable to inheritance strategies where entities are stored in a single table, such as
Single Table Inheritance (STI). Other strategies like Joined Table Inheritance (JTI) and Class Table Inheritance (CTI)
do not use discriminator columns.

Composite primary keys are keys that use more than one column to identify a row in the table uniquely.

## Embeded ids:

We represent a composite primary key in Spring Data by using the @Embeddable annotation on a class. This key is then
embedded in the table’s corresponding entity class as the composite primary key by using the @EmbeddedId annotation on a
field of the @Embeddable type.

Example of @EmbeddedId: Suppose we want to retrieve a specific order for a given user, we can use their email if it is
unique. However, a user may have placed many orders making this return a list of all orders. To retrieve the specific
order we will need a combination of both the email and the datetime. This will be the composite primary key.

- These are the two entries to uniquely identify the order.

```dtd
@Data
        @AllArgsConstructor
        @NoArgsConstructor
        @Embeddable
        public class OrderId {

        private String username;

        private LocalDateTime orderDate;
        }
```

- This is then embedded into the order entity as shown below.

```dtd
@Data
        @AllArgsConstructor
        @NoArgsConstructor
        @Entity
        @Table(name = "_order")
        public class Order implements Serializable {

        @EmbeddedId
        private OrderId id;

        private String orderInfo;

        private String anotherField;
        }
```

Example of @Embedded: Suppose we have a Field address that we want to use in different tables, we can embed it on that
table inorder to avoid code duplication.

- The duplicate item to be used in different entities.

```dtd
        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @Embeddable
        public class Address {

        private String streetName;

        private String houseNumber;

        private String zipCode;
        }
```

- The above code can be inserted into the orders table as shown below,

```dtd
package com.denraxcoding.springDataJpaAlibou.models.embedded;

        import jakarta.persistence.*;
        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

        import java.io.Serializable;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @Entity
        @Table(name = "_order")
        public class Order implements Serializable {

        @EmbeddedId
        private OrderId id;

        @Embedded
        private Address address;

        private String orderInfo;

        private String anotherField;
        }
```

# Query annotation

provides us with the opportunity to write a specific JPQL or SQL query in the @Query annotation:

```dtd
@Query("select u from User u where u.email like '%@gmail.com'")
        List
<User>findUsersWithGmailAddress();
```

In this code snippet, we can see a query retrieving users having an @gmail.com email address.

The first mechanism enables us to retrieve or delete data. As for the second mechanism, it allows us to execute pretty
much any query. However, for updating queries, we must add the @Modifying annotation.
The @Modifying annotation is used to enhance the @Query annotation so that we can execute not only SELECT queries, but
also INSERT, UPDATE, DELETE, and even DDL queries.

Now let’s play with this annotation a little.

First, let’s look at an example of a @Modifying UPDATE query:

```dtd
  @Modifying
        @Query("update User u set u.active = false where u.lastLoginDate
< :date")
        void deactivateUsersNotLoggedInSince(@Param("date") LocalDate date);

```

exmaple2:
Here we’re deactivating the users that haven’t logged in since a given date.

Let’s try another one, where we’ll delete deactivated users:

```dtd
@Modifying
        @Query("delete User u where u.active = false")
        int deleteDeactivatedUsers();
```

@Transactional- This ensures that the modification being made is in the same transaction.

@NamedQueries - Named queries are used for organizing, optimizing and maintaining query definitions in your application.
This annotation is used in Java Persistence API (JPA) to define multiple static, named JPQL (Java Persistence Query
Language) queries. They provide a way to predefine queries that can be referenced by name when needed, promoting code
reuse and improving readability and maintainability. These queries are typically defined at the entity class level.

## Why are named queries important

- Encapsulation of query logic(Helps separate query definition from the rest of the application logic)
- Optimize performance of the application since they are validated and passed and often optimized during application
  start-up
- Centralized. They allow you to save your query on one place such as the entity class or external class this
  externalization simplifies query management and makes it easy to update and refactor the queries.

## Use cases

- When you have complex queries used in multiple places in your application
- when you want to optimize the performance of your application for frequently executed queries.
- when you want to improve code readability and maintainability by separating code definitions from other application
  logic
- when you need a tendered way of organizing and managing queries across your application.

* In Summary, @NamedQueries provide;

- Code Reuse: Named queries allow you to define queries once and use them in multiple places within your application.
  This avoids duplication and makes your code cleaner.

- Centralized Query Management: By defining queries at the entity level, it becomes easier to manage and modify them. If
  a query needs to be changed, it can be updated in one place rather than in every instance where the query is used.

- Readability: Using named queries improves code readability. Instead of having JPQL strings scattered throughout the
  codebase, you refer to named queries by their names, which are more descriptive and easier to understand.

- Refactor-Friendly: Refactoring is easier with named queries. When query logic changes, you only need to update the
  named query definition rather than searching for all occurrences of the query string in the codebase.

- Potential Performance Optimizations: Some JPA providers might optimize the execution of named queries by pre-compiling
  them or caching the query plans, leading to potential performance improvements.

## Spring Data JPA Specifications

This is powerful and flexible feature provided by spring Data JPA framework , that allows developers to create dynamic
and type safe queries using JPA criteria API. It enables the developer to build complex queries based on various
criteria which can be combined and used in different scenarios in providing maintainability and flexibility in
constructing queries. The core revolves around the specification interface which is a functional interface with a single
method.
In simple terms, a specification is an interface or contract that defines a set of rules an implementation must follow.
In the context of Spring Data JPA, specifications are often used to construct queries programmatically, allowing the
creation of dynamic search criteria.

## Specifications Summary

What it is:

- Provides a flexible and expressive way to construct complex queries at runtime.
- Encapsulates query logic within a Specification interface, promoting code organization and maintainability.
- Separates the query logic from the repository, making code more reusable.

## How it works:

1. Define a Specification Interface:

* This interface has a single method

```dtd
  Predicate toPredicate(Root
<T>root, CriteriaQuery<?> query, CriteriaBuilder cb);
```

- Predicates are conditions or criteria used to filter data when querying databases or other data sources. They enable
  developers to define flexible criteria programmatically, allowing for dynamic query construction based on runtime
  conditions.
- toPredicate method receives three arguments:
    * Root represents the root entity in the query from which you can navigate to other related entities and attributes.
      The T represents the entity type in which the query is built,
    * CriteriaQuery which is an object representing the overall object being built. It is of type '?' or any. It's used
      to modify the query structure or add more constraints. It builds predicates (conditions) for your query based on
      entity attributes and desired operations (equality, greater than, etc.).
    * CriteriaBuilder which is an object that acts as a factory for creating various query elements like predicate
      extensions and orderings.
- toPredicate method, returns a Predicate which is a boolean representing the query condition.

2. Implement Specific Criteria:

* Create concrete classes that implement the Specification interface, each representing a specific search criteria.
* Within these classes, define the logic for building predicates based on the specific criteria.

3. Combine Specifications (Optional):

* Spring Data JPA provides methods for combining specifications using logical operators (AND, OR) to create more complex
  queries.

4. Use Specifications in Repositories:

* Repositories extending JpaSpecificationExecutor can leverage the findAll and other methods with a Specification
  parameter.
* Pass the desired Specification object(s) to the repository method to execute the dynamic query.

#### Benefits:

- Dynamic and flexible query construction based on runtime criteria.
- Improved code organization and maintainability through separation of concerns.
- Reusable specifications for common search and filtering scenarios.

## Example of How it works

* Client Request: A client sends a request to the endpoint /authors/older-than with a query parameter age.
* Controller Method: The getAuthorsOlderThan method in AuthorController is called, which in turn calls the
  findAuthorsOlderThan method in AuthorService.
* Service Method:

- The findAuthorsOlderThan method creates a specification using AuthorSpecifications.hasAgeGreaterThan(age).
- This specification defines the condition to filter authors whose age is greater than the provided value.
- The method then calls authorRepository.findAll(spec), passing the specification.

* Repository Query:

- findAll(spec) uses the criteria defined by the specification to query the database.
- It returns a list of Author entities that match the criteria.

* what is a static method: A static method in Java is a method that is part of a class rather than an instance of that
  class. Every instance of a class has access to the method. Static methods have access to class variables (static
  variables) without using the class’s object (instance). You can access a static method without necessarily creating an
  instance of that class. When a variable is declared static in Java programming, it means that the variable belongs to
  the class itself rather than to any specific instance of the class. This means that there is only one copy of the
  variable in memory, regardless of how many instances of the class are created. in summary, Whenever a variable is
  declared as static, this means there is only one copy of it for the entire class, rather than each instance having its
  own copy. A static method means it can be called without creating an instance of the class. Static variables and
  methods in Java provide several advantages, including memory efficiency, global access, object
  independence, performance, and code organization.

## The equals() and hashCode() methods

- Every class in java extends the object class.

### Example;

```dtd
  class Laptop{
        private Int price;
        private String brand;
        };
```

If you print laptop, It prints the name of the class and a HexString of a hashCode. A hashcode is an integer
representation derived from an object's state and used for efficient data retrieval and storage in collections like
HashMap, HashSet, and Hashtable. It is generated based on the data you have.
If I want to print the custom message I have to override the super class.

```dtd
  public String toString(){
        return "custom Message";
        }
```

## Comparison

Suppose we create two instances of the Laptop class, with the same price and brand will the two items be similar?

```dtd
<!--Obj1-->
        Laptop obj1 = new Laptop();
        obj1.price = 250;
        obj1.brand = "Lenovo";

        <!--Obj2-->
        Laptop obj2 = new Laptop();
        obj2.price = 250;
        obj2.brand = "lenovo";
```

* Are the two objects equal?

```dtd
    obj1 == obj2  // False
        boolean result = obj1.equals(obj2) // False
```

- The above code compares the two objects based on their hexadecimal numbers and not their values hence it evaluates to
  false despite the two objects having the same properties and values. To avoid this, ensure that the objects themselves
  compare by overriding the equals() and hashCode().


### VALIDATIONS

- @NotNull- @NotNull constraint won’t allow null values for the constrained field(s). However, the field(s) can be
  empty.
- @NotBlank - The @NotBlank annotation uses the NotBlankValidator class, which checks that a character sequence’s
trimmed length is not empty; i.e. Enforces non-nullity and requires at least one non-whitespace character.
- @NotEmpty - @NotEmpty: Guarantees that collections or arrays are not empty. This means that a field (e.g.
  CharSequence, Collection, Map, or Array) constrained with @NotEmpty must be not null, and its size/length must be
  greater than zero. In doing so, we’d also enforce that the object’s min and max size values are within the specified
  min/max range:
- @Min(value): Checks if a numeric field is greater than or equal to the specified minimum value.
- @Max(value): Checks if a numeric field is less than or equal to the specified maximum value.
- @Size(min, max): Validates if a string or collection size is within a specific range.
  @Pattern(regex): Verifies if a field matches the provided regular expression.
- @Email: Ensures a field contains a valid email address format.
- @Digits(integer, fraction): Validates that a numeric field has a specified number of integer and fraction digits.
- @Past and @Future : Checks that a date or time field is in the past and future respectively.
- @AssertTrue and @AssertFalse: Ensures that a boolean field is true. and false respectively.
- @CreditCardNumber: Validates that a field contains a valid credit card number.
- @Valid: Triggers validation of nested objects or properties.
- @Validated: Specifies validation groups to be applied at the class or method level.


## @NaturalId
Specifies that a field or property of an entity class is part of the natural id of the entity. This annotation is very useful when the primary key of an entity class is a surrogate key, that is, a system-generated synthetic identifier, with no domain-model semantics. There should always be some other field or combination of fields which uniquely identifies an instance of the entity from the point of view of the user of the system. This is the natural id of the entity.

Example:
```
 //simple natural id
     @NotNull @NaturalId
     String ssn;
```

### @CreationTimestamp and @UpdateTimestamp
- @CreateTimestamp annotation marks a property as the creation timestamp of the entity. The property value will be set to the current VM date exactly once when saving the entity for the first time.
- @UpdateTimestamp annotation marks a property as the updated timestamp of the entity. The property value will be set to the current VM date whenever the entity is updated. When the entity is saved the first time, the updation timestamp value is the same as the creation time, but during subsequent entity updates the creation time is not changed only the updation time is updated.

### Java Records
As of JDK 14, we can replace our repetitious data classes with records. Records are immutable data classes that require only the type and name of fields.

The equals, hashCode, and toString methods, as well as the private, final fields and public constructor, are generated by the Java compiler.
 Example:
 ```
 public record Person (String name, String address) {}
 ```
 - The above example provides:
  * Constructor: Using records, a public constructor, with an argument for each field, is generated for us.
  * Getters: We also receive public getters methods, whose names match the name of our field, for free. In our Person record, this means a name() and address() getter.
  * equals: Additionally, an equals method is generated for us.This method returns true if the supplied object is of the same type and the values of all of its fields match:
  * hashCode: Similar to our equals method, a corresponding hashCode method is also generated for us.Our hashCode method returns the same value for two Person objects if all of the field values for both objects match.
  * toString: Lastly, we also receive a toString method that results in a string containing the name of the record, followed by the name of each field and its corresponding value in square brackets.

## The final keyword
The final keyword is a non-access modifier used for classes, attributes and methods, which makes them non-changeable (impossible to inherit or override).