
public class WordsPool {

	private String[] words = {"banana", "apple", "orange", "melon"};
	int length = words.length;
	
	public WordsPool getWorsPool(){
		return this;
	}
	
	public String getWord(int place){
		if(place >= this.length)
			return this.words[this.length - 1];
		return this.words[place];
	}
}
