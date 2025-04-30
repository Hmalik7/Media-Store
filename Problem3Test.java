import Problem3.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for the Media Store Management System.
 * Contains tests to verify the functionality of books and movies,
 * including tests to catch bugs in the equals methods.
 */
public class Problem3Test {
    /**
     * Test to catch the bug in Book's equals method.
     * The bug is that equals() checks more than just the ID.
     */
    @Test
    public void catchTheBugInBook() {
        // Create two identical books with different instances (different IDs)
        String title = "Testing Book";
        String author = "Test Author";
        String genre = "test";
        
        BookFiction book1 = new BookFiction(title, author, genre);
        
        // Create a new book with the same title and author but a different ID
        BookFiction book2 = new BookFiction(title, author, genre);
        
        // Create a copy to test correct implementation (copy constructor copies the ID)
        BookFiction book1Copy = new BookFiction(book1);
        
        // These books should NOT be equal because they have different IDs
        // despite having the same title and author
        assertFalse("Books with same title/author but different IDs should not be equal", 
                    book1.equals(book2));
                    
        // This verifies the copy constructor works (copies the ID)
        assertTrue("Book and its copy should be equal", 
                   book1.equals(book1Copy));
    }

    /**
     * Test to catch the bug in Movie's equals method.
     * The bug is that equals() checks more than just the ID.
     */
    @Test
    public void catchTheBugInMovie() {
        // Create two identical movies with different instances (different IDs)
        String rating = "PG";
        String title = "Test Movie";
        
        MovieAction movie1 = new MovieAction(rating, title);
        
        // Create a new movie with the same rating and title but a different ID
        MovieAction movie2 = new MovieAction(rating, title);
        
        // Create a copy to test correct implementation (copy constructor copies the ID)
        MovieAction movie1Copy = new MovieAction(movie1);
        
        // These movies should NOT be equal because they have different IDs
        // despite having the same rating and title
        assertFalse("Movies with same rating/title but different IDs should not be equal", 
                    movie1.equals(movie2));
                    
        // This verifies the copy constructor works (copies the ID)
        assertTrue("Movie and its copy should be equal", 
                   movie1.equals(movie1Copy));
    }

    // DO NOT REMOVE OR CHANGE ANYTHING BELOW THIS!
    
    /**
     * Tests the equals method for MovieAction objects.
     */
    @Test
    public void testMovieActionEquals() {
        String rating = "PG13";
        String title = "Pulp Fiction";

        MovieAction movie = new MovieAction(rating, title);
        MovieAction movieCopy = new MovieAction(movie);

        // things to consider: why is this "Equal"?
        assertTrue(movie.equals(movieCopy));

        MovieAction movieAnotherCopy = new MovieAction(rating, title);

        // things to consider: why is this "Not Equal"?
        assertFalse(movie.equals(movieAnotherCopy));
    }

    /**
     * Tests the equals method for MovieComedy objects.
     */
    @Test
    public void testMovieComedyEquals() {
        String rating = "G";
        String title = "Toy Story 4";

        MovieComedy movie = new MovieComedy(rating, title);
        MovieComedy movieCopy = new MovieComedy(movie);

        assertTrue(movie.equals(movieCopy));

        movieCopy = new MovieComedy(rating, title);
        assertFalse(movie.equals(movieCopy));
    }

    /**
     * Tests the equals method between different Movie subclasses.
     */
    @Test
    public void testMovieEquals() {
        Movie comedyMovie = new MovieComedy("R", "When Harry Met Sally...");
        Movie actionMovie = new MovieAction("R", "300");

        assertFalse(comedyMovie.equals(actionMovie));  // which equals is called here?
    }

    /**
     * Tests the equals method for BookFiction objects.
     */
    @Test
    public void testBookFictionEquals() {
        String title = "Sun Also Rises";
        String author = "Ernest Hemingway";
        String genre = "historical";

        BookFiction book = new BookFiction(title, author, genre);
        BookFiction bookCopy = new BookFiction(book);
        assertTrue(book.equals(bookCopy));

        bookCopy = new BookFiction(title, author, genre);
        assertFalse(book.equals(bookCopy));
    }

