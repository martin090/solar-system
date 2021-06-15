package com.martinsanguin.solarsystem.controllers;

import com.martinsanguin.solarsystem.dto.WeatherByDayDTO;
import com.martinsanguin.solarsystem.dto.WeatherReportDTO;
import com.martinsanguin.solarsystem.services.DayNotFoundFailure;
import com.martinsanguin.solarsystem.services.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/weather")
public class WeatherController {

    private WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping()
    public ResponseEntity<WeatherByDayDTO> getWeatherByDay(@RequestParam int day){
        try {
            return new ResponseEntity<>(this.weatherService.getWeatherByDay(day), HttpStatus.OK);
        }catch (DayNotFoundFailure ex){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }catch(Exception ex){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/report")
    public ResponseEntity<WeatherReportDTO> getWeatherReport(@RequestParam int years){
        return new ResponseEntity<>(this.weatherService.getWeatherReportForNextYears(years), HttpStatus.OK);
    }
}
