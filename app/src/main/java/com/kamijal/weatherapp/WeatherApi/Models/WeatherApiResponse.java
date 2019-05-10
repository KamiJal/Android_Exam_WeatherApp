package com.kamijal.weatherapp.WeatherApi.Models;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kamijal.weatherapp.WeatherApi.Models.Forecast.Forecast;
import com.kamijal.weatherapp.WeatherApi.Models.Forecast.Infos.CityInfo;
import com.kamijal.weatherapp.models.DailyForecastDto;
import com.kamijal.weatherapp.models.HourlyForecastDto;
import com.kamijal.weatherapp.utils.DateFormatTemplates;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class WeatherApiResponse {
    @SerializedName("cod")
    @Expose
    private String cod;

    @SerializedName("message")
    @Expose
    private Double message;

    @SerializedName("cnt")
    @Expose
    private Integer cnt;

    @SerializedName("list")
    @Expose
    private List<Forecast> list = null;

    @SerializedName("city")
    @Expose
    private CityInfo city;


    //бесплатный сервис обновляется каждые три часа,
    //поэтому избавляемся от ошибочного времени
    public static void trim(@NonNull WeatherApiResponse response) {
        Date currentDate = GregorianCalendar.getInstance(TimeZone.getDefault()).getTime();

        for (int i = 0; i < response.list.size() - 1; i++) {
            Date nextForecastDate = response.list.get(i + 1).getForecastDate();

            if (currentDate.compareTo(nextForecastDate) > 0)
                response.list.remove(response.list.get(i));
        }
    }


    public boolean isSuccessful() {
        return cod.equals("200");
    }


    public String getCurrentCityName() {
        return this.city.getName() == null ? "Not available" : this.city.getName();
    }


    public String getCurrentDayName(){
        return DateFormatTemplates.dayName.format(this.list.get(0).getForecastDate());
    }


    public String getCurrentHumidity(){
        return String.format(Locale.US, "%d %%", this.list.get(0).getHumidity());
    }

    public String getCurrentCloudiness(){
        return String.format(Locale.US, "%d %%", this.list.get(0).getCloudiness());
    }

    public String getCurrentWindSpeed(){
        return String.format(Locale.US,"%d km/h", this.list.get(0).getWindSpeed());
    }


    public String getCurrentPressure(){
        return String.format(Locale.US,"%d hPa", this.list.get(0).getPressure());
    }


    public String getCurrentTemperature() {
        return String.valueOf(this.list.get(0).getTemperature());
    }


    public List<HourlyForecastDto> getHourlyForecastList() {
        List<HourlyForecastDto> data = new ArrayList<>();

        for (Forecast forecast : this.list) {
            String hour = forecast.getForecastHour();
            int temperature = forecast.getTemperature();
            String iconId = forecast.getIconId();

            data.add(new HourlyForecastDto(hour, temperature, iconId));
        }

        return data;
    }


    public String getWeatherDescription() {
        return this.list.get(0).getWeatherDescription();
    }


    public List<DailyForecastDto> getDailyForecastList() {
        List<DailyForecastDto> dailyForecastList = new ArrayList<>();

        for (Forecast forecast : this.list) {
            String dayName = DateFormatTemplates.dayName.format(forecast.getForecastDate());

            if (!DailyForecastDto.containsDayName(dailyForecastList, dayName)) {
                dailyForecastList.add(new DailyForecastDto(dayName, forecast.getIconId()));
            }

            dailyForecastList.get(dailyForecastList.size() - 1)
                    .addTemperature(forecast.getTemperature());
        }

        DailyForecastDto.trim(dailyForecastList);
        return dailyForecastList;
    }
}
