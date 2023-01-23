package org.example;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Truck extends Transport {

    public Truck() {
    }

    public Truck(String name, int capacity, int speed, float costOfKm) {
        super(name, capacity, speed, costOfKm);
    }

    @Override
    public float getPrice(City city) {
        return city.getDistanceKm() * getCostOfKm();
    }

    @Override
    public String toString() {
        return "Truck";
    }
}
