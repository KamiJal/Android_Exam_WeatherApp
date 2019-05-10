package com.kamijal.weatherapp.WeatherApi;

import android.util.Log;

import androidx.annotation.NonNull;

import com.kamijal.weatherapp.BuildConfig;
import com.kamijal.weatherapp.WeatherApi.Models.WeatherApiResponse;
import com.kamijal.weatherapp.base.Observable;
import com.kamijal.weatherapp.base.Observer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherApiService extends Observable<Observer> implements Callback<WeatherApiResponse> {

    private static final String TAG = "WeatherApiService";

    private final Retrofit mRetrofit;
    private final WeatherApiContract mProxy;

    private WeatherApiResponse mWeatherApiResponse = null;

    public WeatherApiService() {
        try {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.WeatherApiBaseAddress)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mProxy = mRetrofit.create(WeatherApiContract.class);

            Log.i(TAG, "WeatherApiService: created.");
        } catch (Exception ex) {
            Log.e(TAG, "WeatherApiService: " + ex.getMessage(), ex);
            throw ex;
        }
    }

    public WeatherApiResponse getWeatherApiResponse() {
        return mWeatherApiResponse;
    }

    public void GetWeatherForecastByCityId(String cityId, String units) {
        mProxy.getWeatherForecastByCityId(cityId, units, BuildConfig.WeatherAPIKey)
                .enqueue(this);
    }

    public void GetWeatherForecastByCoordinates(String latitude, String longtitude, String units) {
        mProxy.getWeatherForecastByCoordinates(latitude, longtitude, units, BuildConfig.WeatherAPIKey)
                .enqueue(this);
    }

    @Override
    public void notifyDataChanged() {
        try {
            for (Observer observer : this.observers) {
                observer.update();
            }

            Log.i(TAG, "notifyDataChanged: notified.");
        }
        catch (Exception ex){
            Log.e(TAG, "notifyDataChanged: " + ex.getMessage(), ex);
            throw ex;
        }
    }

    @Override
    public void onResponse(@NonNull Call<WeatherApiResponse> call,
                           @NonNull Response<WeatherApiResponse> response) {
        WeatherApiResponse body = response.body();

        if (body == null || !body.isSuccessful()) {
            throw new NullPointerException("Response body is null or request failed!");
        }

        this.mWeatherApiResponse = body;
        this.notifyDataChanged();
    }

    @Override
    public void onFailure(@NonNull Call<WeatherApiResponse> call, @NonNull Throwable t) {
        Log.e(TAG, "onFailure: " + t.getMessage(), t);
    }
}
