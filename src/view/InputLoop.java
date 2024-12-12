package view;

/*
 * Author: Mason Cormany
 * Purpose: All the questions an queries the users can ask are here.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import controller.MoneyQuery;
import controller.PersonalQuery;
import model.MovieAlbum;
import model.Record;
public class InputLoop {
	Scanner scnr = new Scanner(System.in);
	PersonalQuery pq;
	MoneyQuery mq;
	MovieAlbum ma = new MovieAlbum();
	HashMap<Integer, Record> workingAlbum = ma.getMovieAlbum();
	public InputLoop() {
		pq = new PersonalQuery();
		mq = new MoneyQuery();
	}
	
	private void beginningPrint() {
		System.out.println("1. Would you like to know the total earnings of certain year?");
		System.out.println("2. Would you like to know all the directors in the database? Its sorted!");
		System.out.println("3. Would you like to know the top X directors in the database?");
		System.out.println("4. Would you like to know who starred in the X highest grossing movie? Enter X: ");
		System.out.println("5. Would you like to know who directed in the X highest grossing movie? Enter X: ");
		System.out.println("6. Would you like to know who starred in the X highest rated movie? Enter X: ");
		System.out.println("7. Would you like to know who directed in the X highest rated movie? Enter X: ");
		System.out.println("8. Would you like to know the average gross across all movies?");
		System.out.println("9. Break");
		System.out.println("Type in the question number that you would like to answer:");
	}
	private void question1Print(Scanner scnr) {
		System.out.println("What year would you like to know?");
		try {
			int chosenYear = Integer.parseInt(scnr.next());
			int wantedEarnings = mq.totalGrossFromOneYear(chosenYear,workingAlbum);
			System.out.println("The total earnings from " + chosenYear + " was " + wantedEarnings + "!");
		}
		catch(Exception E){
			System.out.println("Wrong input type, try again.");
		}
		
	}
	private void question2Print(Scanner scnr) {
		ArrayList<String> listOfDirectors = pq.listOfDirectors(workingAlbum);
		System.out.println("Here are all of the directors in alphabetical order: ");
		for(int i = 0; i < listOfDirectors.size(); i++) {
			System.out.println(listOfDirectors.get(i));
		}
	}
	private void question3Print(Scanner scnr) {
		System.out.println("How many directors do you want to know?");
		try {
			int numberOfDirectors = scnr.nextInt();
			String[] listOfDirectors = pq.mostFrequentDirectors(numberOfDirectors,workingAlbum);
			System.out.println("Here are the top " + numberOfDirectors + " directors: ");
			for(int i = 0; i < numberOfDirectors; i++) {
				System.out.println(listOfDirectors[i]);
			}
		}
		catch(Exception e) {
			System.out.println("Wrong input type, try again.");
		}
		
	}
	private void question4Print(Scanner scnr) {
		System.out.println("What ranking would you like to see");
		try {
			int numberOfRank = scnr.nextInt();
			String[] castList = pq.castOfCertainGrossingMovie(numberOfRank,workingAlbum);
			System.out.println("Here is the cast of the #" + numberOfRank + " grossing film: ");
			for(int i = 0; i < castList.length; i++) {
				System.out.println(castList[i]);
			}
		}
		catch(Exception e) {
			System.out.println("Wrong input type, try again.");
		}
	}
	private void question5Print(Scanner scnr) {
		System.out.println("What ranking would you like to see");
		try {
			int numberOfRank = scnr.nextInt();
			String chosenDirector = pq.directorOfCertainGrossingMovie(numberOfRank,workingAlbum);
			System.out.println("The director of the #" + numberOfRank + " grossing film is " + chosenDirector);
		}
		catch(Exception e) {
			System.out.println("Wrong input type, try again.");
		}
	}
	private void question6Print(Scanner scnr) {
		System.out.println("What ranking would you like to see");
		try {
			int numberOfRank = scnr.nextInt();
			String[] castList = pq.castOfCertainRatingMovie(numberOfRank,workingAlbum);
			System.out.println("Here is the cast of the #" + numberOfRank + " rated film: ");
			for(int i = 0; i < castList.length; i++) {
				System.out.println(castList[i]);
			}
		}
		catch(Exception e) {
			System.out.println("Wrong input type, try again.");
		}
		
	}
	private void question7Print(Scanner scnr) {
		System.out.println("What ranking would you like to see");
		try {
			int numberOfRank = scnr.nextInt();
			String chosenDirector = pq.directorOfCertainRatingMovie(numberOfRank,workingAlbum);
			System.out.println("The director of the #" + numberOfRank + " rated film is " + chosenDirector);
		}
		catch(Exception e) {
			System.out.println("Wrong input type, try again.");
		}
		
	}
	private void question8Print(Scanner scnr){
		try {
			int averageGross = mq.smallestGrossOverAllMovies(workingAlbum);
			System.out.println("The average gross for all movies in the database is: " + averageGross);
		}
		catch(Exception e) {
			System.out.println("Wrong input type, try again.");
		}
		
	}
	public void questionLoop() {
		System.out.println("Welcome to the Movie Database! What queries would you like to run today?");
		while(true) {
			beginningPrint();
			String input = scnr.next();			
			if(input.equals("1")) {
				question1Print(scnr);
			}
			else if(input.equals("2")) {
				question2Print(scnr);
			}
			else if(input.equals("3")) {
				question3Print(scnr);
			}
			else if(input.equals("4")) {
				question4Print(scnr);
			}
			else if(input.equals("5")) {
				question5Print(scnr);
				}
			else if(input.equals("6")) {
				question6Print(scnr);
			}
			else if(input.equals("7")) {
				question7Print(scnr);
			}
			else if(input.equals("8")) {
				question8Print(scnr);
			}
			else if(input.equals("9")) {
				System.out.println("Goodbye :)");
				break;
			}
		}
	}
}
