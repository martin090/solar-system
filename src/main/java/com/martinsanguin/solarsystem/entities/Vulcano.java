package com.martinsanguin.solarsystem.entities;

public class Vulcano extends Planet {
    @Override
    public int calculateGradesByDay(int day) {
        return day * -5;
    }
}
