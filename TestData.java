
/**
 * This class is for extensive testing of other classes and making sure the data is read and analyzed properly.
 * 
 * @author John Khuc
 */

import java.util.*;
import edu.duke.*;

public class TestData {
    public void printAverageRatings() {
        SimpleRaterRatings srs = new SimpleRaterRatings("ratings.csv");
        int raterSize = srs.getRaterSize();
        System.out.println("Number of Raters: " + raterSize);
        MovieDatabase.initialize("ratedmoviesfull.csv");
        int movieSize = MovieDatabase.size();
        System.out.println("Number of Movies: " + movieSize);
        ArrayList<Rating> avgRatings = srs.getAverageRatings(35);
        int avgRatingsSize = avgRatings.size();
        System.out.println("Number of ratings in average: " + avgRatingsSize);
        
        for(Rating ratings : avgRatings){
        	System.out.println(ratings.getValue()+
        	                   " Time: "+ MovieDatabase.getMinutes(ratings.getItem())+
        	                   " "+ MovieDatabase.getTitle(ratings.getItem())+"\n"
        	                   +" "+MovieDatabase.getDirector(ratings.getItem()));
        }	
    }
    
    public void printAverageRatingsByYear() {
        SimpleRaterRatings srs = new SimpleRaterRatings("ratings.csv");
        int raterSize = srs.getRaterSize();
        System.out.println("Number of Raters: " + raterSize);
        MovieDatabase.initialize("ratedmoviesfull.csv");
        int movieSize = MovieDatabase.size();
        System.out.println("Number of Movies: " + movieSize);
        ArrayList<Rating> avgRatings = srs.getAverageRatingsByFilter(20, new YearAfterFilter(2000));
        int avgRatingsSize = avgRatings.size();
        System.out.println("Number of ratings in average: " + avgRatingsSize);
        
        for(Rating ratings : avgRatings){
        	System.out.println(ratings.getValue()+
        	                   " Time: "+ MovieDatabase.getMinutes(ratings.getItem())+
        	                   " "+ MovieDatabase.getTitle(ratings.getItem())+"\n"
        	                   +" "+MovieDatabase.getDirector(ratings.getItem()));
        }	
    }
    
    public void printAverageRatingsByGenre() {
        SimpleRaterRatings srs = new SimpleRaterRatings("ratings.csv");
        int raterSize = srs.getRaterSize();
        System.out.println("Number of Raters: " + raterSize);
        MovieDatabase.initialize("ratedmoviesfull.csv");
        int movieSize = MovieDatabase.size();
        System.out.println("Number of Movies: " + movieSize);
        ArrayList<Rating> avgRatings = srs.getAverageRatingsByFilter(20, new GenreFilter("Comedy"));
        int avgRatingsSize = avgRatings.size();
        System.out.println("Number of ratings in average: " + avgRatingsSize);
        
        for(Rating ratings : avgRatings){
        	System.out.println(ratings.getValue()+
        	                   " Time: "+ MovieDatabase.getMinutes(ratings.getItem())+
        	                   " "+ MovieDatabase.getTitle(ratings.getItem())+"\n"
        	                   +" "+MovieDatabase.getDirector(ratings.getItem()));
        }	
    }
    
    public void printAverageRatingsByMinutes() {
        SimpleRaterRatings srs = new SimpleRaterRatings("ratings.csv");
        int raterSize = srs.getRaterSize();
        System.out.println("Number of Raters: " + raterSize);
        MovieDatabase.initialize("ratedmoviesfull.csv");
        int movieSize = MovieDatabase.size();
        System.out.println("Number of Movies: " + movieSize);
        ArrayList<Rating> avgRatings = srs.getAverageRatingsByFilter(5, new MinutesFilter(105, 135));
        int avgRatingsSize = avgRatings.size();
        System.out.println("Number of ratings in average: " + avgRatingsSize);
        
        for(Rating ratings : avgRatings){
        	System.out.println(ratings.getValue()+
        	                   " Time: "+ MovieDatabase.getMinutes(ratings.getItem())+
        	                   " "+ MovieDatabase.getTitle(ratings.getItem())+"\n"
        	                   +" "+MovieDatabase.getDirector(ratings.getItem()));
        }	
    }
    
