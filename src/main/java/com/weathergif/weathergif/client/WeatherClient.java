package com.weathergif.weathergif.client;

import com.weathergif.weathergif.query.OpenWeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weatherClient", url = "http://api.openweathermap.org")
public interface WeatherClient {
    @GetMapping("/geo/1.0/direct")
    String getCoordinates(
            @RequestParam String q,
            @RequestParam String appid
    );

    @GetMapping("/data/2.5/weather")
    OpenWeatherResponse getWeather(
            @RequestParam double lat,
            @RequestParam double lon,
            @RequestParam String appid
    );
}
