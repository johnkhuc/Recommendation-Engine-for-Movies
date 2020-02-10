
/**
 * Rater Object for representing the profile of an individual
 * with ID and their associated list of Ratings
 * 
 * @author John Khuc
 */

import java.util.*;

public class OldRater implements Rater{
    // ******************************
    // Fields
    // ******************************
    private String myID;
    private ArrayList<Rating> myRatings;
    
    // ******************************
    // Constructors
    // ******************************
    /**
     * Constructor for Rater Object with ID.
     * Initializes new associated Ratings List
     * 
     * @param id: Person's ID
     */
    public OldRater(String id) {
        myID = id;
        myRatings = new ArrayList<Rating>();
    }
    
    // ******************************
    // Mutator and Accessor Methods
    // ******************************
    public String getID() {
        return myID;
    }
    public int numRatings() {
        return myRatings.size();
    }
    public HashMap<String,Rating> getMyRatings() {
        //STUB
        return null;
    }
    
    // ******************************
    // Public Methods
    // ******************************
    // Adds new ratings object to list for a given rater object
    public void addRating(String item, double rating) {
        myRatings.add(new Rating(item,rating));
    }
    
    // Checks if rater has a rating for given movie
    public boolean hasRating(String item) {
        for(int k=0; k < myRatings.size(); k++){
            if (myRatings.get(k).getItem().equals(item)){
                return true;
            }
        }
        return false;
    }

    // Gets rating of a movie if rater has rated it
    public double getRating(String item) {
        for(int k=0; k < myRatings.size(); k++){
            if (myRatings.get(k).getItem().equals(item)){
                return myRatings.get(k).getValue();
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
}
