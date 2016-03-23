package controllers;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import models.WordPair;

public class FileData {

	private File wordFile = new File("data/SpanishWords.txt");
	
	public FileData(){} //blank constructor
	
	public ArrayList<WordPair> readFile()throws Exception{
		ArrayList <WordPair> wordPairs = new ArrayList<WordPair>();
		
		Scanner input = new Scanner(new FileReader(wordFile)); // create a new file reader for our file
		String line = "";
		String delim = "[\t]"; //delimiter by tab
		
		while(input.hasNextLine()){
			line = input.nextLine();
			
			String [] words = line.split(delim);
			wordPairs.add(new WordPair(words[0], words[1]));
			
			if(wordPairs!=null){
				System.out.println(wordPairs.size());
			}else throw new Exception ("Invalid member length" + words.length);
		}
		//for debug purposes
		/*for(int i = 0; i < wordPairs.size();i++)
			System.out.println(wordPairs.get(i));*/
		return wordPairs;
	}
}
