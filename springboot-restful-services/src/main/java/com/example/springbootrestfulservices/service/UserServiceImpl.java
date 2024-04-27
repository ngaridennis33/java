package com.example.springbootrestfulservices.service;

import lombok.AllArgsConstructor;
import com.example.springbootrestfulservices.Entity.User;
import com.example.springbootrestfulservices.repository.UserRepository;
import com.example.springbootrestfulservices.service.UserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}

/*
CODE EXPLANATION
- package com.example.springbootrestfulservices.service;: This line specifies the package name where the class resides.
- import lombok.AllArgsConstructor;: This imports the AllArgsConstructor annotation from Lombok, which automatically generates a constructor with all arguments.
- import com.example.springbootrestfulservices.Entity.User;: This imports the User entity class from the com.example.springbootrestfulservices.Entity package. This entity class represents the data model for users in the application.
- import com.example.springbootrestfulservices.repository.UserRepository;: This imports the UserRepository interface from the com.example.springbootrestfulservices.repository package. This interface provides methods for interacting with the database to perform CRUD operations on User entities.
- port org.springframework.stereotype.Service;: This imports the Service annotation from Spring Framework, which marks the class as a service component in Spring's component scanning mechanism.
- import org.springframework.util.StringUtils;: This imports the StringUtils utility class from Spring Framework, which provides utility methods for working with strings.
- import java.util.List;, import java.util.Objects;, import java.util.Optional;: These import statements bring in Java standard library classes for working with collections and handling null values.
- @Service: This annotation marks the class as a service component in Spring, allowing it to be automatically detected and wired by Spring's component scanning mechanism.
- @AllArgsConstructor: This annotation, provided by Lombok, generates a constructor with all arguments. It's used here to inject dependencies (in this case, the UserRepository) into the class via constructor injection.
- public class UserServiceImpl implements UserService { }: This defines the UserServiceImpl class, which implements the UserService interface.

* Within the UserServiceImpl class, methods are implemented to perform CRUD (Create, Read, Update, Delete) operations on User entities using methods provided by the UserRepository interface:
- createUser(User user): Creates a new user by saving the provided User object using the userRepository.save() method.
- getUserById(Long userId): Retrieves a user by their unique identifier (ID) using the userRepository.findById() method. It returns the user object if found, otherwise throws an exception.
- getAllUsers(): Retrieves all users from the database using the userRepository.findAll() method.
- updateUser(User user): Updates an existing user's information using the provided User object. It retrieves the existing user from the database using the userRepository.findById() method, updates its properties, and saves the updated user using the userRepository.save() method.
- deleteUser(Long userId): Deletes a user by their unique identifier (ID) using the userRepository.deleteById() method.
 */