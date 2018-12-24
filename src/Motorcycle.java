/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gencturk
 */
public class Motorcycle extends Vehicle{
    private String helmetType;
    private int motorPower;

    public Motorcycle(String licencePlate, String brand, String model, int year, double dailyPrice, int minAgeToRent, String helmetType, int motorPower) 
    {
        super(licencePlate, brand, model, year, dailyPrice, minAgeToRent);
        this.helmetType = helmetType;
        this.motorPower = motorPower;
    }

    public Motorcycle(String licencePlate, String brand, String model, int year, double dailyPrice, boolean isRented, int minAgeToRent, String helmetType, int motorPower) {
        super(licencePlate, brand, model, year, dailyPrice, isRented, minAgeToRent);
        this.helmetType = helmetType;
        this.motorPower = motorPower;
    }
    
    public double calculatePrice(int numOfDays)
    {
        if(numOfDays < 3)
            return numOfDays * dailyPrice;
        else if(numOfDays < 7) //%20 discount
            return numOfDays * dailyPrice * .80; 
        else //%20 + %3 discount for every day after 7th day up to the maximum of %70 discount
            return numOfDays * dailyPrice * (1 - Math.min(0.2 + 0.03 * (numOfDays - 7), 0.7));            
    }
    
    public String getDiscountString()
    {
        return "4 days to 7 days : %20 discount\nAfter 7 days for each day %3 discount up to %70";
    }

    public String getHelmetType() {
        return helmetType;
    }

    public int getMotorPower() {
        return motorPower;
    }

    public void setHelmetType(String helmetType) {
        this.helmetType = helmetType;
    }

    public void setMotorPower(int motorPower) {
        this.motorPower = motorPower;
    }

    @Override
    public String toString() {
        return "\n--Motorcycle--\n" + super.toString() + "Helmet type: " + helmetType + "\nMotor power: " + motorPower + "\n";
    }
    
    public String toStringForWriting()
    {
        //licencePlate,brand,model,year,dailyPrice,isRented,minAgeToRent,helmetType,motorPower
        return licencePlate + "," + brand + "," + model + "," + year + "," + dailyPrice + "," + isRented + "," + minAgeToRent + "," + helmetType + "," + motorPower;
    }
    
    
}
