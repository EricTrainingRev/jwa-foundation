package com.example.demo.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.entities.Planet;
import com.example.demo.exceptions.AuthenticationFailed;
import com.example.demo.exceptions.EntityNotFound;
import com.example.demo.service.PlanetService;

public class PlanetController {

    private static Logger planetLogger = LoggerFactory.getLogger(PlanetController.class);

    private PlanetService planetService;

    public void entityNotFound(EntityNotFound e) {
        planetLogger.error(e.getLocalizedMessage(), e);
    }

    public void notAuthorized(AuthenticationFailed e) {
        planetLogger.error(e.getLocalizedMessage(), e);
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

    public void createPlanet(Planet newPlanet) {
        // TODO: Implement
    }

    public void deletePlanet(String name) {
        // TODO: Implement
    }
}
