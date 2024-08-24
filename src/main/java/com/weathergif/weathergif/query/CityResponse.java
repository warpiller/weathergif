package com.weathergif.weathergif.query;

import lombok.Data;

@Data
public class CityResponse {
    private String city;

    public CityResponse(String city) {
        this.city = city;
    }

    public CityResponse() {
    }
}
