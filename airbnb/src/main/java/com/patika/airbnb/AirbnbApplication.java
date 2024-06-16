package com.patika.airbnb;

import com.patika.airbnb.model.Property;
import com.patika.airbnb.service.PropertyService;
import org.springframework.boot.SpringApplication;

import java.math.BigDecimal;

import static com.patika.airbnb.model.enums.PropertyType.*;

public class AirbnbApplication {

    public static void main(String[] args) {
        PropertyService propertyService = new PropertyService();
        //add properties...
        Property evUla          =  new Property("Ev Ula", 5, 2, new BigDecimal("300000"), new BigDecimal("180"), HOME);
        Property evKusadası     =  new Property("Ev Kuşadası", 3, 1, new BigDecimal("300000"), new BigDecimal("180"), HOME);
        Property villaÇesme     =  new Property("Villa Çeşme", 3, 1, new BigDecimal("710000"), new BigDecimal("200"), VILLA);
        Property villaKemer     =  new Property("Villa Kemer", 8,2, new BigDecimal("690000"), new BigDecimal("180"), VILLA);
        Property yazlıkKas      =  new Property("Yazlık Kaş", 3, 1, new BigDecimal("460000"), new BigDecimal("190"), SUMMER_HOUSE);
        Property yazlıkAyvalık  =  new Property("Yazlık Ayvalık", 2, 1, new BigDecimal("750000"), new BigDecimal("100"), SUMMER_HOUSE);

        propertyService.save(evUla);
        propertyService.save(evKusadası);
        propertyService.save(villaÇesme);
        propertyService.save(villaKemer);
        propertyService.save(yazlıkKas);
        propertyService.save(yazlıkAyvalık);

        System.out.println("Total Price of Houses: " + propertyService.getTotalPriceOfHomes());
        System.out.println("Total Price of Villas: " + propertyService.getTotalPriceOfVillas());
        System.out.println("Total price of Summer Houses: " + propertyService.getTotalPriceOfSummerHouses());
        System.out.println("Total Price of Properties: " + propertyService.getTotalPriceOfAllProperties());

        System.out.println("Average square metres of houses: " + propertyService.getAverageSquareMetersOfHomes());
        System.out.println("Average square metres of Villas: " + propertyService.getAverageSquareMetersOfVillas());
        System.out.println("Average square metres of Summer Houses: " + propertyService.getAverageSquareMetersOfSummerHouses());
        System.out.println("Average square metres of Properties: " + propertyService.getAverageSquareMetersOfAllProperties());

        System.out.println("Houses Filtered by Number of Rooms and Halls: " + propertyService.filterPropertiesByRoomsAndLivingRooms(3, 1));
    }
}
