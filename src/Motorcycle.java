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
    private String helmetType,
            vest;
    private int motorPower;

    public Motorcycle(int motorPower, String licencePlate, String brand, String model, int year, double dailyPrice, int minAgeToRent, String helmetType, String vest) {
        super(licencePlate, brand, model, year, dailyPrice, minAgeToRent);
        this.helmetType = helmetType;
        this.vest = vest;
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

    public String getHelmetType() {
        return helmetType;
    }

    public String getVest() {
        return vest;
    }

    public int getMotorPower() {
        return motorPower;
    }

    public void setHelmetType(String helmetType) {
        this.helmetType = helmetType;
    }

    public void setVest(String vest) {
        this.vest = vest;
    }

    public void setMotorPower(int motorPower) {
        this.motorPower = motorPower;
    }

    @Override
    public String toString() {
        return super.toString() + "\tMotorcycle" + "\nHelmet Type: " + helmetType + "\nVest: " + vest + "\nMotor Power: " + motorPower + "\n";
    }
    
    
    
}
