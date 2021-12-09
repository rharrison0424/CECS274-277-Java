
public class CoffeeDrink extends DrinkItem {
	
	private String base;
	private double cost;
	
	/**
	 * constructs a coffee drink with the base milk
	 * **/
	public CoffeeDrink(String base) {
		
		super("Coffee");
		this.base = base;
	}
	/**
	 *sets the base of the coffee
	 *@param base- a string that represents the base of the coffee
	 * **/
	public void setBase(String base) {
		
		this.base = base;
	}
	/**
	 *gets the type of base for the coffee
	 *@return String- returns the String that represents the base 
	 * **/
	public String getBase() {
		
		return base;
	}
	/**
	 *sets the cost of the size of the coffee
	 *@param costSize- a double that represents the cost of the size of the coffee
	 * **/
	public void setCost(double costSize) {
		
		cost = costSize;
	}
	/**
	 *gets the cost of the coffee
	 *@return double- returns the double that represents the cost of the coffee
	 * **/
	public double getCost() {
		
		return cost;
	}
	/**
	 *gets the string representation of the coffee
	 *@return String- returns the String representation of the coffee
	 * **/
	public String toString() {
		
		String result = getSize() + " Coffee with\n";
		result += getSweetness() + "\n" + base + " base\n";
		result += String.format("Total: $%.2f\n", getCost());
		return result;
	}
	/**
	 *gets the highet priced coffee by comparing the paramater coffee with the current cost
	 *@return int- returns an int representation of the highest costing coffee
	 *@param DrinkItem- a coffee drink item
	 * **/
	public int compareTo(DrinkItem c) {
		
		if(this.cost > c.getCost()) {
			
			return 1;
		}
		if(this.cost < c.getCost()) {
			
			return -1;
		}
		else {
			return 0;
		}
	}

}
