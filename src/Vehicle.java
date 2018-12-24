/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gencturk
 */
public abstract class Vehicle implements FileInterface{
    protected String licencePlate,
            brand,
            model;
    protected int year;
    protected double dailyPrice;
    protected boolean isRented;
    protected int minAgeToRent;

    public Vehicle(String licencePlate, String brand, String model, int year, double dailyPrice, int minAgeToRent) {
        this.licencePlate = licencePlate;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.dailyPrice = dailyPrice;
        this.minAgeToRent = minAgeToRent;
        this.isRented = false;
    }

    public Vehicle(String licencePlate, String brand, String model, int year, double dailyPrice, boolean isRented, int minAgeToRent) {
        this.licencePlate = licencePlate;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.dailyPrice = dailyPrice;
        this.isRented = isRented;
        this.minAgeToRent = minAgeToRent;
    }
    
    public boolean isCustomerEligible(Customer customer)
    {
        return customer.age > minAgeToRent;
    }
    
    public boolean isCustomerEligible(int age)
    {
        return age > minAgeToRent;
    }
    
    public abstract double calculatePrice(int numOfDays);
    
    public abstract String getDiscountString();

    public String getLicencePlate() {
        return licencePlate;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public boolean isRented() {
        return isRented;
    }

    public int getMinAgeToRent() {
        return minAgeToRent;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public void setIsRented(boolean isRented) {
        this.isRented = isRented;
    }

    public void setMinAgeToRent(int minAgeToRent) {
        this.minAgeToRent = minAgeToRent;
    }

    @Override
    public String toString() {
        return "Licence Plate: " + licencePlate + "\nBrand: " + brand + "\nModel: " + model + "\nYear: " + year
                + "\nDaily Price: " + dailyPrice + "\nIs Rented: " + isRented
                + "\nMinimum age to rent: " + minAgeToRent + "\n";
    }
}
