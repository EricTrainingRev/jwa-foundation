package com.example.demo.service.user;

import com.example.demo.entities.User;

public interface UserService {
    
    public String createUser(User newUser);
    public User authenticate(User credentials);

}
