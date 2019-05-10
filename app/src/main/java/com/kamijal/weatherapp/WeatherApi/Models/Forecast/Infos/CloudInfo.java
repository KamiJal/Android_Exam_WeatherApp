package com.kamijal.weatherapp.WeatherApi.Models.Forecast.Infos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CloudInfo {
    @SerializedName("all")
    @Expose
    private Double all;

    public Double getCloudiness() {
        return all;
    }
}
