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
        assertEquals(ferengi.calculatePositionInTheOrbitAtDay(3),3);
        assertEquals(ferengi.calculatePositionInTheOrbitAtDay(1500),60);
    }

    @Test
    public void betasoidePositionInOrbitTest(){
        assertEquals(betasoide.calculatePositionInTheOrbitAtDay(1),3);
        assertEquals(betasoide.calculatePositionInTheOrbitAtDay(3),9);
        assertEquals(betasoide.calculatePositionInTheOrbitAtDay(1500),180);
    }

    @Test
    public void vulcanoPositionInOrbitTest(){
        assertEquals(vulcano.calculatePositionInTheOrbitAtDay(1),355);
        assertEquals(vulcano.calculatePositionInTheOrbitAtDay(3),345);
        assertEquals(vulcano.calculatePositionInTheOrbitAtDay(1500),60);
    }

    @Test
    public void angleFromSunBetweenFerengiAndVulcanoIs342ByDay3(){
        assertEquals(ferengi.calculateAngleWithOtherPlanetByDay(3,vulcano),342);
    }

    @Test
    public void angleFromSunBetweenVulcanoAndBetasoideIs336ByDay3(){
        assertEquals(vulcano.calculateAngleWithOtherPlanetByDay(3,betasoide),336);
    }

    @Test
    public void angleFromSunBetweenFerengiAndBetasoideIs6ByDay3(){
        assertEquals(ferengi.calculateAngleWithOtherPlanetByDay(3,betasoide),6);
    }

    @Test
    public void angleFromSunBetweenVulcanoAndBetasoideIs120ByDay1500(){
        assertEquals(vulcano.calculateAngleWithOtherPlanetByDay(1500,betasoide),120);
    }

    @Test
    public void angleFromSunBetweenVulcanoAndFerengiIs0ByDay1500(){
        assertEquals(vulcano.calculateAngleWithOtherPlanetByDay(1500,ferengi),0);
    }

    @Test
    public void distanceBetweenFeregniAndVulcanoIs547AtDay3(){
        assertEquals(ferengi.calculateDistanceToPlanetAtDay(3, vulcano), 546.757243852193);
    }

    @Test
    public void distanceBetweenVulcanoAndBetasoideIs1160AtDay3(){
        assertEquals(vulcano.calculateDistanceToPlanetAtDay(3, betasoide), 1160.0940347358037);
    }

    @Test
    public void distanceBetweenFeregniAndBetasoideIs1504AtDay3(){
        assertEquals(ferengi.calculateDistanceToPlanetAtDay(3, betasoide), 1503.6476346749105);
    }

    @Test
    public void distanceBetweenVulcanoAndBetasoideIs2646AtDay1500(){
        assertEquals(vulcano.calculateDistanceToPlanetAtDay(1500, betasoide), 2645.7513110645905);
    }

    @Test
    public void distanceBetweenVulcanoAndFerengiIs500AtDay1500(){
        assertEquals(vulcano.calculateDistanceToPlanetAtDay(1500, ferengi), 500);
    }

    @Test
    public void distanceBetweenFerengiAndBetasoideIs2291AtDay1500() {
        assertEquals(ferengi.calculateDistanceToPlanetAtDay(1500, betasoide), 2291.28784747792);
    }

    @Test
    public void calculateAreaBetweenFerenginBetasoideAndSunIs54726AtDay3(){
        assertEquals(ferengi.calculateAreaWithOtherPlanetAndSunAtDay(3, betasoide),52264.231633826064);
    }

}
