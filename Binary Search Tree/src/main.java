import java.util.Scanner;

public class main {
	
	public static void menu(BST tree) {
		
		BST mytree=tree;
		int [] valuesArray= mytree.BSTtoArray();
	    mytree.display(valuesArray);
		System.out.print("\nSorted List: ");
		mytree.printInOrder();
		System.out.println("\nTree Height: " + mytree.height());
		System.out.print("Root Value: ");
		mytree.rootValue();
		System.out.println("Item Count: " + mytree.count());
	}
	public static char menuChoice() {
		
		boolean value=false;
		while(value != true) {
			
			System.out.println("(A)dd item   (R)emove item   (F)ind item   (I)nitialize tree   (N)ew tree    (Q)uit");
			Scanner input = new Scanner(System.in);
			char choice= input.next().charAt(0);
			if (choice=='R' || choice=='N' || choice=='F' || choice=='Q' || choice=='A' || choice=='I' || choice=='r' || choice=='n' || choice=='f' || choice=='q' || choice=='a' || choice=='i' ) {
				value=true;
				return choice;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		
		BST mytree= new BST();
		mytree.displayEmptyTree();
		char choice=menuChoice();
		
		while(choice != 'Q' && choice != 'q') {
			
			if(choice=='A' || choice=='a') {
				
				System.out.println("Please enter a number to add to the tree:");
				Scanner input=new Scanner(System.in);
				int value= input.nextInt();
				mytree.add(value);
				menu(mytree);
				choice=menuChoice();
			}
			else if(choice=='R' || choice=='r') {
				
				System.out.println("Please enter a number to remove from the tree:");
				Scanner input=new Scanner(System.in);
				int value= input.nextInt();
				mytree.remove(value);
				if(mytree.getRoot()==null) {
					
					mytree.displayEmptyTree();
					choice=menuChoice();
				}
				else {
					
					menu(mytree);
					choice=menuChoice();
					
				}
			}
			else if(choice=='F' || choice=='f') {
				
				System.out.println("Please enter a number to find on the tree:");
				Scanner input=new Scanner(System.in);
				int value= input.nextInt();
				int found= mytree.find(value);
				
				if(found==0) {
					
					System.out.println("That number was not found in the tree");
				}
				else {
					
					System.out.println("That number was found at tree level " + found);
				}
				menu(mytree);
				choice=menuChoice();
			}
			else if(choice=='I' || choice=='i') {
				
				mytree= new BST();
				mytree.init();
				menu(mytree);
				choice=menuChoice();
			}
			else{
				
				mytree= new BST();
				mytree.displayEmptyTree();
				choice=menuChoice();
			}
			
		}
		
	}
}
