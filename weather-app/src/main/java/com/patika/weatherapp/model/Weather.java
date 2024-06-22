package com.patika.weatherapp.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Weather {
    private String country;
    private String city;
    private LocalDateTime time;
    private Double temperature;
}
