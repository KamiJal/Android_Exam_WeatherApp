package com.kamijal.weatherapp.WeatherApi.Models.Forecast.Infos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SystemInfo {
    @SerializedName("pod")
    @Expose
    private String pod;
}
