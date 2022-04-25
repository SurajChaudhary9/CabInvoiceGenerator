package com.bridgelabs;

import java.util.HashMap;
import java.util.Map;

//STEP 1 : Calculate Fare
public class InvoiceService {
    private static final double MINIMUM_COST_PER_KILOMETER = 10;
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5;
    static Map<String, Ride[]> map = new HashMap();

    //STEP 1 V2 : Minimum Fare
    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += ride.category.calculateCategoryFare(ride.distance, ride.time);

        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public void addRides(String userId, Ride[] rides) {
        map.put(userId, rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        Ride[] ride = map.get(userId);
        InvoiceSummary invoiceSummary = new InvoiceService().calculateFare(ride);
        return invoiceSummary;
    }
}
