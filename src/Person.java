/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gencturk
 */
public abstract class Person implements FileInterface{
    protected String ssn,
            name,
            surname;
    protected int age;

    public Person(String ssn, String name, String surname, int age) {
        this.ssn = ssn;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getSsn() {
        return ssn;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SSN: " + ssn + "\nName: " + name + "\nSurname: " + surname + "\nAge: " + age;
    }
    
    
}
