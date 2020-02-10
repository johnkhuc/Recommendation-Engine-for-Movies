/**
 * Rating Data Object for Rater
 * 
 * @author John Khuc
 */

// An immutable passive data object (PDO) to represent the rating data
public class Rating implements Comparable<Rating> {
    // ******************************
    // Fields
    // ******************************
    private String item;
    private double value;
   
    // ******************************
    // Constructors
    // ******************************
    /**
     * Constructor for Rating Object
     * 
     * @param anItem: The movie ID, aValue: The rating for that movie 
     */
    public Rating (String anItem, double aValue) {
        item = anItem;
        value = aValue;
    }
    
    // ******************************
    // Mutator and Accessor Methods
    // ******************************
    public String getItem () {
        return item;
    }
    public double getValue () {
        return value;
    }
    
    // ******************************
    // Public Methods
    // ******************************
    // Returns a string of the ratings information
    public String toString () {
        return "[" + getItem() + ", " + getValue() + "]";
    }
    
    // Compares ratings 
    public int compareTo(Rating other) {
        if (value < other.value) return -1;
        if (value > other.value) return 1;
        
        return 0;
    }
}
