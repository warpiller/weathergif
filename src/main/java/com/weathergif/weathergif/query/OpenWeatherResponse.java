package com.weathergif.weathergif.query;

import com.weathergif.weathergif.query.weather.Weather;
import com.weathergif.weathergif.query.weather.Wind;
import com.weathergif.weathergif.query.weather.*;

import java.util.ArrayList;

public class OpenWeatherResponse {
    public Coord coord;
    public ArrayList<Weather> weather;
    public String base;
    public Main main;
    public int visibility;
    public Wind wind;
    public Rain rain;
    public Clouds clouds;
    public int dt;
    public Sys sys;
    public int timezone;
    public int id;
    public String name;
    public int cod;
}

