package com.example.demo.repository.user;

import java.util.Optional;

import com.example.demo.entities.User;

public interface UserDao {

    Optional<User> createUser(User newUser);
    Optional<User> findUserByUsername(String username);
}
