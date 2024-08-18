package com.weathergif.weathergif.controller;

import com.weathergif.weathergif.entity.WeatherEntity;
import com.weathergif.weathergif.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;
    @GetMapping("/weather/gif")
    public WeatherEntity getWeather(@RequestParam String city) {
        System.out.println("jaba");
        return weatherService.getWeather(city);
    }
}
