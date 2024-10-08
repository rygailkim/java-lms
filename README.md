# Library Management System

The Library Management System (LMS) is a console-based Java application that simulates a simple library. It will manage a collection of books, allow users to borrow and return them, and perform administrative tasks like searching for books and filtering by genre. The system will use key OOP principles such as **inheritance**, **encapsulation**, **abstraction**, and **polymorphism** to manage different types of books and users.


## Requirements
### Functional Requirements

1.  **User Management:**
    -   Users can register in the system with their name and system will generate them an ID.
    -   Users will have to login with their ID and password.
    -   Users can borrow and return books.
    -   Users can view a list of books they've borrowed.

2.  **Book Management:**
    -   Add, remove, and display books in the library.
    -   Books will have attributes: title, author, genre, availability status, and book ID.
    -   Search for books by title or author.
    -   Filter books by genre (e.g., Fiction, Non-Fiction, Science, etc.).
    -   Check if a book is available or currently borrowed.
    
3.  **Borrowing and Returning Books:**
    -   A user can borrow up to 3 books at a time.
    -   When a user borrows a book, its status changes to unavailable.
    -   A user must return a book before borrowing more.
    - 
4.  **Library Reports:**
    -   View all available books.
    -   View all borrowed books.

### **Non-functional Requirements**
-   Use object-oriented design to model the system (classes for `Book`, `User`, `Library`).
-   Maintain good coding practices, including proper variable names, modular code, and comments.

## Sample Output
    Welcome to the Library Management System!
    
    Adding new books:
    Book added: ID: 101, Title: "The Great Gatsby", Author: F. Scott Fitzgerald, Genre: Fiction, Available: true
    Book added: ID: 102, Title: "Sapiens", Author: Yuval Noah Harari, Genre: Non-Fiction, Available: true
    Book added: ID: 103, Title: "1984", Author: George Orwell, Genre: Science Fiction, Available: true
    
    User John registered with ID: 001
    User Jane registered with ID: 002
    
    John borrows "The Great Gatsby":
    John borrowed ID: 101, Title: "The Great Gatsby", Author: F. Scott Fitzgerald, Genre: Fiction, Available: false
    
    John tries to borrow the same book again:
    Book not available.
    
    Jane borrows "Sapiens":
    Jane borrowed ID: 102, Title: "Sapiens", Author: Yuval Noah Harari, Genre: Non-Fiction, Available: false
    
    Search for 'Sapiens':
    Search results for 'Sapiens':
    ID: 102, Title: "Sapiens", Author: Yuval Noah Harari, Genre: Non-Fiction, Available: false
    
    Filter books by Fiction:
    Books in genre 'Fiction':
    ID: 101, Title: "The Great Gatsby", Author: F. Scott Fitzgerald, Genre: Fiction, Available: false
    
    John returns "The Great Gatsby":
    John returned ID: 101, Title: "The Great Gatsby", Author: F. Scott Fitzgerald, Genre: Fiction, Available: true
    
    Jane views borrowed books:
    Jane's borrowed books:
    ID: 102, Title: "Sapiens", Author: Yuval Noah Harari, Genre: Non-Fiction, Available: false


