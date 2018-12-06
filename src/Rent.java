
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
            dropOffDate;
    private Vehicle vehicleRented;
    private double paymentAmount;

    public Rent(SalesRepresentative salesRep, Customer customer, Date pickUpDate, Date dropOfDate, Vehicle vehicleRented) {
        this.id = lastUsedId++;
        this.salesRep = salesRep;
        this.customer = customer;
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOfDate;
        this.vehicleRented = vehicleRented;
        this.paymentAmount = vehicleRented.calculatePrice(getRentDurationInDays());
    }
    
    public int getRentDurationInDays() 
    {
        long diff = pickUpDate.getTime() - dropOffDate.getTime();
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
        return dropOffDate;
    }

    public Vehicle getVehicleRented() {
        return vehicleRented;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    @Override
    public String toString() {
        return "\tRent" + "\nId: " + id + "\nSales Representative: " + salesRep + "\nCustomer: " + customer + "\nPick Up Date=" + pickUpDate + "\nDrop-off Date: " + dropOffDate + "\nVehicle Rented:" + vehicleRented + "\nPayment Amount: " + paymentAmount + "\n";
    }
    
    
    
    
}
