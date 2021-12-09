import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * the main class of the program that implements the cash register for new sales and printing reciepts
 * @author-Ryan Harrison
 * @version- 1
 * @since- February 7, 2019
 * **/
public class main {
    
	/**
	 * implements the main menu for new sale, display all sales, or close cash register
	 * @return char - returns the user selection based on their inputed character
	 * **/
	public static char mainMenu() {
		
		boolean value = false;
		while (!value) {
			
			System.out.print("\n(N)ew Sale\n(D)isplay all sales\n(C)lose cash register\n");
			Scanner input = new Scanner(System.in);
		    char userChoice= input.next().charAt(0);
		    
		    if(userChoice == 'N' || userChoice == 'D' || userChoice == 'C') {
		    	
		    	value = true;
		    	return userChoice;
		    }
		}
		return 0;
	}
	/**
	 * implements the new sale options of purchase drink or purchase pastry
	 * @return char - returns the user selection based on their inputed character
	 * **/
	public static char newSaleOptions() {
		
		boolean value = false;
		while(!value) {
			
			System.out.print("Purchase (D)rinks\nPurchase (P)astries\n(E)nd Sale\n");
			Scanner input = new Scanner(System.in);
		    char userChoice= input.next().charAt(0);
		    
		    if(userChoice == 'D' || userChoice == 'P' || userChoice == 'E') {
		    	
		    	value = true;
		    	return userChoice;
		    }
		}
		return 0;
	}
	/**
	 * implements the drink options of choosing Boba or Coffee
	 * @return char - returns the user selection based on their inputed character
	 * **/
	public static char drinkOptions() {
		
		boolean value = false;
		while(!value) {
			
			System.out.print("Would you like a\n(B)oba or a\n(C)offee:\n");
			Scanner input = new Scanner(System.in);
		    char userChoice= input.next().charAt(0);
		    
		    if(userChoice == 'B' || userChoice == 'C') {
		    	
		    	value = true;
		    	return userChoice;
		    }
		}
		return 0;
	}
	/**
	 * implements all the options for when buying a Boba
	 * @return BobaDrink - returns the constructed Boba with all its parameters
	 * **/
	public static BobaDrink bobaOptions() {
		
		System.out.println("What kind of base tea would you like for the Boba?");
		String [] tea = {"Rose", "Oolong", "Jasmine", "Green", "Black"};
		for(int i =0; i < 5; i++) {
			
			System.out.println(i+1 + ". " + tea[i]);
		}
		Scanner input = new Scanner(System.in);
	    int userChoice= input.nextInt();
	    BobaDrink b = new BobaDrink(tea[userChoice - 1] + "Tea");
	    
	    System.out.println("What size would you like?");
	    String [] size = {"Small", "Medium", "Large"};
	    double [] cost = {4.75, 5.25, 5.75};
        for(int i = 0; i < 3; i++) {
			
			System.out.println(i+1 + ". " + size[i] + "-$" + cost[i]);
		}
	    int choice= input.nextInt();
	    b.setCost(cost[choice - 1]);
	    b.setSize(size[choice - 1]);
	    
	    System.out.println("How sweet would you like the Boba?");
	    String [] sweetness = {"Full", "3/4", "1/2", "1/4", "unsweetened"};
        for(int i =0; i < 5; i++) {
			
			System.out.println(i+1 + ". " + sweetness[i]);
		}
        userChoice= input.nextInt();
        b.setSweetness(sweetness[userChoice - 1]);
        
        System.out.println("Would you like milk in your Boba?");
        String [] milk = {"Whole Milk", "Half and half", "Almond Milk", "Coconut Milk", "No Milk"};
        for(int i =0; i < 5; i++) {
			
			System.out.println(i+1 + ". " + milk[i]);
		}
        userChoice= input.nextInt();
        b.setMilk(milk[userChoice - 1]);
        
        boolean value = false;
        while(!value) {
        	
        	System.out.println("Would you like to add toppings to your Boba?");
            String [] toppings = {"Grass Jelly", "Lychee Jelly", "Coconut Jelly", "Mini Mochi", "Popping Boba"};
            System.out.println("Enter a 6 to quit");
            for(int i =0; i < 5; i++) {
            	
            	System.out.println(i+1 + ". " + toppings[i]);
            }
            userChoice= input.nextInt();
            if(userChoice == 6) {
            	value = true;
            }
            else {
            	b.addTopping(toppings[userChoice-1]);
            }
        }
        return b;
        
	}
	/**
	 * implements all the options for when buying a Coffee
	 * @return CoffeeDrink - returns the constructed Coffee with all its parameters
	 * **/
	public static CoffeeDrink coffeeOptions() {
		
		System.out.println("What kind of base would you like for the Coffee?");
		String [] base = {"Water", "Whole Milk", "Almond Milk"};
		for(int i = 0; i < 3; i++) {
			
			System.out.println(i+1 + ". " + base[i]);
		}
		Scanner input = new Scanner(System.in);
	    int userChoice= input.nextInt();
		CoffeeDrink c = new CoffeeDrink(base[userChoice-1]);
		
		System.out.println("How many teaspoons of sugar would you like?");
	    userChoice= input.nextInt();
	    c.setSweetness(userChoice + " Teaspoons of Sugar");
	    
	    System.out.println("What size would you like?");
	    String [] size = {"Small", "Medium", "Large"};
	    double [] cost = {2.25, 3.00, 3.50};
        for(int i = 0; i < 3; i++) {
			
			System.out.println(i+1 + ". " + size[i] + "-$" + cost[i]);
		}
	    int choice= input.nextInt();
	    c.setCost(cost[choice - 1]);
	    c.setSize(size[choice - 1]);
	    
	    return c;
		
	}
	/**
	 * implements the dessert options of buying a pastry, cookie, or a macaroon
	 * @return char - returns the user selection based on their inputed character
	 * **/
	public static char dessertOptions() {
		
		boolean value = false;
		while(!value) {
			
			System.out.print("Would you like a\n(P)astry\n(C)ookie or a \n(M)acaroon\n");
			Scanner input = new Scanner(System.in);
		    char userChoice= input.next().charAt(0);
		    
		    if(userChoice == 'P' || userChoice == 'C' || userChoice == 'M') {
		    	
		    	value = true;
		    	return userChoice;
		    }
		}
		return 0;
	}
	/**
	 * implements all the options for when buying a Pastry
	 * @return Pastry - returns the constructed pastry with all its parameters
	 * **/
	public static Pastry pastryOptions() {
		
		System.out.println("What kind of pastry would you like?");
		String [] pastries = {"Donut", "Muffin", "Bagel"};
		double [] price = {1.25, 1.75, 2.75};
        for(int i = 0; i < 3; i++) {
			
			System.out.println(i+1 + ". " + pastries[i] + "- $" + price[i]);
		}
        Scanner input = new Scanner(System.in);
	    int userChoice= input.nextInt();
	    System.out.println("How many " + pastries[userChoice - 1] + " would you like?");
	    int amountChoice = input.nextInt();
	    Pastry p = new Pastry(pastries[userChoice - 1], amountChoice);
	    p.setUnitPrice(price[userChoice - 1]);
	    
	    System.out.println("Would you like to have the " + pastries[userChoice - 1] + " heated? y/n");
	    char choice= input.next().charAt(0);
	    if(choice == 'y') {
	    	p.setHeat(true);
	    }
	    else {
	    	p.setHeat(false);
	    }
	    return p;
		
		
	}
	/**
	 * implements all the options for when buying a Cookie
	 * @return Cookie - returns the constructed Cookie with all its parameters
	 * **/
	public static Cookie cookieOptions() {
		
		System.out.println("What kind of cookie would you like?");
		String [] cookies = {"Chocolate", "Sugar", "Raisin"};
		double [] price = {5.25, 4.75, 4.25};
        for(int i = 0; i < 3; i++) {
			
			System.out.println(i+1 + ". " + cookies[i] + "- $" + price[i] + " / dz");
		}
        Scanner input = new Scanner(System.in);
	    int userChoice= input.nextInt();
	    System.out.println("How many cookies would you like?");
	    int amountChoice = input.nextInt();
	    Cookie c = new Cookie(cookies[userChoice - 1], amountChoice);
	    c.setPriceDozen(price[userChoice - 1]);
	    return c;
	}
	/**
	 * implements all the options for when buying a Macaroon
	 * @return Macaroon - returns the constructed macaroon with all its parameters
	 * **/
	public static Macaroon macaroonOptions() {
		
		System.out.println("What kind of macaroon would you like?");
		String [] types = {"Chocolate", "Vanilla", "Strawberry"};
		double [] unitPrice = {1.25, 0.75, 1.75};
		double [] trioPrice = {3.25, 1.75, 4.25};
        for(int i = 0; i < 3; i++) {
			
			System.out.println(i+1 + ". " + types[i] + "- $" + unitPrice[i] + " or $" + trioPrice[i] + "/3.");
		}
        Scanner input = new Scanner(System.in);
	    int userChoice= input.nextInt();
	    System.out.println("How many macaroons would you like?");
	    int amountChoice = input.nextInt();
	    Macaroon m = new Macaroon(types[userChoice - 1], amountChoice);
	    m.setUnitPrice(unitPrice[userChoice - 1]);
	    m.setPriceThree(trioPrice[userChoice - 1]);
	    return m;
		
	}
	/**
	 * creates a new four arraylists to store the receipts, current order, current drinks,
	 * and current desserts. then implements each option from the menu for new sale, 
	 * display all sales, or close cash register. Gets all the products the user wants 
	 * to buy
	 * **/
	public static void main(String[] args) {
		
		ArrayList<String> receipts= new ArrayList<String>();
		ArrayList<String> currentOrder= new ArrayList<String>();
		ArrayList<DrinkItem> currentDrinks= new ArrayList<DrinkItem>();
		ArrayList<DessertItem> currentDesserts= new ArrayList<DessertItem>();
		CashRegister cr= new CashRegister();
		double totalSales = 0;
		char choice = mainMenu();
		
		while(choice != 'C') {
			
			if(choice == 'N') {
				
				choice = newSaleOptions();
				
				while(choice != 'E') {
					
					if(choice == 'D') {
						
						choice = drinkOptions();
						if(choice == 'B') {
							
							BobaDrink boba = bobaOptions();
							cr.addDrink(boba);
							currentOrder.add(boba.toString());
							currentDrinks.add(boba);
						}
						else if(choice == 'C') {
							
							CoffeeDrink coffee = coffeeOptions();
							cr.addDrink(coffee);
							currentOrder.add(coffee.toString());
							currentDrinks.add(coffee);
						}
					}
					else if(choice == 'P') {
						
						choice = dessertOptions();
						if(choice == 'P') {
							
							Pastry pastry = pastryOptions();
							cr.addDessert(pastry);
							currentOrder.add(pastry.toString());
							currentDesserts.add(pastry);
							
						}
						else if(choice == 'C') {
							
							Cookie cookie = cookieOptions();
							cr.addDessert(cookie);
							currentOrder.add(cookie.toString());
							currentDesserts.add(cookie);
	
						}
						else if(choice == 'M') {
							
							Macaroon macaroon = macaroonOptions();
							cr.addDessert(macaroon);
							currentOrder.add(macaroon.toString());
							currentDesserts.add(macaroon);
						}
					}
					choice = newSaleOptions();
				}
				System.out.println("Final Sale:");
				int size = currentOrder.size();
				for(int i = 0; i < size; i++) {
					
					System.out.println(currentOrder.get(0));
					currentOrder.remove(0);
				}
				double total = cr.total();
				System.out.printf("Total: $%.2f(with tax)\n", total);
				System.out.println("Do you have any coupouns? y/n");
				Scanner input = new Scanner(System.in);
				choice= input.next().charAt(0);
			    if(choice == 'y') {
				    	
			    	System.out.println("What is the coupon for? \n1.Drink Item\n2.Dessert Item");
			    	int itemChoice = input.nextInt();
			    	System.out.println("What percentage is the discount as a decimal?");
			    	double discount= input.nextDouble();
			    	String item;
			    	double savings;
			    	if(itemChoice == 1) {
			    		item = "Drink";
			    		DrinkItem drink = DrinkItem.max(currentDrinks);
			    		System.out.println(drink);
			    		savings = drink.getCost() * discount;
			    		total = total - savings;
			    	}
			    	else {
			    		item = "Dessert";
			    		DessertItem dessert = DessertItem.max(currentDesserts);
			    		System.out.println(dessert);
			    		savings = dessert.getCost() * discount;
			    		total = total - savings;
			    	}
			    	Coupon coup = new Coupon(item, discount);
			    	System.out.println(coup);
			    	System.out.printf("You saved $%.2f\n",savings);
			    	System.out.printf("Your new total is: $%.2f\n",total);
			    	
			    }
			    totalSales = totalSales + total;
			    System.out.println("Enter Payment Amount:");
			    double payment = input.nextDouble();
			    double change = payment - total;
			    System.out.printf("Your change is $%.2f\n", change);
			    cr.setSum(total);
			    System.out.println("Reciept: \n" + cr);
				receipts.add(cr.toString());
				cr.clearRegister();
			}
			else if(choice == 'D'){
				
				for(int i = 0; i < receipts.size(); i++) {
					
					System.out.println(receipts.get(i));
				}
				System.out.printf("Total of all sales: $%.2f\n", totalSales);
			}
			choice = mainMenu();	
		}
	}
	

}
