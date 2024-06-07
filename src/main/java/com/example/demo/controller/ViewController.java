package com.example.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ViewController {

    public String login(){
        try {
            String content = Files.readString(Paths.get("src/main/resources/pages/login.html"));
            return content;
        } catch (IOException e) {
            e.printStackTrace();
            return "Error loading file content";
        }
    }

    public String home(){
        try {
            String content = Files.readString(Paths.get("src/main/resources/pages/home.html"));
            return content;
        } catch (IOException e) {
            e.printStackTrace();
            return "Error loading file content";
        }
    }

    public String create(){
        try {
            String content = Files.readString(Paths.get("src/main/resources/pages/create.html"));
            return content;
        } catch (IOException e) {
            e.printStackTrace();
            return "Error loading file content";
        }
    }
}
