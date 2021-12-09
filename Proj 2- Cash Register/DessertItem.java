import java.util.ArrayList;
import java.util.Collections;

/**
 * the dessert item class that constructs a dessert item with the type of dessert
 * @author-Ryan Harrison
 * @version- 1
 * @since- February 7, 2019
 * **/
public abstract class DessertItem implements Comparable<DessertItem>{
	
	private String dessert;
	
	/**
	 * constructs a dessert item with just the type of dessert
	 * **/
	public DessertItem(String d) {
		
		dessert = d;
	}
	/**
	 *sets the type of the dessert
	 *@param d- a string that represents the type of dessert
	 * **/
	public void setDessert(String d) {
		
		dessert = d;
	}
	/**
	 *gets the type of dessert
	 *@return String- returns the String that represents the type of dessert 
	 * **/
	public String getDessert() {
		
		return dessert;
	}
	/**
	 *gets the string representation of the dessert
	 *@return String- returns the String representation of the dessert
	 * **/
	public String toString() {
		
		return dessert + "";
	}
	/**
	 *gets the highet priced dessert item in the order
	 *@return DessertItem- returns the desserts item that costs the most in the array
	 *@param desserts- an array that stores all the desserts in the current order
	 * **/
	 public static DessertItem max(ArrayList <DessertItem> desserts) {
			
		return Collections.max(desserts);
	}
	 /**
		 *an abstract class representing the cost to be determined in subclasses
		 *@return double- returns the cost of a dessert 
		 * **/
	public abstract double getCost();
	

	
}
