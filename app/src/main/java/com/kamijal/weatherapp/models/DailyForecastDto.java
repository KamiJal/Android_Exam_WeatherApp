package com.kamijal.weatherapp.models;

import com.kamijal.weatherapp.utils.IconResourceIdConverter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DailyForecastDto {
    private final String dayName;
    private final String iconId;
    private final List<Integer> temperatures;

    public DailyForecastDto(String dayName, String iconId) {
        this.dayName = dayName;
        this.iconId = iconId;
        this.temperatures = new ArrayList<>();
    }

    public static void trim(List<DailyForecastDto> dailyForecastList) {
        for (DailyForecastDto dto : dailyForecastList) {
            if (dto.temperatures.size() < 4)
                dailyForecastList.remove(dto);
        }
    }

    public void addTemperature(int temperature) {
        this.temperatures.add(temperature);
    }

    public static boolean containsDayName(List<DailyForecastDto> dailyForecastList, String target) {

        if (dailyForecastList.isEmpty())
            return false;

        for (DailyForecastDto dto : dailyForecastList) {
            if (dto.dayName.equals(target)) {
                return true;
            }
        }

        return false;
    }

    public String getDayName() {
        return dayName;
    }

    public String getHighestTemperature() {
        return String.valueOf(Collections.max(this.temperatures));
    }

    public String getLowestTemperature() {
        return String.valueOf(Collections.min(this.temperatures));
    }

    public int getIconId() {
        return IconResourceIdConverter.convert(iconId);
    }
}
