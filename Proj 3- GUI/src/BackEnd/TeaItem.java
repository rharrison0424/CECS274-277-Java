package BackEnd;

import java.util.ArrayList;

/**
 * the TeaItem class that constructs a tea item
 * @author-Ryan Harrison
 * @version- 1
 * @since- March 21, 2019
 * **/
public class TeaItem extends DrinkItem{
	
	private ArrayList<String> toppings= new ArrayList<String>();
	private static final double TOPPING_PRICE = 0.25;
	
	/**
	 * constructs a default tea item with no attributes
	 * **/
	public TeaItem() {
		
		setName("Tea");
		setSize(null);
		setFlavor(null);
		setSweetness(null);
		setMilk(null);
	}
	/**
	 * constructs a tea item with its size, flavor, sweetness, and type of milk
	 * **/
	public TeaItem(String size, String flavor, String sweetness, String milk) {
		
		setName("Tea");
		setSize(size);
		setFlavor(flavor);
		setSweetness(sweetness);
		setMilk(milk);
	}
	/**
	 *adds toppings that the user wants to the arraylist 
	 *@param topping- a string that represents the topping chosen by the user
	 * **/
	public void addToppings(String topping) {
		
		this.toppings.add(topping);
	}
	/**
	 *gets the string representation of the tea
	 *@return String- returns the String representation of the tea
	 * **/
	public String toString() {
		
		String result = super.toString();
		result += "\n\t\tToppings: ";
		
		if (toppings.size() == 0) {
			
			result += "none";
		}
		else {
			for (int i = 0; i < toppings.size(); i++) {
				
				result += toppings.get(i) + " | ";
			}
		}
		return result;
		
	}
	/**
	 *calculates the cost of the tea based on its size and milk add on
	 *@return double- returns the cost of the tea
	 * **/
	public double calculateCost() {
		
		double cost = 0;
		
		String [] sizes = {"S", "M", "L"};
		double [] basePrice = {2.50, 3.00, 3.50};
		
		for (int i = 0; i < sizes.length; i++) {
			
			if (sizes[i] == getSize()) {
				
				cost += basePrice[i];
			}
		}
		if (getMilk() != "no milk") {
			
			cost += 0.25;
		}
		cost += (toppings.size() * TOPPING_PRICE);
		
		return cost;
	}
}
