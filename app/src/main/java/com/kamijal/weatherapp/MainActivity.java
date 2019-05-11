package com.kamijal.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kamijal.weatherapp.WeatherApi.Models.WeatherApiResponse;
import com.kamijal.weatherapp.WeatherApi.WeatherApiService;
import com.kamijal.weatherapp.adapters.ItemDailyForecastAdapter;
import com.kamijal.weatherapp.adapters.ItemHourlyForecastAdapter;
import com.kamijal.weatherapp.base.Observer;

import java.util.TimeZone;

public class MainActivity extends AppCompatActivity implements Observer {

    private final WeatherApiService service = new WeatherApiService();

    private ImageView background;

    //header
    private TextView cityName;
    private TextView weatherDescription;
    private TextView mainTemperature;
    private TextView dayName;

    //hourly forecast
    private RecyclerView hourlyForecast;

    //scroller daily forecast
    private RecyclerView dailyForecast;

    //scroller lead info
    private TextView leadInfo;

    //scroller main info
    private TextView humidity;
    private TextView cloudiness;
    private TextView windSpeed;
    private TextView atmosphericPressure;


    //util
    private LinearLayoutManager horizontalLayout;
    private LinearLayoutManager verticalLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponents();

        //дома не определяется правильная зона, поэтому выставил вручную
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+6"));

        try {
            service.subscribe(this);
            service.GetWeatherForecastByCityId("1526395", "metric");
        } catch (Exception ex) {
            Toast.makeText(this, "Internal error occurred. Please try later",
                    Toast.LENGTH_LONG).show();
        }
    }

    private void initializeComponents() {
        this.background = findViewById(R.id.background);

        //header
        this.cityName = findViewById(R.id.city_name);
        this.mainTemperature = findViewById(R.id.main_temperature);
        this.weatherDescription = findViewById(R.id.weather_description);
        this.dayName = findViewById(R.id.day_name);

        //hourly forecast
        this.hourlyForecast = findViewById(R.id.hourly_forecast_recycler_view);

        //scroller daily forecast
        this.dailyForecast = findViewById(R.id.daily_forecast_recycler_view);

        //scroller lead info
        this.leadInfo = findViewById(R.id.lead_info);

        //scroller main info
        this.humidity = findViewById(R.id.humidity_value);
        this.cloudiness = findViewById(R.id.cloudiness_value);
        this.windSpeed = findViewById(R.id.wind_speed_value);
        this.atmosphericPressure = findViewById(R.id.pressure_value);

        //utils
        this.verticalLayout = new LinearLayoutManager(this);
        this.horizontalLayout =
                new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
    }

    @Override
    public void update() {
        WeatherApiResponse response = service.getWeatherApiResponse();
        WeatherApiResponse.trim(response);

        this.background.setImageResource(R.drawable.sunnyday_1920);

        //header
        this.cityName.setText(response.getCurrentCityName());
        this.mainTemperature.setText(response.getCurrentTemperature());
        this.weatherDescription.setText(response.getWeatherDescription());
        this.dayName.setText(response.getCurrentDayName());

        //hourly forecast
        this.hourlyForecast.setLayoutManager(horizontalLayout);
        hourlyForecast.setAdapter(new ItemHourlyForecastAdapter(response.getHourlyForecastList()));

        //scroller daily forecast
        this.dailyForecast.setLayoutManager(verticalLayout);
        this.dailyForecast.setAdapter(new ItemDailyForecastAdapter(response.getDailyForecastList()));

        //scroller lead info
        this.leadInfo.setText(String.format("Today: %s. Currently it's %s°.",
                response.getWeatherDescription(), response.getCurrentTemperature()));

        //scroller main info
        this.humidity.setText(response.getCurrentHumidity());
        this.cloudiness.setText(response.getCurrentCloudiness());
        this.windSpeed.setText(response.getCurrentWindSpeed());
        this.atmosphericPressure.setText(response.getCurrentPressure());

    }
}
