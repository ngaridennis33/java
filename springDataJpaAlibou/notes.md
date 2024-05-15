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
