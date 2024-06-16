package com.patika.airbnb.model;

import com.patika.airbnb.model.enums.PropertyType;

import java.math.BigDecimal;


public class Property {

    private String name;
    private Integer numberofrooms;
    private Integer numberoflivingrooms;
    private BigDecimal price;
    private BigDecimal centare;
    private PropertyType type;

    public Property(String name, Integer numberofrooms, Integer numberoflivingrooms, BigDecimal centare, BigDecimal price, PropertyType type) {
        this.name = name;
        this.numberofrooms = numberofrooms;
        this.numberoflivingrooms = numberoflivingrooms;
        this.centare = centare;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberofrooms() {
        return numberofrooms;
    }

    public void setNumberofrooms(Integer numberofrooms) {
        this.numberofrooms = numberofrooms;
    }

    public Integer getNumberoflivingrooms() {
        return numberofrooms;
    }

    public void setNumberoflivingrooms(Integer numberofrooms) {
        this.numberofrooms = numberofrooms;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getCentare() {
        return centare;
    }

    public void setCentare(BigDecimal centare) {
        this.centare = centare;
    }

    public PropertyType getType() {
        return type;
    }

    public void setType(PropertyType type) {
        this.type = type;
    }

}
