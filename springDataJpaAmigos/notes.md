## Java Persistence API (JPA)

JPA is a standard Java specification for object-relational mapping (ORM) and data persistence in Java applications.
JPA also known as Jakarta Persistence API (JPA) is a Java specification for managing relational data in Java
applications.
it provides a high-level, object-oriented interface for working with relational databases.

### key points about JPA

1. Object-Relational Mapping (ORM):
   ORM is a programming technique that maps object-oriented domain models to relational database tables and vice versa.
   With JPA, developers define entity classes in Java to represent database tables. Each entity class corresponds to a
   table, and its attributes represent columns in the table. Relationships between entities are also defined, allowing
   complex associations to be mapped in a straightforward manner.
2. Entity-Relationship Mapping:
   An entity in JPA is a lightweight, persistent Java object that represents a row in a database table. Entities are
   annotated with @Entity to indicate that they are persistent and can be managed by the JPA provider. Each entity class
   typically corresponds to a database table, with its attributes mapping to columns in the table.
   JPA allows developers to define relationships between entities, such as one-to-one, one-to-many, and many-to-many
   relationships. These relationships are represented in Java classes using annotations like @OneToOne, @OneToMany, and
   @ManyToMany. JPA manages the persistence and retrieval of related entities transparently.
3. Annotations:
   JPA uses annotations to define the mapping between Java objects and database tables, as well as to specify various
   persistence-related configurations.
   JPA provides a set of annotations that developers use to define the mapping between Java objects and database tables,
   as well as to configure various aspects of persistence. Some commonly used annotations include:
    - @Entity: Marks a class as a JPA entity.
    - @SequenceGenerator: Specifies the details for generating sequence-based primary key values.
    - @Table: Specifies the name of the database table associated with an entity.
    - @Id: Marks a field as the primary key of an entity.
    - @GeneratedValue: Specifies how primary key values are generated.
    - @Column: Configures the mapping between an entity attribute and a database column.
    - @OneToMany, @ManyToOne, @OneToOne, @ManyToMany: Defines relationships between entities.
4. JPQL (Java Persistence Query Language):
   JPA provides a query language called JPQL, which is similar to SQL but operates on entity objects rather than
   database tables. JPQL queries are portable across different database vendors and allow developers to perform database
   operations using object-oriented syntax.
   JPQL is a database-independent query language provided by JPA for querying entities. JPQL queries operate on entity
   objects and their attributes, rather than directly on database tables. JPQL queries are portable across different
   database vendors, allowing developers to write database queries in a platform-independent manner.
5. In JPA, the persistence context is an in-memory cache of managed entities. The EntityManager is the primary interface
   for interacting with the persistence context and performing CRUD (Create, Read, Update, Delete) operations on
   entities. The EntityManager provides methods for persisting, merging, removing, and querying entities.
   The persistence context is an integral part of JPA and represents the set of managed entity instances that are
   currently associated with a particular database session or transaction. Entities loaded from the database are stored
   in the persistence context, allowing changes to be tracked and managed transparently.
6. JPA includes support for transaction management, allowing developers to perform multiple database operations within a
   single transaction. Transactions ensure data consistency and integrity by providing atomicity, consistency,
   isolation, and durability (ACID) properties.
   JPA supports transaction management, which ensures data consistency and integrity by providing atomicity,
   consistency, isolation, and durability (ACID) properties. Transactions are used to group multiple database operations
   into a single unit of work, ensuring that either all operations succeed or none of them are applied.
7. JPA is a specification, not an implementation. This means that developers can write code using the JPA API without
   being tied to a specific database vendor. JPA implementations, such as Hibernate, EclipseLink, and Apache OpenJPA,
   provide the underlying functionality to interact with different databases.

### REPOSITORY

The goal of spring data repository is to significantly reduce the amount of boilerplate code
required to implement the data access layer for various persistent stores.