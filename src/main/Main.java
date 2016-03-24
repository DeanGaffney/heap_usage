package main;
import java.io.IOException;
import java.util.Scanner;

import heap_usage.MaxHeap;
import models.WordPair;

public class Main {
	
	static MaxHeap maxHeap;
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		maxHeap = new MaxHeap();
		
		int option = 0;
		do{
			displayOptions(); //display options to user

			option = input.nextInt(); //get option from user
			selectOption(option); //run correct option
			
		}while(option!=0);
	}

	private static void displayOptions(){
		System.out.println("1)Add a pair of words to the heap.");
		System.out.println("2)Remove max element.");
		System.out.println("3)Get max element.");
		System.out.println("4)Check if the heap is empty.");
		System.out.println("5)Get the size of the heap.");
		System.out.println("6)Clear all elements from heap.");
		System.out.println("7)Print out the heap.");
		System.out.println("8)Search for English Translation.");
		System.out.println();
		System.out.println("0)To exit.");
	}

	private static void selectOption(int option) throws IOException {
		switch(option){
		case 0:
			System.out.println("Exiting......");
			break;
		case 1:
			System.out.println("Please enter a Spanish Word");
			String spanishWord = input.next();
			System.out.println("Please enter the English translation");
			String englishWord = input.next();
			maxHeap.add(new WordPair(spanishWord,englishWord));
			break;
		case 2:
			WordPair tempWordPair = new WordPair(maxHeap.removeMax());
			System.out.println(tempWordPair.toString());
			break;
		case 3:
			System.out.println("Max item on heap is " + maxHeap.getMax());
			break;
		case 4:
			System.out.println("Heap is empty: " + maxHeap.isEmpty());
			break;
		case 5:
			System.out.println("Heap size: "+ maxHeap.getSize());
			break;
		case 6:
			System.out.println("Heap Cleared.");
			maxHeap.clear();
			break;
		case 7:
			maxHeap.displayHeap();
			break;
		case 8:
			System.out.println("Please enter a english word you wish to get the spanish translation for.");
			String wordToFind = input.next();
			maxHeap.findEnglishWord(wordToFind,0);
			break;
		default:
			System.out.println("That's not a valid option.");
			break;
		}
	}
}
