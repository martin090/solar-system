package com.martinsanguin.solarsystem;

import com.martinsanguin.solarsystem.entities.*;
import org.assertj.core.annotations.Beta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolarSystemTests {

    private SolarSystem solarSystem;
    private Planet ferengi;
    private Planet betasoide;
    private Planet vulcano;

    @BeforeEach
    public void setUp(){
        solarSystem = new SolarSystem();

        ferengi = new Ferengi();
        betasoide = new Betasoide();
        vulcano = new Vulcano();

        solarSystem.getPlanets().add(ferengi);
        solarSystem.getPlanets().add(betasoide);
        solarSystem.getPlanets().add(vulcano);
    }

    @Test
    public void ferengiAndBetasoideAndVulcanoAndTheSunAreAligned() {

        solarSystem.getPlanets().add(ferengi);
        solarSystem.getPlanets().add(betasoide);
        solarSystem.getPlanets().add(vulcano);

        assertTrue(solarSystem.arePlanetsAndSunAligned(90));
        assertTrue(solarSystem.arePlanetsAndSunAligned(450));
        assertTrue(solarSystem.arePlanetsAndSunAligned(1170));
    }

    @Test
    public void ferengiAndBetasoideAndVulcanoAndTheSunAreNotAligned() {

        solarSystem.getPlanets().add(ferengi);
        solarSystem.getPlanets().add(betasoide);
        solarSystem.getPlanets().add(vulcano);

        assertFalse(solarSystem.arePlanetsAndSunAligned(15));
        assertFalse(solarSystem.arePlanetsAndSunAligned(430));
        assertFalse(solarSystem.arePlanetsAndSunAligned(1560));
    }

}
