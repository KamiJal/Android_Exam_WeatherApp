package com.kamijal.weatherapp.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kamijal.weatherapp.R;

public class ItemHourlyForecastViewHolder extends RecyclerView.ViewHolder {

    private final TextView time;
    private final TextView temperature;
    private final ImageView icon;

    public ItemHourlyForecastViewHolder(@NonNull View itemView) {
        super(itemView);
        time = itemView.findViewById(R.id.item_hourly_time);
        temperature = itemView.findViewById(R.id.item_hourly_temperature);
        icon = itemView.findViewById(R.id.item_hourly_weather_icon);
    }

    public void setTime(String time) {
        this.time.setText(time);
    }

    public void setTemperature(String temperature) {
        this.temperature.setText(temperature);
    }

    public void setIcon(int iconId) {
        this.icon.setImageResource(iconId);
    }
}
