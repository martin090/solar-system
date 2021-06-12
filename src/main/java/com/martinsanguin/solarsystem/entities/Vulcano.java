package com.martinsanguin.solarsystem.entities;

public class Vulcano extends Planet {
    @Override
    public int calculateGradesTraveledByDay(int day) {
        return day * -5;
    }
}
