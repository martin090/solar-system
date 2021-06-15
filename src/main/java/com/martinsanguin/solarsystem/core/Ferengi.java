package com.martinsanguin.solarsystem.core;

public class Ferengi extends Planet {
    @Override
    public int calculateDegreesTraveledByDay(int day) {
        return day * 1;
    }

    @Override
    public int distanceFromSun() {
        return 500;
    }

}
