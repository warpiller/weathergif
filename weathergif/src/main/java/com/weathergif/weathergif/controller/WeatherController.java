package com.weathergif.weathergif.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    @GetMapping("/weather/gif")
    public String getWeather() {
        System.out.println("jaba");
        return "jaba";
    }
}
