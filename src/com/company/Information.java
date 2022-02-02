package com.company;

public class Information implements InformationInterface {
    private String name;
    private String id;
    private MyDate dateRegistration;

    private Information() {}

    public Information(String name, String id, MyDate dateRegistration) {
        this.name = name;
        this.dateRegistration = dateRegistration;
    }

    //adapter from Person to Information
    public Information(PersonInformation info){
        this.name = info.getName() + info.getSurname();
        this.id = info.getPassport();
        this.dateRegistration = info.getDateRegistration();
    }

    //adapter from Organization to Information
    public Information(OrganizationInformation info){
        this.name = info.getName();
        this.id = info.getINN();
        this.dateRegistration = info.getDateRegistration();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public MyDate getDateRegistration() {
        return dateRegistration;
    }

    @Override
    public void printInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("ID: " + this.id);
        this.dateRegistration.printMyDate();
    }
}