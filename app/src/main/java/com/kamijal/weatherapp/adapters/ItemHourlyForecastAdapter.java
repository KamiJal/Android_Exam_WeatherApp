package com.kamijal.weatherapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kamijal.weatherapp.R;
import com.kamijal.weatherapp.models.HourlyForecastDto;
import com.kamijal.weatherapp.viewHolders.ItemHourlyForecastViewHolder;

import java.util.List;

public class ItemHourlyForecastAdapter extends RecyclerView.Adapter<ItemHourlyForecastViewHolder> {

    private final List<HourlyForecastDto> data;

    public ItemHourlyForecastAdapter(List<HourlyForecastDto> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ItemHourlyForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_hourly_forecast, parent, false);
        return new ItemHourlyForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHourlyForecastViewHolder holder, int position) {
        HourlyForecastDto current = data.get(position);

        holder.setTime(position == 0 ? "Now" : current.getTime());
        holder.setTemperature(current.getTemperature());
        holder.setIcon(current.getIconId());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
