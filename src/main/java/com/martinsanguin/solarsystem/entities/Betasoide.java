package com.martinsanguin.solarsystem.entities;

public class Betasoide extends Planet {
    @Override
    public int calculateGradesTraveledByDay(int day) {
        return day * 3;
    }
}
