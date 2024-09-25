import java.util.ArrayList;

public class User {
    private String userID;
    private String name;
    private String password;
    private boolean isAdmin;
    private ArrayList<Book> borrowedBooks;

    public User (String userID, String name, String password, boolean isAdmin) {
        this.userID = userID;
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters and setters
    public String getUserID() { return userID; }
    public String getName() { return name; }
    public String getPassword() { return password; }
    public ArrayList<Book> getBorrowedBooks() { return borrowedBooks; }


    // Borrow book

    // Return book

    // Get borrowed books

}
