package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.entities.Moon;
import com.example.demo.exceptions.AuthenticationFailed;
import com.example.demo.exceptions.EntityNotFound;
import com.example.demo.service.moon.MoonServiceImp;

public class MoonController {

    private static Logger moonLogger = LoggerFactory.getLogger(MoonController.class);

    private MoonServiceImp moonService;

    public void entityNotFound(EntityNotFound e) {
        moonLogger.error(e.getLocalizedMessage(), e);
    }

    public void notAuthorized(AuthenticationFailed e) {
        moonLogger.error(e.getLocalizedMessage(), e);
    }

    public void findAll() {
        // TODO: Implement
    }

    public void findById(int id) {
        // TODO: Implement
    }

    public void findByName(String name) {
        // TODO: Implement
    }

    public void createMoon(Moon newMoon) {
        // TODO: Implement
    }

    public void deleteMoon(String name) {
        // TODO: Implement
    }

}
