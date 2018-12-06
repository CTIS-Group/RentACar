
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
public class Customer extends Person{
    private Date registerDate;

    public Customer(String ssn, String name, String surname, int age, Date registerDate) {
        super(ssn, name, surname, age);
        this.registerDate = registerDate;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return super.toString() + "Customer{" + "registerDate=" + registerDate + '}';
    }

    
    
    
}
