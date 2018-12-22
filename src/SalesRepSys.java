
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
public class SalesRepSys {
    private static ArrayList<SalesRepresentative> salesReps = new ArrayList<SalesRepresentative>();
    
    public static boolean addSalesRep(SalesRepresentative salesRep)
    {
        for(int i = 0; i < salesReps.size(); i++)
            if(salesReps.get(i).getSsn() == salesRep.getSsn())
                return false;
        salesReps.add(salesRep);
        return true;
    }
    
    public static SalesRepresentative searchSalesRep(String ssn)
    {
        for(int i = 0; i < salesReps.size(); i++)
            if(salesReps.get(i).getSsn().equals(ssn))
                return salesReps.get(i);
        return null;
    }
    
    public static ArrayList<SalesRepresentative> getSalesReps()
    {
        return salesReps;
    }
    
    public static String getSalesRepsInfo()
    {
        String result = "";
        for(int i = 0; i < salesReps.size(); i++)
            result += salesReps.get(i).toString();
        return result;
    }
    
    public static boolean readTextFile()
    {
        /*File Structure
        ssn,name,surname,age,salary,commissionPct
        21703067,furkan,gencturk,21,2500,8
        */
        File file = new File("salesrepresentative.txt");
        if(!file.exists())
            return false;
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SalesRepSys.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        String input[];
        while(scanner.hasNext())
        {
            input = scanner.nextLine().split(",");
            addSalesRep(new SalesRepresentative(input[0],input[1],input[2],
                                                Integer.parseInt(input[3]),
                                                Double.parseDouble(input[4]),
                                                Double.parseDouble(input[5])));            
        }
        return true;
    }
    
    public static void writeTextFile()
    {
        File file = new File("salesrepresentative.txt");
        PrintWriter writer;
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SalesRepSys.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        for(int i = 0; i < salesReps.size(); i++)
            writer.println(salesReps.get(i).toStringForWriting());
        writer.close();
    }
}
