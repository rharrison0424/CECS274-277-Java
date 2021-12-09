// Ryan Harrison
// CECS 274-05
// Prog 2-Solitare Prime
// Due October 2, 2018

public class Card {
	private char suit;
	private char rank;
	
	public Card(char r, char s) {
		
		rank=r;                //card consists of a rank and a suit
		suit=s;
	}
	public void display() {
		
		if (rank=='T') {
			System.out.print("10" + suit);  //if the rank is ten, it will display a two character '10'
		}
		else {
			System.out.print(rank);     //if not, it will display the single character rank and suit
			System.out.print(suit);
		}
	}
	public int getValue() {
		int cardValue;
		if (rank=='A') {
			return cardValue=1;      // returns card value of 1 if rank is ace
		}
		else if(rank=='T' || rank=='J' || rank=='Q' || rank=='K'){
			return cardValue=10;   // returns card value of 10 if rank is ten or jack or queen or king
		}
		else {
			char [] remainingRanks= {'2','3','4','5','6','7','8','9'};
			for (int i=0; i<8;i++) { 
				if (rank==remainingRanks[i]) {  //loops through a list of remaining ranks to determine card value
					return cardValue=2+i;    //if given rank is the same as one of the ranks in the list it will
				}                            //return the card value of 2 + the position of the rank in the list
			}
		}
        return 0;
	}
	public char getRank() {
		return rank;         // returns rank of any given card
	}
	public char getSuit() {
		return suit;         // returns suit of any given card
	}
	
	

}