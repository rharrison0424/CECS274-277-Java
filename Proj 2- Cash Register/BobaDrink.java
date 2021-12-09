import java.util.ArrayList;
import java.util.Collections;

/**
 * the BobaDrink class that constructs a boba drink with the type of base tea, milk, cost, toppings
 * @author-Ryan Harrison
 * @version- 1
 * @since- February 7, 2019
 * **/
public class BobaDrink extends DrinkItem{
	
	private String baseTea;
	private ArrayList<String> toppings= new ArrayList<String>();
	private String milk;
	private double cost;
	private double TOPPING = 0.25;
	
	/**
	 * constructs a boba drink with the base tea
	 * **/
	public BobaDrink(String tea) {
		
		super("Boba");
		baseTea = tea;
	}
	/**
	 *sets the base tea of the boba
	 *@param tea- a string that represents the base tea
	 * **/
	public void setBaseTea(String tea) {
		
		baseTea = tea;
	}
	/**
	 *gets the type of base tea
	 *@return String- returns the String that represents the base tea
	 * **/
	public String getBaseTea() {
		
		return baseTea;
	}
	/**
	 *sets the type of milk in the boba
	 *@param milkType- a string that represents the type of milk to be used in the Boba
	 * **/
	public void setMilk(String milkType) {
		
		milk = milkType;
	}
	/**
	 *gets the type of milk
	 *@return String- returns the String that represents the type of milk 
	 * **/
	public String getMilk() {
		
		return milk;
	}
	/**
	 *adds toppings that the user wants to the arraylist 
	 *@param topping- a string that represents the topping chosen by the user
	 * **/
	public void addTopping(String topping) {
		
		toppings.add(topping);
	}
	/**
	 *sets the cost of the size of the boba
	 *@param costSize- a double that represents the cost of the size of the boba
	 * **/
	public void setCost(double costSize) {
		
		cost = costSize;
	}
	/**
	 *gets the cost of the boba
	 *@return double- returns the cost of the boba
	 * **/
	public double getCost() {
		
		return cost + (toppings.size() * TOPPING);
	}
	/**
	 *gets the string representation of the boba
	 *@return String- returns the String representation of the boba
	 * **/
	public String toString() {
		
		String result = getSize() + " Boba with\n";
		result += baseTea + "\n" + getSweetness() + " sweetness\n" + milk + "\n";
		
		for(int i = 0; i < toppings.size(); i++) {
			
			result += toppings.get(i) + ", ";
		}
		result += String.format("\nTotal: $%.2f\n", getCost());
		return result;
	}
	/**
	 *gets the highet priced boba by comparing the paramater boba with the current cost
	 *@return int- returns an int representation of the highest costing boba
	 *@param DrinkItem- a boba drink item
	 * **/
	public int compareTo(DrinkItem b) {
		
       if(this.cost > b.getCost()) {
			
			return 1;
		}
		if(this.cost < b.getCost()) {
			
			return -1;
		}
		else {
			return 0;
		}
	}


	

}
