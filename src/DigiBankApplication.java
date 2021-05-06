import java.util.Scanner;

public class DigiBankApplication {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to DigiBank..!!");
        System.out.println("Please enter Customer Name");
        String cName = scanner.nextLine();

        BankAccount obj = new BankAccount(cName);
        obj.showMenu();
    }
}


