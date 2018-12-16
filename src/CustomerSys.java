
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gencturk
 */
public class CustomerSys {
    private static ArrayList<Customer> customers = new ArrayList<Customer>();
    
    public static boolean addCustomer(Customer customer)
    {
        for(int i = 0; i < customers.size(); i++)
            if(customers.get(i).getSsn() == customer.getSsn())
                return false;
        customers.add(customer);
        return true;
    }
    
    public static Customer searchCustomer(String ssn)
    {
        for(int i = 0; i < customers.size(); i++)
            if(customers.get(i).getSsn().equals(ssn))
                return customers.get(i);
        return null;
    }
    
    public static ArrayList<Customer> getSalesReps()
    {
        return customers;
    }
    
    public static String getCustomersInfo()
    {
        String result = "";
        for(int i = 0; i < customers.size(); i++)
            result += customers.get(i).toString();
        return result;
    }
    
    public static boolean readTextFile()
    {
        /*File Structure
        ssn,name,surname,age,salary,commissionPct
        21703067,furkan,gencturk,21,2500,8
        */
        File file = new File("customer.txt");
        if(!file.exists())
            return false;
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CustomerSys.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        String input[];
        String date[];
        while(scanner.hasNext())
        {
            input = scanner.nextLine().split(",");
            date = input[4].split("\\.");
            addCustomer(new Customer(input[0],input[1],input[2],
                                                Integer.parseInt(input[3]),
                                                new SDate(date[0], date[1], date[2])));            
        }
        return true;
    }
    
    public static void writeTextFile()
    {
        File file = new File("customer.txt");
        PrintWriter writer;
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CustomerSys.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
        for(int i = 0; i < customers.size(); i++)
            writer.println(customers.get(i).toStringForWriting());
    }
}
