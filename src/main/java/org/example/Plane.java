package org.example;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Plane extends Transport{

    public Plane() {
    }

    public Plane(String name, int capacity, int speed, float costOfKm) {
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
