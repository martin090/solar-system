package com.martinsanguin.solarsystem.entities;

public class Vulcano extends Planet {
    @Override
    public int calculateDegreesTraveledByDay(int day) {
        return day * -5;
    }

    @Override
    protected int distanceFromSun() {
        return 1000;
    }
}
