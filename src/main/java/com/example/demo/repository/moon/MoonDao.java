package com.example.demo.repository.moon;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Moon;

public interface MoonDao {

    Optional<Moon> createMoon(Moon moon);
    Optional<Moon> readMoon(int id);
    Optional<Moon> readMoon(String name);
    List<Moon> readAllMoons();
    List<Moon> readMoonsByPlanet(int planetId);
    Optional<Moon> updateMoon(Moon moon);
    boolean deleteMoon(int id);
    boolean deleteMoon(String name);

}