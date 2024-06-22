package com.patika.weatherapp;

import com.patika.weatherapp.dto.response.WeatherResponse;
import com.patika.weatherapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherAppApplication implements CommandLineRunner {

    @Autowired
    private WeatherService weatherService;

    public static void main(String[] args) {
        SpringApplication.run(WeatherAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String country = "Turkey";
        String city = "Istanbul";

        WeatherResponse dailyWeather = weatherService.getDailyWeather(country, city);
        WeatherResponse weeklyWeather = weatherService.getWeeklyWeather(country, city);
        WeatherResponse monthlyWeather = weatherService.getMonthlyWeather(country, city);

        System.out.println("Daily Weather:");
        printWeather(dailyWeather);

        System.out.println("Weekly Weather:");
        printWeather(weeklyWeather);

        System.out.println("Monthly Weather:");
        printWeather(monthlyWeather);
    }

    private void printWeather(WeatherResponse weather) {
        System.out.println("Country: " + weather.getCountry());
        System.out.println("City: " + weather.getCity());
        System.out.println("Temperature: " + weather.getTemperature());
    }
}
