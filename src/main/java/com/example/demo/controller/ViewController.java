package com.example.demo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.javalin.http.Context;

public class ViewController {

    //TODO: Add a Utility Class that loads HTML files once and stores them in a Map, access
    //pages with a single method instead of multiple

    //TODO: add a error page for when there is an error loading a page

    public String loadPage(String page) throws IOException{
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(String.format("pages/%s", page));
        StringBuilder stringBuilder = new StringBuilder();
        try (Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
            int read;
            char[] buffer = new char[4096];
            while ((read = reader.read(buffer)) != -1) {
                stringBuilder.append(buffer, 0, read);
            }
        }
        String content = stringBuilder.toString();   
        return content;
    }

    public void login(Context ctx){
        try {
            String content = loadPage("login.html");
            ctx.html(content);
            ctx.status(200);
        } catch (IOException e) {
            e.printStackTrace();
            ctx.status(400);}
    }

    public void home(Context ctx){
        try {
            String content = loadPage("home.html");
            ctx.html(content);
            ctx.status(200);
        } catch (IOException e) {
            e.printStackTrace();
            ctx.status(400);}
    }

    public void register(Context ctx){
        try {
            String content = loadPage("create.html");
            ctx.html(content);
            ctx.status(200);
        } catch (IOException e) {
            e.printStackTrace();
            ctx.status(400);}
    }
}
