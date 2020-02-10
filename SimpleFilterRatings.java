
/**
 * This class is for calculating simple averages and inteacting with
 * movie and rater data files with filters
 * 
 * @author John Khuc
 */

import java.util.*;
import edu.duke.*;

public class SimpleFilterRatings {
    // ******************************
    // Fields
    // ******************************
    private ArrayList<Rater> myRaters;
    
    // ******************************
    // Constructors
    // ******************************
    /**
     * Default Constructor for Simple Filer Ratings
     * 
     * Reads in default data file
     */
    public SimpleFilterRatings() {
        this("ratings.csv");
    }
    /**
     * Constructor for Simple Filer Ratings
     * 
     * Reads in given data file for ratings
     */
    public SimpleFilterRatings(String ratingsfile){
        LoadRatings lrs = new LoadRatings();
        myRaters = lrs.loadRaters(ratingsfile);
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
    // Gets array list of raters and their unique ratings
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
    
    // Gets averages for a given movie's ratings 
    public double printAverageRatingOneMovie(String movieId){
        int countRaters = 0;
        double total = 0;
        for (Rater rater : myRaters) {
            countRaters = (rater.hasRating(movieId)) ? countRaters + 1 : countRaters;
            total = (rater.hasRating(movieId)) ? total + rater.getRating(movieId) : total;
        }
        return total / countRaters;
    }
    
    // Gets averages for movie ratings with minimal amount of reviews and filter criteria
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
