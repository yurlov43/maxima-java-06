package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Ship  extends Transport{

    public Ship() {
    }

    @Autowired
    public Ship(@Value("${ship.name}") String name,
                @Value("${ship.capacity}") int capacity,
                @Value("${ship.speed}") int speed,
                @Value("${ship.costOfKm}") float costOfKm) {
        super(name, capacity, speed, costOfKm);
    }

    @Override
    public float getPrice(City city){
        return city.isOnWater() ? city.getDistanceKm() * getCostOfKm() : 0;
    }

    @Override
    public String toString() {
        return "Ship";
    }
}
