
/**
 * Class for easier adding of filters in a centralized object
 * Allows for more flexible, easier to understand 
 * 
 * @author John Khuc
 */

import java.util.ArrayList;

public class AllFilters implements Filter {
    // ******************************
    // Fields
    // ******************************
    ArrayList<Filter> filters;
    
    // ******************************
    // Constructors
    // ******************************
    /**
     * Default Contructor for All Filters 
     */
    public AllFilters() {
        filters = new ArrayList<Filter>();
    }
    
    // ******************************
    // Public Methods
    // ******************************
    // Adds a filter into allfilters object's filter list
    public void addFilter(Filter f) {
        filters.add(f);
    }
    
    // Checks if Movie Objects in the Movie Database satisfies all filter criterias
    @Override
    public boolean satisfies(String id) {
        for(Filter f : filters) {
            if (! f.satisfies(id)) {
                return false;
            }
        }
        return true;
    }
}
