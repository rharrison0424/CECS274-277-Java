import java.util.ArrayList;
import java.util.Scanner;

/**
 * the main class of the program that implements the game of war and the war mode
 * @author-Ryan Harrison
 * @version- 1
 * @since- February 7, 2019
 * **/
public class main{
	
	/**
	 * implements the war mode where three cards are played face down and the fourth card
	 * in each hand is played to determine the winner
	 * @param playerHand- an array list that stores all the cards in the hand of
	 * the player
	 * @param computerHand- an array list that stores all the cards in the hand of 
	 * the computer
	 * @param warCards- an array list that stores and keeps track of all the cards 
	 * being played during the war 
	 * **/
	public static void warMode(ArrayList<Card> playerHand, ArrayList<Card> computerHand, ArrayList<Card> warCards) {
		//case 1: each player has more than three cars in their hands
		if(playerHand.size() > 3 && computerHand.size() > 3) {
			for (int i=0; i<3; i++) {
				
				warCards.add(playerHand.get(i));
			    warCards.add(computerHand.get(i));
			}
			for(int i=0; i<3; i++) {
				
				playerHand.remove(0);
			    computerHand.remove(0);
		    }
			System.out.println("    " + "XXX" + "\t\t    " + "XXX");
			System.out.println("Three cards from both hands have been played faced down.");
		    System.out.println("The fourth card in each hand is:");
		}
		//case 2: the player has more than three cards in their hand
		//but the computer has less than three cards in their hand
		else if(playerHand.size() > 3 && computerHand.size() <= 3) {
			
			for(int i=0; i<3; i++) {
				
				warCards.add(playerHand.get(i));
			} //plays three cards face down from the player's hand 
			for(int i=0; i<3; i++) {
				
				playerHand.remove(0);
			}
			if(computerHand.size() == 3) {
				
				warCards.add(computerHand.get(0));
				warCards.add(computerHand.get(1));
				computerHand.remove(0);
				computerHand.remove(1);
				System.out.println("The fourth card in the player hand is: and the third card in the computer hand is");
			}
			else if(computerHand.size() == 2) {
				
				warCards.add(computerHand.get(0));
				computerHand.remove(0);
				System.out.println("The fourth card in the player hand is: and the second card in the computer hand is:");
			}
			else {
				System.out.println("The fourth card in the player hand is: and the last card left in the computer hand is:");
			}
			
		}
		//case 3: the computer has more than three cards in their hand
		//but the player has less than three cards in their hand
		else if(playerHand.size() <= 3 && computerHand.size() > 3) {
			for(int i=0; i<3; i++) {
				
				warCards.add(computerHand.get(i));
			}//plays three cards face down from the computer's hand 
			for(int i=0; i<3; i++) {
				
				computerHand.remove(0);
			}
			if(playerHand.size() == 3) {
				
				warCards.add(playerHand.get(0));
				warCards.add(playerHand.get(1));
				playerHand.remove(0);
				playerHand.remove(1);
				System.out.println("The third card in the player hand is: and the fourth card in the computer hand is:");
			}
			else if(playerHand.size() == 2) {
				
				warCards.add(playerHand.get(0));
				playerHand.remove(0);
				System.out.println("The second card in the player hand is: and the fourth card in the computer hand is:");
			}
			else {
				System.out.println("The only card left in the player hand is: and the fourth card in the computer hand is:");
			}
		}
		//plays the deciding card from both hands and displays it to the screen
	    Card topPlayerCard= playerHand.get(0);
	    Card topComputerCard= computerHand.get(0);
	    playerHand.remove(0);
	    computerHand.remove(0);
	    warCards.add(topPlayerCard);
	    warCards.add(topComputerCard);
	    System.out.print("    ");
	    topPlayerCard.display();
	    System.out.print("\t\t    ");
	    topComputerCard.display();
	    System.out.println();
	    
	    if(topPlayerCard.getRankValue() == topComputerCard.getRankValue()) {
	    	//play war again if the deciding cards have the same rank
	    	warMode(playerHand, computerHand, warCards);
	    }
	    else if(topPlayerCard.getRankValue() > topComputerCard.getRankValue()) {
	    	
	    	System.out.println("Congratulations! You won the war round!");
	
	    	for(int i=0; i<warCards.size(); i++) {
	    		
	    		playerHand.add(warCards.get(i));
	    	}
	    }
	    else {
	    	System.out.println("Sorry! You lost the war round!");
	 
	    	for(int i=0; i<warCards.size(); i++) {
	    		
	    		computerHand.add(warCards.get(i));
	    	}
	    }
		for(int i=0; i<warCards.size(); i++) {
			//remove all cards from the Array list for next war round
			warCards.remove(0);
		}
}
		
		
		
