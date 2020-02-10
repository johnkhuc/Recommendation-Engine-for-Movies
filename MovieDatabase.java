/**
 * Database Object of Movies for Easier Access
 * 
 * @author John Khuc
 */

import java.util.*;
import edu.duke.*;
import org.apache.commons.csv.*;

public class MovieDatabase {
    // ******************************
    // Fields
    // ******************************
    private static HashMap<String, Movie> ourMovies;
    
    // ******************************
    // Constructors
    // ******************************
    /**
     * Default Constructor for Database Object of Movies 
     * 
     * Initializes new HashMap of all Raters
     * Reads from default data file 
     */
    private static void initialize() {
        if (ourMovies == null) {
            ourMovies = new HashMap<String,Movie>();
            loadMovies("data/ratedmoviesfull.csv");
        }
    }   
    
     /**
     * Constructor for Database Object of Raters  
     * 
     * Initializes new HashMap of Movie ID's and their information
     * Reads from given data file 
     */
    public static void initialize(String moviefile) {
        if (ourMovies == null) {
            ourMovies = new HashMap<String,Movie>();
            loadMovies("data/" + moviefile);
        }
    }

    // ******************************
    // Mutator and Accessor Methods
    // ******************************
    public static String getGenres(String id) {
        initialize();
        return ourMovies.get(id).getGenres();
    }
    public static String getTitle(String id) {
        initialize();
        return ourMovies.get(id).getTitle();
    }
    public static Movie getMovie(String id) {
        initialize();
        return ourMovies.get(id);
    }
    public static String getPoster(String id) {
        initialize();
        return ourMovies.get(id).getPoster();
    }
    public static String getCountry(String id) {
        initialize();
        return ourMovies.get(id).getCountry();
    }
    public static String getDirector(String id) {
        initialize();
        return ourMovies.get(id).getDirector();
    }  
    public static int getYear(String id) {
        initialize();
        return ourMovies.get(id).getYear();
    }
    public static int getMinutes(String id) {
        initialize();
        return ourMovies.get(id).getMinutes();
    }
    public static int size() {
        return ourMovies.size();
    }
    
    // ******************************
    // Public Methods
    // ******************************
    // Checks if movie database contains give movie id
    public static boolean containsID(String id) {
        initialize();
        return ourMovies.containsKey(id);
    }
    
    // Load Movies into Movies Database given data file
    private static void loadMovies(String filename) {
        LoadRatings lrs = new LoadRatings();
        ArrayList<Movie> list = lrs.loadMovies(filename);
        for (Movie m : list) {
            ourMovies.put(m.getID(), m);
        }
    }
    
    // Checks if movies meet filter criteria and returns list
    public static ArrayList<String> filterBy(Filter f) {
        initialize();
        ArrayList<String> list = new ArrayList<String>();
        for(String id : ourMovies.keySet()) {
            if (f.satisfies(id)) {
                list.add(id);
            }
        }        
        return list;
    }

}
