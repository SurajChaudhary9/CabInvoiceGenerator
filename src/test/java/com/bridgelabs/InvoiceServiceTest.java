package com.bridgelabs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InvoiceServiceTest {
    InvoiceService invoiceService = null;

    @Before
    public void setUp() throws Exception {
        invoiceService = new InvoiceService();
    }

    //STEP 1 : Calculate Fare
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceService.calculateFare(distance, time);
        assertEquals(25, fare, 0.0);

    }

    //STEP 1 V2 : Minimum Fare
    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceService.calculateFare(distance, time);
        assertEquals(5, fare, 0.0);
    }

    ////STEP 1 V3 : Advance Invoice
    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        InvoiceSummary summary = invoiceService.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        assertEquals(expectedInvoiceSummary, summary);
    }

    //STEP 4 : Invoice Service
    @Test
    public void givenUserAndRides_ShouldReturnInvoiceSummary() {
        String user1 = "abc.com";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        invoiceService.addRides(user1, rides);
        String user2 = "abcd.com";
        Ride[] rides1 = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        invoiceService.addRides(user2, rides1);
        InvoiceSummary summary = invoiceService.getInvoiceService(user1);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        assertEquals(expectedInvoiceSummary, summary);

    }
    @Test
    public void givenNormalAndPremiumRides_ShouldReturnInvoiceSummary() {
        String user1 = "Suraj";
        Ride[] rides1 = {new Ride(RideCategory.PREMIUM,2.0, 5), new Ride(RideCategory.NORMAL,0.1, 1)};
        invoiceService.addRides(user1,rides1);
        String user2 = "Sagar";
        Ride[] rides2 = {new Ride(RideCategory.PREMIUM,3.0, 5), new Ride(RideCategory.NORMAL,0.1, 1)};
        invoiceService.addRides(user2,rides2);
        InvoiceSummary summary = invoiceService.getInvoiceSummary(user1);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 45);
        assertEquals(expectedInvoiceSummary,summary);
    }
}
