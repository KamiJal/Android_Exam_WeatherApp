package com.kamijal.weatherapp.utils;

import com.kamijal.weatherapp.R;

public class IconResourceIdConverter {
    public static int convert(String iconId) {
        switch (iconId) {
            case "01d":
            case "01n":
                return R.drawable.ic_weather_clear_sky;
            case "02d":
            case "02n":
                return R.drawable.ic_weather_few_clouds;
            case "03d":
            case "04d":
            case "03n":
            case "04n":
                return R.drawable.ic_weather_scattered_clouds;
            case "09d":
            case "10d":
            case "11d":
            case "13d":
            case "50d":
            case "09n":
            case "10n":
            case "11n":
            case "13n":
            case "50n":
                return R.drawable.ic_weather_raining;
            default:
                return 0;
        }
    }
}
