package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Truck extends Transport {

    public Truck() {
    }

    @Autowired
    public Truck(@Value("${truck.name}") String name,
                 @Value("${truck.capacity}") int capacity,
                 @Value("${truck.speed}") int speed,
                 @Value("${truck.costOfKm}") float costOfKm) {
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
