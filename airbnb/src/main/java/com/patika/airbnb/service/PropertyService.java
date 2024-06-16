package com.patika.airbnb.service;

import com.patika.airbnb.model.Property;
import com.patika.airbnb.repository.PropertyRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static com.patika.airbnb.model.enums.PropertyType.*;

public class PropertyService {

    private PropertyRepository propertyRepository = new PropertyRepository();

    public void save(Property property) {
        propertyRepository.addProperty(property);
    };

    public List<Property> getAll() {
        return propertyRepository.getProperties();
    }
    public BigDecimal getTotalPriceOfHomes() {
        return propertyRepository.getProperties().stream()
                .filter(property -> property.getType() == HOME)
                .map(Property::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalPriceOfVillas() {
        return propertyRepository.getProperties().stream()
                .filter(property -> property.getType() == VILLA)
                .map(Property::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalPriceOfSummerHouses() {
        return propertyRepository.getProperties().stream()
                .filter(property -> property.getType() == SUMMER_HOUSE)
                .map(Property::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalPriceOfAllProperties() {
        return propertyRepository.getProperties().stream()
                .map(Property::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getAverageSquareMetersOfHomes() {
        return propertyRepository.getHomes().stream()
                .map(Property::getCentare)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(new BigDecimal(propertyRepository.getHomes().size()), BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getAverageSquareMetersOfVillas() {
        return propertyRepository.getVillas().stream()
                .map(Property::getCentare)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(new BigDecimal(propertyRepository.getVillas().size()), BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getAverageSquareMetersOfSummerHouses() {
        return propertyRepository.getSummerHouses().stream()
                .map(Property::getCentare)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(new BigDecimal(propertyRepository.getSummerHouses().size()), BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getAverageSquareMetersOfAllProperties() {
        return propertyRepository.getProperties().stream()
                .map(Property::getCentare)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(new BigDecimal(propertyRepository.getProperties().size()), BigDecimal.ROUND_HALF_UP);
    }

    public List<String> filterPropertiesByRoomsAndLivingRooms(int numberOfRooms, int numberOfLivingRooms) {
        return propertyRepository.getProperties().stream()
                .filter(property -> property.getNumberofrooms().equals(numberOfRooms) && property.getNumberoflivingrooms().equals(numberOfLivingRooms))
                .map(Property::getName)
                .collect(Collectors.toList());
    }
}
