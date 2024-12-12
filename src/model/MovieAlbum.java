package model;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Author: Mason Cormany
 * Purpose: Stores all movie data. Deals with getting info from various files and compiling it into a useable format for the queries.
 */

public class MovieAlbum extends Album{
	
	private HashMap<Integer, Record> movieAlbum = new HashMap<>();
	
	private HashMap<Integer, Record> movieAlbumCast = new HashMap<>();
	private ArrayList<String[]> preMovieAlbumCast = new ArrayList<>();
	private HashMap<Integer, Record> movieAlbumGross = new HashMap<>();
	private ArrayList<String[]> preMovieAlbumGross = new ArrayList<>();
	private HashMap<Integer, Record> movieAlbumRating = new HashMap<>();
	private ArrayList<String[]> preMovieAlbumRating = new ArrayList<>();
	
	protected HashMap<Integer, HashMap<Integer, Record>> albumStorage = new HashMap<>();
	protected Record inspectingRecord;
	protected Record currentRecord;
	private int idNumber;
	
	public MovieAlbum() {
		setUpAlbumStorage();
		setUpCommandMap();
		getInfo();
	}

	private void getInfoCast() {
		String fileName = chooseIfTesting("testing_movie_data/testingMovieCast.txt", "movie_data/imdb_movies_cast.txt");;
		int indexNumber = 0;
		getTextIntoList(fileName, preMovieAlbumCast);
		for(int i = 0; i < preMovieAlbumCast.size(); i++) {
			String[] fileList = preMovieAlbumCast.get(i);
			String movieTitle = fileList[1];
			int yearOfMovie = Integer.parseInt(fileList[2]);
			String directorOfMovie = fileList[3];
			String[] movieCast = new String[5];
			int fileListSize = fileList.length;
			for(int j = 4; j < fileListSize; j++) {
				movieCast[j-4] = fileList[j];
			}
			Record currentRecord = new MovieRecord(movieTitle, yearOfMovie, directorOfMovie, movieCast);
			movieAlbumCast.put(indexNumber, currentRecord);
			indexNumber++;
		}
	}
	
	private void getInfoGross() {
		String fileName = chooseIfTesting("testing_movie_data/testingMovieGross.txt", "movie_data/imdb_movies_gross.txt");;
		int indexNumber = 0;
		getTextIntoList(fileName, preMovieAlbumGross);
		for(int i = 0; i < preMovieAlbumGross.size(); i++) {
			String[] fileList = preMovieAlbumGross.get(i);
			int rankNumber = Integer.parseInt(fileList[0]);
			String movieTitle = fileList[1];
			int yearOfMovie = Integer.parseInt(fileList[2]);
			int grossingOfMovie = Integer.parseInt(fileList[3]);
			Record currentRecord =  new MovieRecord(rankNumber, movieTitle, yearOfMovie, grossingOfMovie);
			movieAlbumGross.put(indexNumber, currentRecord);
			indexNumber++;
		}
		
	}
	
	private void getInfoRating() {
		String fileName = chooseIfTesting("testing_movie_data/testingMovieRating.txt", "movie_data/imdb_movies_toprated.txt");;
		int indexNumber = 0;
		getTextIntoList(fileName, preMovieAlbumRating);
		for(int i = 0; i < preMovieAlbumRating.size(); i++) {
			String[] fileList = preMovieAlbumRating.get(i);
			int rankNumber = Integer.parseInt(fileList[0]);
			String movieTitle = fileList[1];
			int yearOfMovie = Integer.parseInt(fileList[2]);
			double ratingOfMovie = Double.parseDouble(fileList[3]);
			Record currentRecord = new MovieRecord(rankNumber, movieTitle, yearOfMovie, ratingOfMovie);
			movieAlbumRating.put(indexNumber, currentRecord);
			indexNumber++;
		}
	}
	
	protected void getAlbumInfo(HashMap<Integer, Record> inputHashMap, int whichInfoIndicator) {
		
		for(int i = 0; i < inputHashMap.size(); i++) {
			boolean repeatChecker = false;
			currentRecord = inputHashMap.get(i);
			String currentName = currentRecord.getMediaName();
			for(int j = 0; j < movieAlbum.size(); j++) {
				inspectingRecord = movieAlbum.get(j);
				String inspectingName = inspectingRecord.getMediaName();
				if(currentName.equals(inspectingName)) {
					commandMap.get(whichInfoIndicator).run();
					repeatChecker = true;
					break;
				}
			}
			if(!repeatChecker) {
				movieAlbum.put(idNumber, currentRecord);
				idNumber++;
			}	
		}
	}
	
	private void getInfo() {
		getInfoRating();
		getInfoGross();
		getInfoCast();
		idNumber = 0;
		for(int i = 0; i < commandMap.size(); i++) {
			HashMap<Integer, Record> currentMap = albumStorage.get(i);
			getAlbumInfo(currentMap, i);
		}
	}
	
	private void setUpCommandMap() {
		commandMap.put(0, () -> setUpRatingRecord());
		commandMap.put(1,  () -> setUpGrossRecord());
		commandMap.put(2, () -> setUpCastRecord());
		
	}
	
	private void setUpAlbumStorage() {
		albumStorage.put(0, movieAlbumRating);
		albumStorage.put(1,  movieAlbumGross);
		albumStorage.put(2, movieAlbumCast);
	}
	
	private void setUpRatingRecord() {
		int ratingRank = currentRecord.getMediaRatingRanking();
		double rating = currentRecord.getMediaRating();
		inspectingRecord.setMediaRatingRanking(ratingRank);
		inspectingRecord.setMediaRating(rating);
	}
	
	private void setUpGrossRecord() {
		int grossRank = currentRecord.getMediaGrossRanking();
		int grossDollars = currentRecord.getMediaGross();
		inspectingRecord.setMediaGrossRanking(grossRank);
		inspectingRecord.setMediaGross(grossDollars);
	}
	
	private void setUpCastRecord() {
		String director = currentRecord.getMediaCreator();
		String[] cast = currentRecord.getMediaPeopleInvolved();
		inspectingRecord.setMediaPeopleInvolved(cast);
		inspectingRecord.setMediaDirector(director);
	}
	
	public HashMap<Integer, Record> getMovieAlbum(){
		return movieAlbum;
	}

}
