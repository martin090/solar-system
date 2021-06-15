package com.martinsanguin.solarsystem.core;

public class Betasoide extends Planet {
    @Override
    public int calculateDegreesTraveledByDay(int day) {
        return day * 3;
    }

    @Override
    protected int distanceFromSun() {
        return 2000;
    }
}
