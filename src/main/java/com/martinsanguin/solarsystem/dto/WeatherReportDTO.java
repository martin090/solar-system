package com.martinsanguin.solarsystem.dto;

public class WeatherReportDTO {
    private int year;
    private String reportDescription;
    private int droughtPeriods;
    private int rainPeriods;
    private int optimalPressureAndTemperaturePeriods;
    private Integer[] topRainyDays;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getReportDescription() {
        return reportDescription;
    }

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }

    public int getDroughtPeriods() {
        return droughtPeriods;
    }

    public void setDroughtPeriods(int droughtPeriods) {
        this.droughtPeriods = droughtPeriods;
    }

    public int getRainPeriods() {
        return rainPeriods;
    }

    public void setRainPeriods(int rainPeriods) {
        this.rainPeriods = rainPeriods;
    }

    public int getOptimalPressureAndTemperaturePeriods() {
        return optimalPressureAndTemperaturePeriods;
    }

    public void setOptimalPressureAndTemperaturePeriods(int optimalPressureAndTemperaturePeriods) {
        this.optimalPressureAndTemperaturePeriods = optimalPressureAndTemperaturePeriods;
    }

    public Integer[] getTopRainyDays() {
        return topRainyDays;
    }

    public void setTopRainyDays(Integer[] topRainyDays) {
        this.topRainyDays = topRainyDays;
    }
}
