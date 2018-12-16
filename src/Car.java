/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gencturk
 */
public class Car extends Vehicle{
    private int numOfSeats;
    private String fuelType;

    public Car(String licencePlate, String brand, String model, int year, double dailyPrice, int minAgeToRent, int numOfSeats, String fuelType) {
        super(licencePlate, brand, model, year, dailyPrice, minAgeToRent);
        this.numOfSeats = numOfSeats;
        this.fuelType = fuelType;
    }

    public Car(String licencePlate, String brand, String model, int year, double dailyPrice, boolean isRented, int minAgeToRent,int numOfSeats, String fuelType) {
        super(licencePlate, brand, model, year, dailyPrice, isRented, minAgeToRent);
        this.numOfSeats = numOfSeats;
        this.fuelType = fuelType;
    }
    
    public double calculatePrice(int numOfDays)
    {
        if(numOfDays < 3)
            return numOfDays * dailyPrice;
        else if(numOfDays < 7) //%10 discount
            return numOfDays * dailyPrice * .90; 
        else //%10 + %3 discount for every day after 7th day to the maximum of %50 discount
            return numOfDays * dailyPrice * (1 - Math.min(0.1 + 0.03 * (numOfDays - 7), 0.5));            
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "\n--Car--\n" + super.toString() + "# of seats: " + numOfSeats + "\nFuel type: " + fuelType + "\n";
    }
    public String toStringForWriting()
    {
        //licencePlate,brand,model,year,dailyPrice,isRented,minAgeToRent,numOfSeats,fuelType
        return licencePlate + "," + brand + "," + model + "," + year + "," + dailyPrice + "," + isRented + "," + minAgeToRent + "," + numOfSeats + "," + fuelType;
    }
    
    
    
}
