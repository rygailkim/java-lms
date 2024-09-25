public class Book {
    private String bookID;
    private String title;
    private String author;
    private String genre;
    private boolean isAvailable;

    public Book(String bookID, String title, String author, String genre, boolean isAvailable) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
    }

    // getters and setters
    public String getBookID() {
        return bookID;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getGenre() {
        return genre;
    }
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