	/**
	 * implements the game of war where each player plays a card face up and the higher
	 * rank wins the hand
	 * @param playerHand- an array list that stores all the cards in the hand of
	 * the player
	 * @param computerHand- an array list that stores all the cards in the hand of 
	 * the computer
	 * **/
	public static void playWar(ArrayList<Card> playerHand, ArrayList<Card> computerHand) {
		
		System.out.println("Player Card \tComputerCard");
		System.out.println("----------- \t-------------");
		
		boolean value=false;
		
		while(value != true) {
			
			if(playerHand.isEmpty()==false && computerHand.isEmpty()==false) {
				//plays top card from both hands
				System.out.println("The player has " + playerHand.size() + " cards in their hand.");
			    System.out.println("The computer has " + computerHand.size() + " cards in their hand.");
				Card topPlayerCard= playerHand.get(0);
			    Card topComputerCard= computerHand.get(0);
			    playerHand.remove(0);
			    computerHand.remove(0);
			    System.out.print("    ");
			    topPlayerCard.display();
			    System.out.print("\t\t    ");
			    topComputerCard.display();
			    System.out.println();
			    
			    
			    int playerCardRank= topPlayerCard.getRankValue();
			    int computerCardRank= topComputerCard.getRankValue();
			    
			    if(playerCardRank == computerCardRank) {
			    	//enter war mode
			    	ArrayList<Card> warCards= new ArrayList<Card>();
			    	warCards.add(topPlayerCard);
			    	warCards.add(topComputerCard);
			    	warMode(playerHand, computerHand, warCards);
			    }
			    else if(playerCardRank > computerCardRank) {
			    	//the player wins the hand
			    	if(topPlayerCard.getCardValue() >= 7 && topComputerCard.getCardValue() <= 4 ) {
			    		//the computer plays a second card to try to win the hand
			    		System.out.println("The computer is going to play a second card.");
			    		Card secondTopComputerCard = computerHand.get(0);
			    		computerHand.remove(0);
			    		System.out.print("The card is a ");
			    		secondTopComputerCard.display();
			    		System.out.println("\n");
			    		int total = topComputerCard.getCardValue() + secondTopComputerCard.getCardValue();
			    		
			    		if(total <= topPlayerCard.getCardValue()) {
			    			
			    			System.out.println("The total of the two cards is " + total + " the computer wins and gets your card");
			    			computerHand.add(topPlayerCard);
			    			computerHand.add(topComputerCard);
			    			computerHand.add(secondTopComputerCard);
			    	    }
			    		else {
			    			
			    			System.out.println("The total of the two cards is " + total + " the computer loses! You gain the two cards.");
			    			playerHand.add(topComputerCard);
					    	playerHand.add(topPlayerCard);
					    	playerHand.add(secondTopComputerCard);
			    			
			    		}
			    	}
			    	else {
			    		
			    		playerHand.add(topComputerCard);
				    	playerHand.add(topPlayerCard);
			    	}
			    }
			    else {
			    	//the player loses the initial hand and is asked if they would
			    	//like to play a second card to try to win the hand
			    	System.out.println("You have a lower card than the computer.");
			    	System.out.println("Would you like to play a second card for a chance to win the hand?");
			    	Scanner input = new Scanner(System.in);
				    char choice= input.next().charAt(0);
				    if(choice == 'y' || choice == 'Y') {
				    	
				    	Card secondTopPlayerCard= playerHand.get(0);
				    	playerHand.remove(0);
				    	System.out.print("The second card is a ");
				    	secondTopPlayerCard.display();
				    	System.out.println("\n");
				    	int total = secondTopPlayerCard.getCardValue() + topPlayerCard.getCardValue();
				    	
				    	if(total <= topComputerCard.getCardValue()) {
				    		//the player's second card wins the hand because the sum
				    		//is lower than the computer card's value
				    		System.out.println("The total of the two cards is " + total);
				    		System.out.println("It is less than or equal to the computer's card. You win!");
				    		playerHand.add(topComputerCard);
				    		playerHand.add(topPlayerCard);
				    		playerHand.add(secondTopPlayerCard);
				    	}
				    	else {
				    		
				    		System.out.println("The total of the two cards is " + total + " you lose!");
				    		computerHand.add(topPlayerCard);
				    		computerHand.add(secondTopPlayerCard);
					    	computerHand.add(topComputerCard);
				    		
				    	}
			    }
				    else {
				    	
				    	computerHand.add(topPlayerCard);
				    	computerHand.add(topComputerCard);
				    }
			    
			}
			}
			else {
				
				value=true;
				if(playerHand.isEmpty() == true) {
					System.out.println("Sorry you lost!");
				}
				else {
					System.out.println("Congratulations! You Won!");
				}
			}
			
		}
	}
    
	/**
	 * creates a new deck and shuffles the deck. creates two array lists to store
	 * the cards in the hands of the player and computer. deals 26 cards into each
	 * array list from the deck and calls the playWar function
	 * **/
	public static void main(String[] args) {

		Deck myDeck= new Deck();
		myDeck.shuffle();
		System.out.println("\n");
		
		ArrayList<Card> playerHand= new ArrayList<Card>();
		ArrayList<Card> computerHand= new ArrayList<Card>();
		
		for(int i=0; i<52; i++) {
			
			Card C= myDeck.deal();
			if(i % 2 == 0) {
				playerHand.add(C);
			}
			else {
				computerHand.add(C);
			}
		}
		playWar(playerHand,computerHand);

	}

}
