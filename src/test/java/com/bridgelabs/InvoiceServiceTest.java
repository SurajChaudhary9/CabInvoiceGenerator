package com.bridgelabs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
    InvoiceService invoiceService = null;
    @Before
    public void setUp() throws Exception {
        invoiceService = new InvoiceService();
    }
    //STEP 1 : Calculate Fare
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare(){
        double distance = 2.0;
        int time =5;
        double fare = invoiceService.calculateFare(distance,time);
        Assert.assertEquals(25,fare,0.0);

    }
    //STEP 1 V2 : Minimum Fare
    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinFare(){
        double distance =0.1;
        int time =1;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(5,fare,0.0);
    }
    ////STEP 1 V3 : Advance Invoice
    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides ={new Ride(2.0,5),
                new Ride(0.1,1) };
        InvoiceSummary summary= invoiceService.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,30.0);
        Assert.assertEquals(expectedInvoiceSummary,summary);
    }
    //STEP 4 : Invoice Service
    @Test
    public void givenUserAndRides_ShouldReturnInvoiceSummary(){
        String userId = "abc.com";
        Ride[] rides ={new Ride(2.0,5),
                new Ride(0.1,1) };
        invoiceService.calculateFare(userId,rides);
        InvoiceSummary summary = invoiceService.getInvoiceService(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,30.0);
        Assert.assertEquals(expectedInvoiceSummary,summary);

    }
}
