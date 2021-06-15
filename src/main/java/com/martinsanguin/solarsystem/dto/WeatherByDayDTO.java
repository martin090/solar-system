package com.martinsanguin.solarsystem.dto;

public class WeatherByDayDTO {
    private int day;
    private String weather;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}
