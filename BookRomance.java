package Problem3;

/**
 * Concrete implementation of Book for romance books.
 * Implements specific late fee calculation for romance books.
 */
public class BookRomance extends Book {

    private int lateFeePerDayInDollar = 4;  // Late fee per day for romance books

    /**
     * Constructor to create a new romance book.
     * 
     * @param title  The title of the book
     * @param author The author of the book
     */
    public BookRomance(String title, String author) {
        super(title, author);
    }

    /**
     * Copy constructor - creates a copy of another romance book.
     * 
     * @param anotherBook The romance book to copy
     */
    public BookRomance(BookRomance anotherBook) {
        super(anotherBook);
    }

    /**
     * Gets the base late fee per day for romance books.
     * 
     * @return The late fee per day in dollars
     */
    @Override
    public int getLateFeeInDollar() {
        return lateFeePerDayInDollar;
    }

    /**
     * Calculates the late fee based on the number of days past due.
     * For romance books, the fee is the base rate times the number of days,
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
