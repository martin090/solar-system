package com.martinsanguin.solarsystem.bootstrap;

import com.martinsanguin.solarsystem.entities.Weather;
import com.martinsanguin.solarsystem.services.WeatherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class WeatherConditionsLoader implements CommandLineRunner {

    private boolean dataInitialization;
    private int years;
    private WeatherService weatherService;

    public WeatherConditionsLoader(@Value("${weather.data.init}") String dataInitialization,
                                   @Value("${weather.data.years}") int years,
                                   WeatherService weatherService) {
        this.dataInitialization = Boolean.valueOf(dataInitialization);
        this.years = years;
        this.weatherService = weatherService;
    }

    @Override
    public void run(String... args) throws Exception {
        if(this.dataInitialization){
            int days = 365 * this.years;
            for (int day = 1; day <= days; day++){
                Weather weather = new Weather();
                weather.setDay(day);
                weather.setWeather(this.weatherService.computeWeatherForDay(day).toString());
                weather.setPerimeter(this.weatherService.computePerimeterForDay(day));
                this.weatherService.saveWeatherCondition(weather);
            }
        }
    }
}
