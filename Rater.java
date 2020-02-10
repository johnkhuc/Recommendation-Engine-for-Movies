
/**
 * Interface for Refactoring Rater for Efficiency
 * 
 * @author John Khuc
 */

import java.util.*;

public interface Rater {
    public void addRating(String item, double rating);
    public boolean hasRating(String item);
    public String getID();
    public HashMap<String, Rating> getMyRatings();
    public double getRating(String item);
    public int numRatings();
    public ArrayList<String> getItemsRated();
}
