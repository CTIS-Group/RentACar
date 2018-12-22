
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
public class VehicleSys {
    private static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    
    public static boolean addVehicle(Vehicle vehicle)
    {
        for(int i = 0; i < vehicles.size(); i++)
            if(vehicles.get(i).getLicencePlate()== vehicle.getLicencePlate())
                return false;
        vehicles.add(vehicle);
        return true;
    }
    
    public static Vehicle searchVehicle(String licencePlate)
    {
        for(int i = 0; i < vehicles.size(); i++)
            if(vehicles.get(i).getLicencePlate().equals(licencePlate))
                return vehicles.get(i);
        return null;
    }
    
    public static ArrayList<Vehicle> getVehicles()
    {
        return vehicles;
    }
    
    public static ArrayList<Car> getCars()
    {
        ArrayList<Car> cars = new ArrayList<Car>();
        for(int i = 0; i < vehicles.size(); i++)
            if(vehicles.get(i) instanceof Car)
                cars.add((Car)vehicles.get(i));
        return cars;
    }
    
    public static ArrayList<Motorcycle> getMotorcycles()
    {
        ArrayList<Motorcycle> motors = new ArrayList<Motorcycle>();
        for(int i = 0; i < vehicles.size(); i++)
            if(vehicles.get(i) instanceof Motorcycle)
                motors.add((Motorcycle)vehicles.get(i));
        return motors;
    }
    
    public static ArrayList<Minivan> getMinivans()
    {
        ArrayList<Minivan> minivans = new ArrayList<Minivan>();
        for(int i = 0; i < vehicles.size(); i++)
            if(vehicles.get(i) instanceof Minivan)
                minivans.add((Minivan)vehicles.get(i));
        return minivans;
    }
    
    public static String getVehiclesInfo()
    {
        String result = "";
        for(int i = 0; i < vehicles.size(); i++)
            result += vehicles.get(i).toString();
        return result;
    }
    
    public static String getCarsInfo(boolean checkAvailibility)
    {
        String result = "";
        for(int i = 0; i < vehicles.size(); i++)
        {
            if(checkAvailibility && vehicles.get(i).isRented)
                continue;
            if(vehicles.get(i) instanceof Car)
                result += vehicles.get(i).toString();            
        }
        return result;
    }
    
    public static String getMotorsInfo(boolean checkAvailibility)
    {
        String result = "";
        for(int i = 0; i < vehicles.size(); i++)
        {
            if(checkAvailibility && vehicles.get(i).isRented)
                continue;
            if(vehicles.get(i) instanceof Motorcycle)
                result += vehicles.get(i).toString();            
        }
        return result;
    }
    
    public static String getMinivansInfo(boolean checkAvailibility)
    {
        String result = "";
        for(int i = 0; i < vehicles.size(); i++)
        {
            if(checkAvailibility && vehicles.get(i).isRented)
                continue;
            if(vehicles.get(i) instanceof Minivan)
                result += vehicles.get(i).toString();            
        }
        return result;
    }
    
    public static boolean readTextFile()
    {
        /*File Structure
        --Car--
        licencePlate,brand,model,year,dailyPrice,isRented,minAgeToRent,numOfSeats,fuelType
        --Motor--
        licencePlate,brand,model,year,dailyPrice,isRented,minAgeToRent,helmetType,motorPower
        --Minivan--
        licencePlate,brand,model,year,dailyPrice,isRented,minAgeToRent,weightCapacity,numOfSeats
        */
        Scanner scanner;
        File file = new File("car.txt");
        if(file.exists())
        {            
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VehicleSys.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            String input[];
            while(scanner.hasNext())
            {
                input = scanner.nextLine().split(",");
                addVehicle(new Car(input[0],input[1],input[2],
                                                    Integer.parseInt(input[3]),
                                                    Double.parseDouble(input[4]),
                                                    Boolean.parseBoolean(input[5]),
                                                    Integer.parseInt(input[6]),
                                                    Integer.parseInt(input[7]),
                                                    input[8]));          
            }
        }
        file = new File("motor.txt");
        if(file.exists())
        {
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VehicleSys.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            String input[];
            while(scanner.hasNext())
            {
                input = scanner.nextLine().split(",");
                addVehicle(new Motorcycle(input[0],input[1],input[2],
                                                    Integer.parseInt(input[3]),
                                                    Double.parseDouble(input[4]),
                                                    Boolean.parseBoolean(input[5]),
                                                    Integer.parseInt(input[6]),
                                                    input[7],
                                                    Integer.parseInt(input[8])));          
            }
        }
        file = new File("minivan.txt");
        if(file.exists())
        {
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VehicleSys.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            String input[];
            while(scanner.hasNext())
            {
                input = scanner.nextLine().split(",");
                addVehicle(new Minivan(input[0],input[1],input[2],
                                                    Integer.parseInt(input[3]),
                                                    Double.parseDouble(input[4]),
                                                    Boolean.parseBoolean(input[5]),
                                                    Integer.parseInt(input[6]),
                                                    Double.parseDouble(input[7]),
                                                    Integer.parseInt(input[8])));
            }
        }
        return true;
    }
    
    public static void writeTextFile()
    {
        //CAR.TXT
        File file = new File("car.txt");
        PrintWriter writer;
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VehicleSys.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        ArrayList<Car> cars = getCars();
        for(int i = 0; i < cars.size(); i++)
            writer.println(cars.get(i).toStringForWriting());
        writer.close();
        //MOTOR.TXT
        file = new File("motor.txt");
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VehicleSys.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        ArrayList<Motorcycle> motors = getMotorcycles();
        for(int i = 0; i < motors.size(); i++)
            writer.println(motors.get(i).toStringForWriting());
        writer.close();
        //MINIVAN.TXT
        file = new File("minivan.txt");
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VehicleSys.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        ArrayList<Minivan> minivans = getMinivans();
        for(int i = 0; i < minivans.size(); i++)
            writer.println(minivans.get(i).toStringForWriting());
        writer.close();
    }
}
