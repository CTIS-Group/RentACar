
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
    private SDate registerDate;

    public Customer(String ssn, String name, String surname, int age, SDate registerDate) {
        super(ssn, name, surname, age);
        this.registerDate = registerDate;
    }

    public SDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(SDate registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return super.toString() + "Customer{" + "registerDate=" + registerDate + '}';
    }
    
    public String toStringForWriting()
    {
        //ssn,name,surname,age,registerDate
        return ssn + "," + name + "," + surname + "," + age + "," + registerDate.toString();
    }
}
