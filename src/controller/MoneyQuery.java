package controller;

import java.util.HashMap;
import model.Record;

/*
 * Author: Mason Cormany
 * Purpose: Processes money requests, inherits from Query for any helper methods
 */

public class MoneyQuery {
	public MoneyQuery() {
	}
	
	//Purpose: Looks through every record and adds gross to a sum if the year wanted is equal to the year found
	public int totalGrossFromOneYear(int yearWanted, HashMap<Integer, Record> workingAlbum) {
		int sum = 0;
		for(int i = 0; i < workingAlbum.size(); i++) {
			Record currentRecord = workingAlbum.get(i);
			int currentYear = currentRecord.getYearReleased();
			if(currentYear == yearWanted) {
				int currentGross = currentRecord.getMediaGross();
				sum += currentGross;
			}
		}
		return sum;
	}
	
	//Purpose: Looks through every record and compares that record's gross to the min and makes a new min if the record's gross is smaller
	public int smallestGrossOverAllMovies(HashMap<Integer, Record> workingAlbum) {
		int min = 1000000000;
		for(int i = 0; i < workingAlbum.size(); i++) {
			Record currentRecord = workingAlbum.get(i);
			int currentGross = currentRecord.getMediaGross();
			if(currentGross < min && currentGross > 0) {
				min = currentGross;
			}
		}
		return min;	
	}
}
