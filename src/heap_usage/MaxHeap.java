package heap_usage;
import java.util.ArrayList;
import java.util.Collections;

import controllers.FileData;
import models.WordPair;
public class MaxHeap {

	private ArrayList <WordPair> maxHeap;

	public MaxHeap() throws Exception{
		FileData fileData = new FileData();
		maxHeap = fileData.readFile();
		Collections.sort(maxHeap,Collections.reverseOrder()); //sorts the list in descending order just like max heap
		for(int i =0;i<maxHeap.size();i++){
			System.out.println(maxHeap.get(i));
		}
		System.out.println("\n1st index " + maxHeap.get(0));
		System.out.println("\nLast index " + maxHeap.get(maxHeap.size()-1));
	}

	//goes upwards through the heap and compares all objects.
	//Find left child of parent --->current index*2 + 1
	//Find right child of parent --->current index *2 + 2
	//Find Parent from a child --->(index-1)/2 (make sure it's int to truncate.
	//when finding a parent if the index is 0 don't compute it because its the top of the heap
	private void siftUp(){
		int itemIndex = maxHeap.size() -1;
		while(itemIndex > 0){

			int parentIndex = (itemIndex - 1)/2;

			WordPair item = maxHeap.get(itemIndex);
			WordPair parent = maxHeap.get(parentIndex);

			if(item.compareTo(parent) > 0){
				//swap
				maxHeap.set(itemIndex,parent);
				maxHeap.set(parentIndex, item);

				//set new index position for next loop cycle
				itemIndex = parentIndex;
			}else break;
		}
	}

	private void siftDown(){
		//goes down through the heap and compares all objects.
		int itemIndex = 0;
		int left = itemIndex*2 +1;
		while(left < maxHeap.size()){
			int max = left;
			int right = itemIndex*2+2;
			if(right < maxHeap.size()){// theres a right child
				if(maxHeap.get(right).compareTo(maxHeap.get(left)) > 0)
					max++;
			}
			if(maxHeap.get(itemIndex).compareTo(maxHeap.get(max)) < 0 ){
				//switch them
				WordPair temp = maxHeap.get(itemIndex);
				maxHeap.set(itemIndex, maxHeap.get(max));
				maxHeap.set(max, temp);
				itemIndex = max;
				left = 2*itemIndex+1;
			}else break;
		}
	}

	public void findEnglishWord(String spanishWord,int rootNode){
		int left = rootNode * 2 + 1;
		int right = rootNode * 2 + 2;
		
		if(maxHeap.get(rootNode).getSpanishword().equals(spanishWord)){
			System.out.println("English translation: "+ maxHeap.get(rootNode).getEnglishWord()+"\n");
			return ;
		}
		if(left < maxHeap.size())findEnglishWord(spanishWord,left);
		if(right < maxHeap.size())findEnglishWord(spanishWord, right);
	}

	public void add(WordPair wordpair){
		//put it in last index and sift up comparing them.
		maxHeap.add(wordpair);
		//go through heap and arrange everything correctly.
		siftUp();
	}

	public WordPair removeMax(){
		if(maxHeap.isEmpty())return null;
		//return the largest wordPair item and remove it from the heap.
		if(maxHeap.size() == 1)return maxHeap.get(0);

		WordPair tempWordPair = maxHeap.get(0);
		maxHeap.set(0,maxHeap.remove(maxHeap.size() - 1));
		//Then sift down through the heap and put everything back in correct placement
		siftDown();
		return tempWordPair;
	}

	//returns the largest item on the heap if list isn't empty,null otherwise.
	public WordPair getMax(){
		return(maxHeap.isEmpty()) ? null:maxHeap.get(0);
	}

	//returns true if heap is empty,false otherwise.
	public boolean isEmpty(){
		return(maxHeap.isEmpty()) ? true:false;
	}

	//returns the size of the max heap
	public int getSize(){
		return maxHeap.size();
	}

	//clears the max heap
	public void clear(){
		maxHeap.clear();
	}

	public void displayHeap(){
		for(int i =0;i<maxHeap.size();i++)
			System.out.println(maxHeap.get(i).toString());
	}
}
