package com.patika.weatherapp.dto.response;

import lombok.Data;

@Data
public class WeatherResponse {
    private String city;
    private String country;
    private double temperature;
}
