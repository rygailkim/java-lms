import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Library library = new Library();
    private static Authentication auth = new Authentication();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        populateLibrary();

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
            System.out.println("\nWelcome " + user.getName() + "!");

            if (user.isAdmin()) {
                adminMenu(scanner, user);
            } else {
                userMenu(scanner, user);
            }

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

    private static void userMenu(Scanner scanner, User user) {
        int choice = 0;
        boolean isLoggedIn = true;
        while (isLoggedIn) {
            System.out.println("\n1. View All Books");
            System.out.println("2. Search for a Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Borrowed Books");
            System.out.println("6. Logout\n");

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
                    library.viewAllBooks();
                    break;
                case 2:
                    searchBook(scanner);
                    break;
                case 3:
                    borrowBook(scanner, user);
                    break;
                case 4:
                    returnBook(scanner, user);
                    break;
                case 5:
                    user.getBorrowedBooks();
                    break;
                case 6:
                    System.out.println("Logging out...");
                    isLoggedIn = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void adminMenu(Scanner scanner, User user) {
        int choice = 0;
        boolean isLoggedIn = true;
        while (isLoggedIn) {
            System.out.println("\n1. Add a Book");
            System.out.println("2. Remove a Book");
            System.out.println("3. View All Books");
            System.out.println("4. Search for a Book");
            System.out.println("5. Logout\n");

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
                    addBook(scanner);
                    break;
                case 2:
                    removeBook(scanner);
                    break;
                case 3:
                    library.viewAllBooks();
                    break;
                case 4:
                    searchBook(scanner);
                    break;
                case 5:
                    System.out.println("Logging out...");
                    isLoggedIn = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void populateLibrary() {
        ArrayList<Book> existingBooks = new ArrayList<>();
        existingBooks.add(new Book("1", "To Kill a Mockingbird", "Harper Lee", "Fiction", true));
        existingBooks.add(new Book("2", "1984", "George Orwell", "Dystopian", true));
        existingBooks.add(new Book("3", "The Great Gatsby", "F. Scott Fitzgerald", "Fiction", true));
        existingBooks.add(new Book("4", "Moby Dick", "Herman Melville", "Adventure", true));
        existingBooks.add(new Book("5", "Pride and Prejudice", "Jane Austen", "Romance", true));

        library.populateBooks(existingBooks);

    }

    private static void addBook(Scanner scanner) {
        System.out.println("Enter title: ");
        String title = scanner.nextLine();

        System.out.println("Enter author: ");
        String author = scanner.nextLine();

        System.out.println("Enter genre: ");
        String genre = scanner.nextLine();

        // Generate book ID
        Book lastBook = library.getBooks().get(library.getBooks().size() - 1);
        String bookID = String.valueOf(lastBook.getBookID() + 1);
        Book newBook = new Book(bookID, title, author, genre, true);
        library.addBook(newBook);
    }

    private static void removeBook(Scanner scanner) {
        System.out.println("Enter ID of book to be removed: ");
        String bookID = scanner.nextLine();
        library.removeBook(bookID);
    }

    private static void searchBook(Scanner scanner) {
        System.out.println("Enter title or author: ");
        String keyword = scanner.nextLine();
        library.searchBook(keyword);
    }

    private static void borrowBook(Scanner scanner, User user) {
        System.out.println("Enter Book ID to borrow:");
        String bookID = scanner.nextLine();
        Book book = library.getBookByID(bookID);
        if (book != null) {
            if (book.isAvailable()) {
                user.borrowBook(book);
                System.out.println(book.getTitle() + " borrowed successfully!");
            } else {
                System.out.println("Book is currently not available.");
            }
        } else {
            System.out.println("Book ID is invalid.");
        }
    }

    private static void returnBook(Scanner scanner, User user) {
        System.out.println("Enter Book ID to return:");
        String bookID = scanner.nextLine();
        for (Book book: user.getBorrowedBooks()) {
            if (library.getBookByID(bookID) != null) {
                user.returnBook(book);
                System.out.println(book.getTitle() + " returned successfully!");
                return;
            }
        }

        System.out.println("Invalid Book ID.");
    }
}