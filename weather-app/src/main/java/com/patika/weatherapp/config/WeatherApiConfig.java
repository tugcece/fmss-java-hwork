package com.patika.weatherapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeatherApiConfig {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.daily.url}")
    private String dailyUrl;

    @Value("${weather.api.weekly.url}")
    private String weeklyUrl;

    @Value("${weather.api.monthly.url}")
    private String monthlyUrl;

    public String getApiKey() {
        return apiKey;
    }

    public String getDailyUrl() {
        return dailyUrl;
    }

    public String getWeeklyUrl() {
        return weeklyUrl;
    }

    public String getMonthlyUrl() {
        return monthlyUrl;
    }
}
