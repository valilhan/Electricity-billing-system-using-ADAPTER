package com.company;

public interface InformationInterface {
    String name = "default";
    String Id = "default";
    MyDate dateRegistration = new MyDate(0, 0, 0);

    public String getName();

    public String getId();

    public MyDate getDateRegistration() ;

    public void printInfo() ;
}

