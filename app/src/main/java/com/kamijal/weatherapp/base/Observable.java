package com.kamijal.weatherapp.base;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable<T> {
    private static String TAG;

    protected Observable() {
        TAG = getClass().getSimpleName();
    }

    protected final List<T> observers = new ArrayList<>();

    public void subscribe(T observer){
        observers.add(observer);

        Log.i(TAG, "Subscribed: " + observer.getClass().getSimpleName());
    }

    public void unsubscribe(T observer){
        observers.remove(observer);
    }

    public abstract void notifyDataChanged();
}
