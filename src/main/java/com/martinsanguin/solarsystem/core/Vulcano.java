package com.martinsanguin.solarsystem.core;

public class Vulcano extends Planet {
    @Override
    public int calculateDegreesTraveledByDay(int day) {
        return day * -5;
    }

    @Override
    public int distanceFromSun() {
        return 1000;
    }
}
