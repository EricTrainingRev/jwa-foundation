package com.example.demo.controller;

import com.example.demo.entities.User;
import com.example.demo.exceptions.UserFail;
import com.example.demo.service.user.UserService;

import io.javalin.http.Context;

public class UserController {

    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void createUser(Context ctx) {
        try {
            User user = ctx.bodyAsClass(User.class);
            String result = userService.createUser(user);
            ctx.status(201);
            ctx.json(result);
        } catch (UserFail e) {
            ctx.status(400);
            ctx.json(e.getMessage());
        }
    }

    public void login(Context ctx){
        User user = ctx.bodyAsClass(User.class);
        try {
            user = userService.authenticate(user);
        } catch (UserFail e) {
            ctx.status(401);
            ctx.json(e.getMessage());
        }
        ctx.sessionAttribute("user", user.getUsername());
        ctx.status(200);
        ctx.json(user);
    }


    public void logout(Context ctx){
        ctx.req().getSession().invalidate();
        ctx.json("Logged out");
        ctx.status(401);
    }
}
