package com.kamijal.weatherapp.WeatherApi.Models.Forecast.Infos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherInfo {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("main")
    @Expose
    private String main;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("icon")
    @Expose
    private String icon;

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }
}
