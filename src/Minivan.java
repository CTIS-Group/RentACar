/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gencturk
 */
public class Minivan extends Vehicle{
    private double weightCapacity;
    private int numOfSeats;

    public Minivan(String licencePlate, String brand, String model, int year, double dailyPrice, int minAgeToRent, double weightCapacity, int numOfSeats) {
        super(licencePlate, brand, model, year, dailyPrice, minAgeToRent);
        this.weightCapacity = weightCapacity;
        this.numOfSeats = numOfSeats;
    }

    public Minivan(String licencePlate, String brand, String model, int year, double dailyPrice, boolean isRented, int minAgeToRent,double weightCapacity, int numOfSeats) {
        super(licencePlate, brand, model, year, dailyPrice, isRented, minAgeToRent);
        this.weightCapacity = weightCapacity;
        this.numOfSeats = numOfSeats;
    }
    
    public double calculatePrice(int numOfDays)
    {
        if(numOfDays < 7)
            return numOfDays * dailyPrice;
        else if(numOfDays < 30) //%20 discount
            return numOfDays * dailyPrice * 0.8;   
        else //%20 + %2 discount for every day after 30th day up to the maximum of %50 discount
            return numOfDays * dailyPrice * (1 - Math.min(0.2 + 0.02 * (numOfDays - 30), 0.5));
    }
    
    public String getDiscountString()
    {
        return "7 days to 30 days : %20 discount\nAfter 30 days for each day %2 discount up to %50";
    }

    public double getWeightCapacity() {
        return weightCapacity;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setWeightCapacity(double weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    @Override
    public String toString() {
        return "\n--Minivan--\n" + super.toString() + "# of seats: " + numOfSeats + "\nWeight capacity: " + weightCapacity + "\n";
    }
    public String toStringForWriting()
    {
        //licencePlate,brand,model,year,dailyPrice,isRented,minAgeToRent,weightCapacity,numOfSeats
        return licencePlate + "," + brand + "," + model + "," + year + "," + dailyPrice + "," + isRented + "," + minAgeToRent + "," + weightCapacity + "," + numOfSeats;
    }
    
    
}
