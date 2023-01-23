package org.example;

public class City {
    private String name;
    private int distanceKm;
    private boolean hasAirport;
    private boolean isOnWater;

    public City() {
    }

    public City(String name, int distanceKm) {
        this(name, distanceKm, false, true);
    }

    public City(String name, int distanceKm, boolean hasAirport, boolean isOnWater) {
        this.name = name;
        this.distanceKm = distanceKm;
        this.hasAirport = hasAirport;
        this.isOnWater = isOnWater;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(int distanceKm) {
        this.distanceKm = distanceKm;
    }

    public boolean hasAirport() {
        return hasAirport;
    }

    public void setHasAirport(boolean hasAirport) {
        this.hasAirport = hasAirport;
    }

    public boolean isOnWater() {
        return isOnWater;
    }

    public void setOnWater(boolean onWater) {
        isOnWater = onWater;
    }
}
