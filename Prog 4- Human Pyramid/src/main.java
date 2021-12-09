//Ryan Harrison
//CECS 274-05
//Prog 3-Human Pyramid
//Due October 30, 2018

import java.util.Scanner;
public class main {
	static int count=0;
	public static int getWeight(int r, int c) {
		count++;
		if (c>r) {
			System.out.println("There is no person at row positon " + r + " and column position " + c);   //base case because there does not exist a person at any column number greater than the row number
			return 0;                                                                                     //each row has the same number of columns as the row number
		}
		if (r==1) {           //base case
			return 0;
		}
		if (c==1) {
			return ((getWeight(r-1,c) + 200)/2);      //left hand side of a row
		}
		if (r==c) {
			return ((getWeight(r-1,c-1) +200)/2);     //right hand side of a row
		}
		else {
			return (((getWeight(r-1,c-1)+200)/2)+ ((getWeight(r-1,c)+200)/2));   //will get person's weight at left hand side and right hand side
		}
	}
	public static int[] rowColChoice() {
		System.out.println("\nPlease type your selections for Row and Column with a space:");
		Scanner input = new Scanner(System.in);                                              
		String line=input.nextLine();              //reads the input line from user         
		String [] numbers=line.split(" ");        //splits the input based on spaces
		int [] rowCol= new int[2];                //creates integer array with two positions 
		for (int i=0; i<2;i++) {
			  rowCol[i]=Integer.parseInt(numbers[i]);   //reads the two input numbers into array
		}
		return rowCol;
	}
    public static void main(String[] args) {
		System.out.println("Welcome to the Human Pyramid. Select a row and column combination and I will tell you how much weight that person is supporting.");
		int [] userChoice=rowColChoice();
		int row=userChoice[0];             //first number inputed by user is the row
		int col=userChoice[1];             //second number is the column
		while (row != 0 && col !=0) {      //will continue to play human pyramid game till user quits by entering 0 0
			int weight=getWeight(row,col);
			System.out.println("Person at (" + row + "," + col + ") is supporting " + weight + " pounds.");;
			System.out.println("(The recursive function was called " + count + " times)");
			count=0;
			userChoice=rowColChoice();
			row=userChoice[0];
			col=userChoice[1];
		}
		System.out.println("\nThanks for playing Human Pyramid.");
	}
}
