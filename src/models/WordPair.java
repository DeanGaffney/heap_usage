package models;

public class WordPair implements Comparable<WordPair> {

	private int pairLength; // used to compare two objects
	private String spanishWord;
	private String englishWord;
	
	public WordPair(String spanishWord, String englishWord){
		this.englishWord = englishWord;
		this.spanishWord = spanishWord;
		this.pairLength = getPairLength();
	}
	
	public WordPair(WordPair wordPair){
		this.englishWord = wordPair.englishWord;
		this.spanishWord = wordPair.spanishWord;
		this.pairLength = wordPair.pairLength;
	}
	
	public String getEnglishWord(){
		return englishWord;
	}
	
	public String getSpanishword(){
		return spanishWord;
	}
	
	public int getPairLength(){
		return spanishWord.length() + englishWord.length();
	}

	@Override
	public String toString() {
		return "WordPair [spanishWord=" + spanishWord + ", englishWord=" + englishWord +", length=" + getPairLength()+"]";
	}

	//compares the combined length of english and spanish words.
	@Override
	public int compareTo(WordPair other) {
		if(this.pairLength > other.pairLength)return +1;
		if(this.pairLength < other.pairLength)return -1;
		return 0;
	}

}
