package com.example.springbootrestfulservices.service;

import com.example.springbootrestfulservices.Entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserById(Long userId);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long userId);
}

/*
CODE EXPLANATION

- package com.example.springbootrestfulservices.service;: This line specifies the package name where the interface resides.
- import com.example.springbootrestfulservices.Entity.User;: This imports the User entity class from the com.example.springbootrestfulservices.Entity package.
- import java.util.List;: This imports the List interface from the Java Standard Library. This will be used to define methods that return a list of User objects.
- public interface UserService { }: This defines the UserService interface.
Within the UserService interface, the following methods are declared:
1. User createUser(User user);: This method declares a signature for creating a new user. It takes a User object as a parameter and returns a User object representing the newly created user.
2. User getUserById(Long userId);: This method declares a signature for retrieving a user by their unique identifier (ID). It takes a Long value representing the user's ID as a parameter and returns a User object representing the user with the specified ID.
3. List<User> getAllUsers();: This method declares a signature for retrieving all users. It returns a list of User objects containing all users in the system.
4. User updateUser(User user);: This method declares a signature for updating an existing user. It takes a User object representing the updated user as a parameter and returns a User object representing the updated user.
5. void deleteUser(Long userId);: This method declares a signature for deleting a user by their unique identifier (ID). It takes a Long value representing the user's ID as a parameter and does not return any value (void).
 */
