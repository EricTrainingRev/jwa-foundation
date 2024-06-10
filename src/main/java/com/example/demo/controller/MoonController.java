package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.entities.Moon;
import com.example.demo.entities.Planet;
import com.example.demo.exceptions.AuthenticationFailed;
import com.example.demo.exceptions.EntityNotFound;
import com.example.demo.service.moon.MoonService;
import com.example.demo.service.moon.MoonServiceImp;

import io.javalin.http.Context;

public class MoonController {

    private MoonService moonService;

    public MoonController(MoonService moonService) {
        this.moonService = moonService;
    }

    public void findAll(Context ctx) {
        List<Moon> moons = moonService.selectAllMoons();
        ctx.json(moons);
        ctx.status(200);
    }

    public void findAllByPlanet(Context ctx) {
        int ownerId = Integer.parseInt(ctx.pathParam("planetId"));
        List<Moon> moons = moonService.selectByPlanet(ownerId);
        ctx.json(moons);
        ctx.status(200);
    }

    public void findByIdentifier(Context ctx) {
        String identifier = ctx.pathParam("identifier");
        Moon moon;
        if(identifier.matches("^[0-9]+$")) {
            moon = moonService.selectMoon(Integer.parseInt(identifier));
        } else {
            moon = moonService.selectMoon(identifier);
        }
        ctx.json(moon);
        ctx.status(200);
    }

    public void createMoon(Context ctx) {
        Moon moon = ctx.bodyAsClass(Moon.class);
        Moon createdMoon = moonService.createMoon(moon);
        ctx.json(createdMoon);
        ctx.status(201);
    }

    public void deleteMoon(Context ctx) {
        String identifier = ctx.pathParam("identifier");
        String responseMessage;
        if(identifier.matches("^[0-9]+$")) {
            responseMessage = moonService.deleteMoon(Integer.parseInt(identifier));
        } else {
            responseMessage = moonService.deleteMoon(identifier);
        }
        ctx.json(responseMessage);
        ctx.status(200);
    }

}
