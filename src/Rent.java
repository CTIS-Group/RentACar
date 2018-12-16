/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gencturk
 */
public class Rent implements FileInterface{
    private int id;
    private static int lastUsedId = 100;
    private SalesRepresentative salesRep;
    private Customer customer;
    private SDate pickUpDate,
            dropOfDate;
    private Vehicle vehicleRented;
    private double paymentAmount;

    public Rent(SalesRepresentative salesRep, Customer customer, SDate pickUpDate, SDate dropOfDate, Vehicle vehicleRented) {
        this.id = lastUsedId++;
        this.salesRep = salesRep;
        this.customer = customer;
        this.pickUpDate = pickUpDate;
        this.dropOfDate = dropOfDate;
        this.vehicleRented = vehicleRented;
        this.paymentAmount = vehicleRented.calculatePrice(getRentDurationInDays());
    }
    
    public Rent(int id, SalesRepresentative salesRep, Customer customer, SDate pickUpDate, SDate dropOfDate, Vehicle vehicleRented, double paymentAmount) {
        this.id = id;
        this.salesRep = salesRep;
        this.customer = customer;
        this.pickUpDate = pickUpDate;
        this.dropOfDate = dropOfDate;
        this.vehicleRented = vehicleRented;
        this.paymentAmount = paymentAmount;
    }
    
    public int getRentDurationInDays() 
    {
        return dropOfDate.differenceInDays(pickUpDate);
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

    public SDate getPickUpDate() {
        return pickUpDate;
    }

    public SDate getDropOfDate() {
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
    public String toStringForWriting()
    {
        return id+","+salesRep.getSsn()+","+customer.getSsn()+","+pickUpDate.toString()+","+dropOfDate.toString()+","+vehicleRented.getLicencePlate()+","+paymentAmount;
    }
}
