
/**
 * This class is for calculating simple averages and inteacting with
 * movie and rater data files without filters
 * 
 * @author John Khuc 
 */

import java.util.*;
import edu.duke.*;
public class SimpleRaterRatings {
    // ******************************
    // Fields
    // ******************************
    private ArrayList<Rater> myRaters;
    
    // ******************************
    // Constructors
    // ******************************
    /**
     * Default Constructor for Simple Movie Ratings
     * 
     * Reads in default data file for ratings
     */
    public SimpleRaterRatings() {
        this("ratings.csv");
    }
    /**
     * Constructor for Simple Movie Ratings
     * 
     * Reads in given data file for ratings
     */
    public SimpleRaterRatings(String ratingsfile){
        LoadRatings fr = new LoadRatings();
        myRaters = fr.loadRaters(ratingsfile);
    }
    
    // ******************************
    // Mutator and Accessor Methods
    // ******************************
    public int getRaterSize() {
        return myRaters.size();
    }
    public void print() {
        System.out.println(myRaters);
    }
    
    // ******************************
    // Private Methods
    // ******************************
    // Gets averages for a given movie's ratings with minimal amount of reviews
    private double getAverageByID(String movieId, int minimalRaters) {
        double total = 0;
        int countRaters = 0;
        for (Rater rater : myRaters) {
            countRaters = (rater.hasRating(movieId)) ? countRaters + 1 : countRaters;
            total = (rater.hasRating(movieId)) ? total + rater.getRating(movieId) : total;
        }
        return (countRaters >= minimalRaters) ? (total/countRaters) : 0.0;
    }
    
    // ******************************
    // Public Methods
    // ******************************
    // Gets Unique ArrayList of Raters 
    public ArrayList<Rater> uniqueRatings() {
        ArrayList<Rater> ratingsUnique = new ArrayList<Rater>();
        for (Rater rater: myRaters) {
            HashMap<String, Rating> myRatings = rater.getMyRatings();
            for (String rating : myRatings.keySet()) {
                if (!ratingsUnique.contains(rating)) {
                    ratingsUnique.add(rater);
                }
            }
        }
        System.out.println(ratingsUnique);
        return ratingsUnique;
    }
    
    // Gets averages for movie ratings with minimal amount of reviews
    public ArrayList<Rating> getAverageRatings(int minimumRaters){
        ArrayList<Rating> rating = new ArrayList<Rating>();
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        Rating ratings = new Rating("", 0.0);
        for (String movieId : movies) {
            if (getAverageByID(movieId, minimumRaters) != 0) {
                rating.add(new Rating(movieId, getAverageByID(movieId, minimumRaters)));
            }
        }
        Collections.sort(rating);
        return rating;
    }
    
    // Get Average Rating for Given Movie ID
    public double printAverageRatingOneMovie(String movieId){
        int countRaters = 0;
        double total = 0;
        for (Rater rater : myRaters) {
            countRaters = (rater.hasRating(movieId)) ? countRaters + 1 : countRaters;
            total = (rater.hasRating(movieId)) ? total + rater.getRating(movieId) : total;
        }
        return total / countRaters;
    }
    
    // Get ArrayList of Average Ratings for Movies that meet the filter criteria
    public ArrayList<Rating> getAverageRatingsByFilter(int minimumRaters, Filter filterCriteria) {
        ArrayList<Rating> rating = new ArrayList<Rating>();
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
        Rating ratings = new Rating("", 0.0);
        for (String movieId : movies) {
            if (getAverageByID(movieId, minimumRaters) != 0) {
                rating.add(new Rating(movieId, getAverageByID(movieId, minimumRaters)));
            }
        }
        Collections.sort(rating);
        return rating;
    }
}
