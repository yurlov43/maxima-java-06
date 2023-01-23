package org.example;

public abstract class Transport implements Repairable {
    private String name;
    private int capacity;
    private int speed;
    private float costOfKm;

    private boolean repair;

    public Transport() {
    }

    public Transport(String name, int capacity, int speed, float costOfKm) {
        this.name = name;
        this.capacity = capacity;
        this.speed = speed;
        this.costOfKm = costOfKm;
    }

    public abstract float getPrice(City city);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public float getCostOfKm() {
        return costOfKm;
    }

    public void setCostOfKm(float costOfKm) {
        this.costOfKm = costOfKm;
    }

    public boolean isShippingAvailable(City city, int weight, int hours){
        return !isRepairing() && getPrice(city) > 0 &&
                getCapacity() >= weight && city.getDistanceKm() / getSpeed() <= hours;
    }

    @Override
    public boolean isRepairing() {
        return repair;
    }

    @Override
    public void startRepair() {
        this.repair = true;
    }

    @Override
    public void finishRepair() {
        this.repair = false;
    }
}
