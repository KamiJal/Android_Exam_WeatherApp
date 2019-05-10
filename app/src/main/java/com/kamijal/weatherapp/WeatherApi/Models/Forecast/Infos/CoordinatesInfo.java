package com.kamijal.weatherapp.WeatherApi.Models.Forecast.Infos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CoordinatesInfo {
    @SerializedName("lat")
    @Expose
    private Double lat;

    @SerializedName("lon")
    @Expose
    private Double lon;
}
