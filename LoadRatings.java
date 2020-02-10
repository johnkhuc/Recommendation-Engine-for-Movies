
/**
 * This class is for loading the data in and creating necessary objects
 * 
 * @author John Khuc
 */

import java.util.*;
import edu.duke.*;
import org.apache.commons.csv.*;

public class LoadRatings {
    // ******************************
    // Public Methods
    // ******************************
    // Loads movie data into array list of movie objects
    public ArrayList<Movie> loadMovies(String filename){
       ArrayList<Movie> movies = new ArrayList<Movie>();
       // String file = "data/" + filename;
       FileResource fr = new FileResource(filename);
       CSVParser parser = fr.getCSVParser();
       // Create movie object for each row and add to movies ArrayList
       for (CSVRecord record: parser) {
           Movie movie = new Movie(record.get("id"), record.get("title"),
                                   record.get("year"), record.get("genre"),
                                   record.get("director"), record.get("country"),
                                   record.get("poster"), Integer.parseInt(record.get("minutes")));
           movies.add(movie);
       }
       return movies;
    }
    
    // Loads rater data into array list of raters objects
    public ArrayList<Rater> loadRaters(String ratersfile) {
       ArrayList<Rater> raters = new ArrayList<Rater>();
       String file = "data/" + ratersfile;
       FileResource fr = new FileResource(file);
       CSVParser parser = fr.getCSVParser();
       // Create rater object and their ratings for each row and add to raters ArrayList
       for (CSVRecord record : parser) {
           String raterId = record.get("rater_id");
           if (raters.contains(raterId)) {
               int idx = raters.indexOf(raterId);
               raters.get(idx).addRating(record.get("movie_id"), Double.parseDouble(record.get("rating")));
           } else {
               Rater curRater = new FastRater(raterId);
               curRater.addRating(record.get("movie_id"), Double.parseDouble(record.get("rating")));
               raters.add(curRater);
           }
       }
       return raters;
    }
    
    // ******************************
    // In-Class Test Methods
    // ******************************
    public void testLoadMovies() {        
        // Load Movie Data
        ArrayList<Movie> movies = loadMovies("ratedmoviesfull.csv");
        
        // Confirmation
        System.out.println("Success! " + movies.size() + " movies were loaded.");

        // Count Movies under Comedy Genre
        int count = 0;
        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            String genre = movie.getGenres();     
            if (genre.indexOf("Comedy") != -1) {
                count++;
            }
        }
        System.out.println(count + " Movies with Comedy Genre were found.");
        
        // Count Movies longer than 150 minutes
        count = 0;
        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            if (movie.getMinutes() > 150) {
                count++;
            } 
        }
        System.out.println(count + " Movies longer than 150 minutes were found.");
        
        // Determine directors with most movies
        Map<String, Integer> dirCount = new HashMap<String, Integer>();
        for (int i = 0; i < movies.size(); i++) {
            String dir = movies.get(i).getDirector();
            Integer sum = dirCount.get(dir);
            dirCount.put(dir, (sum == null) ? 1 : sum + 1);
        }
        
        int max = 0;
        for (int num : dirCount.values()) {
            max = (num > max) ? num : max;
        }
        System.out.println("The most movies under a single director was " + max + ".");
        
        System.out.println("Directors that filmed " + max + " movies were: ");
        for (String name : dirCount.keySet()) {
            if (dirCount.get(name) == max) {
                System.out.println(name);
            }
        }
    }
    public void testLoadRaters() {
        // Load Movie Data
        ArrayList<Rater> raters = loadRaters("ratings.csv");
        
        // Confirmation
        System.out.println("Success! " + raters.size() + " raters data were loaded.");
        
        // Unique Rater IDs and Number of Ratings
        Set<String> uniqueRaterId = new HashSet<String>();
        ArrayList<Integer> numRatings = new ArrayList<Integer>();
        for (int i = 0; i < raters.size(); i++) {
            Rater rater = raters.get(i);
            if (uniqueRaterId.add(rater.getID())) {
                numRatings.add(rater.numRatings());
            }
        }
        
        System.out.println(uniqueRaterId.size() + " unique raters found!");
        
        // Find number of ratings for a particular rater
        int rater = 193;
        int ratings = numRatings.get(rater - 1);
        System.out.println("Rater " + rater + " made " + ratings + " ratings!");
        
        // Find most ratings by any user
        int max = 0;
        for (int i = 0; i < raters.size(); i++) {
            int numOfRatings = raters.get(i).numRatings();
            max = (numOfRatings > max) ? numOfRatings : max;
        }
        System.out.println("The most ratings by any user: " + max);
        
        // Find raters that rated the most times
        System.out.println("Raters that have rated " + max + " times are:");
        for (int i = 0; i < raters.size(); i++) {
            if (raters.get(i).numRatings() == max) {
                System.out.println("Rater " + raters.get(i).getID());
            }
        }
        
        // Dtermine number of unique movies rated and for a given movie, how many raters rated it.
        Set<String> movieId = new HashSet<String>();
        String randMovieId = "1798709";
        int count = 0;
        for (int i = 0; i < raters.size(); i++) {
            ArrayList<String> ratedMovies = raters.get(i).getItemsRated();
            for (int j = 0; j < ratedMovies.size(); j++) {
                String ratedMovie = ratedMovies.get(j);
                movieId.add(ratedMovie);
                count = (ratedMovie.equals(randMovieId)) ? count + 1 : count;
            }
        }
        System.out.println(movieId.size() + " Unique movies rated");
        System.out.println("The movie \"" + randMovieId + "\" was rated by " + count + " raters.");
    }
}
