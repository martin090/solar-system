package com.martinsanguin.solarsystem.entities;

public class Betasoide extends Planet {
    @Override
    public int calculateGradesByDay(int day) {
        return day * 3;
    }
}
