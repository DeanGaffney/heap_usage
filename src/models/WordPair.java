package models;

public class WordPair {

	private String spanishWord;
	private String englishWord;
	
	public WordPair(String spanishWord, String englishWord){
		this.englishWord = englishWord;
		this.spanishWord = spanishWord;
	}
	
	public String getEnglishWord(){
		return englishWord;
	}
	
	public String getSpanishword(){
		return spanishWord;
	}

	@Override
	public String toString() {
		return "WordPair [spanishWord=" + spanishWord + ", englishWord=" + englishWord + "]";
	}
}
