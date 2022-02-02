package com.company;

public class PersonInformation {
    private String name;
    private String surname;
    private MyDate dateRegistration;
    private String passport;

    private PersonInformation() {}

    public PersonInformation(String name, String surname, String passport, MyDate dateRegistration) {
        this.name = name;
        this.surname = surname;
        this.dateRegistration = dateRegistration;
        this.passport = passport;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getPassport() {
        return this.passport;
    }

    public MyDate getDateRegistration() {
        return this.dateRegistration;
    }

    public void printInfo() {
        System.out.println("Name : " + this.name);
        System.out.println("Surname : " + this.surname);
        System.out.println("Passport : " + this.passport);
        this.dateRegistration.printMyDate();
    }
}