    public void printAverageRatingsByDirectors() {
        SimpleRaterRatings srs = new SimpleRaterRatings("ratings.csv");
        int raterSize = srs.getRaterSize();
        System.out.println("Number of Raters: " + raterSize);
        MovieDatabase.initialize("ratedmoviesfull.csv");
        int movieSize = MovieDatabase.size();
        System.out.println("Number of Movies: " + movieSize);
        ArrayList<Rating> avgRatings = srs.getAverageRatingsByFilter(4,new DirectorsFilter("Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack"));
        int avgRatingsSize = avgRatings.size();
        System.out.println("Number of ratings in average: " + avgRatingsSize);
        
        for(Rating ratings : avgRatings){
        	System.out.println(ratings.getValue()+
        	                   " Time: "+ MovieDatabase.getMinutes(ratings.getItem())+
        	                   " "+ MovieDatabase.getTitle(ratings.getItem())+"\n"
        	                   +" "+MovieDatabase.getDirector(ratings.getItem()));
        }	
    }
    
    public void printAverageRatingsByYearAfterAndGenre() {
        SimpleRaterRatings srs = new SimpleRaterRatings("ratings.csv");
        int raterSize = srs.getRaterSize();
        System.out.println("Number of Raters: " + raterSize);
        MovieDatabase.initialize("ratedmoviesfull.csv");
        int movieSize = MovieDatabase.size();
        System.out.println("Number of Movies: " + movieSize);
        
        AllFilters af = new AllFilters();
        af.addFilter(new YearAfterFilter(1990));
        af.addFilter(new GenreFilter("Drama"));
        
        ArrayList<Rating> avgRatings = srs.getAverageRatingsByFilter(8, af);
        int avgRatingsSize = avgRatings.size();
        System.out.println("Number of ratings in average: " + avgRatingsSize);
        
        for(Rating ratings : avgRatings){
        	System.out.println(ratings.getValue()+
        	                   " Time: "+ MovieDatabase.getMinutes(ratings.getItem())+
        	                   " "+ MovieDatabase.getTitle(ratings.getItem())+"\n"
        	                   +" "+MovieDatabase.getDirector(ratings.getItem()));
        }	
    }
    
    public void printAverageRatingsByDirectorsAndMinutes() {
        SimpleRaterRatings srs = new SimpleRaterRatings("ratings.csv");
        int raterSize = srs.getRaterSize();
        System.out.println("Number of Raters: " + raterSize);
        MovieDatabase.initialize("ratedmoviesfull.csv");
        int movieSize = MovieDatabase.size();
        System.out.println("Number of Movies: " + movieSize);
        
        AllFilters af = new AllFilters();
        af.addFilter(new MinutesFilter(90, 180));
        af.addFilter(new DirectorsFilter("Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack"));
        
        ArrayList<Rating> avgRatings = srs.getAverageRatingsByFilter(3, af);
        int avgRatingsSize = avgRatings.size();
        System.out.println("Number of ratings in average: " + avgRatingsSize);
        
        for(Rating ratings : avgRatings){
        	System.out.println(ratings.getValue()+
        	                   " Time: "+ MovieDatabase.getMinutes(ratings.getItem())+
        	                   " "+ MovieDatabase.getTitle(ratings.getItem())+"\n"
        	                   +" "+MovieDatabase.getDirector(ratings.getItem()));
        }	
    }
    
    public void printAverageRatingsByYearAfterAndGenre2() {
        WeightedRatings wrs = new WeightedRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        int movieSize = MovieDatabase.size();
        System.out.println("Number of Movies: " + movieSize);
        
        AllFilters af = new AllFilters();
        af.addFilter(new YearAfterFilter(1990));
        af.addFilter(new GenreFilter("Drama"));
        
        ArrayList<Rating> avgRatings = wrs.getAverageRatingsByFilter(8, af);
        int avgRatingsSize = avgRatings.size();
        System.out.println("Number of ratings in average: " + avgRatingsSize);
        
        for(Rating ratings : avgRatings){
        	System.out.println(ratings.getValue()+
        	                   " Time: "+ MovieDatabase.getMinutes(ratings.getItem())+
        	                   " " + MovieDatabase.getTitle(ratings.getItem())+"\n"
        	                   + " " + MovieDatabase.getDirector(ratings.getItem()));
        }	
    }
    
