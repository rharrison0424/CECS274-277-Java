package BackEnd;

/**
 * the CoffeeItem class that constructs a coffee item
 * @author-Ryan Harrison
 * @version- 1
 * @since- March 21, 2019
 * **/
public class CoffeeItem extends DrinkItem{
	
	private String temperature;
	private String specialInstructions;
	
	/**
	 * constructs a default coffee item with no attributes
	 * **/
	public CoffeeItem() {
		
		setName("Coffee");
		setSize(null);
		setFlavor(null);
		setSweetness(null);
		setMilk(null);
		temperature = null;
		specialInstructions = null;
	} 
	/**
	 * constructs a coffee item with its size, flavor, sweetness, type of milk, temperature, and special instructions
	 * **/
	public CoffeeItem(String size, String flavor, String sweetness, String milk, String temp, String instructions) {
		
		setName("Coffee");
		setSize(size);
		setFlavor(flavor);
		setSweetness(sweetness);
		setMilk(milk);
		this.temperature = temp;
		this.specialInstructions = instructions;
	}
	/**
	 *gets the string representation of the coffee
	 *@return String- returns the String representation of the coffee
	 * **/
	public String toString() {
		
		String result = super.toString();
		result += "\n\t\tTemp: " + temperature;
		result += "\n\t\tSpecial Instructions: " + specialInstructions;
		
		return result;
	}
	/**
	 *calculates the cost of the coffee based on its size, temperature, and milk add on
	 *@return double- returns the cost of the coffee
	 * **/
	public double calculateCost() {
		
		double cost = 0;
		
		String [] coffeeSize = {"S", "M", "L"};
		double [] coffeeSizeHotIced = {1.00, 1.50, 2.00};
		
		for (int i = 0; i < coffeeSize.length; i++) {
			
			if(coffeeSize[i] == getSize()) {
				
				cost += coffeeSizeHotIced[i];
			}
		}
		if (temperature.equals("blended")) {
			
			cost += 0.25;
		}
		if (getMilk() != "no milk") {
			
			cost += 0.25;
		}
		return cost;
		
	}
}
