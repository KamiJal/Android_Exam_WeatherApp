package com.kamijal.weatherapp.WeatherApi.Models.Forecast.Infos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RainInfo {
    @SerializedName("3h")
    @Expose
    private Double snowVolumeFor3Hours;
}
