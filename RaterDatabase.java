
/**
 * Database Object of Raters for Easier Access
 * 
 * @author John Khuc
 */

import java.util.*;
import edu.duke.*;
import org.apache.commons.csv.*;

public class RaterDatabase {
    // ******************************
    // Fields
    // ******************************
    private static HashMap<String,Rater> ourRaters;
    
    // ******************************
    // Constructors
    // ******************************
    /**
     * Default Constructor for Database Object of Raters 
     * 
     * Initializes new HashMap of all Raters
     * Called from addRatings 
     */
    private static void initialize() {
        if (ourRaters == null) {
            ourRaters = new HashMap<String,Rater>();
        }
    }
    
    /**
     * Constructor for Database Object of Raters  
     * 
     * Initializes new HashMap of all Raters
     * Given data file 
     */
    public static void initialize(String raterfile) {
        if (ourRaters == null) {
            ourRaters= new HashMap<String,Rater>();
            addRatings("data/" + raterfile);
        }
    }   
    
    // ******************************
    // Mutator and Accessor Methods
    // ******************************
    public static Rater getRater(String id) {
        initialize();
        return ourRaters.get(id);
    }
    public static int size() {
        return ourRaters.size();
    }
    public static ArrayList<Rater> getRaters() {
        initialize();
        ArrayList<Rater> list = new ArrayList<Rater>(ourRaters.values());
        return list;
    }
    
    // ******************************
    // Public Methods
    // ******************************
    // Parse through given data file and extract raters and their ratings
    public static void addRatings(String filename) {
        initialize(); 
        FileResource fr = new FileResource(filename);
        CSVParser csvp = fr.getCSVParser();
        for(CSVRecord rec : csvp) {
                String id = rec.get("rater_id");
                String item = rec.get("movie_id");
                String rating = rec.get("rating");
                addRaterRating(id,item,Double.parseDouble(rating));
        } 
    }
    
    // Add new instance of a rater's rating given their ID
    public static void addRaterRating(String raterID, String movieID, double rating) {
        initialize(); 
        Rater rater =  null;
                if (ourRaters.containsKey(raterID)) {
                    rater = ourRaters.get(raterID); 
                } 
                else { 
                    rater = new FastRater(raterID);
                    ourRaters.put(raterID,rater);
                 }
                 rater.addRating(movieID,rating);
    }    
}
