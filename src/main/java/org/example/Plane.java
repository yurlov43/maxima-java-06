package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Plane extends Transport{

    public Plane() {
    }

    @Autowired
    public Plane(@Value("${plane.name}") String name,
                 @Value("${plane.capacity}") int capacity,
                 @Value("${plane.speed}") int speed,
                 @Value("${plane.costOfKm}") float costOfKm) {
        super(name, capacity, speed, costOfKm);
    }

    @Override
    public float getPrice(City city){
        return city.hasAirport() ? city.getDistanceKm() * getCostOfKm() : 0;
    }

    @Override
    public String toString() {
        return "Plane";
    }
}
