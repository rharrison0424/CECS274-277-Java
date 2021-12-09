import java.util.Scanner;

public class main {

	public static boolean isPrime(int n) {
		
		if (n==0 || n==1) {    //0 and 1 are not prime numbers
			return false;
		}
		else if(n==2 || n==3 || n==5 || n==7 || n==11) {  //2,3,5,7,11 are the lowest prime numbers
			return true;
		}
		else if (n%2==0 || n%3==0 || n%5==0 || n%7==0 || n%11==0) {  //if any number is divisible by these numbers, then it is not prime
			return false;
		}
		return true;
	}
	public static void playSolitare(Deck myDeck){
		
		int cardNumber=0;
		int pile=0;
		int sum=0;
		Card myCard;
		System.out.println("\nPlaying Solitare Prime!\n");
		while (cardNumber<52) {
			
			while (isPrime(sum) != true && cardNumber<52) {  //loops through the deck while the sum is not prime and the deck still contains cards
				
				myCard= myDeck.deal();
				myCard.display();
				System.out.print(", ");
				sum+= myCard.getValue();
				cardNumber=cardNumber+1;
			}
			if (cardNumber<52) {
				System.out.print("Prime: " + sum + "\n");   //while their are cards left in the deck and the sum becomes prime, it will print out the prime number
				sum=0;
			}
			pile=pile+1;   //keeps track of how many piles are created
		}
		cardNumber=cardNumber+1;
		if (isPrime(sum)==true) {                     //once the last card in the deck is dealt, this determines if the sum is prime
			System.out.print("Prime: " + sum + "\n");
			System.out.print("\nWinner in " + pile + " piles.\n" );  //if the sum is prime, the user wins the game
		}
		else {
			System.out.print("Loser\n");  //if the sum is not prime, the user loses the game
		}
		
	}
	public static int menu() {  //creates and displays a menu for the user
		
		boolean value=false;
		while (value != true) {
			System.out.println("\nWelcome to Solitare Prime!");
		    System.out.println("1.New Deck");
		    System.out.println("2.Display Deck");
		    System.out.println("3.Shuffle Deck");
		    System.out.println("4.Play Solitare Prime");
		    System.out.println("5.Exit");
		    Scanner input = new Scanner(System.in);
		    int choice= input.nextInt();
		    if (choice>0 && choice<6) {   //validates the user entered a number between 1 and 5, or else it will ask the user to enter a number again
		    	value=true;
			    return choice;
			}
		}
		return 0;
	}
	public static void main(String[] args) {   //the main function in the program
		
		Deck myDeck=new Deck();
		int choice=menu();
		while (choice != 5) {       //goes through each possible choice the user has
		   if (choice==1) {
			   myDeck= new Deck();
		   }
		   else if (choice==2) {
			   myDeck.display();
		   }
		   else if (choice==3) {
			   myDeck.shuffle();
		   }
		   else {
			   playSolitare(myDeck);
		   }
		   choice=menu();
		
		}
	
		    
		
	}

}
