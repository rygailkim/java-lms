import java.util.ArrayList;

public class User {
    private String userID;
    private String name;
    private String password;
    private ArrayList<Book> borrowedBooks;

    public User (String userID, String name, String password) {
        this.userID = userID;
        this.name = name;
        this.password = password;
        this.borrowedBooks = new ArrayList<>();
    }
    // Borrow book

    // Return book

    // Get borrowed books

}
