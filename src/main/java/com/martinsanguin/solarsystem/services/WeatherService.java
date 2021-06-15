package com.martinsanguin.solarsystem.services;

import com.martinsanguin.solarsystem.dto.WeatherByDayDTO;
import com.martinsanguin.solarsystem.dto.WeatherReportDTO;
import com.martinsanguin.solarsystem.entities.Weather;
import com.martinsanguin.solarsystem.core.WeatherConditionEnum;

public interface WeatherService {
    WeatherConditionEnum computeWeatherForDay(int day);
    double computePerimeterForDay(int day);

    WeatherReportDTO getWeatherReportForNextYears(int years);
    WeatherByDayDTO getWeatherByDay(int day) throws DayNotFoundFailure;
    Integer[] getTopRainyDays();

    void saveWeatherCondition(Weather weather);

}
