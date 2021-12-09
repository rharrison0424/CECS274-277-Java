/**
 * the Pastry class that constructs a pastry
 * @author-Ryan Harrison
 * @version- 1
 * @since- February 7, 2019
 * **/
public class Pastry extends DessertItem{
	
	private String pastryType;
	private int quantity;
	private double unitPrice;
	private double HEATING = 0.25;
	private boolean heat;
	
	/**
	 * constructs a pastry with the type of pastry and quantity
	 * **/
	public Pastry(String pastry, int q) {
		
		super("Pastry");
		pastryType = pastry;
		quantity = q;
	}
	/**
	 *sets the heat of the pastry to true/false depending on if they want it heated
	 *@param value- a boolean that represents the truth value of heating the pastry
	 * **/
	public void setHeat(boolean value) {
		
		heat = value;
	}
	/**
	 *gets the heat boolean value
	 *@return heat-returns the truth value of heating the pastry
	 * **/
	public boolean getHeat() {
		
		return heat;
	}
	/**
	 *sets the unit price of the pastry
	 *@param price- a double representing the price of a pastry
	 * **/
	public void setUnitPrice(double price) {
		
		unitPrice = price;
	}
	/**
	 *gets the unit price of a pastry
	 *@return double- returns the unit price of a pastry
	 * **/
	public double getUnitPrice() {
		
		return unitPrice;
	}
	/**
	 *sets the quantity of pastries wanted by the user
	 *@param q- a int that represents the quantity of pastries
	 * **/
	public void setQuantity(int q) {
		
		quantity = q;
	}
	/**
	 *gets the quantity
	 *@return int- returns the quantity of pastries wanted by the customer
	 * **/
	public int getQuantity() {
		
		return quantity;
	}
	/**
	 *sets the type of pastry
	 *@param pastry- a string that represents the type of pastry
	 * **/
	public void setPastryType(String pastry) {
		
		pastryType = pastry;
	}
	/**
	 *gets the type of pastry
	 *@return String- returns the String representation of the type of pastry
	 * **/
	public String getPastryType() {
		
		return pastryType;
	}
	/**
	 *gets the cost of the pastry
	 *@return double- returns the cost of the pastry
	 * **/
	public double getCost() {
		if(heat) {
			
			return (quantity * unitPrice) + HEATING;
		}
		else {
			
			return quantity * unitPrice;
		}
	}
	/**
	 *gets the string representation of the pastry
	 *@return String- returns the String representation of the pastry
	 * **/
	public String toString(){
		
		String result = quantity + " " + pastryType + "s\n";
		if(heat == true) {
			
			result += "heated";
		}
		else {
			
			result += "not heated";
		}
		result += String.format("\nTotal: $%.2f\n", getCost());
		return result;
	}
	/**
	 *gets the highet priced pastry by comparing the parameter pastry with the current cost
	 *@return int- returns an int representation of the highest costing pastry
	 *@param DessertItem- a pastry object
	 * **/
	public int compareTo(DessertItem p) {
		
	       if(this.getCost() > p.getCost()) {
				
				return 1;
			}
			if(this.getCost() < p.getCost()) {
				
				return -1;
			}
			else {
				return 0;
			}
		}

}
