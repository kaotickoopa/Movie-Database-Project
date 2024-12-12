package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


/*
 * Author: Mason Cormany
 * Purpose: Gets a file scanner for any specified file entered
 */
public class FileScanner {
	public FileScanner() {
		
	}
	public Scanner getFileScanner(String fileName) {
		try {
			FileInputStream fs = new FileInputStream(fileName);
			Scanner s = new Scanner(fs);

			return s;
		}
		catch(IOException ie) {
			System.out.println("File exeption occured");
			return null;
		}
	}
}
