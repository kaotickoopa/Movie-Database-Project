package model;

/*
 * Author: Mason Cormany
 * Purpose: To store any media,
 */
public abstract class Record {
	private String mediaName;
	private int yearReleased;
	private int mediaRatingRanking;
	private double mediaRating;
	private int mediaGrossRanking;
	private int mediaGross;
	private String mediaCreator;
	private String[] mediaPeopleInvolved;
	
	public Record(String mediaName, int yearReleased, String mediaCreator, String[] mediaPeopleInvolved) {
		this.mediaName = mediaName;
		this.yearReleased = yearReleased;
		this.mediaCreator = mediaCreator;
		this.mediaPeopleInvolved = mediaPeopleInvolved;
	}
	
	public Record(int mediaRatingRanking, String mediaName, int yearReleased, double mediaRating) {
		this.mediaRatingRanking = mediaRatingRanking;
		this.mediaName = mediaName;
		this.yearReleased = yearReleased;
		this.mediaRating = mediaRating;
	}
	public Record(int mediaGrossRanking, String mediaName, int yearReleased, int mediaGross) {
		this.mediaGrossRanking = mediaGrossRanking;
		this.mediaName = mediaName;
		this.yearReleased = yearReleased;
		this.mediaGross = mediaGross;
	}
	
	
	
	public String getMediaName() {
		return mediaName;
	}
	public int getYearReleased() {
		return yearReleased;
	}
	public int getMediaRatingRanking() {
		return mediaRatingRanking;
	}
	public double getMediaRating() {
		return mediaRating;
	}
	public int getMediaGrossRanking() {
		return mediaGrossRanking;
	}
	public int getMediaGross() {
		return mediaGross;
	}
	public String getMediaCreator() {
		return mediaCreator;
	}
	public String[] getMediaPeopleInvolved() {
		return mediaPeopleInvolved;
	}
	
	public void setMediaName(String movieName) {
		this.mediaName = movieName;
	}
	public void setYearReleased(int yearReleased) {
		this.yearReleased = yearReleased;
	}
	public void setMediaRatingRanking(int movieRatingRanking) {
		this.mediaRatingRanking = movieRatingRanking;
	}
	public void setMediaRating(double movieRating) {
		this.mediaRating = movieRating;
	}
	public void setMediaGrossRanking(int movieGrossRanking) {
		this.mediaGrossRanking = movieGrossRanking;
	}
	public void setMediaGross(int movieGross) {
		this.mediaGross = movieGross;
	}
	public void setMediaDirector(String movieDirector) {
		this.mediaCreator = movieDirector;
	}
	public void setMediaPeopleInvolved(String[] mediaPeopleInvolved) {
		this.mediaPeopleInvolved = mediaPeopleInvolved;
	}

	public String toString() {
		return "Media Name: " + mediaName + ", Year Released: " + yearReleased + ", Media Gross: " + mediaGross + ", Media Director: " + mediaCreator + ", Media Rating: " + mediaRating;
	}
	
}
