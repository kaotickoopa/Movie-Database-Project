package model;


/*
 * Author: Mason Cormany
 * Purpose: Subclass of Record, frankly serves to augment the toString for more accurate printing
 */
public class MovieRecord extends Record{
	
	public MovieRecord(String movieName, int yearReleased, String movieDirector, String[] movieCast) {
		super(movieName, yearReleased, movieDirector, movieCast);
	}
	
	public MovieRecord(int movieRatingRanking, String movieName, int yearReleased, double movieRating) {
		super(movieRatingRanking, movieName, yearReleased, movieRating);
	}
	
	public MovieRecord(int movieGrossRanking, String movieName, int yearReleased, int movieGross) {
		super(movieGrossRanking, movieName, yearReleased, movieGross);
	}
	@Override
	public String toString() {
		return "Movie Name: " + getMediaName() + ", Year Released: " + getYearReleased() + ", Movie Gross: " + getMediaGross() + ", Movie Director: " + getMediaCreator() + ", Movie Rating: " + getMediaRating();
	}

}
