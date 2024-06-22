package com.patika.weatherapp.controller;

import com.patika.weatherapp.dto.response.WeatherResponse;
import com.patika.weatherapp.model.Weather;
import com.patika.weatherapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;

@RestController
@Validated
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather/daily")
    public WeatherResponse getDailyWeather(@RequestParam String country, @RequestParam String city) {
        return weatherService.getDailyWeather(country, city);
    }

    @GetMapping("/weather/weekly")
    public WeatherResponse getWeeklyWeather(@RequestParam String country, @RequestParam String city) {
        return weatherService.getWeeklyWeather(country, city);
    }

    @GetMapping("/weather/monthly")
    public WeatherResponse getMonthlyWeather(@RequestParam String country, @RequestParam String city) {
        return weatherService.getMonthlyWeather(country, city);
    }

}
