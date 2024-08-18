package com.weathergif.weathergif.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

class Clouds{
    public int all;
}

class Coord{
    public double lon;
    public double lat;
}

class Main{
    public double temp;
    public double feels_like;
    public double temp_min;
    public double temp_max;
    public int pressure;
    public int humidity;
    public int sea_level;
    public int grnd_level;
}

class Rain{
    @JsonProperty("1h")
    public double _1h;
}

public class WeatherEntity{
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

class Sys{
    public int type;
    public int id;
    public String country;
    public int sunrise;
    public int sunset;
}

class Weather{
    public int id;
    public String main;
    public String description;
    public String icon;
}

class Wind{
    public double speed;
    public int deg;
    public double gust;
}


