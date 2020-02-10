
/**
 * Class for filtering Directors
 * 
 * @author John Khuc
 */

import java.util.*;

public class DirectorsFilter implements Filter{
    // ******************************
    // Fields
    // ******************************
    private String myDirectors;
    
    // ******************************
    // Constructors
    // ******************************
    /**
     * Contructor for Director Filter
     * Given string of directors separated by ','
     */
    public DirectorsFilter(String directors) {
        myDirectors = directors;
    }
        
    // ******************************
    // Public Methods
    // ******************************
    // Checks if Movie Objects in the Movie Database have been directed by given directors
    @Override
    public boolean satisfies(String id) {
        String[] directorsArray = myDirectors.split(",");
        if (MovieDatabase.getDirector(id).indexOf(",") != -1) {
            String[] myDirectorsArray = MovieDatabase.getDirector(id).split(",");
            for (int i = 0; i < directorsArray.length; i++) {
                for (int j = 0; j < myDirectorsArray.length; j++) {
                    if (myDirectorsArray[j].equals(directorsArray[i])) {
                        return true;
                    }
                }
            } 
        } else {
            for (int i = 0; i < directorsArray.length; i++) {
                if (directorsArray[i].equals(MovieDatabase.getDirector(id))) {
                    return true;
                }
            }
        }
        return false;
    }   
}
