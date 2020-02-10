
/**
 * Class for filtering Genres
 * 
 * @author John Khuc
 */

import java.util.*;

public class GenreFilter implements Filter{
    // ******************************
    // Fields
    // ******************************
    private String myGenre;
    
    // ******************************
    // Constructors
    // ******************************
    /**
     * Contructor for Genre Filter
     * Given genre 
     */
    public GenreFilter(String genre) {
        myGenre = genre;
    }
    
    // ******************************
    // Public Methods
    // ******************************
    // Checks if Movie Objects in the Movie Database contains given genre
    @Override
    public boolean satisfies(String id) {
        boolean isGenre = false;
        if (MovieDatabase.getGenres(id).indexOf(", ") == -1) {
            return MovieDatabase.getGenres(id).equals(myGenre);
        } else {
            String[] genreArray = MovieDatabase.getGenres(id).split(", ");
            int i = genreArray.length - 1;
            while (i >= 0) {
                isGenre = genreArray[i].equals(myGenre);
                if (isGenre != false) {
                    break;
                }
                i--;
            }
        }
        return isGenre;
    }
}