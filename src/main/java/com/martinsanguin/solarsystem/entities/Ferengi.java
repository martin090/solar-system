package com.martinsanguin.solarsystem.entities;

public class Ferengi extends Planet {

    @Override
    public int calculateGradesByDay(int day) {
        return day * 1;
    }

}
