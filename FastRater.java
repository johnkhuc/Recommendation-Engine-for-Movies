
/**
 * More efficient version of previous OldRater class using HashMaps Data Structure
 * 
 * @author John Khuc
 */

import java.util.*;
import edu.duke.*;

public class FastRater implements Rater{
    // ******************************
    // Fields
    // ******************************
    private String myID;
    private HashMap<String, Rating> myRatings;
    
    // ******************************
    // Constructors
    // ******************************
    /**
     * Constructor for Rater Object with ID.
     * Initializes new associated Ratings HashMap for (Movie, Rating)
     * 
     * @param id: Person's ID
     */
    public FastRater(String id) {
        myID = id;
        myRatings = new HashMap<String, Rating>();
    }
    
    // ******************************
    // Mutator and Accessor Methods
    // ******************************
    public String getID() {
        return myID;
    }
    public HashMap<String, Rating> getMyRatings() {
        return myRatings;
    }
    public int numRatings() {
        return myRatings.size();
    }
    
    // ******************************
    // Public Methods
    // ******************************
    // Adds new (Movie, Ratings) pair into hashmap of rater's ratings
    public void addRating(String item, double rating) {
        myRatings.put(item, new Rating(item,rating));
    }

    // Checks if rater has rated a given movie
    public boolean hasRating(String item) {
        return myRatings.containsKey(item);
    }

    // Get the rating of a movie if rater has rated it
    public double getRating(String item) {
        for (String movieId : myRatings.keySet()) {
            if (myRatings.get(movieId).getItem().equals(item)) {
                return myRatings.get(movieId).getValue();
            }
        }
        return -1;
    }

    // Returns list of items rated by a given rater
    public ArrayList<String> getItemsRated() {
        ArrayList<String> list = new ArrayList<String>();
        for(int k=0; k < myRatings.size(); k++){
            list.add(myRatings.get(k).getItem());
        }
        return list;
    }
    
    // Returns a string of the movie ratings information
    public String toString() {
        return "ID: " + myID + ", Rating: " + myRatings;
    }
}
