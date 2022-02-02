package com.company;

public class OrganizationInformation {
    private String name;
    private String INN;
    private MyDate dateRegistration;

    private OrganizationInformation(){;}
    
    public OrganizationInformation(String name, String INN, MyDate dateRegistration) {
        this.name = name;
        this.INN = INN;
        this.dateRegistration = dateRegistration;
    }

    public String getName() {
        return this.name;
    }

    public String getINN() {
        return this.INN;
    }

    public MyDate getDateRegistration() {
        return this.dateRegistration;
    }

    public void printInfo() {
        System.out.println("Name : " + this.name);
        System.out.println("INN : " + this.INN);
        System.out.println("date : " + this.dateRegistration);
    }

}
