package BackEnd;

/**
 * the abstract item class that constructs a item
 * @author-Ryan Harrison
 * @version- 1
 * @since- March 21, 2019
 * **/
public abstract class Item {
	
	private String name;
	private double cost;
	
	/**
	 * constructs a default item with no attributes
	 * **/
	public Item() {
		
		name = null;
		cost = 0;
	}
	/**
	 * constructs a item with the name of the item and its cost
	 * **/
	public Item(String name, double cost) {
		
		this.name = name;
		this.cost = cost;
	}
	/**
	 *sets the name of the item
	 *@param name- a string that represents the name of the item
	 * **/
	public void setName(String name) {
		
		this.name = name;
	}
	/**
	 *sets the cost of the item
	 *@param cost- a double that represents the cost of the item
	 * **/
	public void setCost(double cost) {
		
		this.cost = cost;
	}
	/**
	 *gets the name of the item
	 *@return String- returns the String that represents a item's name 
	 * **/
	public String getName() {
		
		return name;
	}
	/**
	 *gets the cost of the item
	 *@return double- returns a double that represents how much an item costs 
	 * **/
	public double getCost() {
		
		return cost;
	}
	/**
	 *an abstract class representing the cost to be calculated in subclasses
	 *@return double- returns the calculated cost of a item 
	 * **/
	public abstract double calculateCost();

}
