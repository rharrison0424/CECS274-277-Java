/**
 * models a Card with functionality to display a Card, get rank, get suit,
 * get rank value, get Card value
 * @author-Ryan Harrison
 * @version- 1
 * @since- February 7, 2019
 * **/
public class Card {
		
		private char rank;
		private char suit;

		/**
		 * constructs a Card with given rank and suit
		 * @param r- the rank of the card
		 * @param s- the suit of the card
		 * **/
		public Card(char r, char s) {
			
			rank=r;                //card consists of a rank and a suit
			suit=s;
		}
		/**
		 * displays a Card's rank and suit. Ex-8S which is the eight of spades
		 * **/
		public void display() {
			
			if (rank=='T') {
				System.out.print("10" + suit);  //if the rank is ten, it will display a two character '10'
			}
			else {
				System.out.print(rank);     //if not, it will display the single character rank and suit
				System.out.print(suit);
			}
		}
		/**
		 *gives a card a value based on its rank. The higher the rank, the higher value
		 *the card has. This allows the program to later be able to compare two cards, 
		 *to see which has a higher rank.
		 *@return int- returns the assigned value of the card based on its rank
		 * **/
		public int getRankValue() {
			if (rank=='A') {
				return 1;      // returns card value of 1 if rank is ace
			}
			else if(rank=='T'){
				return 10;   // returns card value of 10 if rank is ten or jack or queen or king
			}
			else if(rank == 'J') {
				return 11;
			}
			else if(rank == 'Q') {
				return 12;
			}
			else if(rank == 'K') {
				return 13;
			}
			else if(rank=='2' || rank=='3' || rank=='4' || rank=='5' || rank=='6' || rank=='7' || rank=='8' || rank=='9') {
				return Character.getNumericValue(rank);
			}
			else {
				return 0;
			}
		}
		/**
		 * gives each card a value which is how much that card is worth. Ace has a value
		 * of 1 and tens, kings, queens, and jacks all have values of 10
		 * @return int- returns the integer value the card is worth
		 * **/
		public int getCardValue() {
			if (rank=='A') {
				return 1;      // returns card value of 1 if rank is ace
			}
			else if(rank=='T' || rank=='J' || rank=='Q' || rank=='K'){
				return 10;   // returns card value of 10 if rank is ten or jack or queen or king
			}
			else if(rank=='2' || rank=='3' || rank=='4' || rank=='5' || rank=='6' || rank=='7' || rank=='8' || rank=='9') {
				return Character.getNumericValue(rank);
			}
			else {
				return 0;
			}
		}
		/**
		 * gets the rank of a card
		 * @return char- returns the character that represents a card's rank
		 * **/
		public char getRank() {
			return rank;         // returns rank of any given card
		}
		/**
		 *gets the suit of a card
		 *@return char- returns the character that represents a card's suit 
		 * **/
		public char getSuit() {
			return suit;         // returns suit of any given card
		}
	}


