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
    public boolean isAdmin() { return isAdmin; }
    public ArrayList<Book> getBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books available in the library.");
            return null;
        } else {
            for (Book book : borrowedBooks) {
                System.out.println(book);
            }
        }

        return borrowedBooks;
    }


    // Borrow book
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.setAvailable(false);
    }

    // Return book
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.setAvailable(true);
    }

    @Override
    public String toString() {
        return "User: " + name + "(ID: " + userID + ")";
    }

}
