package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


/*
 * Author: Mason Cormany
 * Purpose: Superclass for albums, can have various media albums using this class
 */
public abstract class Album {
	protected HashMap<Integer, Runnable> commandMap = new HashMap<>();
	protected FileScanner scanotron = new FileScanner();
	private boolean isTesting = false;
	protected HashMap<Integer, HashMap<Integer, Record>> albumStorage = new HashMap<>();
	
	//Chooses a certain datafile depending on what the variable isTesting is set to
	protected String chooseIfTesting(String fileName1, String fileName2) {
		if (isTesting) {
			return fileName1;
		}
		else{
			return fileName2;
		}
	}
	
	//Gets all the text lines from a file and puts them into a list for later use
	protected void getTextIntoList(String fileName, ArrayList<String[]> exampleList) {
		Scanner scnr;
		scnr = scanotron.getFileScanner(fileName);
		scnr.nextLine();
		while(scnr.hasNext()) {
			String fileLine = scnr.nextLine();
			String[] fileList = fileLine.split("[^\\S\\r\\n]{2,}|\\t");
			fileList = trimListItems(fileList);
			exampleList.add(fileList);
		}
	}
	
	
	//Below are printing methods to aid in testing
	protected void printList(String[] printerList) {
		for(int i = 0; i < printerList.length; i++) {
			System.out.print(printerList[i] + " ");
		}
		System.out.println(" ");

	}
	protected String[] trimListItems(String[] preTrimList) {
		String[] postTrimList = new String[preTrimList.length];
		for(int i = 0; i < preTrimList.length; i++) {
			String item = preTrimList[i];
			item = item.trim();
			postTrimList[i] = item;
		}
		return postTrimList;
	}
	
	protected void printMap(HashMap<Integer, MovieRecord> map) {
		for(int i = 0; i < map.size(); i++) {
			System.out.println("Line " + i + ": " +  map.get(i));
			System.out.println(" ");

		}
	}


}
