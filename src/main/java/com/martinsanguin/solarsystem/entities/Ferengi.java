package com.martinsanguin.solarsystem.entities;

public class Ferengi extends Planet {

    @Override
    public int calculateDegreesTraveledByDay(int day) {
        return day * 1;
    }

    @Override
    protected int distanceFromSun() {
        return 500;
    }

}
