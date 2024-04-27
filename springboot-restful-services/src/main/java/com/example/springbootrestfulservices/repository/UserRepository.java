package com.example.springbootrestfulservices.repository;

import com.example.springbootrestfulservices.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
}

/*
CODE EXPLANATION

- package com.example.springbootrestfulservices.repository;: This line specifies the package name where the interface resides.
- import com.example.springbootrestfulservices.Entity.User;: This imports the User entity class from the com.example.springbootrestfulservices.Entity package. This entity class represents the data model for users in the application.
- import org.springframework.data.jpa.repository.JpaRepository;: This imports the JpaRepository interface from the Spring Data JPA framework. JpaRepository is an interface provided by Spring Data JPA for creating repositories for JPA entities.
- public interface UserRepository extends JpaRepository<User, Long> { }: This defines the UserRepository interface.
Within the UserRepository interface, methods are inherited from the JpaRepository interface for performing common database operations on User entities. Some of these methods include:
1. findById(Long id): Retrieves an entity by its ID.
2. findAll(): Retrieves all entities.
3. save(S entity): Saves an entity.
4. deleteById(Long id): Deletes an entity by its ID.
 */
