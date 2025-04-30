package Problem3;

/**
 * Concrete implementation of Book for fiction books.
 * Adds genre-specific functionality and implements the late fee calculation.
 */
public class BookFiction extends Book {

    private int lateFeePerDayInDollar = 2;  // Late fee per day for fiction books
    private String genres;                  // The genres this fiction book belongs to

    /**
     * Constructor to create a new fiction book.
     * 
     * @param title  The title of the book
     * @param author The author of the book
     * @param genres The genres this book belongs to
     */
    public BookFiction(String title, String author, String genres) {
        super(title, author);
        this.genres = genres;
    }

    /**
     * Copy constructor - creates a copy of another fiction book.
     * 
     * @param anotherBook The fiction book to copy
     */
    public BookFiction(BookFiction anotherBook) {
        super(anotherBook);
        this.genres = anotherBook.genres;
    }

    /**
     * Gets the base late fee per day for fiction books.
     * 
     * @return The late fee per day in dollars
     */
    @Override
    public int getLateFeeInDollar() {
        return lateFeePerDayInDollar;
    }

    /**
     * Calculates the late fee based on the number of days past due.
     * For fiction books, the fee is the base rate times the number of days,
     * with no fee if returned on time or early.
     * 
     * @param numOfDaysPastDue The number of days past due
     * @return The calculated late fee in dollars
     */
    @Override
    public int calcLateFees(int numOfDaysPastDue) {
        if (numOfDaysPastDue <= 0) {
            return 0;  // No late fee if returned on time or early
        }
        return lateFeePerDayInDollar * numOfDaysPastDue;
    }
}
