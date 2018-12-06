
import java.util.Date;
import java.util.concurrent.TimeUnit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gencturk
 */
public class Rent {
    private int id;
    private static int lastUsedId = 100;
    private SalesRepresentative salesRep;
    private Customer customer;
    private Date pickUpDate,
            dropOfDate;
    private Vehicle vehicleRented;
    private double paymentAmount;

    public Rent(SalesRepresentative salesRep, Customer customer, Date pickUpDate, Date dropOfDate, Vehicle vehicleRented) {
        this.id = lastUsedId++;
        this.salesRep = salesRep;
        this.customer = customer;
        this.pickUpDate = pickUpDate;
        this.dropOfDate = dropOfDate;
        this.vehicleRented = vehicleRented;
        this.paymentAmount = vehicleRented.calculatePrice(getRentDurationInDays());
    }
    
    public int getRentDurationInDays() 
    {
        long diff = pickUpDate.getTime() - dropOfDate.getTime();
        return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public int getId() {
        return id;
    }

    public SalesRepresentative getSalesRep() {
        return salesRep;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public Date getDropOfDate() {
        return dropOfDate;
    }

    public Vehicle getVehicleRented() {
        return vehicleRented;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    @Override
    public String toString() {
        return "Rent{" + "id=" + id + ", salesRep=" + salesRep + ", customer=" + customer + ", pickUpDate=" + pickUpDate + ", dropOfDate=" + dropOfDate + ", vehicleRented=" + vehicleRented + ", paymentAmount=" + paymentAmount + '}';
    }
    
    
    
    
}
