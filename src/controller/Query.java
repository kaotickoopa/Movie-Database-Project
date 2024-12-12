package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Query {
	
	/*
	 * Author: Mason Cormany
	 * Purpose: The 4 methods below are used to sort the keys of a hashmap and return them in a set to use for queries
	 */
	protected Set<String> returnSortedKeysOfStringIntMap(HashMap<String, Integer> hm){
		List<Map.Entry<String, Integer>> entries = new ArrayList<>(hm.entrySet());
		entries.sort(Map.Entry.comparingByValue());
		LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
		for (Map.Entry<String, Integer> entry : entries) {
		    sortedMap.put(entry.getKey(), entry.getValue());
		}
		Set<String> directorKeys = sortedMap.keySet();	
		return directorKeys;
	}	
	protected Set<String> returnSortedKeysOfStringDoubleMap(HashMap<String, Double> hm){
		List<Map.Entry<String, Double>> entries = new ArrayList<>(hm.entrySet());
		entries.sort(Map.Entry.comparingByValue());
		LinkedHashMap<String, Double> sortedMap = new LinkedHashMap<>();
		for (Map.Entry<String, Double> entry : entries) {
		    sortedMap.put(entry.getKey(), entry.getValue());
		}		
		Set<String> directorKeys = sortedMap.keySet();	
		return directorKeys;
	}
	protected Set<String[]> returnSortedKeysOfStringListIntMap(HashMap<String[], Integer> hm){
		List<Map.Entry<String[], Integer>> entries = new ArrayList<>(hm.entrySet());
		entries.sort(Map.Entry.comparingByValue());
		LinkedHashMap<String[], Integer> sortedMap = new LinkedHashMap<>();
		for (Map.Entry<String[], Integer> entry : entries) {
		    sortedMap.put(entry.getKey(), entry.getValue());
		}
		Set<String[]> directorKeys = sortedMap.keySet();	
		return directorKeys;
	}
	protected Set<String[]> returnSortedKeysOfStringListDoubleMap(HashMap<String[], Double> hm){
		List<Map.Entry<String[], Double>> entries = new ArrayList<>(hm.entrySet());
		entries.sort(Map.Entry.comparingByValue());
		LinkedHashMap<String[], Double> sortedMap = new LinkedHashMap<>();
		for (Map.Entry<String[], Double> entry : entries) {
		    sortedMap.put(entry.getKey(), entry.getValue());
		}		
		Set<String[]> directorKeys = sortedMap.keySet();		
		return directorKeys;
	}	
	
	//Purpose: print methods that help with testing new queries
	protected void printStringListIntMap(HashMap<String[], Integer> hm) {
		Set<String[]> castListOfLists = hm.keySet();
		Iterator<String[]> value = castListOfLists.iterator();
		int gross = 0;
		value.next();
		int tracker = 1;
		while(value.hasNext()) {
			String[] currentList = value.next();
			gross = hm.get(currentList);
			System.out.println("Cast: " + tracker);
			for(int j = 0; j < currentList.length; j++) {
				System.out.print(currentList[j] + " ");
			}
			System.out.println("Gross: " + gross + "\n");
			tracker++;
		}
	}	
	protected void printList(String[] printerList) {
		for(int i = 0; i < printerList.length; i++) {
			System.out.print(printerList[i] + " ");
		}
		System.out.println(" ");
	}
	protected void printDiffList(List<String> printerList) {
		for(int i = 0; i < printerList.size(); i++) {
			System.out.print(printerList.get(i) + " ");
		}
		System.out.println(" ");
	}

}
