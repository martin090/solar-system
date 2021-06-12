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
    public void ferengiMovesOneGradePerDay(){
        assertEquals(ferengi.calculateGradesByDay(1),1);
        assertEquals(ferengi.calculateGradesByDay(10),10);
        assertEquals(ferengi.calculateGradesByDay(512),512);
    }

    @Test
    public void betasoideMovesThreeGradesPerDay(){
        assertEquals(betasoide.calculateGradesByDay(1),3);
        assertEquals(betasoide.calculateGradesByDay(3),9);
        assertEquals(betasoide.calculateGradesByDay(510),1530);
    }

    @Test
    public void vulcanoMovesMinusFiveGradesPerDay(){
        assertEquals(vulcano.calculateGradesByDay(1),-5);
        assertEquals(vulcano.calculateGradesByDay(10),-50);
        assertEquals(vulcano.calculateGradesByDay(310),-1550);
    }

}
