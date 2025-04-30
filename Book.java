package Problem3;

import java.util.UUID;

/**
 * Abstract base class for all book types.
 * Implements the StoreMediaOperations interface and provides common
 * functionality for different book categories.
 */
public abstract class Book implements StoreMediaOperations {
    UUID id;        // Unique identifier for each book
    String title;   // Book title
    String author;  // Book author

    /**
     * Constructor to create a new book with a unique ID.
     * 
     * @param title  The title of the book
     * @param author The author of the book
     */
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.id = UUID.randomUUID();  // Generate a unique ID for this book
    }

    /**
     * Copy constructor - creates a copy of another book.
     * Note: The ID is copied as well, meaning the copy is considered
     * the same book identity-wise.
     * 
     * @param anotherBook The book to copy
     */
    public Book(Book anotherBook) {
        this.id = anotherBook.id;      // Copy the ID (important for equality)
        this.title = anotherBook.title;
        this.author = anotherBook.author;
    }

    /**
     * Determines if this book is equal to another object.
     * The current implementation has a bug - it checks too many properties.
     * 
     * @param obj The object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;  // Same instance - always equal
        }

        if (!(obj instanceof Book)) {
            return false; // Not a Book - cannot be equal
        }

        Book theOtherBook = (Book) obj;

        // TODO, Quiz: add unit tests to catch a bug.

        // Here is the WRONG implementation (the bug)
        return id.equals(theOtherBook.id) &&
                author.equals(theOtherBook.author) &&
                title.equals(theOtherBook.title);

        // The bug is caught when
        //  1. newly added tests fail while all previous tests still pass
        //  2. fix the bug with the code below, and now all tests (new and old) pass

        // And the fix to this bug is here
        // return id.equals(theOtherBook.id);
    }
}
