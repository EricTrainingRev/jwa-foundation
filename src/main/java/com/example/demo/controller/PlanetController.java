package com.example.demo.controller;

import java.util.List;

import com.example.demo.entities.Planet;
import com.example.demo.exceptions.AuthenticationFailed;
import com.example.demo.exceptions.EntityNotFound;
import com.example.demo.service.planet.PlanetService;

import io.javalin.http.Context;

public class PlanetController {

    private PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    public void findAll(Context ctx) {
        List<Planet> planets = planetService.selectAllPlanets();
        ctx.json(planets);
        ctx.status(200);
    }

    public void findAllByOwner(Context ctx) {
        int ownerId = Integer.parseInt(ctx.pathParam("ownerId"));
        List<Planet> planets = planetService.selectByOwner(ownerId);
        ctx.json(planets);
        ctx.status(200);
    }

    public void findByIdentifier(Context ctx) {
        String identifier = ctx.pathParam("identifier");
        Planet planet;
        if(identifier.matches("^[0-9]+$")) {
            planet = planetService.selectPlanet(Integer.parseInt(identifier));
        } else {
            planet = planetService.selectPlanet(identifier);
        }
        ctx.json(planet);
        ctx.status(200);
    }

    public void createPlanet(Context ctx) {
        Planet planet = ctx.bodyAsClass(Planet.class);
        Planet createdPlanet = planetService.createPlanet(planet);
        ctx.json(createdPlanet);
        ctx.status(201);
    }

    public void deletePlanet(Context ctx) {
        String identifier = ctx.pathParam("identifier");
        String responseMessage;
        if(identifier.matches("^[0-9]+$")) {
            responseMessage = planetService.deletePlanet(Integer.parseInt(identifier));
        } else {
            responseMessage = planetService.deletePlanet(identifier);
        }
        ctx.json(responseMessage);
        ctx.status(200);
    }

}
