package com.kamijal.weatherapp.WeatherApi.Models.Forecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kamijal.weatherapp.WeatherApi.Models.Forecast.Infos.CloudInfo;
import com.kamijal.weatherapp.WeatherApi.Models.Forecast.Infos.MainInfo;
import com.kamijal.weatherapp.WeatherApi.Models.Forecast.Infos.RainInfo;
import com.kamijal.weatherapp.WeatherApi.Models.Forecast.Infos.SnowInfo;
import com.kamijal.weatherapp.WeatherApi.Models.Forecast.Infos.SystemInfo;
import com.kamijal.weatherapp.WeatherApi.Models.Forecast.Infos.WeatherInfo;
import com.kamijal.weatherapp.WeatherApi.Models.Forecast.Infos.WindInfo;
import com.kamijal.weatherapp.utils.DateFormatTemplates;

import java.util.Date;
import java.util.List;

public class Forecast {

    @SerializedName("dt")
    @Expose
    private Long dt;

    @SerializedName("main")
    @Expose
    private MainInfo main;

    @SerializedName("weather")
    @Expose
    private List<WeatherInfo> weather = null;

    @SerializedName("clouds")
    @Expose
    private CloudInfo clouds;

    @SerializedName("wind")
    @Expose
    private WindInfo wind;

    @SerializedName("rain")
    @Expose
    private RainInfo rain;

    @SerializedName("snow")
    @Expose
    private SnowInfo snow;

    @SerializedName("sys")
    @Expose
    private SystemInfo sys;

    @SerializedName("dt_txt")
    @Expose
    private String dtTxt;


    public Date getForecastDate() {
        return new Date(this.dt * 1000L);
    }


    public String getForecastHour() {
        return DateFormatTemplates.hour.format(this.getForecastDate());
    }


    public String getIconId() {
        return this.weather.get(0).getIcon();
    }


    public String getWeatherDescription() {
        return this.weather.get(0).getDescription();
    }


    public int getHumidity() {
        return roundDouble(this.main.getHumidity());
    }


    public int getTemperature() {
        return roundDouble(this.main.getTemp());
    }


    public int getPressure() {
        return roundDouble(this.main.getPressure());
    }

    public int getWindSpeed() {
        return roundDouble(this.wind.getSpeed());
    }

    public int getCloudiness() {
        return roundDouble(this.clouds.getCloudiness());
    }


    private int roundDouble(Double value) {
        return Math.toIntExact(Math.round(value));
    }
}
