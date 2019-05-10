package com.kamijal.weatherapp.WeatherApi;

import com.kamijal.weatherapp.WeatherApi.Models.WeatherApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiContract {
    @GET("forecast")
    Call<WeatherApiResponse> getWeatherForecastByCityId(@Query("id") String cityId,
                                                        @Query("units") String units,
                                                        @Query("APPID") String apiKey);

    @GET("forecast")
    Call<WeatherApiResponse> getWeatherForecastByCoordinates(@Query("lat") String latitude,
                                                             @Query("lon") String longitude,
                                                             @Query("units") String units,
                                                             @Query("APPID") String apiKey);
}
