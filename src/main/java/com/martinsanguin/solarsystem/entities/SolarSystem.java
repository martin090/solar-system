package com.martinsanguin.solarsystem.entities;

import java.util.ArrayList;
import java.util.List;

public class SolarSystem {

    private List<Planet> planets = new ArrayList<Planet>();

    public List<Planet> getPlanets() { return this.planets; }

    public Boolean arePlanetsAndSunAligned(Integer day) {
        Integer[] planetsPosition = this.getPlanetPositions(day);
        Boolean aligned = this.arePlanetPositionsAlignedWithSun(planetsPosition);
        return aligned;
    }

    private Integer[] getPlanetPositions(Integer day){
        return this.planets.stream()
                .map(p -> p.calculatePositionInTheOrbitAtDay(day))
                .toArray(Integer[]::new);
    }

    private Boolean arePlanetPositionsAlignedWithSun(Integer[] planetsPosition){
        boolean aligned = true;
        int planetPosition = planetsPosition[0];
        for (int i = 1; i < planetsPosition.length; i++){
            aligned = aligned && this.arePositionsAligned(planetPosition,planetsPosition[i]);
            planetPosition = planetsPosition[i];
        }
        return aligned;
    }

    private Boolean arePositionsAligned(Integer planetPosition1, Integer planetPosition2){
        return (Math.abs(planetPosition1 - planetPosition2) == 180) || (Math.abs(planetPosition1 - planetPosition2) == 360);
    }
}
