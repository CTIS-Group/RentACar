/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gencturk
 */
public class deneme {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(VehicleSys.readTextFile())
            System.out.println("MUAZZAM");
        
        System.out.println(VehicleSys.getVehiclesInfo());        
        VehicleSys.addVehicle(new Car("34 AK 354","Mini","CooperS",2013,75,false,18,4,"Gas"));
        VehicleSys.writeTextFile();
    }
    
}
