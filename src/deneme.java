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
        if (VehicleSys.readTextFile()) {
            System.out.println("MUaZZaM");
        }
        
        Car car = new Car("34 BEG 615", "Mini", "CooperS", 2013, 75, false, 18, 4, "Gas");
/*
        System.out.println(VehicleSys.getVehiclesInfo());
        VehicleSys.addVehicle(car);
        VehicleSys.writeTextFile();
  */      
        SDate registerDate = new SDate("07", "07", "2007");
        SDate pickUpDate = new SDate("07", "05", "2017");
        SDate dropOffDate = new SDate("08", "06", "2018");
        SalesRepresentative salesGuy = new SalesRepresentative("354", "Bersin", "Karaisik", 5, 1500, 0.3);
        Customer custGuy = new Customer("5", "Sinber", "Isikkara", 16, registerDate);
        RentSys.addRent(new Rent(105, salesGuy, custGuy, pickUpDate, dropOffDate, car, 1500));
        
        SDate registerDate2 = new SDate("07", "07", "2007");
        SDate pickUpDate2 = new SDate("07", "05", "2017");
        SDate dropOffDate2 = new SDate("08", "06", "2018");
        SalesRepresentative salesGuy2 = new SalesRepresentative("354", "Bersin", "Karaisik", 5, 1500, 0.3);
        Customer custGuy2 = new Customer("5", "Sinber", "Isikkara", 16, registerDate);
        RentSys.addRent(new Rent(106, salesGuy2, custGuy2, pickUpDate2, dropOffDate2, car, 1500));
        System.out.println(RentSys.getRents().toString());
    }

}
