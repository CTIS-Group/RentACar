
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gencturk
 */
public class SalesRepresentative extends Person{
    private double baseSalary,
            commisionPercentage,
            totalSaleAmount;

    public SalesRepresentative(String ssn, String name, String surname, int age, double baseSalary, double commisionPercentage) {
        super(ssn, name, surname, age);
        this.baseSalary = baseSalary;
        this.commisionPercentage = commisionPercentage;
    }
    
    public double getSalaryOfCurrentMonth()
    {
        //No-arg constructor of Date initalizes it with the current system date. So, we simply use it to find the current month.
        Date date = new Date();
        return getSalary(date.getMonth());
    }
    public double getSalary(int month)
    {
        //Because RentSys class has not been implemented yet, the code does not work for now.
        /*
        Rent rents = RentSys.GetRentsOfSaleRepresentative(this);
        double totalCommissionAmount = 0;
        for(int i = 0; i < rents.length; i++)
        {
            if(rents[i].getPickUpDate().getMonth() == month)
                totalCommissionAmount += rents[i].getPaymentAmount();
        }
        return baseSalary + totalCommissionAmount * this.commisionPercentage / 100;
        */
        return 0;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getCommisionPercentage() {
        return commisionPercentage;
    }

    public double getTotalSaleAmount() {
        return totalSaleAmount;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setCommisionPercentage(double commisionPercentage) {
        this.commisionPercentage = commisionPercentage;
    }

    public void setTotalSaleAmount(double totalSaleAmount) {
        this.totalSaleAmount = totalSaleAmount;
    }

    @Override
    public String toString() {
        return super.toString() + "\tSalesRepresentative" + "\nBase Salary: " + baseSalary + "\nCommision Percentage: " + commisionPercentage + "\nTotal Sale Amount: " + totalSaleAmount + "\n";
    }
    
    
}
