//Andriy Zasypkin
//2015-08-27
//Homework 01

/** Description:
  *   Create a class that stores a movie
  *     - title
  *     - actors(stars)
  *     - rating(G,PG,PG-13,...)
  *     - reviews
  *     - show time[s]
  *  Class must have accessor and mutator methods
  *
  * Assumptions:
  *   Movies and movie metadata can be hard coded
  */

public class Main {
  public static void printMovie(Movie movie){
    //Print a nice table for the movie
    //Since reviews range from 0 to 10, there is a padding of 2 so that
    //  the decimal points will line up even if one is a 10 and the other
    //  is a 6
    
    System.out.printf("Title:      %s\n",       movie.displayName());
    System.out.printf("Stars:      %s\n",       movie.displayStars());
    System.out.printf("Show Time:  %s\n",       movie.displayShowTime());
    System.out.printf("Age Rating: %s\n",       movie.displayRating());
    System.out.printf("Review:     %06.3f\n\n", movie.displayReview());
  }
  
  public static void main(String[] args) {
    //http://www.imdb.com/title/tt0091059/
    Movie a = new Movie("Flight of the Navigator",
                        "Joey Cramer, Paul Reubens, Veronica Cartwright",
                        "Tuesday 15:40 and 18:20", "PG", 6.9);
    
    //http://www.imdb.com/title/tt0088763/
    Movie b = new Movie();
    b.setName("Back to the Future");
    b.setStars("Michael J. Fox, Christopher Lloyd, Lea Thompson");
    b.setShowTime("2015-09-03T08:30:00-05:00");
    b.setRating("PG");
    b.setReview(8.5);
    
    //Print movie info to command line
    printMovie(a);
    printMovie(b);
    
    System.exit(0);
  }
}