    /**
     * Tests the equals method for BookRomance objects.
     */
    @Test
    public void testBookRomanceEquals() {
        String title = "Love Story";
        String author = "Erich Segal";

        BookRomance romanceMovie = new BookRomance(title, author);
        BookRomance fc = new BookRomance(romanceMovie);
        assertTrue(romanceMovie.equals(fc));

        fc = new BookRomance(title, author);
        assertFalse(romanceMovie.equals(fc));
    }

    /**
     * Tests the equals method between different Book subclasses.
     */
    @Test
    public void testBookEquals() {
        String title = "Pride and Prejudice";
        String author = "Jane Austen";

        Book fictionBook = new BookFiction(title, author, "romance");
        Book romanceBook = new BookRomance(title, author);

        assertFalse(fictionBook.equals(romanceBook)); // why is this False? Are they not the same book?
    }

    /**
     * Tests the late fee calculation for BookFiction objects.
     */
    @Test
    public void testBookFictionCalcLateFees() {
        Book bookFiction = new BookFiction("Murder on the Orient Express",
                "Agatha Christie", "crime novel");

        for (int numOfDaysPastDue = -5; numOfDaysPastDue < 5; numOfDaysPastDue++) {
            int fees = bookFiction.calcLateFees(numOfDaysPastDue);
            assertEquals(fees, Math.max(numOfDaysPastDue, 0) * bookFiction.getLateFeeInDollar());
        }
    }

    /**
     * Tests the late fee calculation for BookRomance objects.
     */
    @Test
    public void testBookRomanceCalcLateFees() {
        Book bookRomance = new BookRomance("Gone with the Wind", "Margaret Mitchell");

        for (int numOfDaysPastDue = -5; numOfDaysPastDue < 5; numOfDaysPastDue++) {
            int fees = bookRomance.calcLateFees(numOfDaysPastDue);
            assertEquals(fees, Math.max(numOfDaysPastDue, 0) * bookRomance.getLateFeeInDollar());
        }
    }

    /**
     * Tests the late fee calculation for MovieAction objects,
     * including the special case for 5+ days late.
     */
    @Test
    public void testMovieActionCalcLateFees() {
        Movie movieAction = new MovieAction("PR-13", "Die Hard");

        for (int numOfDaysPastDue = -5; numOfDaysPastDue < 5; numOfDaysPastDue++) {
            int fees = movieAction.calcLateFees(numOfDaysPastDue);
            assertEquals(fees, Math.max(numOfDaysPastDue, 0) * movieAction.getLateFeeInDollar());
        }

        for (int numOfDaysPastDue = 5; numOfDaysPastDue <= 10; numOfDaysPastDue++) {
            int fees = movieAction.calcLateFees(numOfDaysPastDue);
            assertEquals(fees, 2 * numOfDaysPastDue * movieAction.getLateFeeInDollar());
        }
    }

    /**
     * Tests the late fee calculation for MovieComedy objects.
     */
    @Test
    public void testMovieComedyCalcLateFees() {
        Movie movieComedy = new MovieComedy("R", "Deadpool 3");

        for (int numOfDaysPastDue = -5; numOfDaysPastDue < 10; numOfDaysPastDue++) {
            int fees = movieComedy.calcLateFees(numOfDaysPastDue);
            assertEquals(fees, Math.max(numOfDaysPastDue, 0) * movieComedy.getLateFeeInDollar());
        }
    }

    /**
     * Tests the late fee calculation across all media types.
     */
    @Test
    public void testStoreMediaCalcLateFees() {
        StoreMediaOperations[] storeMedias = new StoreMediaOperations[4];

        storeMedias[0] = new BookFiction("Vingt mille lieues sous les mers",
                "Jules Gabriel Verne", "sci-fi");
        storeMedias[1] = new BookRomance("A Room With A View", "E.M. Forster");
        storeMedias[2] = new MovieAction("PG-13", "Fast Five");
        storeMedias[3] = new MovieComedy("G", "Ratatouille");

        int dayMissed = 10;

        int lateFees = 0;
        for (StoreMediaOperations storeMediaOperations : storeMedias) {
            lateFees += storeMediaOperations.calcLateFees(dayMissed);
        }

        int expect = 0;
        for (StoreMediaOperations storeMediaOperations : storeMedias) {
            int factor = (storeMediaOperations instanceof MovieAction) ? 2 : 1;
            expect += storeMediaOperations.getLateFeeInDollar() * dayMissed * factor;
        }

        assertEquals(expect, lateFees);
    }
}
