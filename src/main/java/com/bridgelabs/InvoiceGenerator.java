package com.bridgelabs;
//STEP 1 : Calculate Fare
public class InvoiceGenerator {
    private static final double MINIMUM_COST_PER_KILOMETER =1 ;
    private static final int COST_PER_TIME =10 ;

    public double calculateFare(double distance, int time){
        return distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        
    }
}
