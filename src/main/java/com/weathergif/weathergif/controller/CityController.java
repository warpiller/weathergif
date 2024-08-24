package com.weathergif.weathergif.controller;

import com.weathergif.weathergif.entity.CityEntity;
import com.weathergif.weathergif.mapper.CityListMapper;
import com.weathergif.weathergif.query.CityResponse;
import com.weathergif.weathergif.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CityController {
    private final CityRepository cityRepository;
    private final CityListMapper mapper;

    @GetMapping("/cities/all")
    public List<CityResponse> getCities() {
        return mapper.map(cityRepository.findAll());
    }

    @PostMapping("/cities/add")
    public CityResponse addCity(@RequestParam String city) {
        return new CityResponse(cityRepository.save(new CityEntity(city)).getCity());
    }

    @GetMapping("/city/get/id")
    public Integer getId(@RequestParam String city) {
        CityEntity response = cityRepository.findCityEntitiesByCity(city);
        if (response == null)
            return null;
        else return response.getId();
    }

    @DeleteMapping("/cities/delete")
    public void deleteCity(@RequestParam Integer id) {
        cityRepository.deleteById(id);
    }
}
