package com.weathergif.weathergif.service;

import com.weathergif.weathergif.client.WeatherClient;
import com.weathergif.weathergif.entity.WeatherEntity;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherClient weatherClient;
    @Value("${weather.key}")
    private String appId;
    public WeatherEntity getWeather(String city) {
        double lat = 55;
        double lon = 37;
        String coordinatesEntity = weatherClient.getCoordinates(city, appId);
        JSONArray jsonArray = new JSONArray(coordinatesEntity);
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        lat = jsonObject.getDouble("lat");
        lon = jsonObject.getDouble("lon");
        WeatherEntity weatherEntity = weatherClient.getWeather(lat, lon, appId);
        return weatherEntity;
    }
}
