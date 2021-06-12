package com.martinsanguin.solarsystem;

import com.martinsanguin.solarsystem.entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

        solarSystem.addPlanet(ferengi);
        solarSystem.addPlanet(betasoide);
        solarSystem.addPlanet(vulcano);
    }

    @Test
    public void ferengiAndBetasoideAndVulcanoAndTheSunAreAligned() {

        solarSystem.addPlanet(ferengi);
        solarSystem.addPlanet(betasoide);
        solarSystem.addPlanet(vulcano);

        assertTrue(solarSystem.arePlanetsAndSunAlignedAtDay(90));
        assertTrue(solarSystem.arePlanetsAndSunAlignedAtDay(450));
        assertTrue(solarSystem.arePlanetsAndSunAlignedAtDay(1170));
    }

    @Test
    public void ferengiAndBetasoideAndVulcanoAndTheSunAreNotAligned() {

        solarSystem.addPlanet(ferengi);
        solarSystem.addPlanet(betasoide);
        solarSystem.addPlanet(vulcano);

        assertFalse(solarSystem.arePlanetsAndSunAlignedAtDay(15));
        assertFalse(solarSystem.arePlanetsAndSunAlignedAtDay(430));
        assertFalse(solarSystem.arePlanetsAndSunAlignedAtDay(1560));
    }

    @Test
    public void perimeterOfPlanetsAtDay3is3211Km(){
        assertEquals(solarSystem.calculatePerimeterOfPlanetsAtDay(3),3211);
    }

    @Test
    public void perimeterOfPlanetsAtDay1500is5437Km(){
        assertEquals(solarSystem.calculatePerimeterOfPlanetsAtDay(1500),5437);
    }


}
