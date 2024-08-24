package com.weathergif.weathergif.service;

import com.weathergif.weathergif.client.GifClient;
import com.weathergif.weathergif.client.WeatherClient;
import com.weathergif.weathergif.query.GiphyResponse;
import com.weathergif.weathergif.query.OpenWeatherResponse;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherClient weatherClient;
    private final GifClient gifClient;
    @Value("${weather.key}")
    private String appId;
    @Value("${gif.app.id}")
    private String api_key;

    public OpenWeatherResponse getWeather(String city) {
        double lat = 55;
        double lon = 37;
        String coordinatesEntity = weatherClient.getCoordinates(city, appId);
        JSONArray jsonArray = new JSONArray(coordinatesEntity);
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        lat = jsonObject.getDouble("lat");
        lon = jsonObject.getDouble("lon");
        return weatherClient.getWeather(lat, lon, appId);
    }
    public String getWeatherGif(String city) {
        double lat = 55;
        double lon = 37;
        String coordinatesEntity = weatherClient.getCoordinates(city, appId);
        JSONArray jsonArray = new JSONArray(coordinatesEntity);
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        lat = jsonObject.getDouble("lat");
        lon = jsonObject.getDouble("lon");
        OpenWeatherResponse weatherEntity = weatherClient.getWeather(lat, lon, appId);
        GiphyResponse giphyResponse = gifClient.getRandomGif(api_key, weatherEntity.weather.get(0).description, "r");
        return giphyResponse.getData().getImages().get("original").get("url");
    }
}
