// Ryan Harrison
// CECS 274-05
// Prog 0- Happy Birthday
// Due Aug 30, 2018

import java.util.Scanner;

public class birthday{
	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		String name;
		int age;
		int birthYear;
		char thisYear;
		
		System.out.print("What is your name?");
		name= in.next();
		System.out.print("How old are you "+name+"?");
		age= in.nextInt();
		System.out.print(name+", have you had your birthday yet this year? (y/n)");;
		thisYear= in.next().charAt(0);
		
		if (thisYear=='y' || thisYear=='Y')
			birthYear= 2018-age;
		else
			birthYear= 2018-age-1;
		System.out.println("I guess that you were born in "+birthYear);
		
	}	
	}
