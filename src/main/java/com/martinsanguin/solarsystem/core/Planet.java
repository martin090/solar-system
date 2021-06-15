package com.martinsanguin.solarsystem.core;

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

    public double calculateDistanceToPlanetAtDay(int day, Planet otherPlanet) {
        double angleToOtherPlanetInRadians = Math.toRadians(this.calculateAngleWithOtherPlanetByDay(day, otherPlanet));

        //Se utiliza el teorema del coseno
        double distanceBetweenPlanets = Math.sqrt(Math.pow(this.distanceFromSun(),2) + Math.pow(otherPlanet.distanceFromSun(),2)
                                                    - 2 * this.distanceFromSun() * otherPlanet.distanceFromSun() * Math.cos(angleToOtherPlanetInRadians));
        return distanceBetweenPlanets;
    }

    public double calculateAreaWithOtherPlanetAndSunAtDay(int day, Planet otherPlanet){
        double distanceBetweenTwoPlanets = this.calculateDistanceToPlanetAtDay(day, otherPlanet);
        double perimeterBetweenTwoPlanetsAndSun = this.distanceFromSun() + otherPlanet.distanceFromSun() + distanceBetweenTwoPlanets;
        double area = HeronFormula.calculateArea(perimeterBetweenTwoPlanetsAndSun,
                                                distanceBetweenTwoPlanets,
                                                this.distanceFromSun(),
                                                otherPlanet.distanceFromSun());
        return area;
    }

    private int getPositionInTheOrbit(int gradesTraveled){
        if(gradesTraveled >= 0)
            return gradesTraveled % 360;
        else
            return (gradesTraveled % 360) + 360;

    }
}
