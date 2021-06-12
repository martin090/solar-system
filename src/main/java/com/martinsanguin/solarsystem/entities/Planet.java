package com.martinsanguin.solarsystem.entities;

public abstract class Planet {
    protected abstract int calculateGradesTraveledByDay(int day);

    public int calculatePositionInTheOrbitAtDay(int day){
        int gradesTraveled = this.calculateGradesTraveledByDay(day);
        return gradesTraveled % 360;
    }

    public int calculateAngleWithOtherPlanetByDay(int day, Planet otherPlanet){
        int myPositionInOrbit = this.calculatePositionInTheOrbitAtDay(day);
        int otherPlanetPositionInOrbit = otherPlanet.calculatePositionInTheOrbitAtDay(day);
        return Math.abs(myPositionInOrbit - otherPlanetPositionInOrbit);
    }
}
