
/**
 * Movie Data Object 
 * 
 * @author John Khuc
 */

import java.util.ArrayList;
import java.util.Arrays;

// An immutable passive data object (PDO) to represent the movie data
public class Movie {
    // ******************************
    // Fields
    // ******************************
    private String id;
    private String title;
    private String genres;
    private String director;
    private String country;
    private String poster;
    private int year;
    private int minutes;
    
    // ******************************
    // Constructors
    // ******************************
    /**
     * Constructor for Rating Object  
     * 
     * Given Movie ID, Title, Year, Genre
     */
    public Movie (String anID, String aTitle, String aYear, String theGenres) {
        // Trim Whitespaces
        id = anID.trim();
        title = aTitle.trim();
        year = Integer.parseInt(aYear.trim());
        genres = theGenres;
    }
   
    /**
     * Constructor for Rating Object  
     * 
     * Given Movie ID, Title, Year, Genre, Director Name, Country, Poster, Duration
     */
    public Movie (String anID, String aTitle, String aYear, String theGenres, String aDirector,
    String aCountry, String aPoster, int theMinutes) {
        // Trim Whitespaces
        id = anID.trim();
        title = aTitle.trim();
        year = Integer.parseInt(aYear.trim());
        genres = theGenres;
        director = aDirector;
        country = aCountry;
        poster = aPoster;
        minutes = theMinutes;
    }
    
    // ******************************
    // Mutator and Accessor Methods
    // ******************************
    public String getID () {
        return id;
    }
    public String getTitle () {
        return title;
    }
    public String getGenres () {
        return genres;
    }
    public String getCountry(){
        return country;
    }
    public String getDirector(){
        return director;
    }
    public String getPoster(){
        return poster;
    }
    public int getYear () {
        return year;
    }
    public int getMinutes(){
        return minutes;
    }
    
    // ******************************
    // Public Methods
    // ******************************
    // Returns a string of the movie's information
    public String toString () {
        return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", genres= " + genres + "]";
    }
}
