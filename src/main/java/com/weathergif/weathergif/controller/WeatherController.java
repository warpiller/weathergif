package com.weathergif.weathergif.controller;

import com.weathergif.weathergif.query.OpenWeatherResponse;
import com.weathergif.weathergif.service.WeatherService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;
    @GetMapping("/weather/data")
    public OpenWeatherResponse getWeather(@RequestParam String city) {
        return weatherService.getWeather(city);
    }

    @SneakyThrows
    @GetMapping(value = "/weather/gif", produces = "image/gif")
    public @ResponseBody ResponseEntity<ByteArrayResource> getWeatherGif(@RequestParam String city, HttpServletResponse response) {
        String gifUrl = weatherService.getWeatherGif(city); // Замените на URL вашего GIF
        RestTemplate restTemplate = new RestTemplate();

        // Скачиваем GIF
        byte[] gifBytes;
        try {
            gifBytes = restTemplate.getForObject(gifUrl, byte[].class);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        // Возвращаем GIF пользователю
        ByteArrayResource resource = new ByteArrayResource(gifBytes);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"downloaded.gif\"")
                .contentType(MediaType.IMAGE_GIF)
                .contentLength(gifBytes.length)
                .body(resource);
    }
}
