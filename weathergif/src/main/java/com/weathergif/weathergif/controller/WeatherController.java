package com.weathergif.weathergif.controller;

import com.weathergif.weathergif.entity.WeatherEntity;
import com.weathergif.weathergif.service.WeatherService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.net.URLConnection;

@RestController
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;
    @GetMapping("/weather/data")
    public WeatherEntity getWeather(@RequestParam String city) {
        return weatherService.getWeather(city);
    }

    @SneakyThrows
    @GetMapping("/weather/gif")
    public void getWeatherGif(@RequestParam String city, HttpServletResponse response) {
        String source = weatherService.getWeatherGif(city);
        URL url = new URL(source);
        URLConnection conn = url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);
        conn.connect();
        response.setContentType("image/gif");
        response.addHeader("Content-Disposition", "attachment; filename=" + source + ".gif");
        IOUtils.copy(conn.getInputStream(), response.getOutputStream());
    }
}
