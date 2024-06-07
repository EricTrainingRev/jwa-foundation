package com.example.demo.service.planet;

import com.example.demo.entities.Planet;

import java.util.List;

public interface PlanetService<T> {

    Planet createPlanet(Planet planet);
    Planet selectPlanet(T idOrName);
    List<Planet> selectAllPlanets();
    List<Planet> selectByOwner(int ownerId);
    Planet updatePlanet(Planet planet);
    String deletePlanet(T idOrName);
    
}
