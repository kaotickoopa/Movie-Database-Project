package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import model.Record;

/*
 * Author: Mason Cormany
 * Purpose: Processes personal requests, inherits from Query for any helper methods
 */
public class PersonalQuery extends Query{

	public PersonalQuery() {
	}
	
	//Purpose: Loops through album and adds directors namees to a list if the name isn't null and hasn't already been added.
	//		   Sorts the list at the end using collections.
	public ArrayList<String> listOfDirectors(HashMap<Integer, Record> workingAlbum) {
		ArrayList<String> directorList = new ArrayList<>();
		for(int i = 0; i < workingAlbum.size(); i++) {
			Record currentRecord = workingAlbum.get(i);
			String currentDirector = currentRecord.getMediaCreator();
			if(currentDirector != null && !directorList.contains(currentDirector)) {
				directorList.add(currentDirector);
			}
		}
		Collections.sort(directorList);
		return directorList;
	}
	
	//Purpose: Makes a frequency HashMap to keep track of all the times directors appear in the album. It then sorts the keys
	//		   via a method in the superclass. A for loop at the end adds the wanted directors to an Array to return.
	public String[] mostFrequentDirectors(int amountOfDirectors, HashMap<Integer, Record> workingAlbum){
		String[] directorList = new String[amountOfDirectors];
		HashMap<String, Integer> directorFrequencyList = new HashMap<>();
		for(int i = 0; i < workingAlbum.size(); i++) {
			Record currentRecord = workingAlbum.get(i);
			String currentDirector = currentRecord.getMediaCreator();
			if(directorFrequencyList.containsKey(currentDirector)) {
				int currentFrequency = directorFrequencyList.get(currentDirector);
				directorFrequencyList.put(currentDirector, currentFrequency + 1);
			}
			else {
				directorFrequencyList.put(currentDirector, 1);
			}
		}
		Set<String> directorKeys = returnSortedKeysOfStringIntMap(directorFrequencyList);
		List<String> list = new ArrayList<>(directorKeys);
		int listSize = list.size()-2;
		int dlTracker = 0;
		for(int i = listSize; i > (listSize - amountOfDirectors); i--) {
			directorList[dlTracker] = list.get(i);
			dlTracker++;
		}
		return directorList;
	}
	
	//The next 4 methods are very similar but have different components, mainly that they want different aspects from a record and are
	//dealing with different data types in the HashMap like String vs. String[] and int vs. double
	
	//General structure of them all is a loop to add in all not null answers and store in a hashmap of wanted item (cast or director) and number
	//(rating or gross). It then calls the helper method to sort the keys and gets the right index to return.
	
	
	public String[] castOfCertainGrossingMovie(int rankOfGross, HashMap<Integer, Record> workingAlbum) {
		rankOfGross--;
		HashMap<String[], Integer> castOfMoviesWithGrossMap = new HashMap<>();
		for(int i = 0; i < workingAlbum.size(); i++) {
			Record currentRecord = workingAlbum.get(i);
			String[] workingCast = currentRecord.getMediaPeopleInvolved();
			int workingGross = currentRecord.getMediaGross();
			if(workingCast != null && workingGross > 1) {
				castOfMoviesWithGrossMap.put(workingCast, workingGross);
			}
		}		
		Set<String[]> castKeys = returnSortedKeysOfStringListIntMap(castOfMoviesWithGrossMap);		
		List<String[]> list = new ArrayList<>(castKeys);
		String[] answer = list.get(list.size() - rankOfGross+1);
		return answer;
	}			
	public String directorOfCertainGrossingMovie(int rankOfGross, HashMap<Integer, Record> workingAlbum) {
		rankOfGross--;
		HashMap<String, Integer> castOfMoviesWithGrossMap = new HashMap<>();
		for(int i = 0; i < workingAlbum.size(); i++) {
			Record currentRecord = workingAlbum.get(i);
			String workingDirector = currentRecord.getMediaCreator();
			int workingGross = currentRecord.getMediaGross();
			if(workingDirector != null && workingGross != 0) {
				castOfMoviesWithGrossMap.put(workingDirector, workingGross);
			}
		}		
		Set<String> grossKeys = returnSortedKeysOfStringIntMap(castOfMoviesWithGrossMap);	
		List<String> list = new ArrayList<>(grossKeys);
		String answer = list.get(list.size() - rankOfGross+1);
		return answer;	
	}
	public String[] castOfCertainRatingMovie(int rankOfRating, HashMap<Integer, Record> workingAlbum) {
		rankOfRating--;
		HashMap<String[], Double> castOfMoviesWithRatingMap = new HashMap<>();
		for(int i = 0; i < workingAlbum.size(); i++) {
			Record currentRecord = workingAlbum.get(i);
			String[] workingCast = currentRecord.getMediaPeopleInvolved();
			String workingDirector = currentRecord.getMediaCreator();
			double workingRating= currentRecord.getMediaRating();
			if(workingCast != null && workingRating != 0.0 && workingDirector != null) {
				castOfMoviesWithRatingMap.put(workingCast, workingRating);
			}
		}		
		Set<String[]> ratingKeys = returnSortedKeysOfStringListDoubleMap(castOfMoviesWithRatingMap);	
		List<String[]> list = new ArrayList<>(ratingKeys);
		String[] answer = list.get(list.size() - rankOfRating);	
		return answer;
	}
	public String directorOfCertainRatingMovie(int rankOfRating, HashMap<Integer, Record> workingAlbum) {
		rankOfRating--;
		HashMap<String, Double> castOfMoviesWithRatingMap = new HashMap<>();
		for(int i = 0; i < workingAlbum.size(); i++) {
			Record currentRecord = workingAlbum.get(i);
			String workingDirector = currentRecord.getMediaCreator();
			String[] workingCast = currentRecord.getMediaPeopleInvolved();
			double workingRating= currentRecord.getMediaRating();
			if(workingDirector != null && workingRating != 0.0 && workingCast != null) {
				castOfMoviesWithRatingMap.put(workingDirector, workingRating);
			}
		}		
		Set<String> ratingKeys = returnSortedKeysOfStringDoubleMap(castOfMoviesWithRatingMap);	
		List<String> list = new ArrayList<>(ratingKeys);
		String answer = list.get(list.size() - rankOfRating);	
		return answer;
	}
}
	
	
