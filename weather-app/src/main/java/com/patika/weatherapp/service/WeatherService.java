package com.patika.weatherapp.service;

import com.patika.weatherapp.config.WeatherApiConfig;
import com.patika.weatherapp.dto.response.WeatherApiResponse;
import com.patika.weatherapp.dto.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;

@Service
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WeatherApiConfig weatherApiConfig;

    public WeatherResponse getDailyWeather(String country, String city) {
        String url = buildUrl(weatherApiConfig.getDailyUrl(), city);
        return getWeatherResponse(url, country, city);
    }

    public WeatherResponse getWeeklyWeather(String country, String city) {
        String url = buildUrl(weatherApiConfig.getWeeklyUrl(), city);
        return getWeatherResponse(url, country, city);
    }

    public WeatherResponse getMonthlyWeather(String country, String city) {
        LocalDate futureDate = LocalDate.now().plusMonths(1);
        String url = buildUrl(weatherApiConfig.getMonthlyUrl(), city, futureDate.toString());
        return getWeatherResponse(url, country, city);
    }

    private WeatherResponse getWeatherResponse(String url, String country, String city) {
        try {
            WeatherApiResponse response = restTemplate.getForObject(url, WeatherApiResponse.class);
            return mapToWeatherResponse(response, country, city);
        } catch (HttpClientErrorException e) {
            System.err.println("Error fetching weather data: " + e.getMessage());
            WeatherResponse weatherResponse = new WeatherResponse();
            weatherResponse.setCountry(country);
            weatherResponse.setCity(city);
            return weatherResponse;
        }
    }

    private String buildUrl(String urlTemplate, String city) {
        return String.format(urlTemplate, city, weatherApiConfig.getApiKey());
    }

    private String buildUrl(String urlTemplate, String city, String date) {
        return String.format(urlTemplate, city, weatherApiConfig.getApiKey(), date);
    }

    private WeatherResponse mapToWeatherResponse(WeatherApiResponse response, String country, String city) {
        WeatherResponse weatherResponse = new WeatherResponse();
        weatherResponse.setCountry(country);
        weatherResponse.setCity(city);
        return weatherResponse;
    }
}
