import java.lang.reflect.Array;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }
    // Add a new book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully: " + book.getTitle());
    }

    // Add multiple books
    public void addBooks(ArrayList<Book> books) {
        this.books.addAll(books);
        System.out.println(books.size() + " added successfully.");
    }

    // Populate books
    public void populateBooks(ArrayList<Book> existingBooks) {
        books.addAll(existingBooks);
    }

    // Remove a book by ID

    // View all books
    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    // Search for a book by title or author


}
