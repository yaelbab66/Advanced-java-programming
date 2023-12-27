
public class Word {
	
	private String word;
	private int length;
	
	
	//Constructor
	public Word() {
		WordsPool p = new WordsPool();
		int wordPlace = ChooseWord(p.length);
		this.word = p.getWord(wordPlace);
		this.length = word.length();
		
	}
	//Choose random word from the pool
	private int ChooseWord(int length){
		int a = (int) ((Math.random() * 10)/(length-1));
		System.out.println(a);
		return a;
	}

	public String getWord() {
		return word;
	}

	public int getLength(){
		return this.length;
	}
	public void setWord(String word) {
		this.word = word;
	}
	

	
}
