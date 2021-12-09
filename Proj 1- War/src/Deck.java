import java.util.ArrayList;
import java.util.Random;   // need this for shuffle

/**
 * models a deck of cards with functionality to shuffle the deck and deal the cards
 * in the deck
 * @author-Ryan Harrison
 * @version- 1
 * @since- February 7, 2019
 * **/
public class Deck {
	
	private ArrayList<Card> storage= new ArrayList<Card>();
	private int top=0;
	
	/**
	 * constructs the deck of 52 cards with 13 ranks and 4 suits
	 * **/
	public Deck() {
		Card C1;
		char rank;
		char suit;
		for(int i=1; i<5; i++) {
			for(int j=1; j<14; j++) {
				
				if(i==1) {
					suit='S';
				}
				else if(i==2) {
					suit='H';
				}
				else if(i==3) {
					suit='D';
				}
				else {
					suit='C';
				}
				if(j==1) {
					rank='A';
				}
				else if(j>1 && j<10) {
					char jChar=(char) (j+'0');
					rank=jChar;
				}
				else if(j==10) {
					rank='T';
				}
				else if(j==11) {
					rank='J';
				}
				else if(j==12){
					rank='Q';
				}
				else {
					rank='K';
				}
				C1=new Card(rank,suit);
				storage.add(C1);
			}
		}
		
	}
	/**
	 *shuffles the deck by switching two random card's positions in the deck 10,000 times  
	 * **/
    public void shuffle() {
		
		int x,y;
		Random ran= new Random();    //creates random variable
		for (int i=0; i<10000;i++) {   //shuffles two cards in the deck 10,000 times
			x= ran.nextInt(52);   //sets variable x to random position in the array of 52 cards
			y=ran.nextInt(52);    //sets variable y to random position in the array of 52 cards
			Card temp1= storage.get(x); //sets a temporary card to the card at the position of x
			Card temp2=storage.get(y);
			storage.set(x, temp2);  //swaps the card at position of x with the card at the position of y
			storage.set(y, temp1);        // swaps the card at position of y with the position of x
		}
	}
    /**
     * deals the top card from the deck
     * @return Card- returns the card at the top of the deck
     * **/
    public Card deal() {
		
		Card C=new Card(storage.get(top).getRank(),storage.get(top).getSuit());   //gets a new card at the position of storage
		top=top+1;
		return C;
	}
}


