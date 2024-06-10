package com.example.demo.repository.planet;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Planet;

public interface PlanetDao {

    Optional<Planet> createPlanet(Planet planet);
    Optional<Planet> readPlanet(int id);
    Optional<Planet> readPlanet(String name);
    List<Planet> readAllPlanets();
    List<Planet> readPlanetsByOwner(int ownerId);
    Optional<Planet> updatePlanet(Planet planet);
    boolean deletePlanet(int id);
    boolean deletePlanet(String name);

}