
import java.util.ArrayList;

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
            commisionPercentage;

    public SalesRepresentative(String ssn, String name, String surname, int age, double baseSalary, double commisionPercentage) {
        super(ssn, name, surname, age);
        this.baseSalary = baseSalary;
        this.commisionPercentage = commisionPercentage;
    }
    
    public double getSalaryOfCurrentMonth()
    {
        //No-arg constructor of Date initalizes it with the current system date. So, we simply use it to find the current month.
        SDate date = new SDate();
        return getCommissionOfMonth(date.getMonth());
    }
    public double getCommissionOfMonth(int month)
    {        
        ArrayList<Rent> rents = RentSys.getRentsOfSalesRep(ssn);
        double totalCommissionAmount = 0;
        for(int i = 0; i < rents.size(); i++)
        {
            if(rents.get(i).getPickUpDate().getMonth() == month)
                totalCommissionAmount += rents.get(i).getPaymentAmount();
        }
        return totalCommissionAmount * this.commisionPercentage / 100;
    }
    
    public double getSalary(int month)
    {
        return baseSalary + getCommissionOfMonth(month);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getCommisionPercentage() {
        return commisionPercentage;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setCommisionPercentage(double commisionPercentage) {
        this.commisionPercentage = commisionPercentage;
    }

    @Override
    public String toString() {
        return "\n--Sales Representative--\n" + super.toString() + "\nBase Salary: " + baseSalary + "\nCommision Percentage: " + commisionPercentage + "\n";
    }
    public String toStringForWriting()
    {
        //ssn,name,surname,age,salary,commissionPct
        return ssn + "," + name + "," + surname + "," + age + "," + baseSalary + "," + commisionPercentage;
    }
    
    
}
