package com.martinsanguin.solarsystem.services;

import com.martinsanguin.solarsystem.dto.WeatherByDayDTO;
import com.martinsanguin.solarsystem.dto.WeatherReportDTO;
import com.martinsanguin.solarsystem.entities.Weather;
import com.martinsanguin.solarsystem.core.SolarSystem;
import com.martinsanguin.solarsystem.core.WeatherConditionEnum;
import com.martinsanguin.solarsystem.repository.WeatherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeatherServiceImpl implements WeatherService {

    private SolarSystem solarSystem;
    private WeatherRepository weatherRepository;

    public WeatherServiceImpl(SolarSystem solarSystem, WeatherRepository weatherRepository) {
        this.solarSystem = solarSystem;
        this.weatherRepository = weatherRepository;
    }

    @Override
    public WeatherReportDTO getWeatherReportForNextYears(int year) {
        int droughtPeriods = 0;
        int rainPeriods = 0;
        int optimalPressureTemperaturePeriods = 0;
        int daysToReport = 365 * year;

        WeatherConditionEnum previousWeatherCondition = this.computeWeatherForDay(1);
        for (int day = 2; day <= daysToReport; day++){
            WeatherConditionEnum currentWeatherCondition = this.computeWeatherForDay(day);

            if(previousWeatherCondition.equals(currentWeatherCondition)){
                if(currentWeatherCondition.equals(WeatherConditionEnum.DROUGHT))
                    droughtPeriods++;
                if(currentWeatherCondition.equals(WeatherConditionEnum.RAINY))
                    rainPeriods++;
                if(currentWeatherCondition.equals(WeatherConditionEnum.OPTIMAL_PRESURE_AND_TEMPERATURE))
                    optimalPressureTemperaturePeriods++;
            }

            previousWeatherCondition = currentWeatherCondition;
        }

        WeatherReportDTO weatherReport = new WeatherReportDTO();
        weatherReport.setYear(year);
        weatherReport.setReportDescription("Weather's periods for next " + year + " years");
        weatherReport.setDroughtPeriods(droughtPeriods);
        weatherReport.setRainPeriods(rainPeriods);
        weatherReport.setOptimalPressureAndTemperaturePeriods(optimalPressureTemperaturePeriods);
        weatherReport.setTopRainyDays(this.getTopRainyDays());

        return weatherReport;
    }

    @Override
    public WeatherConditionEnum computeWeatherForDay(int day) {
        if(this.solarSystem.arePlanetsAndSunAlignedAtDay(day))
            return WeatherConditionEnum.DROUGHT;
        if(this.solarSystem.isSunInsidePerimeterOfPlanetsAtDay(day))
            return WeatherConditionEnum.RAINY;
        if(this.solarSystem.arePlanetsWithoutSunAlignedAtDay(day))
            return WeatherConditionEnum.OPTIMAL_PRESURE_AND_TEMPERATURE;
        else
            return WeatherConditionEnum.SUNNY;
    }

    @Override
    public double computePerimeterForDay(int day) {
        return this.solarSystem.calculatePerimeterOfPlanetsAtDay(day);
    }

    @Override
    public WeatherByDayDTO getWeatherByDay(int day) throws DayNotFoundFailure{
        Optional<Weather> weather = this.weatherRepository.findById(day);
        if(weather.isPresent()){
            WeatherByDayDTO weatherDto = new WeatherByDayDTO();
            weatherDto.setDay(day);
            weatherDto.setWeather(weather.get().getWeather());
            return weatherDto;
        }else{
            throw new DayNotFoundFailure("There is no weather defined for day " + day);
        }
    }

    @Override
    public Integer[] getTopRainyDays() {
        List<Integer> topRainyDays = this.weatherRepository.findDayWithMaxPerimeter();
        return topRainyDays.stream().toArray(Integer[]::new);
    }

    @Override
    public void saveWeatherCondition(Weather weather) {
        this.weatherRepository.save(weather);
    }

}
