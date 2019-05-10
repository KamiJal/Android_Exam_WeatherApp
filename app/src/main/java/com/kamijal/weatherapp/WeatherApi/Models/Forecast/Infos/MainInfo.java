package com.kamijal.weatherapp.WeatherApi.Models.Forecast.Infos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainInfo {
    @SerializedName("temp")
    @Expose
    private Double temp;

    @SerializedName("temp_min")
    @Expose
    private Double tempMin;

    @SerializedName("temp_max")
    @Expose
    private Double tempMax;

    @SerializedName("pressure")
    @Expose
    private Double pressure;

    @SerializedName("sea_level")
    @Expose
    private Double seaLevel;

    @SerializedName("grnd_level")
    @Expose
    private Double grndLevel;

    @SerializedName("humidity")
    @Expose
    private Double humidity;

    @SerializedName("temp_kf")
    @Expose
    private Double tempKf;

    public Double getTemp() {
        return temp;
    }

    public Double getPressure() {
        return pressure;
    }

    public Double getHumidity() {
        return humidity;
    }
}
