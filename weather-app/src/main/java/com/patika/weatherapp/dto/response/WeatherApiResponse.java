package com.patika.weatherapp.dto.response;

import lombok.Data;


@Data
public class WeatherApiResponse {
    private Current current;
   @Data
    public static class Current {
        private double tempC;
        private Condition condition;
    }

    @Data
    public static class Condition {
        private String text;
    }
}
