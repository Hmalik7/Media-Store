package Problem3;

/**
 * Concrete implementation of Movie for comedy movies.
 * Implements specific late fee calculation for comedy movies.
 */
public class MovieComedy extends Movie {
    private int lateFeePerDayInDollar = 3;  // Late fee per day for comedy movies

    /**
     * Constructor to create a new comedy movie.
     * 
     * @param rating The rating of the movie
     * @param title The title of the movie
     */
    public MovieComedy(String rating, String title) {
        super(rating, title);
    }

    /**
     * Copy constructor - creates a copy of another comedy movie.
     * 
     * @param anotherMovie The comedy movie to copy
     */
    public MovieComedy(MovieComedy anotherMovie) {
        super(anotherMovie);
    }

    /**
     * Gets the base late fee per day for comedy movies.
     * 
     * @return The late fee per day in dollars
     */
    @Override
    public int getLateFeeInDollar() {
        return lateFeePerDayInDollar;
    }

    /**
     * Calculates the late fee based on the number of days past due.
     * For comedy movies, the fee is the base rate times the number of days,
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
