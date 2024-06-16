package com.patika.airbnb.repository;
import com.patika.airbnb.model.Property;

import java.util.ArrayList;
import java.util.List;

import static com.patika.airbnb.model.enums.PropertyType.*;

public class PropertyRepository {

    private List<Property> properties = new ArrayList<>();

    public void addProperty( Property property) {
        properties.add(property);
    }

    public List<Property> getProperties() {
        return properties;
    }

    public List<Property> getHomes() {
        return properties.stream()
                .filter(property -> property.getType() == HOME)
                .toList();
    }
    public List<Property> getVillas() {
        return  properties.stream()
                .filter(property -> property.getType() == VILLA)
                .toList();
    }
    public List<Property> getSummerHouses() {
        return  properties.stream()
                .filter(property -> property.getType() == SUMMER_HOUSE)
                .toList();
    }
}