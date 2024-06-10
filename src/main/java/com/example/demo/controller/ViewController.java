package com.example.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.javalin.http.Context;

public class ViewController {

    //TODO: Add a Utility Class that loads HTML files once and stores them in a Map, access
    //pages with a single method instead of multiple

    //TODO: add a error page for when there is an error loading a page

    public void login(Context ctx){
        try {
            String content = Files.readString(Paths.get("src/main/resources/pages/login.html"));
            ctx.html(content);
            ctx.status(200);
        } catch (IOException e) {
            e.printStackTrace();
            ctx.status(400);}
    }

    public void home(Context ctx){
        try {
            String content = Files.readString(Paths.get("src/main/resources/pages/home.html"));
            ctx.html(content);
            ctx.status(200);
        } catch (IOException e) {
            e.printStackTrace();
            ctx.status(400);}
    }

    public void register(Context ctx){
        try {
            String content = Files.readString(Paths.get("src/main/resources/pages/create.html"));
            ctx.html(content);
            ctx.status(200);
        } catch (IOException e) {
            e.printStackTrace();
            ctx.status(400);}
    }
}
