package com.kamijal.weatherapp.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateFormatTemplates {
    public final static SimpleDateFormat hour = new SimpleDateFormat("HH", Locale.US);
    public final static SimpleDateFormat dayName = new SimpleDateFormat("EEEE", Locale.US);
}
