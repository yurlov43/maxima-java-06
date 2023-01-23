package org.example;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Ship  extends Transport{

    public Ship() {
    }

    public Ship(String name, int capacity, int speed, float costOfKm) {
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
