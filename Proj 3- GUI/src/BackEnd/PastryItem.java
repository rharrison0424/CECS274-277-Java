package BackEnd;

/**
 * the PastryItem class that constructs a pastry item
 * @author-Ryan Harrison
 * @version- 1
 * @since- March 21, 2019
 * **/
public class PastryItem extends Item{
	
	private String flavor;
	private boolean isHeated;
	private static final double HEAT_PRICE = 0.25;
	
	/**
	 * constructs a pastry with the type of pastry, flavor, and if it is heated
	 * **/
	public PastryItem(String pastryType, String flavor, boolean heat) {
		
		setName(pastryType);
		this.flavor = flavor;
		isHeated = heat;
	}
	/**
	 *calculates the cost of the pastry based on its type and if it is heated
	 *@return double- returns the cost of the pastry
	 * **/
	public double calculateCost() {
		
		double cost = 0;
		
		if (getName().equals("Cheesecake Slice")) {
			
			String [] cheesecakeType = {"Regular", "Cherry", "Blueberry"};
			double [] cheesecakeTypePrice = {4.00, 4.50, 4.50};
			
			for (int i = 0; i < cheesecakeType.length; i++) {
				
				if (cheesecakeType[i] == flavor) {
					
					cost += cheesecakeTypePrice[i];
				}
			}
		}
		else {
			
			String [] type = {"Muffin", "Cookie", "Danish"};
			double [] typePrice = {2.00, 1.50, 2.50};
			
			for (int i = 0; i < type.length; i++) {
				
				if (type[i] == getName()) {
					
					cost += typePrice[i];
				}
			}
		}
		if (isHeated) {
			
			cost += HEAT_PRICE;
		}
		return cost;
	}
	/**
	 *gets the string representation of the pastry
	 *@return String- returns the String representation of the pastry
	 * **/
	public String toString() {
		
		String result = "--" + getName();
		
		if(isHeated) {
			
			result += "(heated):";
		}
		else {
			
			result += "(not heated):";
		}
		result += String.format("\t\t$%.2f\n", getCost()); 
		result += "\t\t" + flavor;
		
		return result;
	}

}
