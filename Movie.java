package Problem3;

import java.util.UUID;

/**
 * Abstract base class for all movie types.
 * Implements the StoreMediaOperations interface and provides common
 * functionality for different movie categories.
 */
public abstract class Movie implements StoreMediaOperations {
    String rating;  // Movie rating (PG, PG-13, R, etc.)
    String title;   // Movie title
    UUID id;        // Unique identifier for each movie

    /**
     * Constructor to create a new movie with a unique ID.
     * 
     * @param rating The rating of the movie
     * @param title  The title of the movie
     */
    public Movie(String rating, String title) {
        this.rating = rating;
        this.title = title;
        this.id = UUID.randomUUID();  // Generate a unique ID for this movie
    }

    /**
     * Copy constructor - creates a copy of another movie.
     * Note: The ID is copied as well, meaning the copy is considered
     * the same movie identity-wise.
     * 
     * @param anotherMovie The movie to copy
     */
    public Movie(Movie anotherMovie) {
        this.rating = anotherMovie.rating;
        this.title = anotherMovie.title;
        this.id = anotherMovie.id;  // Copy the ID (important for equality)
    }

    /**
     * Determines if this movie is equal to another object.
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

        if (!(obj instanceof Movie)) {
            return false; // Not a Movie - cannot be equal
        }

        Movie theOtherMovie = (Movie) obj;

        // TODO, Quiz: add unit tests to catch this bug.

        // Here is the WRONG implementation (the bug)
        return id.equals(theOtherMovie.id) &&
                rating.equals(theOtherMovie.rating) &&
                title.equals(theOtherMovie.title);

        // The bug is caught when
        //  1. newly added tests fail while all previous tests still pass
        //  2. fix the bug with the code below, and now all tests (new and old) pass

        // Fix to this bug is here
        // return id.equals(theOtherMovie.id);
    }
}
