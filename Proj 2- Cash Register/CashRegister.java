import java.util.ArrayList;
import java.util.Collections;

/**
 * the Pastry class that constructs a pastry
 * @author-Ryan Harrison
 * @version- 1
 * @since- February 7, 2019
 * **/
public class CashRegister {

	private ArrayList<DrinkItem> drinks= new ArrayList<DrinkItem>();
	private ArrayList<DessertItem> desserts= new ArrayList<DessertItem>();
	final double TAX = 0.0725;
	private double sumDrinks;
	private double sumDesserts;
	private double sum;
	
	/**
	 *adds drinks that the user wants to the arraylist 
	 *@param d- a DrinkItem that represents the drinks chosen by the user
	 * **/
	public void addDrink(DrinkItem d) {
		
		drinks.add(d);
	}
	/**
	 *adds desserts that the user wants to the arraylist 
	 *@param d- a DessertItem that represents the desserts chosen by the user
	 * **/
	public void addDessert(DessertItem d) {
		
		desserts.add(d);
	}
	/**
	 *clears the current cash register of all orders
	 * **/
	public void clearRegister() {
		
		int size = drinks.size();
		for(int i = 0; i < size; i++) {
			
			drinks.remove(0);
		}
		size = desserts.size();
		for(int j = 0; j < size; j++) {
			
			desserts.remove(0);
		}
	}
	/**
	 *gets the cost of the current drinks in the order
	 *@return double- returns the current price of all drinks in the order
	 * **/
	public double priceDrinks() {
		
		sumDrinks = 0;
		for(int i = 0; i < drinks.size(); i++) {
			
			sumDrinks += drinks.get(i).getCost();
		}
		return sumDrinks;
	}
	/**
	 *gets the cost of the current desserts in the order
	 *@return double- returns the current price of all desserts in the order
	 * **/
	public double priceDesserts() {
		
		sumDesserts = 0;
        for(int i = 0; i < desserts.size(); i++) {
			
			sumDesserts += desserts.get(i).getCost();
		}
		return sumDesserts;
	}
	/**
	 *gets the size of the array list holding all the desserts in the order
	 *@return int- returns the int that represents the size of the desserts 
	 * **/
	public int numberDesserts() {
		
		return desserts.size();
	}
	/**
	 *gets the size of the array list holding all the drinks in the order
	 *@return int- returns the int that represents the size of the drinks 
	 * **/
	public int numberDrinks() {
		
		return drinks.size();
	}
	/**
	 *returns the total of the current cash register order
	 *@return double- a double that represents the sum of the cash register
	 * **/
	public double total() {
		
		sum = 0;
		sum = priceDrinks() + priceDesserts();
		sum = sum + (sum * TAX);
		return sum;
	}
	/**
	 *sets the sum of the current cash register
	 *@param amt- a double that represents the sum of the cash register
	 * **/
	public void setSum(double amt) {
		
		sum = amt;
	}
	/**
	 *gets the string representation of the receipts
	 *@return String- returns the String representation of the receipts
	 * **/
	public String toString() {
		
		String result = String.format("%d Drink Items- $%.2f\n", numberDrinks(), priceDrinks());
		result += String.format("%d Desserts- $%.2f \n", numberDesserts(), priceDesserts());
		result += String.format("Total Amount: $%.2f (including tax)\n", sum);
		return result;
	}
	

}
