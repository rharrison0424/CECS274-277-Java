/**
 * the Pastry class that constructs a cookie
 * @author-Ryan Harrison
 * @version- 1
 * @since- February 7, 2019
 * **/
public class Cookie extends DessertItem {

	private int quantity;
	private double priceDozen;
	private String cookieType;
	
	/**
	 * constructs a cookie with the type of cookie and quantity
	 * **/
	public Cookie(String type, int q) {
		
		super("Cookie");
		cookieType = type;
		quantity = q;
	}
	/**
	 *gets the price of the cookies by the dozen
	 *@return priceDozen-returns price of a dozen cookies
	 * **/
	public double getPriceDozen() {
		
		return priceDozen;
	}
	/**
	 *sets the price per dozen of the cookies
	 *@param price- a double representing the price of a dozen cookies
	 * **/
	public void setPriceDozen(double price) {
		
		priceDozen = price;
	}
	/**
	 *gets the quantity of cookies 
	 *@return quantity-returns the quantity of cookies wanted by the user
	 * **/
	public int getQuantity() {
		
		return quantity;
	}
	/**
	 *sets the quantity of cookies wanted by the user
	 *@param q- a int that represents the quantity of cookies
	 * **/
	public void setQuantity(int q) {
		
		quantity = q;
	}
	/**
	 *sets the type of cookie
	 *@param pastry- a string that represents the type of cookie
	 * **/
	public void setCookieType(String type) {
		
		cookieType = type;
	}
	/**
	 *gets the type of cookie
	 *@return cookieType-returns the type of cookie
	 * **/
	public String getCookieType() {
		
		return cookieType;
	}
	/**
	 *gets the cost of the cookie
	 *@return double- returns the cost of the cookie
	 * **/
	public double getCost() {
		
		return ((priceDozen / 12) * quantity);
	}
	/**
	 *gets the string representation of the cookie
	 *@return String- returns the String representation of the cookie
	 * **/
	public String toString() {
		
		String result = quantity + " " + cookieType + " cookies\n";
		result += String.format("Total: $%.2f\n", getCost());
		return result;
	}
	/**
	 *gets the highet priced cookie by comparing the parameter cookie with the current cost
	 *@return int- returns an int representation of the highest costing cookie
	 *@param DessertItem- a cookie object
	 * **/
	public int compareTo(DessertItem c) {
		
	       if(this.getCost() > c.getCost()) {
				
				return 1;
			}
			if(this.getCost() < c.getCost()) {
				
				return -1;
			}
			else {
				return 0;
			}
		}
}
