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
            dropOffDate;
    private Vehicle vehicleRented;
    private double paymentAmount;

    public Rent(SalesRepresentative salesRep, Customer customer, SDate pickUpDate, SDate dropOfDate, Vehicle vehicleRented) {
        this.id = ++lastUsedId;
        this.salesRep = salesRep;
        this.customer = customer;
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOfDate;
        this.vehicleRented = vehicleRented;
        this.paymentAmount = vehicleRented.calculatePrice(getRentDurationInDays());
    }
    
    public Rent(int id, SalesRepresentative salesRep, Customer customer, SDate pickUpDate, SDate dropOffDate, Vehicle vehicleRented, double paymentAmount) {
        this.id = id;
        this.salesRep = salesRep;
        this.customer = customer;
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOffDate;
        this.vehicleRented = vehicleRented;
        this.paymentAmount = paymentAmount;
    }

    public static void setLastUsedId(int id)
    {
        lastUsedId = id;
    }
    
    public int getRentDurationInDays() 
    {
        return dropOffDate.differenceInDays(pickUpDate);
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
        return "\n|---- RENT " + id + " ----|\nRent ID: " + id + "\nPick-up Date: " + pickUpDate + "\nDrop-off Date: " + dropOffDate + "\nPayment Amount: " + paymentAmount + " TL\n" + salesRep + customer + vehicleRented + "\n";
    }
    
    public String showLess()
    {
        return "\n|---- RENT " + id + " ----|\nRent ID: " + id + "\nPick-up Date: " + pickUpDate + "\nDrop-off Date: " + dropOffDate + "\nPayment Amount: " + paymentAmount + " TL\n";
    }
    public String toStringForWriting()
    {
        return id+","+salesRep.getSsn()+","+customer.getSsn()+","+pickUpDate.toString()+","+dropOffDate.toString()+","+vehicleRented.getLicencePlate()+","+paymentAmount;
    }
}
