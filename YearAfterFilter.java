
/**
 * Class for filtering movies created after given year
 * 
 * @author John Khuc
 */

public class YearAfterFilter implements Filter {
    // ******************************
    // Fields
    // ******************************
    private int myYear;

    // ******************************
    // Constructors
    // ******************************
    /**
     * Contructor for YearAfter Filter
     * Given year
     */
    public YearAfterFilter(int year) {
    	myYear = year;
    }
    
    // ******************************
    // Public Methods
    // ******************************
    // Checks if Movie Objects in the Movie Database have been made after given year
    @Override
    public boolean satisfies(String id) {
    	return MovieDatabase.getYear(id) >= myYear;
    }
}

