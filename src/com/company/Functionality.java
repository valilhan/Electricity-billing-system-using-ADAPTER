package com.company;

import java.util.Scanner;

public class Functionality {
    public static void PrintUserOption(){
        System.out.println("Enter 0 for passing K number of days");
        System.out.println("Enter 1 to login to system");
        System.out.println("Enter 2 to sign up to system");
        System.out.println("Enter 3 or any other number to finish program");
        System.out.println();
    }

    public static void PrintAccountOption(){
        System.out.println("Enter 0 for making payment");
        System.out.println("Enter 1 for printing summary of bills");
        System.out.println("Enter 2 to know how much you dept");
        System.out.println("Enter 3 to see your current balance");
        System.out.println("Enter 4 to set a new password for your account");
        System.out.println("Enter 5 to delete your account and tore the contract");
        System.out.println("Enter 6 to see your information");
        System.out.println("Enter 7 or any other number to logout");
        System.out.println();
    }

    public static void PastDays(Database MyDatabase, Scanner scan){
        System.out.print("Enter number of days: ");
        int k = scan.nextInt();
        for(int i = 1; i <= k; i ++){
            MyDatabase.CurrentDate.increaseDay();
            MyDatabase.calculateCosts();
        }
    }

    public static void Login(Database MyDatabase, Scanner scan){
        System.out.print("Enter your email: ");
        String email2=scan.next();
        System.out.print("Enter your password: ");
        String password2=scan.next();
        Account _account2 = new Account(email2, password2);
        Customer loginedCustomer = MyDatabase.getCostumer(_account2);
        if( loginedCustomer == null ){
            System.out.println("***ERROR: There is no such account in the system!");
            return;
        }
        int loginOption = 0;
        do{

            Functionality.PrintAccountOption();

            loginOption = scan.nextInt();
            switch (loginOption){
                case 0:
                    System.out.print("How much do you want to pay: ");
                    int payment = scan.nextInt();
                    loginedCustomer.makePayment(payment);
                    break;
                case 1:
                    if( loginedCustomer.getSummary().isEmpty() ){
                        System.out.println("There is no any bills!");
                    }
                    else{
                        System.out.println("List of bills : ");
                        for (Bill bill : loginedCustomer.getSummary()) {
                            System.out.println(Integer.toString(bill.getYear()) + " " + Integer.toString(bill.getMonth()) + " " + Float.toString(bill.getPrice()));
                        }
                    }
                    break;
                case 2:
                    System.out.print("** Your debt is : ");
                    System.out.println(loginedCustomer.getRemainder());
                    break;
                case 3:
                    System.out.print("** Your balance is : ");
                    System.out.println(loginedCustomer.getBalance());
                    break;
                case 4:
                    System.out.print("Enter your new password : ");
                    String newPassword = scan.next();
                    loginedCustomer.account.setPassword(newPassword);
                    break;
                case 5:
                    if(loginedCustomer.isDebtor){
                        System.out.println("Bacause of your deptency, you can't tore the contract, please pay " + loginedCustomer.getRemainder() + " to tore the contract");
                        loginOption = 0;
                        break;
                    }
                    MyDatabase.deleteCustomer(loginedCustomer);
                    System.out.println("** You successfully deleted your account. Money on your balance was sent to your credit card");
                    break;
                case 6:
                    loginedCustomer.getInfo().printInfo();
                    break;
                default:
                    break;
            }
        } while( loginOption >= 0 && 4 >= loginOption );
    }

    public static void SignUp(Database MyDatabase, Scanner scan){
        System.out.print("Enter your email: ");
        String email=scan.next();
        if( MyDatabase.accountExist(email) ){
            System.out.println("This account already exist");
            return;
        }
        System.out.print("Enter your password: ");
        String password=scan.next();

        Account _account = new Account(email,password);

        Information _information = null;
        int InfoOption;
        System.out.println("Enter 0 if you are organization");
        System.out.println("Enter 1 if you are a person");
        InfoOption = scan.nextInt();

        switch (InfoOption) {
            case (0):
                System.out.println("Enter the name of your organization");
                String OrganizationName = scan.next();

                System.out.println("Enter the INN of your organization");
                String INN = scan.next();

                MyDate OrganizationDate = MyDatabase.CurrentDate;

                var newOrganization = new OrganizationInformation(OrganizationName, INN, OrganizationDate);
                _information = new Information(newOrganization);
                break;
            case(1):
                System.out.print("Enter your name: ");
                String PersonName = scan.next();

                System.out.print("Enter your surname: ");
                String PersonSurname = scan.next();

                System.out.print("Enter your passport id: ");
                String PersonPassport=scan.next();

                MyDate PersonDate = MyDatabase.CurrentDate;

                var newPerson = new PersonInformation(PersonName, PersonSurname, PersonPassport, PersonDate);
                _information = new Information(newPerson);
                break;
            default:
                break;
        }

        Bill _bill = new Bill(MyDatabase.CurrentDate.getMonth(), MyDatabase.CurrentDate.getYear(), 0, false);
        Customer _customer = new Customer(_information, _account, _bill);

        MyDatabase.addCustomer(_customer);
    }
}
