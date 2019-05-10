package com.kamijal.weatherapp.WeatherApi.Models.Forecast.Infos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityInfo {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("coord")
    @Expose
    private CoordinatesInfo coord;

    @SerializedName("country")
    @Expose
    private String country;

    public String getName() {
        return name;
    }
}
