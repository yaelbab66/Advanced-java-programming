// Fig. 7.9: Card.java
// Card class represents a playing card.

public class Card 
{
   private int face; // face of card (1,2,3, ...)
   private String suit; // suit of card ("Hearts", "Diamonds", ...)

   // two-argument constructor initializes card's face and suit
   public Card( int cardFace, String cardSuit )
   {
      face = cardFace; // initialize face of card
      suit = cardSuit; // initialize suit of card
   } // end two-argument Card constructor

   // return String representation of Card
   public String toString() 
   { 
      return face + " of " + suit;
   } // end method toString
   
   //Return true if both cards are equals
   public boolean equals(Card card2){
	   if(this.face == card2.face)
		   return true;
	   return false;
   }
   //Return true if 'this' card is bigger then card2 
   public boolean isBigger(Card card2){
	   if ( this.face > card2.face)
		   return true;
	return false;
	   
   }
} // end class Card


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
