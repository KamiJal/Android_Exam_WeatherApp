package com.kamijal.weatherapp.models;

import com.kamijal.weatherapp.R;
import com.kamijal.weatherapp.utils.IconResourceIdConverter;

public class HourlyForecastDto {
    private final String time;
    private final int temperature;
    private final String iconId;

    public HourlyForecastDto(String time, int temperature, String iconId) {
        this.time = time;
        this.temperature = temperature;
        this.iconId = iconId;
    }

    public String getTime() {
        return time;
    }

    public String getTemperature() {
        return String.valueOf(temperature);
    }

    public int getIconId() {
        return IconResourceIdConverter.convert(iconId);
    }
}
