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
    }

    @Test
    public void ferengiAndBetasoideAndVulcanoAndTheSunAreAligned() {
        assertTrue(solarSystem.arePlanetsAndSunAlignedAtDay(90));
        assertTrue(solarSystem.arePlanetsAndSunAlignedAtDay(450));
        assertTrue(solarSystem.arePlanetsAndSunAlignedAtDay(1170));
    }

    @Test
    public void ferengiAndBetasoideAndVulcanoAndTheSunAreNotAligned() {

        assertFalse(solarSystem.arePlanetsAndSunAlignedAtDay(15));
        assertFalse(solarSystem.arePlanetsAndSunAlignedAtDay(430));
        assertFalse(solarSystem.arePlanetsAndSunAlignedAtDay(1560));
    }

    @Test
    public void perimeterOfPlanetsAtDay3is3211Km(){
        assertEquals(solarSystem.calculatePerimeterOfPlanetsAtDay(3),3210.498913262907);
    }

    @Test
    public void perimeterOfPlanetsAtDay1500is5437Km(){
        assertEquals(solarSystem.calculatePerimeterOfPlanetsAtDay(1500),5437.03915854251);
    }

    @Test
    public void theSunIsOutsideThePerimeterOfPlanetsByDay3(){
        assertFalse(solarSystem.isSunInsidePerimeterOfPlanetsAtDay(3));
    }

    @Test
    public void theSunIsInsideThePerimeterOfPlanetsByDay259(){
        assertTrue(solarSystem.isSunInsidePerimeterOfPlanetsAtDay(259));
    }

    @Test
    public void planetsAreNotAlignedWithoutTheSunAtDay259(){
        assertFalse(solarSystem.arePlanetsWithoutSunAlignedAtDay(259));
    }

    @Test
    public void planetsAreAlignedWithoutTheSunAtDay493(){
        assertTrue(solarSystem.arePlanetsWithoutSunAlignedAtDay(493));
    }

}
