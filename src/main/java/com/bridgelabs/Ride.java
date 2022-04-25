package com.bridgelabs;

public class Ride {
    RideCategory category;
    public int time;
    public double distance;

    public Ride(double distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    public Ride(RideCategory category, double distance, int time) {
        this.distance = distance;
        this.time = time;
        this.category = category;
    }
}
