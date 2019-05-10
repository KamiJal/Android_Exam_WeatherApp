package com.kamijal.weatherapp.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kamijal.weatherapp.R;

public class ItemDailyForecastViewHolder extends RecyclerView.ViewHolder {

    private final TextView dayName;
    private final TextView highestTemperature;
    private final TextView lowestTemperature;

    private final ImageView icon;

    public ItemDailyForecastViewHolder(@NonNull View itemView) {
        super(itemView);

        this.dayName = itemView.findViewById(R.id.item_daily_day_name);
        this.highestTemperature = itemView.findViewById(R.id.item_daily_highest_temperature);
        this.lowestTemperature = itemView.findViewById(R.id.item_daily_lowest_temperature);
        this.icon = itemView.findViewById(R.id.item_daily_weather_icon);
    }

    public void setDayName(String dayName) {
        this.dayName.setText(dayName);
    }

    public void setHighestTemperature(String highestTemperature) {
        this.highestTemperature.setText(highestTemperature);
    }

    public void setLowestTemperature(String lowestTemperature) {
        this.lowestTemperature.setText(lowestTemperature);
    }

    public void setIcon(int iconId) {
        this.icon.setImageResource(iconId);
    }


}
