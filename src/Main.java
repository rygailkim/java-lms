import java.util.Scanner;

public class Main {
    private static Library library = new Library();
    private static Authentication auth = new Authentication();
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

            scanner.nextLine();
            switch (choice) {
                case 1:
                    userLogin(scanner);
                    break;
                case 2:
                    registerUser(scanner);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void userLogin(Scanner scanner) {
        System.out.print("Enter user ID: ");
        String userID = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = auth.userLogin(userID, password);
        if (user != null) {
            System.out.println("Welcome " + user.getName() + "!");
        }
    }

    private static void registerUser(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User newUser = auth.registerUser(name, password);
        System.out.println("Registration successful! Your User ID is: " + newUser.getUserID());
    }
}