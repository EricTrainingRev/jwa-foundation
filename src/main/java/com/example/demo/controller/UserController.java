package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.example.demo.entities.User;
import com.example.demo.service.UserService;
import com.example.demo.exceptions.AuthenticationFailed;

public class UserController {

    private static Logger userLogger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    public void notAuthorized(AuthenticationFailed e) {
        userLogger.error(e.getLocalizedMessage(), e);
    }

    public void createUser(User newUser) {
         // TODO: implement
    }

    public void login(User credentials){
        // TODO: implement
    }

    public void logout(){
        // TODO: implement
    }
}
