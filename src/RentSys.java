
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
public class RentSys {
    private static ArrayList<Rent> rents = new ArrayList<Rent>();
    
    public static boolean addRent(Rent rent)
    {
        for(int i = 0; i < rents.size(); i++)
            if(rents.get(i).getId() == rent.getId())
                return false;
        rents.add(rent);
        return true;
    }
    
    public static Rent searchRent(int id)
    {
        Rent rent;
        for(int i = 0; i < rents.size(); i++)
        {
            rent = rents.get(i);
            if(rent.getId() == id)
                return rent;
        }
        return null;
    }
    
    public static ArrayList<Rent> getRents()
    {
        return rents;
    }
    
    public static String getRentsInfo()
    {
        String result = "";
        for(int i = 0; i < rents.size(); i++)
            result += rents.get(i).toString() + "\n";
        return result;
    }
    
    public static ArrayList<Rent> getRentsOfMonth(int month)
    {
        ArrayList<Rent> result = new ArrayList<Rent>();
        
        for(int i = 0; i < rents.size(); i++)
        {
            if(rents.get(i).getPickUpDate().getMonth() == month)
                result.add(rents.get(i));
        }
        return result;
    }
    
    public static ArrayList<Rent> getRentsOfSalesRep(String ssn)
    {
       ArrayList<Rent> result = new ArrayList<Rent>();
        
        for(int i = 0; i < rents.size(); i++)
        {
            if(rents.get(i).getSalesRep().getSsn() == ssn)
                result.add(rents.get(i));
        }
        return result; 
    }
    
    public static ArrayList<Rent> getRentsOfCustomer(String ssn)
    {
       ArrayList<Rent> result = new ArrayList<Rent>();
        
        for(int i = 0; i < rents.size(); i++)
        {
            if(rents.get(i).getCustomer().getSsn() == ssn)
                result.add(rents.get(i));
        }
        return result; 
    }
    
    public static boolean readTextFile()
    {
        /*File structure
        Rentid,salesRepSsn,customerSsn,pickUpDate,dropOfDate,vehicleLicenceId,paymentAmount
        22,21703067777,57645656874,25.05.2018,29.05.2018,34 BZ 4579,650
        */
        File file = new File("rent.txt");
        if(!file.exists())
            return false;
        Scanner scanner;
        try 
        {
            scanner = new Scanner(file);
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(RentSys.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        String input[];
        String pickUpDateStr[],
                dropOfDateStr[];
        SDate pickUpDate,
                dropOfDate;
        while(scanner.hasNext())
        {
            input = scanner.nextLine().split(",");
            pickUpDateStr = input[3].split("\\.");
            dropOfDateStr = input[4].split("\\.");
            
            pickUpDate = new SDate(pickUpDateStr[0],
                                    pickUpDateStr[1],
                                    pickUpDateStr[2]);
            
            dropOfDate = new SDate(dropOfDateStr[0],
                                    dropOfDateStr[1],
                                    dropOfDateStr[2]);
            
            Rent rent = new Rent(Integer.parseInt(input[0]),
                                SalesRepSys.searchSalesRep(input[1]),
                                CustomerSys.searchCustomer(input[2]),
                                pickUpDate,
                                dropOfDate,
                                VehicleSys.searchVehicle(input[5]),
                                Double.parseDouble(input[6]));
            
            addRent(rent);
        }
        if(rents.size() > 0)
            Rent.setLastUsedId(rents.get(rents.size() - 1).getId());
        return true;
    }
    
    public static void writeTextFile()
    {
        /*File structure
        Rentid,salesRepSsn,customerSsn,pickUpDate,dropOfDate,vehicleLicenceId,paymentAmount
        22,21703067777,57645656874,25.05.2018,29.05.2018,34 BZ 4579,650
        */
        File file = new File("rent.txt");
        PrintWriter writer;
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RentSys.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
        for(int i = 0; i < rents.size(); i++)
            writer.println(rents.get(i).toStringForWriting());
        writer.close();
    }
}
