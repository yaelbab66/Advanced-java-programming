import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Game {
	//Players
	private DeckOfCards player1;
	private DeckOfCards player2;
	//ArrayList to save the cards in case of war. The winner at the next round will win 
	//those card as well, and the list will get empty.
	ArrayList<Card> warCards = new ArrayList<Card>(0);
	// no-argument constructor initializes a new game with shuffled deck of cards.
	public Game(){
		player1 = new DeckOfCards();
		player1.shuffle();
		
		player2 = new DeckOfCards();
		player2.shuffle();
	}

	//The game
	public void play() {
		
		Card card1, card2;
		//While both players have cards
		while(!player1.isEmpty() && !player2.isEmpty()){
			card1 = player1.dealCard();
			card2 = player2.dealCard();
			//Print details
			JOptionPane.showMessageDialog(null, "Player 1: Deck size- "+player1.getDeck().size()
					+" Card:- "+card1.toString()+"\nPlayer 2: Deck size- "+player2.getDeck().size()
					+" Card:- "+card2.toString()+"\nWar card on stack- "+warCards.size());
			//War
			if (card1.equals(card2)){
				//Adding all of the cards in the war to the warCards array.
				warCards.add(card1);
				warCards.add(card2);
				for(int i = 0 ; i< 3; i++ )
					//In case a player don't have 3 cards and one more to spare, he will leave one card 
					//for the next round to decide how won the war.
					if(player1.getDeck().size()>1)
						warCards.add(player1.dealCard());
				for(int i = 0 ; i<3; i++ )
					if(player2.getDeck().size()>1)
						warCards.add(player2.dealCard());
				//Print war cards
				JOptionPane.showMessageDialog(null, "War: dealing cards:\n"+warCards.toString());
				
			}else
				//Player 1 card is bigger
				if(card1.isBigger(card2)){
					player1.addCard(card1);
					player1.addCard(card2);
					JOptionPane.showMessageDialog(null, "Player 1 won !");
									
					while(!warCards.isEmpty()){
						player1.addCard(warCards.get(0));
						
						warCards.remove(0);
					}
					
					//Player 2 card is bigger
				}else{
				player2.addCard(card1);
				player2.addCard(card2);
				JOptionPane.showMessageDialog(null, "Player 2 won !");
				while(!warCards.isEmpty()){
					player2.addCard(warCards.get(0));
					warCards.remove(0);
				}
				
			}
			
			int play = JOptionPane.showConfirmDialog(null, "next round?");
			if(play == 1)
				return;
		}
		//Winner announcement
		//in case both players have only one card and are identical the game ends in a tie.
		if(player2.isEmpty() && player1.isEmpty())
			JOptionPane.showMessageDialog(null,"No winners, it's a draw");
		else{
		if (player1.isEmpty())
			JOptionPane.showMessageDialog(null,"The winner is player 2");
		
		if (player2.isEmpty())
			JOptionPane.showMessageDialog(null,"The winner is player 1");
		}
		
	}

}

