package com.martinsanguin.solarsystem.entities;

import java.util.function.DoubleBinaryOperator;

public abstract class Planet {
    protected abstract int calculateDegreesTraveledByDay(int day);
    protected abstract int distanceFromSun();

    public int calculatePositionInTheOrbitAtDay(int day){
        int degreesTravelled = this.calculateDegreesTraveledByDay(day);
        return this.getPositionInTheOrbit(degreesTravelled);
    }

    public int calculateAngleWithOtherPlanetByDay(int day, Planet otherPlanet){
        int myPositionInOrbit = this.calculatePositionInTheOrbitAtDay(day);
        int otherPlanetPositionInOrbit = otherPlanet.calculatePositionInTheOrbitAtDay(day);
        return Math.abs(myPositionInOrbit - otherPlanetPositionInOrbit) % 360;
    }

    public Double calculateDistanceToPlanetAtDay(int day, Planet otherPlanet) {
        Double angleToOtherPlanetInRadians = Math.toRadians(this.calculateAngleWithOtherPlanetByDay(day, otherPlanet));
        Double distanceBetweenPlanets = Math.sqrt(Math.pow(this.distanceFromSun(),2) + Math.pow(otherPlanet.distanceFromSun(),2) - 2 * this.distanceFromSun() * otherPlanet.distanceFromSun() * Math.cos(angleToOtherPlanetInRadians));
        return distanceBetweenPlanets;
    }

    public Double calculateAreaWithOtherPlanetAndSunAtDay(int day, Planet otherPlanet){
        Double distanceBetweenTwoPlanets = this.calculateDistanceToPlanetAtDay(day, otherPlanet);
        Double perimeterBetweenTwoPlanetsAndSun = this.distanceFromSun() + otherPlanet.distanceFromSun() + distanceBetweenTwoPlanets;
        Double semiPerimeter = perimeterBetweenTwoPlanetsAndSun / 2;
        Double area = Math.sqrt(semiPerimeter
                * (semiPerimeter - distanceBetweenTwoPlanets)
                * (semiPerimeter - this.distanceFromSun())
                * (semiPerimeter - otherPlanet.distanceFromSun()));
        return area;
    }

    private int getPositionInTheOrbit(int gradesTraveled){
        if(gradesTraveled >= 0)
            return gradesTraveled % 360;
        else
            return (gradesTraveled % 360) + 360;

    }
}
