package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Logistics {
    private Transport[] vehicles;

    public Logistics() {
    }

    @Autowired
    public Logistics(Transport[] vehicles,
                     TransportFactory transportFactory,
                     City city, @Value("${logistics.weight}") int weight,
                     @Value("${logistics.hours}") int hours) {
        this.vehicles = vehicles;
        if (vehicles.length == 0) {
            this.vehicles = new Transport[]{transportFactory.getTransport(city, weight, hours)};
        }
    }

    public Transport[] getVehicles() {
        return vehicles;
    }

    public Transport getShipping(City city, int weight, int hours){
        Transport suitableVehicle = null;

        for(Transport vehicle : getVehicles()){
            if(!vehicle.isShippingAvailable(city, weight, hours)) continue;
            if(suitableVehicle == null || suitableVehicle.getPrice(city) > vehicle.getPrice(city)){
                suitableVehicle = vehicle;
            }
        }
        return suitableVehicle;
    }
}
