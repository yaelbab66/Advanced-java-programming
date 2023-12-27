// Fig. 7.10: DeckOfCards.java
// DeckOfCards class represents a deck of playing cards.
import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards
{
	//Deck of cards
	private ArrayList<Card> deck; 
  
     private static final int NUMBER_OF_CARDS = 52; // constant # of Cards
   // random number generator
   private static final Random randomNumbers = new Random();

   // constructor fills deck of Cards
   public DeckOfCards()
   {
      int[] faces = {1,2,3,4,5,6,7,8,9,10,11,12,13};
      String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
      deck = new ArrayList<Card>(0);  // create arrayList of Card objects
     

      // populate deck with Card objects
      for ( int count = 0; count < NUMBER_OF_CARDS; count++ ) {
    	  
    	  deck.add(new Card( faces[ count%13 ], suits[ count / 13 ] )); 
      
      }
      deck.add(new Card( faces[ 12], suits[3] )); 
   } // end DeckOfCards constructor
   
   public ArrayList getDeck(){
	   return this.deck;
   }
   // shuffle deck of Cards with one-pass algorithm
   public void shuffle()
   {
      // for each Card, pick another random Card (0-51) and swap them
      for ( int first = 0; first < NUMBER_OF_CARDS; first++ ) 
      {
         // select a random number between 0 and 51 
         int second =  randomNumbers.nextInt( NUMBER_OF_CARDS-1 );
         
         // swap current Card with randomly selected Card
         Card temp = deck.get(first);        
         deck.set(first, deck.get(second));   
         deck.set(second, temp);    
         
      } // end for
   } // end method shuffle

   // deal one Card
   public Card dealCard()
   {
	   Card temp;
      // determine whether Cards remain to be dealt
      if (!deck.isEmpty() ){
    	  temp = deck.get(0);
    	  deck.remove(0);
    	  return temp;
      }
         return null; 
   }
   //Return true if the deck is empty
	public boolean isEmpty() {
		return this.deck.isEmpty();
		
	}
	//Returns deck size
	public int length(){
		return this.deck.size();
	}
	//Add card to the end of the array
	public void addCard(Card card){
		deck.add(card);
		
	}
} // end class DeckOfCards


/**************************************************************************
 * (C) Copyright 1992-2012 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
