package main;
import heap_usage.MaxHeap;

public class Main {
	public static void main(String[] args) {
		try {
			MaxHeap maxHeap = new MaxHeap();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error reading from file.");
		}
	}
}
