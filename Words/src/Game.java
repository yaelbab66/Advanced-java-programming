

import javax.swing.JOptionPane;
public class Game {
	//The ABC
	String abc= "";
	String showWord = "";
	String playWord = "";
	Word play;
	
	//Constructor
	public Game(){
		Word play = new Word();
		playWord = play.getWord();
		
		abc = "a";
		for(char i = 'b' ; i<= 'z' ; i++){
			abc = abc + ','+i;
		}
		for(int i = 0; i< play.getLength(); i++){
			showWord = showWord + "_";
		}
	}
	
	//Play the game
	public void play(){
		
		//Until all the characters are guest
			while(showWord.contains("_")){
				String letter = editABC();
				showWord = editWord( letter);
				
			}
			JOptionPane.showMessageDialog(null,"You won the word is: "+showWord);
	}

	//Put the guest Char in the correct place, if exists
	private String editWord(String letter) {
		int i = 0;
		int place = playWord.indexOf(letter, i);
		while( place < playWord.length() && place != -1){
			if(place == 0){
				showWord = letter + showWord.substring(place+1, showWord.length());
			}
			if(place == playWord.length()-1){
				showWord = showWord.substring(0, place)+letter;
				
			}
			if(place < playWord.length()-1 && place > 0){
					showWord = showWord.substring(0, place)+letter+showWord.substring(place+1, showWord.length());
				
			}
					
			i = place + 1;
			place = playWord.indexOf(letter, i);
		}
		
		return showWord;
	}

	//Remove the chosen Char from the ABC
	private String editABC() {
		while(true){
			String letter = JOptionPane.showInputDialog("The word is: "+showWord+"\n"+"Choose a letter\n"+abc);
			if(letter.length() ==  1){
				if(abc.indexOf(letter) != -1){
					abc = abc.replace(letter, "_");
					return letter;
				}
				//Case of invalid char, or char that was already chosen
				JOptionPane.showMessageDialog(null, "Invalid char, choose again");
				
			}
			else
				//Case of more them 1 char
				JOptionPane.showMessageDialog(null, "1 char please");
			
		}
	}


	
	
	
	
	
	
	
}
