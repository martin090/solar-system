package com.martinsanguin.solarsystem;

import com.martinsanguin.solarsystem.entities.Betasoide;
import com.martinsanguin.solarsystem.entities.Ferengi;
import com.martinsanguin.solarsystem.entities.Planet;
import com.martinsanguin.solarsystem.entities.Vulcano;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlanetTests {

    private Planet ferengi;
    private Planet betasoide;
    private Planet vulcano;

    @BeforeEach
    public void setUp(){
        ferengi = new Ferengi();
        betasoide = new Betasoide();
        vulcano = new Vulcano();
    }

    @Test
    public void ferengiPositionInOrbitTest(){
        assertEquals(ferengi.calculatePositionInTheOrbitAtDay(1),1);
        assertEquals(ferengi.calculatePositionInTheOrbitAtDay(10),10);
        assertEquals(ferengi.calculatePositionInTheOrbitAtDay(512),152);
    }

    @Test
    public void betasoidePositionInOrbitTest(){
        assertEquals(betasoide.calculatePositionInTheOrbitAtDay(1),3);
        assertEquals(betasoide.calculatePositionInTheOrbitAtDay(3),9);
        assertEquals(betasoide.calculatePositionInTheOrbitAtDay(510),90);
    }

    @Test
    public void vulcanoPositionInOrbitTest(){
        assertEquals(vulcano.calculatePositionInTheOrbitAtDay(1),-5);
        assertEquals(vulcano.calculatePositionInTheOrbitAtDay(10),-50);
        assertEquals(vulcano.calculatePositionInTheOrbitAtDay(310),-110);
    }

    @Test
    public void angleBetweenFerengiAndBetasoideIsTwoByDayOne(){
        assertEquals(ferengi.calculateAngleWithOtherPlanetByDay(1,betasoide),2);
    }

    @Test
    public void angleBetweenFerengiAndVulcanoIsSixByDayOne(){
        assertEquals(ferengi.calculateAngleWithOtherPlanetByDay(1,vulcano),6);
    }

    @Test
    public void angleBetweenVulcanoAndBetasoideIs24ByDayThree(){
        assertEquals(vulcano.calculateAngleWithOtherPlanetByDay(3,betasoide),24);
    }

}
