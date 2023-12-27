import javax.swing.JOptionPane;
public class Do {

	//Main
	public static void main(String[] arg){
		int play = 0;
		//Until exit the game
		while(play == 0){
			Game g = new Game();
			
			g.play(); 
			play = JOptionPane.showConfirmDialog(null, "Would you like to play again?");
		
		}
	}
	
}