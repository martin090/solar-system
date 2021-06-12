package com.martinsanguin.solarsystem.entities;

public abstract class Planet {
    protected abstract int calculateGradesTraveledByDay(int day);
    protected abstract int distanceFromSun();

    public int calculatePositionInTheOrbitAtDay(int day){
        int gradesTraveled = this.calculateGradesTraveledByDay(day);
        return gradesTraveled % 360;
    }

    public int calculateAngleWithOtherPlanetByDay(int day, Planet otherPlanet){
        int myPositionInOrbit = this.calculatePositionInTheOrbitAtDay(day);
        int otherPlanetPositionInOrbit = otherPlanet.calculatePositionInTheOrbitAtDay(day);
        return Math.abs(myPositionInOrbit - otherPlanetPositionInOrbit) % 360;
    }

    public long calculateDistanceToPlanetAtDay(int day, Planet otherPlanet) {
        double angleToOtherPlanetInRadians = Math.toRadians(this.calculateAngleWithOtherPlanetByDay(day, otherPlanet));
        double distanceBetweenPlanets = Math.sqrt(Math.pow(this.distanceFromSun(),2) + Math.pow(otherPlanet.distanceFromSun(),2) - 2 * this.distanceFromSun() * otherPlanet.distanceFromSun() * Math.cos(angleToOtherPlanetInRadians));
        return Math.round(distanceBetweenPlanets);
    }
}
