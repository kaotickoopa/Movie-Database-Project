package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import controller.*;
import model.MovieAlbum;
import model.Record;

public class CaseTest {
	MovieAlbum ma = new MovieAlbum();
	PersonalQuery pq = new PersonalQuery();
	MoneyQuery mq = new MoneyQuery();
	HashMap<Integer, Record> workingAlbum = ma.getMovieAlbum();
	
	//Tests for Query #1
	@Test
	public void testQuestion1RightAnswer() {
		System.out.println("Question 1...\n");
		int question1Answer = mq.totalGrossFromOneYear(1902, workingAlbum);
		assertEquals(question1Answer, 1000);
	}
	
	@Test
	public void testQuestion1ZeroAnswer() {
		System.out.println("Question 1...\n");

		int question1Answer = mq.totalGrossFromOneYear(2018, workingAlbum);
		assertEquals(question1Answer, 0);
	}
	
	@Test
	public void testQuestion1NoMoviesInThatYear() {
		System.out.println("Question 1...\n");

		int question1Answer = mq.totalGrossFromOneYear(1, workingAlbum);
		assertEquals(question1Answer, 0);
	}
	@Test
	public void testQuestion1MultipleMoviesInOneYear() {
		System.out.println("Question 1...\n");

		int question1Answer = mq.totalGrossFromOneYear(2024, workingAlbum);;
		assertEquals(question1Answer, 504);
	}
	
	//Tests for Query #2
	@Test
	public void testQuestion2NormalFunctioning() {
		System.out.println("Question 2...\n");

		ArrayList<String> question2Answer = new ArrayList<>();
		question2Answer.add("Geoffrey Wiggleton");
		question2Answer.add("Mason Cormany");
		question2Answer.add("Mr. Monkey");

		assertEquals(question2Answer, pq.listOfDirectors(workingAlbum));
	}
	
	//Needs seperate Cast file to test but works;
	/*
	@Test
	public void testQuestion2EmptyList() {
			System.out.println("Question 2...\n");

		ArrayList<String> question2Answer = new ArrayList<>();
		assertEquals(question2Answer, pq.listOfDirectors(workingAlbum));
	}
	*/
	
	//Tests for Query #3
	@Test
	public void testQuestion3NormalFunction() {
		System.out.println("Question 3...\n");

		String[] question3Answer = pq.mostFrequentDirectors(2, workingAlbum);
		//printList(question3Answer);
		String[] answer = new String[2];
		answer[0] = "Mason Cormany";
		answer[1] = "Geoffrey Wiggleton";
		assertArrayEquals(answer, question3Answer);
	}
	
	//Tests for Query #4
	@Test
	public void testQuestion4NormalFunction() {
		System.out.println("Question 4...\n");

		String[] question4Answer = pq.castOfCertainGrossingMovie(4, workingAlbum);
		String[] answer = new String[5];
		answer[0] = "Alex Kuang";
		answer[1] = "Griffin Malcolm";
		answer[2] = "Giuly Zegarra";
		answer[3] = null;
		answer[4] = null;
		assertArrayEquals(answer, question4Answer);
	}
	
	//Tests for Query #5
	@Test
	public void testQuestion5NormalFunction() {
		System.out.println("Question 5...\n");

		String question5Answer = pq.directorOfCertainGrossingMovie(3, workingAlbum);
		String answer = "Mr. Monkey";
		assertEquals(answer, question5Answer);
	}
	
	//Tests for Query #6
	@Test
	public void testQuestion6NormalFunctionPart1() {
		System.out.println("Question 6...\n");

		String[] question6Answer = pq.castOfCertainRatingMovie(2, workingAlbum);
		String[] answer = new String[5];
		answer[0] = "Big Bird";
		answer[1] = "Tweety Bird";
		answer[2] = null;
		answer[3] = null;
		answer[4] = null;
		assertArrayEquals(answer, question6Answer);
	}
	@Test
	public void testQuestion6NormalFunctionPart2() {
		System.out.println("Question 6...\n");

		String[] question6Answer = pq.castOfCertainRatingMovie(3, workingAlbum);
		String[] answer = new String[5];
		answer[0] = "King Kong";
		answer[1] = "Donkey Kong";
		answer[2] = "Funky Kong";
		answer[3] = null;
		answer[4] = null;
		assertArrayEquals(answer, question6Answer);
	}
	//Tests for Query #7
	@Test
	public void testQuestion7NormalFunction() {
		System.out.println("Question 7...\n");

		String question7Answer = pq.directorOfCertainRatingMovie(2, workingAlbum);
		String answer = "Mason Cormany";
		assertEquals(answer, question7Answer);
	}

	//Tests for Query #8
	@Test
	public void testQuestion8NormalFunction() {
		System.out.println("Question 8...\n");

		int question8Answer = mq.smallestGrossOverAllMovies(workingAlbum);
		int answer = 2;
		assertEquals(answer, question8Answer);
	}
	public void printList(String[] printerList) {
		for(int i = 0; i < printerList.length; i++) {
			System.out.print(printerList[i] + " ");
		}
		System.out.println(" ");

	}
	

}
