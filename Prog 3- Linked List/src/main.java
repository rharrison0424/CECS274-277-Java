import java.util.Scanner;
import java.util.Random;

public class main {
	
	public static char menu(LinkList list) {
		LinkList myList=list;
		boolean value=false;
		while (value != true) {
			System.out.println("\n(R)emove (N)ew (F)ind Size:" + myList.size() + " Ave:" + myList.average() + " (Q)uit" );
			Scanner input = new Scanner(System.in);
			char choice= input.next().charAt(0);
			if (choice=='R' || choice=='N' || choice=='F' || choice=='Q') {
				value=true;
				return choice;
			}
		}
		return 0;
	}
	

	public static void main(String[] args) {
		Random rand=new Random();
		int r;
		LinkList myList=new LinkList();
		for (int i=0; i<200;i++) {     //this for loop creates the first 200 numbers in the link list
			r=rand.nextInt(90000)+10000;
			myList.add(r);
		}
		myList.display();
		char choice=menu(myList);
		while (choice != 'Q') {      //this while loop will be the main implementation of the code
			if (choice=='R') {      //if the user chooses to remove a number from the link list
				if (myList.isEmpty()==true){
					System.out.println("\nSorry there are no more numbers left in the Link List.");
				}
				else {
					int location=rand.nextInt(myList.size())+1;
				    int numberRemoved=myList.remove(location);
				    myList.display();
				    System.out.println("\n" + numberRemoved + " was removed at location " + location + ".");
				}
			}
			else if (choice=='N') {                    //if the user chooses to add a number to the link list
				int number= rand.nextInt(90000)+10000;
				int locationAdded=myList.add(number);
				myList.display();
				System.out.println("\n" + number + " was added to location " + locationAdded + ".");
			} 
			else {                     //this will find a number in the list entered in by the user
				boolean value=false;
				int number=0;
				while (value != true) {
					System.out.println("\nPlease enter a five digit number.");  //this asks the user to enter a five digit number
					Scanner input = new Scanner(System.in);
				    number= input.nextInt();
					if (number>=10000 && number<=99999) {
						value=true;
					}
				}
				int location=myList.findNumber(number);
				if (location==0) {
					System.out.println("\n" + number + " was not found.");  
				}
				else {
					System.out.println("\n" + number + " was found in location " + location + ".");
				}
			}
			choice=menu(myList);
		}
		
	}
}
