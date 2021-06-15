package com.martinsanguin.solarsystem.core;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SolarSystem {

    private LinkedList<Planet> planets;

    public SolarSystem(){
        planets = new LinkedList<Planet>();
        planets.add(new Ferengi());
        planets.add(new Vulcano());
        planets.add(new Betasoide());
    }

    public Boolean arePlanetsAndSunAlignedAtDay(Integer day) {
        Integer[] planetsPosition = this.getPlanetPositions(day);
        Boolean aligned = this.arePlanetPositionsAlignedWithSun(planetsPosition);
        return aligned;
    }

    public Boolean isSunInsidePerimeterOfPlanetsAtDay(int day) {
        Double areaBetweenPlanets = this.calculateAreaOfPlanetsAtday(day);
        Double areaBetweenFeregniVulcanoSun = this.getFeregni().calculateAreaWithOtherPlanetAndSunAtDay(day,this.getVulcano());
        Double areaBetweenVulcanoBetasoideSun = this.getVulcano().calculateAreaWithOtherPlanetAndSunAtDay(day,this.getBetasoide());
        Double areaBetweenFeregniBetasoideSun = this.getBetasoide().calculateAreaWithOtherPlanetAndSunAtDay(day,this.getFeregni());
        Double areaOfPlanetsWithSun = areaBetweenFeregniVulcanoSun + areaBetweenVulcanoBetasoideSun + areaBetweenFeregniBetasoideSun;

        if(areaBetweenPlanets != 0)
            return areaBetweenPlanets.intValue() == areaOfPlanetsWithSun.intValue();
        else
            return false;
    }

    public double calculatePerimeterOfPlanetsAtDay(Integer day) {
        List<Double> distancesBetweenPlanets = this.getDistancesBetweenPlanetsAtDay(day);
        Double perimeter = distancesBetweenPlanets.stream().reduce(0D, (subtotal,distance) -> subtotal + distance);
        return perimeter;
    }

    public Boolean arePlanetsWithoutSunAlignedAtDay(int day) {
        if(!this.arePlanetsAndSunAlignedAtDay(day)){
            return this.areOnlyThePlanetsAlignedAtDay(day);
        }
        return false;
    }

    private Boolean areOnlyThePlanetsAlignedAtDay(int day) {
        List<Double> distancesBetweenConsecutivesPlanets = this.getDistancesBetweenConsecutivePlanetsAtDay(day);
        Double distanceBetweenFirstAndLastPlanet = this.planets.getFirst().calculateDistanceToPlanetAtDay(day,this.planets.getLast());

        Double totalDistanceBetweenConsecutivesPlanets = distancesBetweenConsecutivesPlanets
                                                                        .stream()
                                                                        .reduce(0D, (subtotal,distance) -> subtotal + distance);

        return totalDistanceBetweenConsecutivesPlanets.intValue() == distanceBetweenFirstAndLastPlanet.intValue();
    }

    private Integer[] getPlanetPositions(Integer day){
        return this.planets.stream()
                .map(p -> p.calculatePositionInTheOrbitAtDay(day))
                .toArray(Integer[]::new);
    }

    private Boolean arePlanetPositionsAlignedWithSun(Integer[] planetsPosition){
        boolean aligned = true;
        double planetPosition = planetsPosition[0];
        for (int i = 1; i < planetsPosition.length; i++){
            aligned = aligned && this.arePositionsAligned(planetPosition,planetsPosition[i]);
            planetPosition = planetsPosition[i];
        }
        return aligned;
    }

    private Boolean arePositionsAligned(double planetPosition1, double planetPosition2){
        return (Math.abs(planetPosition1 - planetPosition2) == 0) || (Math.abs(planetPosition1 - planetPosition2) == 180) || (Math.abs(planetPosition1 - planetPosition2) == 360);
    }

    private List<Double> getDistancesBetweenPlanetsAtDay(int day) {
        List<Double> distancesBetweenPlanets = new ArrayList<>();
        distancesBetweenPlanets.addAll(this.getDistancesBetweenConsecutivePlanetsAtDay(day));
        distancesBetweenPlanets.add(this.planets.getFirst().calculateDistanceToPlanetAtDay(day,this.planets.getLast()));
        return distancesBetweenPlanets;
    }

    private List<Double> getDistancesBetweenConsecutivePlanetsAtDay(int day){
        List<Double> distancesBetweenConsecutivePlanets = new ArrayList<>();

        for (int i = 0; i < this.planets.size(); i++){
            Planet planet1 = this.planets.get(i);
            Optional<Planet> planet2 = getConsecutivePlanet(i);

            if(planet2.isPresent()){
                distancesBetweenConsecutivePlanets.add(planet1.calculateDistanceToPlanetAtDay(day,planet2.get()));
            }
        }

        return distancesBetweenConsecutivePlanets;
    }

    private Optional<Planet> getConsecutivePlanet(int currentPosition) {
        if (currentPosition < this.planets.size() - 1) {
            Planet consecutivePlanet;
            consecutivePlanet = this.planets.get(currentPosition + 1);
            return Optional.of(consecutivePlanet);
        } else {
            return Optional.empty();
        }
    }

    private double calculateAreaOfPlanetsAtday(int day){
        double planetsPerimeter = this.calculatePerimeterOfPlanetsAtDay(day);

        double area = HeronFormula.calculateArea(planetsPerimeter,
                                                getFeregni().calculateDistanceToPlanetAtDay(day,getVulcano()),
                                                getVulcano().calculateDistanceToPlanetAtDay(day,getBetasoide()),
                                                getBetasoide().calculateDistanceToPlanetAtDay(day,getFeregni()));

        return area;
    }

    private Planet getFeregni(){
        return this.planets.get(0);
    }

    private Planet getVulcano(){
        return this.planets.get(1);
    }

    private Planet getBetasoide(){
        return this.planets.get(2);
    }

}
