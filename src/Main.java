import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Library Management System!");

        int choice = 0;

        while (true) {
            System.out.println("\n1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit \n");

            System.out.print("Please select an option: ");
            boolean validInput = false;
            do {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    validInput = true;
                } else {
                    System.out.print("Your input is incorrect. Please enter a number: ");
                    scanner.nextLine();
                }
            } while (!validInput);

            switch(choice) {
                case 1:
                    System.out.println("Logging in...");
                    break;
                case 2:
                    System.out.println("Registering...");
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}