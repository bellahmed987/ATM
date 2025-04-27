package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner=new Scanner(System.in);
        Atm atm=new Atm();
        System.out.println("Enter PIN:");
        int userpin=scanner.nextInt();
        if(!atm.authenticate(userpin)){
            System.out.println("Incorrect PIN. Access Denied.");
            return;
        }
        int choice;
        do {
            atm.displaymenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
switch (choice){
    case  1 :
        atm.checkBalance();
        break;
    case  2 :
        System.out.println("Enter amount to withdraw");
        double amount=scanner.nextDouble();
        atm.withdrawmoney(amount);
        break;
    case 3: // Exit
        System.out.println("Exiting... Thank you for using the ATM!");
        break;
    default:
        System.out.println("Invalid choice! Please try again.");
}

        }while (choice !=3);

    }
    public static class Atm{
        private double balance=20000;
        private int pin=1234;
        public boolean authenticate(int userpin){
return  userpin==pin;
        }
        public  void displaymenu(){
            System.out.println("ATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Exit");
        }
        public void checkBalance() {
            System.out.println("Your current balance is: $" + balance);
        }
        public void withdrawmoney(double amount){
            if(amount <=balance){
                balance-=amount;
                System.out.println("Successfully withdrew: $" + amount);
            }
            else {
                System.out.println("Insufficient funds!");
            }
        }
    }
}