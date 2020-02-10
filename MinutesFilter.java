
/**
 * Class for filtering duration of movies
 * 
 * @author John Khuc
 */

public class MinutesFilter implements Filter{
    // ******************************
    // Fields
    // ******************************
    private int myMin;
    private int myMax;

    // ******************************
    // Constructors
    // ******************************
    /**
     * Contructor for Genre Filter
     * Given range of minutes  
     */
    public MinutesFilter(int min, int max) {
        myMin = min;
        myMax = max;
    }
    
    // ******************************
    // Public Methods
    // ******************************
    // Checks if Movie Objects in the Movie Database are within given minute range
    @Override
    public boolean satisfies(String id) {
        return ((MovieDatabase.getMinutes(id) >= myMin) && (MovieDatabase.getMinutes(id) <= myMax));
    }
}
