package com.patika.weatherapp.converter;

import com.patika.weatherapp.dto.response.WeatherResponse;
import com.patika.weatherapp.model.Weather;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WeatherConverter {
    private WeatherResponse convertToWeatherResponse(Weather weather) {
        WeatherResponse response = new WeatherResponse();
        response.setCountry(weather.getCountry());
        response.setCity(weather.getCity());
        response.setTemperature(weather.getTemperature());
        return response;
    }
}
