package com.martinsanguin.solarsystem.entities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class SolarSystem {

    private LinkedList<Planet> planets = new LinkedList<Planet>();

    public void addPlanet(Planet planet){
        this.planets.add(planet);
    }

    public Boolean arePlanetsAndSunAlignedAtDay(Integer day) {
        Integer[] planetsPosition = this.getPlanetPositions(day);
        Boolean aligned = this.arePlanetPositionsAlignedWithSun(planetsPosition);
        return aligned;
    }

    public Long calculatePerimeterOfPlanetsAtDay(Integer day) {
        List<Long> distancesBetweenPlanets = this.getDistancesBetweenPlanetsAtDay(day);
        return distancesBetweenPlanets.stream().reduce(0L, (subtotal,distance) -> subtotal + distance);
    }

    private Integer[] getPlanetPositions(Integer day){
        return this.planets.stream()
                .map(p -> p.calculatePositionInTheOrbitAtDay(day))
                .toArray(Integer[]::new);
    }

    private Boolean arePlanetPositionsAlignedWithSun(Integer[] planetsPosition){
        //TODO: Should I use directly the LinkedList?
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

    private List<Long> getDistancesBetweenPlanetsAtDay(int day) {
        List<Long> distancesBetweenPlanets = new ArrayList<>();

        distancesBetweenPlanets.addAll(this.getDistancesBetweenConsecutivePlanetsAtDay(day));
        distancesBetweenPlanets.add(this.planets.getFirst().calculateDistanceToPlanetAtDay(day,this.planets.getLast()));

        return distancesBetweenPlanets;
    }

    private List<Long> getDistancesBetweenConsecutivePlanetsAtDay(int day){
        List<Long> distancesBetweenConsecutivePlanets = new ArrayList<>();

        for (int i = 0; i < this.planets.size(); i++){
            Planet planet1 = this.planets.get(i);
            Optional<Planet> planet2 = getConsecutivePlanet(i);

            if(planet2.isPresent()){
                distancesBetweenConsecutivePlanets.add(planet1.calculateDistanceToPlanetAtDay(day,planet2.get()));
            }
        }

        return distancesBetweenConsecutivePlanets;
    }

    private Optional<Planet> getConsecutivePlanet(int index){
        Planet consecutivePlanet;
        if(index < this.planets.size() - 1){
            consecutivePlanet = this.planets.get(index+1);
            return Optional.of(consecutivePlanet);
        }else{
            return Optional.empty();
        }
    }
}
