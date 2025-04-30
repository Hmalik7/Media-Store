package Problem3;

/**
 * Interface that defines required operations for all media items in the store.
 * Any class implementing this interface must provide methods for calculating
 * late fees and retrieving the base late fee rate.
 */
public interface StoreMediaOperations {
    /**
     * Calculates late fees based on the number of days past due.
     * 
     * @param numOfDaysPastDue The number of days the item is past due
     * @return The total late fees in dollars
     */
    int calcLateFees(int numOfDaysPastDue);

    /**
     * Gets the base late fee per day in dollars.
     * 
     * @return The late fee rate per day in dollars
     */
    int getLateFeeInDollar();
}
