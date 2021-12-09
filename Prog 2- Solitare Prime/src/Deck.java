import java.util.Random;   // need this for shuffle

public class Deck {
	private Card [ ] storage;   // makes array of cards under variable name storage
	private int top=0;
	
	public Deck() {
		
		char [] suits= {'S','H','D','C'};                                       // creates list of all possible suits
		char [] ranks= {'A','2','3','4','5','6','7','8','9','T','J','Q','K'};   // creates list of all possible ranks
		storage= new Card[52];
		
		int count=0;
		Card C1;
		for (int s=0; s<4;s++) {
			for (int r=0; r<13; r++) {    //goes through a loop to create 52 cards of 13 ranks with 4 suits
				
				C1=new Card(ranks[r],suits[s]);
				storage[count++]=C1;
			}
		}
		
	}
	public void display() {
		    int cardPosition=0;
			for (int c=0;c<4;c++) {       //loop goes through each 4 columns and 13 rows
				for (int r=0;r<13;r++) {
					//Card myCard= new Card(storage[cardPosition].getRank(),storage[cardPosition].getSuit());  // gets the rank and suit of the card in the position of the array
					storage[cardPosition].display();     // displays the rank and position of that card
					System.out.print(" ");   //prints a space
					cardPosition=cardPosition+1;
				    if (cardPosition==13 || cardPosition==26 || cardPosition==39) {  // this will print a new line to move on to next column after a row of 13 cards is displayed
				    	System.out.print("\n"); 
				    }
			    }
			}
			System.out.print("\n");
   }
	public void shuffle() {
		
		int x,y;
		Random ran= new Random();    //creates random variable
		for (int i=0; i<10000;i++) {   //shuffles two cards in the deck 10,000 times
			x= ran.nextInt(52);   //sets variable x to random position in the array of 52 cards
			y=ran.nextInt(52);    //sets variable y to random position in the array of 52 cards
			Card temp;
			temp= storage[x];      //sets a temporary card to the card at the position of x
			storage[x]=storage[y];  //swaps the card at position of x with the card at the position of y
			storage[y]=temp;        // swaps the card at position of y with the position of x
		}
	}
	public Card deal() {
		
		Card C=new Card(storage[top].getRank(),storage[top].getSuit());   //gets a new card at the position of storage
		top=top+1;
		if (top==52) {  // once the deck has ran out, the top card of the deck returns to 0 in anticipation of a new deck
			top=0;
		}
		return C;
	}
		
		
		
}


