// Ryan Harrison
// CECS 274-05
// Prog 1-Marathon
// Due Sep 18, 2018

import java.util.Scanner;
public class Runner {
	
	public static void formatTime(boolean value,int hour, int min, int sec) {
		
		if (value==true){
			
			System.out.printf("%1d:%02d", min, sec);
		}
		else {
			
			System.out.printf("%01d:%02d:%02d", hour, min, sec);
			
		}
		
 }
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("What is your first name?:");
		String theirName= input.nextLine();
		System.out.print("How far did you run today?:");
		Float miles = input.nextFloat();
		System.out.print("How long did it take? hours:");
		int hours= input.nextInt();
		System.out.print("\t\t      minutes:");
		int min= input.nextInt();
		System.out.print("\t\t      seconds:");
		int sec= input.nextInt();
		
		int time_sec= ((hours * 3600) + (min*60) + sec);
		double pace= (time_sec / miles);
		int pace_m= (int) (pace/60);
		int pace_s= (int) (pace%60);
		
		double marathon= pace * 26.2;
		int marathon_h= (int) (marathon/3600);
		int marathon_m= (int) ((marathon%3600)/60);
		int marathon_s= (int) ((marathon%3600)%60);
		
		double ten_k_miles= (10/1.61);
		double ten_k= pace * ten_k_miles;
		int ten_k_h= (int) (ten_k/3600);
		int ten_k_m= (int) ((ten_k%3600)/60);
		int ten_k_s= (int) ((ten_k%3600)%60);
		
		System.out.println("Hi " + theirName+ ",");
		System.out.print("Your pace is ");
		formatTime(true,0,pace_m,pace_s);
		System.out.print("\nAt this rate your marathon time would be ");
		formatTime(false,marathon_h,marathon_m,marathon_s);
		System.out.print("\nand your 10K time would be ");
		formatTime(false,ten_k_h,ten_k_m,ten_k_s);
		System.out.print("\nGood luck with your training.");
		
		System.out.println("\n\nPace\t10K Time\tMaraton Time");
		System.out.println("-------------------------------------------");
		
		for (int pace_time=281;pace_time<=491;pace_time+=30) {
			
			pace_m= (pace_time/60);
			pace_s= (pace_time%60);
			formatTime(true,0,pace_m,pace_s);
			
			ten_k_miles= (10/1.61);
			ten_k= pace_time * ten_k_miles;
	        ten_k_m= (int) ((ten_k%3600)/60);
			ten_k_s= (int) ((ten_k%3600)%60);
			System.out.print("\t");
			formatTime(true,0,ten_k_m,ten_k_s);
			
			marathon= pace_time * 26.2;
			marathon_h= (int) (marathon/3600);
		    marathon_m= (int) ((marathon%3600)/60);
			marathon_s= (int) ((marathon%3600)%60);
			System.out.print("\t\t");
			formatTime(false,marathon_h,marathon_m,marathon_s);
			System.out.print("\n");
		}
		
}
	
	
	
		
	}

