package com.kamijal.weatherapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kamijal.weatherapp.R;
import com.kamijal.weatherapp.models.DailyForecastDto;
import com.kamijal.weatherapp.viewHolders.ItemDailyForecastViewHolder;

import java.util.List;

public class ItemDailyForecastAdapter extends RecyclerView.Adapter<ItemDailyForecastViewHolder> {
    private final List<DailyForecastDto> data;

    public ItemDailyForecastAdapter(List<DailyForecastDto> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ItemDailyForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_daily_forecast, parent, false);
        return new ItemDailyForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemDailyForecastViewHolder holder, int position) {
        DailyForecastDto current = data.get(position);

        holder.setDayName(current.getDayName());
        holder.setHighestTemperature(current.getHighestTemperature());
        holder.setLowestTemperature(current.getLowestTemperature());
        holder.setIcon(current.getIconId());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
