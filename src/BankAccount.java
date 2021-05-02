import java.util.Scanner;

public class BankAccount {

    double balance;
    double previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cname, String cid) {
        customerName = cname;
        customerId = cid;
    }

    void deposit(double amount) {
            balance = balance + amount;
            previousTransaction = amount;
            System.out.println("Deposit Successful");
            System.out.println("Total available balance in your account = Rs." + balance);
    }

    void withdraw(double amount) {
            balance = balance - amount;
            previousTransaction = -amount;
            System.out.println("Amount Successfully Withdrawn");
            System.out.println("Total available balance in your account = Rs." + balance);
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Credited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Debited: " + -previousTransaction);
        } else {
            System.out.println("No Transaction Occurred");
        }
    }

    void showMenu() {

        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your Id " + customerId);

        System.out.println("A: Check Your Balance");
        System.out.println("B: Deposit");
        System.out.println("C: Withdraw");
        System.out.println("D: Previous Transaction");
        System.out.println(" Exit The System");

        do {
            System.out.println("=*=*=*=*=*=*=*=*=*=*=");
            System.out.println("Enter Your Option");
            System.out.println("=*=*=*=*=*=*=*=*=*=*=");
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch (option) {
                case 'A':
                    System.out.println("------------------------------");
                    System.out.println("Balance = Rs." + balance);
                    System.out.println("------------------------------");
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("-------------------------------");
                    System.out.println("Enter an amount to deposit");
                    System.out.println("--------------------------------");

                    double amount = scanner.nextDouble();
                    while (amount <= 0){
                        System.out.println("Please enter a valid amount to deposit");
                        amount = scanner.nextDouble();
                    }
                        deposit(amount);
                        System.out.println("\n");

                    break;

                case 'C':
                    System.out.println("--------------------------------");
                    System.out.println("Enter an amount to withdraw");
                    System.out.println("--------------------------------");

                    double amount2 = scanner.nextDouble();
                    while(amount2 <= 0 || amount2 > balance){
                        if (amount2 <= 0){
                            System.out.println("Amount to be withdrawn must be greater than 0. Please try again.");
                        }
                        else {
                            System.out.println("Not enough balance available in your account.Please enter a lesser value.");
                        }
                        amount2 = scanner.nextDouble();
                    }
                    withdraw(amount2);
                    System.out.println("\n");
                    break;

                case 'D':
                    System.out.println("---------------------------------");
                    getPreviousTransaction();
                    System.out.println("---------------------------------");
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("===========================================================================");
                    break;

                default:
                    System.out.println("Invalid Option!! Please Enter Correct Option.....");
                    break;

            }
        }
        while (option != 'E');
        System.out.println("Thank You for Using our Services.....!!");
    }
}