package com.martinsanguin.solarsystem.bootstrap;

import com.martinsanguin.solarsystem.entities.Weather;
import com.martinsanguin.solarsystem.services.WeatherService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class WeatherConditionsLoader implements CommandLineRunner {

    private WeatherService weatherService;

    public WeatherConditionsLoader(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Override
    public void run(String... args) throws Exception {
        int days = 365 * 10;
        for (int day = 1; day <= days; day++){
            Weather weather = new Weather();
            weather.setDay(day);
            weather.setWeather(this.weatherService.computeWeatherForDay(day).toString());
            weather.setPerimeter(this.weatherService.computePerimeterForDay(day));
            this.weatherService.saveWeatherCondition(weather);
        }
    }
}
