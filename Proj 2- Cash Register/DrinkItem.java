import java.util.ArrayList;
import java.util.Collections;

/**
 * the drink item class that constructs a drink item with its name, sweetness, and size
 * @author-Ryan Harrison
 * @version- 1
 * @since- February 7, 2019
 * **/
public abstract class DrinkItem implements Comparable<DrinkItem>{
	
	private String drinkName;
	private String sweetness;
	private String size;
	
	/**
	 * constructs a drink item with just the name of the drink
	 * **/
	public DrinkItem(String drink) {
		
		drinkName = drink;
	}
	/**
	 * constructs a drink item with name of the drink and sweetness
	 * **/
	public DrinkItem(String drink, String sweetness) {
		
		drinkName = drink;
		this.sweetness = sweetness;
	}
	/**
	 * constructs a drink item with name of the drink and sweetness and size
	 * **/
	public DrinkItem(String drink, String sweetness, String size) {
		
		drinkName = drink;
		this.sweetness = sweetness;
		this.size = size;
	}
	/**
	 *sets the size of the drink
	 *@param drinkSize- a string that represents the size of a drink
	 * **/
	public void setSize(String drinkSize) {
		
		size = drinkSize; 
	}
	/**
	 *gets the size of the drink
	 *@return String- returns the String that represents a drink's size 
	 * **/
	public String getSize() {
		
		return size;
	}
	/**
	 *sets the name of the drink
	 *@param drink- a string that represents the name of a drink
	 * **/
	public void setDrink(String drink) {
		
		drinkName = drink;
	}
	/**
	 *gets the name of the drink
	 *@return String- returns the String that represents a drink's name, Boba or Coffee 
	 * **/
	public String getDrink() {
		
		return drinkName;
	}
	/**
	 *sets the sweetness of the drink
	 *@param sweet- a string that represents the sweetness of a drink
	 * **/
	public void setSweetness(String sweet) {
		
		sweetness = sweet;
	}
	/**
	 *gets the sweetness of the drink
	 *@return String- returns the String that represents a drink's sweetness 
	 * **/
	public String getSweetness() {
		
		return sweetness;
	}
	/**
	 *gets the string representation of the drink
	 *@return String- returns the String representation of the drink
	 * **/
	public String toString() {
		
		return drinkName + "" + sweetness + "" + size;
	}
	/**
	 *gets the highet priced drink item in the order
	 *@return DrinkItem- returns the drink item that costs the most in the array
	 *@param drinks- an array that stores all the drinks in the current order
	 * **/
	public static DrinkItem max(ArrayList <DrinkItem> drinks) {
		
		return Collections.max(drinks);
	}
	/**
	 *an abstract class representing the cost to be determined in subclasses
	 *@return double- returns the cost of a drink 
	 * **/
	public abstract double getCost();

}
