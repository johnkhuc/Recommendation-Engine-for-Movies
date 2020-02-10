
/**
 * Class for explicitly defining filter
 * 
 * @author John Khuc 
 */

public class TrueFilter implements Filter {
    // ******************************
    // Public Methods
    // ******************************
    // Checks if Movie Objects in the Movie Database satisfies condition
    @Override
    public boolean satisfies(String id) {
    	return true;
    }
}

