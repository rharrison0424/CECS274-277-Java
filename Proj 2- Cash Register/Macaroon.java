/**
 * the Pastry class that constructs a macaroon
 * @author-Ryan Harrison
 * @version- 1
 * @since- February 7, 2019
 * **/
public class Macaroon extends Cookie{
	
	private String macaroonType;
	private double priceThree;
	private double unitPrice;
	
	/**
	 * constructs a macaroon with the type of macaroon and quantity
	 * **/
    public Macaroon(String type, int q) {
		
		super("Macaroon", q);
		macaroonType = type;
	}
    /**
	 *gets the unit price of a macaroon
	 *@return double- returns the unit price of a macaroon
	 * **/
    public double getUnitPrice() {
    	
    	return unitPrice;
    }
    /**
	 *sets the unit price of the macaroon
	 *@param price- a double representing the price of a macaroon
	 * **/
    public void setUnitPrice(double price) {
    	
    	unitPrice = price;
    }
    /**
	 *sets the price per three of the macaroons
	 *@param price- a double representing the price of a three macaroons
	 * **/
    public void setPriceThree(double price) {
    	
    	priceThree = price;
    }
    /**
	 *gets the price of three macaroons
	 *@return priceDozen-returns price of a three macaroons
	 * **/
    public double getPriceThree() {
    	
    	return priceThree;
    }
    /**
	 *sets the type of macaroon
	 *@param pastry- a string that represents the type of macaroon
	 * **/
    public void setMacaroonType(String macaroon) {
    	
    	macaroonType = macaroon;
    }
    /**
	 *gets the type of macaroon
	 *@return cookieType-returns the type of macaroon
	 * **/
    public String getMacaroonType() {
    	
    	return macaroonType;
    }
    /**
	 *gets the cost of the macaroons ordered by the user
	 *@return double- returns the cost of the macaroons
	 * **/
    public double getCost() {
    	
    	double cost;
    	
    	if(getQuantity() >= 3) { 
    		
    		int numberTrio = getQuantity() / 3;
    		int individual = getQuantity() % 3;
    		cost = (numberTrio * priceThree) + (individual * unitPrice);
    	}
    	else {
    		
    		cost = getQuantity() * unitPrice;
    	}
    	return cost;
    }
    /**
	 *gets the string representation of the macaroon
	 *@return String- returns the String representation of the macaroon
	 * **/
    public String toString() {
    	
    	String result = getQuantity() + " " + macaroonType + " macaroons\n";
    	result += String.format("Total: $%.2f\n", getCost());
		return result;
    }
	

}
