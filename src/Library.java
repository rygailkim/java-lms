import java.lang.reflect.Array;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks(){
        return books;
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
    public void removeBook (String bookID) {
        System.out.println("Removing " + bookID);
        books.removeIf(book -> book.getBookID().equals(bookID));
    }

    // View all books
    public ArrayList<Book> viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return null;
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }

        return books;
    }

    // Search for a book by title or author
    public Book searchBook(String keyword) {
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) || book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(book);
                return book;
            }
        }

        System.out.println("Book is not in library.");
        return null;
    }

}
