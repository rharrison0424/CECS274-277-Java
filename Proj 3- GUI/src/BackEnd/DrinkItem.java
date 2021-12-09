package BackEnd;

/**
 * the abstract DrinkItem class that constructs a drink item
 * @author-Ryan Harrison
 * @version- 1
 * @since- March 21, 2019
 * **/
public abstract class DrinkItem extends Item{
	
	private String size;
	private String flavor;
	private String sweetness;
	private String milk;
	
	/**
	 * constructs a default drink item with no attributes
	 * **/
	public DrinkItem() {
		
		size = null;
		flavor = null;
		sweetness = null;
		milk = null;
	}
	/**
	 * constructs a drink item with its type, size, flavor, sweetness, and type of milk
	 * **/
	public DrinkItem(String drinkType, String size, String flavor, String sweetness, String milk) {
		
		setName(drinkType);
		this.size = size;
		this.flavor = flavor;
		this.sweetness = sweetness;
		this.milk = milk;
	}
	/**
	 *sets the flavor of the drink
	 *@param flavor- a string that represents the flavor of the drink
	 * **/
	public void setFlavor(String flavor) {
		
		this.flavor = flavor;
	}
	/**
	 *sets the milk of the drink
	 *@param milk- a string that represents the milk type in the drink
	 * **/
	public void setMilk(String milk) {
		
		this.milk = milk;
	}
	/**
	 *sets the size of the drink
	 *@param size- a string that represents the size of the drink
	 * **/
	public void setSize(String size) {
		
		this.size = size;
	}
	/**
	 *sets the sweetness of the drink
	 *@param sweetness- a string that represents the sweetness of the drink
	 * **/
	public void setSweetness(String sweetness) {
		
		this.sweetness = sweetness;
	}
	/**
	 *gets the flavor of the drink
	 *@return String- returns the String that represents a drink's flavor 
	 * **/
	public String getFlavor() {
		
		return flavor;
	}
	/**
	 *gets the milk type to be used in the drink
	 *@return String- returns the String that represents a drink's milk type 
	 * **/
	public String getMilk() {
		
		return milk;
	}
	/**
	 *gets the size of the drink
	 *@return String- returns the String that represents a drink's size 
	 * **/
	public String getSize() {
		
		return size;
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
		
		String result = "--" + flavor + " " + getName() + "(" + size + ")";
		
		result += String.format("\t\t$%.2f", getCost()); 
		result += "\n\t\tSweetness: " + sweetness;
		result += "\n\t\tMilk: " + milk;
		
		return result;
	}
}
