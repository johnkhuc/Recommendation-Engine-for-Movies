
/**
 * This class is for calculating weighted averages and similarity profiling
 * 
 * @author John Khuc 
 */

import java.util.*;
import edu.duke.*;

public class WeightedRatings{
    // ******************************
    // Private Methods
    // ******************************
    // Gets averages for a given movie's ratings with minimal amount of reviews
    private double getAverageByID(String movieId, int minimumRaters){
        int countRaters=0;
        double total=0.0;
        ArrayList<Rater> myRaters = RaterDatabase.getRaters();
        for (Rater rater: myRaters){
            if(rater.hasRating(movieId)){
                total += rater.getRating(movieId);
                countRaters += 1;
            }
        }
        return (countRaters>=minimumRaters) ? total/countRaters : 0;
    }
    
    // Computes dot product of two raters and their ratings for similarity score
    private double dotProduct(Rater u,Rater v){
    	HashMap<String,Rating> movies = u.getMyRatings();
    	double dot = 0;
    	for(String movieId : movies.keySet()){
    		double scale = u.getRating(movieId) - 5;
    		if (v.hasRating(movieId)){
    			dot += scale*(v.getRating(movieId) - 5);
    		}
    	}
    	return dot;
    }
    
    // Get ArrayList of ratings for similar ratings with respect to a given rater 
    private ArrayList<Rating> getSimilarities(String id){
    	ArrayList<Rating> similarRating = new ArrayList<Rating>();
    	Rater u = RaterDatabase.getRater(id);
    	for(Rater v : RaterDatabase.getRaters()){
    		if(!u.getID().equals(v.getID())){
    			double dot = dotProduct(u, v);
    			if(dot > 0){
    				Rating rat = new Rating(v.getID(), dot);
    				similarRating.add(rat);
    			}
    		}
    	}
    	Collections.sort(similarRating, Collections.reverseOrder());
    	return similarRating;
    }
    
    // Get boolean value if a movie meets minimum number of reviews for similarity  
    private boolean hasMinRaters(String movieId, int minimumRaters, int numOfSimilarRaters, ArrayList<Rating> ratingRater){
    	int countRaters = 0;
    	int md_id = Integer.parseInt(movieId);
        ArrayList<Rater> myRaters = RaterDatabase.getRaters();
        for(int i=0; i < numOfSimilarRaters; i++){
            Rater rater = RaterDatabase.getRater(ratingRater.get(i).getItem());
            HashMap<String, Rating> movieRated=rater.getMyRatings();
            for(String mo_id : movieRated.keySet()){
                int rm_id = Integer.parseInt(mo_id);
                if(rm_id == md_id){
                    countRaters += 1;
                }
            }
        }      
        return countRaters >= minimumRaters;
    }
    
    // ******************************
    // Public Methods
    // ******************************
    // Get average ratings of movies that meet minimum reviews
    public ArrayList<Rating> getAverageRatings(int minimumRaters){
        ArrayList<Rating> rating= new ArrayList<Rating>();
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        Rating rat= new Rating("",0.0);
        for (String movieId : movies){
            if (getAverageByID(movieId, minimumRaters) != 0){  
                rating.add(new Rating(movieId, getAverageByID(movieId, minimumRaters))); 
            } 
        }
        Collections.sort(rating);
        return rating;
    }
    
    // Get average ratings of movies that meet minimum reviews and filter criteria
    public ArrayList<Rating> getAverageRatingsByFilter(int minimumRaters, Filter filterCriteria){
        ArrayList<Rating> rating = new ArrayList<Rating>();
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
        Rating rat= new Rating("",0.0);
        for (String movieId : movies){
            if (getAverageByID(movieId, minimumRaters) != 0) {            
                rating.add(new Rating(movieId,getAverageByID(movieId, minimumRaters))); 
            }
        }
        Collections.sort(rating);
        return rating;
    }
    
    // Get similar movies ratings for a given rater that meets minimum reviews and compares to similar raters 
    public ArrayList<Rating> getSimilarRatings(String id, int numOfSimilarRaters, int minimumRaters){
        ArrayList<Rating> ratingMoive = new ArrayList<Rating>();
        ArrayList<Rating> ratingRater = getSimilarities(id);
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        for (int j=0; j < movies.size(); j++) {
            String movieId = movies.get(j);
            int md_id = Integer.parseInt(movieId);
            if (hasMinRaters(movieId, minimumRaters, numOfSimilarRaters, ratingRater)){ 
                double total = 0.0;
                int count = 0;
                for(int i=0;i<numOfSimilarRaters;i++){
                    Rater rater = RaterDatabase.getRater(ratingRater.get(i).getItem());
                    HashMap<String,Rating> movieRated=rater.getMyRatings();
                    for(String mo_id : movieRated.keySet()){
                        int rm_id =Integer.parseInt(mo_id);
                        if(rm_id==md_id){
                            total += ratingRater.get(i).getValue()*rater.getRating(mo_id);
                            count += 1;
                        }
                    }           
                }
                if(count != 0.0){
                    ratingMoive.add(new Rating(movieId, total/count));
                }           
            }   
        }
        Collections.sort(ratingMoive,Collections.reverseOrder());       
        return ratingMoive;
    }
    
    // Get similar movies ratings for a given rater that meets minimum reviews, filter criteria, and compares to similar raters 
    public ArrayList<Rating> getSimilarRatingsByFilter(String id, int numOfSimilarRaters, int minimumRaters, Filter filterCriteria){
        ArrayList<Rating> ratingMoive = new ArrayList<Rating>();
        ArrayList<Rating> ratingRater = getSimilarities(id);
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
        for (int j=0; j < movies.size(); j++){
            String movieId = movies.get(j);
            int md_id = Integer.parseInt(movieId);
            if (hasMinRaters(movieId, minimumRaters, numOfSimilarRaters, ratingRater)) {
                double total = 0.0;
                int count = 0;
                for(int i=0;i<numOfSimilarRaters;i++){
                    Rater rater = RaterDatabase.getRater(ratingRater.get(i).getItem());
                    HashMap<String,Rating> movieRated=rater.getMyRatings();
                    for(String mo_id : movieRated.keySet()){
                        int rm_id =Integer.parseInt(mo_id);
                        if(rm_id==md_id){
                            total += ratingRater.get(i).getValue()*rater.getRating(mo_id);
                            count += 1;
                        }
                    }           
                }
                if (count != 0) {
                    ratingMoive.add(new Rating(movieId, total/count));
                }           
            }   
        }
        Collections.sort(ratingMoive,Collections.reverseOrder());       
        return ratingMoive;
    }
}