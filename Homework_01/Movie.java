//Andriy Zasypkin
//2015-08-27
//Homework 01

public class Movie {
  private String strTime;   //Time when movie shows
  private String strName;   //Name of the movie
  private String strStars;  //Names of the stars of the movie
                            //  Writen as a comma seperated list of strings
                            //  Was planning to use an array
                            //  but that seemed useless
                            //  and would have required a "join" to string
                            //  method
  private String strRating; //Age rating of movie(G, PG, PG-13, R, NC-17, NR)
  private double dReview;   //Review of the movie(how many stars)
                            //  range of review: [0, 10]
  
  
  //Constructors
  public Movie() { //Default values for all fields of movie.
    this.strTime   = "None";
    this.strName   = "Untitled";
    this.strStars  = "Unknown";
    this.strRating = "NR";
    this.dReview   = 0.0;
  }
  
  public Movie(String strName) { //Only title of movie passed to constructor
    this.strTime   = "None";
    this.strName   = strName;
    this.strStars  = "Unknown";
    this.strRating = "NR";
    this.dReview   = 0.0;
  }
  
  public Movie(String strName, String strStars) {
    this.strTime   = "None";
    this.strName   = strName;
    this.strStars  = strStars;
    this.strRating = "NR";
    this.dReview   = 0.0;
  }
  
  public Movie(String strName, String strStars,
               String strTime) {
    this.strTime   = strTime;
    this.strName   = strName;
    this.strStars  = strStars;
    this.strRating = "NR";
    this.dReview   = 0.0;
  }
  
  public Movie(String strName, String strStars,  //All fields are given
               String strTime, String strRating,
               double dReview) {
    this.strTime   = strTime;
    this.strName   = strName;
    this.strStars  = strStars;
    this.strRating = strRating;
    
    //Review must be in the range [0, 10]
    dReview        = Math.min(dReview, 10);
    this.dReview   = Math.max(dReview, 0);
    
  }
  
  //Mutator Methods
  public void setShowTime(String strTime) {
    this.strTime = strTime;
  }
  
  public void setName(String strName) {
    this.strName = strName;
  }
  
  public void setStars(String strStars) {
    this.strStars = strStars;
  }
  
  public void setRating(String strRating) {
    this.strRating = strRating;
  }
  
  public void setReview(double dReview) {
    //To keep the review in the range [0, 10]
    dReview        = Math.min(dReview, 10);
    this.dReview   = Math.max(dReview, 0);
  }
  
  //Accessor Methods
  public String displayShowTime() {
    return this.strTime;
  }
  
  public String displayName() {
    return this.strName;
  }
  
  public String displayStars() {
    return this.strStars;
  }
  
  public String displayRating() {
    return this.strRating;
  }
  
  public double displayReview() {
    return this.dReview;
  }
}