    public void printSimilarRatings() {
        WeightedRatings wrs = new WeightedRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        int movieSize = MovieDatabase.size();
        System.out.println("Number of Movies: " + movieSize);
        RaterDatabase.initialize("ratings.csv");
        int raingsSize = RaterDatabase.size();
        System.out.println("Number of Ratings: " + raingsSize);
        
        ArrayList<Rating> simRatings = wrs.getSimilarRatings("71", 20, 5);
        int simRatingsSize = simRatings.size();
        System.out.println("Number of ratings in similar: " + simRatingsSize);
        System.out.println(simRatings);
	System.out.println(MovieDatabase.getTitle(simRatings.get(0).getItem()));
    }
    
    public void printSimilarRatingsByGenre() {
        WeightedRatings wrs = new WeightedRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        int movieSize = MovieDatabase.size();
        System.out.println("Number of Movies: " + movieSize);
        RaterDatabase.initialize("ratings.csv");
        int raingsSize = RaterDatabase.size();
        System.out.println("Number of Ratings: " + raingsSize);
        
        ArrayList<Rating> simRatings = wrs.getSimilarRatingsByFilter("964", 20, 5, new GenreFilter("Mystery"));
        int simRatingsSize = simRatings.size();
        System.out.println("Number of ratings in similar: " + simRatingsSize);
        System.out.println(simRatings);
	System.out.println(MovieDatabase.getTitle(simRatings.get(0).getItem()));
    }
    
    public void printSimilarRatingsByDirector() {
        WeightedRatings wrs = new WeightedRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        int movieSize = MovieDatabase.size();
        System.out.println("Number of Movies: " + movieSize);
        RaterDatabase.initialize("ratings.csv");
        int raingsSize = RaterDatabase.size();
        System.out.println("Number of Ratings: " + raingsSize);
        
        ArrayList<Rating> simRatings = wrs.getSimilarRatingsByFilter("120", 10, 2, new DirectorsFilter("Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh"));
        int simRatingsSize = simRatings.size();
        System.out.println("Number of ratings in similar: " + simRatingsSize);
        System.out.println(simRatings);
	System.out.println(MovieDatabase.getTitle(simRatings.get(0).getItem()));
    }
    
    public void printSimilarRatingsByGenreAndMinutes() {
        WeightedRatings wrs = new WeightedRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        int movieSize = MovieDatabase.size();
        System.out.println("Number of Movies: " + movieSize);
        RaterDatabase.initialize("ratings.csv");
        int raingsSize = RaterDatabase.size();
        System.out.println("Number of Ratings: " + raingsSize);
        
        AllFilters af = new AllFilters();
        af.addFilter(new GenreFilter("Drama"));
        af.addFilter(new MinutesFilter(80,160));
        
        ArrayList<Rating> simRatings = wrs.getSimilarRatingsByFilter("168", 10, 3, af);
        int simRatingsSize = simRatings.size();
        System.out.println("Number of ratings in similar: " + simRatingsSize);
        System.out.println(simRatings);
	System.out.println(MovieDatabase.getTitle(simRatings.get(0).getItem()));
    }
    
    public void printSimilarRatingsByYearAfterAndMinute() {
        WeightedRatings wrs = new WeightedRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        int movieSize = MovieDatabase.size();
        System.out.println("Number of Movies: " + movieSize);
        RaterDatabase.initialize("ratings.csv");
        int raingsSize = RaterDatabase.size();
        System.out.println("Number of Ratings: " + raingsSize);
        
        AllFilters af = new AllFilters();
        af.addFilter(new YearAfterFilter(1975));
        af.addFilter(new MinutesFilter(70,200));
        
        ArrayList<Rating> simRatings = wrs.getSimilarRatingsByFilter("314", 10, 5, af);
        int simRatingsSize = simRatings.size();
        System.out.println("Number of ratings in similar: " + simRatingsSize);
        System.out.println(simRatings);
	System.out.println(MovieDatabase.getTitle(simRatings.get(0).getItem()));
    }
}


