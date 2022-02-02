package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Database MyDatabase = Database.getInstance();
        Scanner scan = new Scanner(System.in);
        System.out.println("We welcome to our program, you will need to set server date");
        System.out.println("then you will have options what to do, don't forget to sign up!!!\n");
        int Option;
        do {
            Functionality.PrintUserOption();
            Option = scan.nextInt();
            switch (Option){
                case 0:
                    Functionality.PastDays(MyDatabase, scan);
                    break;
                case 1:
                    Functionality.Login(MyDatabase, scan);
                    break;
                case 2:
                    Functionality.SignUp(MyDatabase, scan);
                    break;
                default:
                    break;
            }
        }
        while( Option >= 0 && 2 >= Option );
    }
}
