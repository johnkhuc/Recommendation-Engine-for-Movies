
/**
 * This class is for calculating simple averages and inteacting with
 * movie and rater data files without filters
 * 
 * @author John Khuc
 */

import java.util.*;
import edu.duke.*;

public class SimpleMovieRatings {
    // ******************************
    // Fields
    // ******************************
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    // ******************************
    // Constructors
    // ******************************
    /**
     * Default Constructor for Simple Movie Ratings
     * 
     * Reads in default data files
     */
    public SimpleMovieRatings() {
        this("ratedmoviesfull.csv", "ratings.csv");
    }
    /**
     * Constructor for Simple Movie Ratings
     * 
     * Reads in inputed data files on movies and raters
     */
    public SimpleMovieRatings(String moviefile, String ratersfile) {
        LoadRatings lrs = new LoadRatings();
        myMovies = lrs.loadMovies(moviefile);
        myRaters = lrs.loadRaters(ratersfile);
    }
    
    // ******************************
    // Mutator and Accessor Methods
    // ******************************
    public int getMovieSize() {
        return myMovies.size();
    }
    public int getRaterSize() {
        return myRaters.size();
    }
        public String getTitle(String id) {
        for (int i = 0; i < myMovies.size(); i++) {
            if (myMovies.get(i).getID().equals(id)) {
                return myMovies.get(i).getTitle();
            }
        }
        return "The id " + id + " was not found.";
    }
    public String getID(String title) {
        for (int i = 0; i < myMovies.size(); i++) {
            if (myMovies.get(i).getTitle().equals(title)) {
                return myMovies.get(i).getID();
            }
        }
        return "NO SUCH TITLE";
    }
    
    // ******************************
    // Public Methods
    // ******************************
    // Gets averages for movie ratings with minimal amount of reviews
    public ArrayList<Rating> getAverageRatings(int minimalRaters) {
        ArrayList<Rating> ratings = new ArrayList<Rating>();
        for (int i = 0; i < myMovies.size(); i++) {
            String id = myMovies.get(i).getID();
            double avgRating = getAverageById(id, minimalRaters);
            if (avgRating != 0) {
                ratings.add(new Rating(id, avgRating));
            }
        }
        return ratings;
    }
    
    // Gets averages for a given movie's ratings with minimal amount of reviews
    public double getAverageById(String id, int minimalRaters) {
        double total = 0;
        int count = 0;
        for (int i = 0; i < myRaters.size(); i++) {
            if (myRaters.get(i).hasRating(id)) {
                total += myRaters.get(i).getRating(id);
                count++;
            }
        }
        return (count < minimalRaters) ? 0 : (total/count);
    }
}
