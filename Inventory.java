/**
 * CET - CS Academic Level 3
 * Student Name: Oghenerukevwe Akpoguma
 * Student Number:  041075624
 * Course: CST8130 - Data Structures
 * Lab Section: 304
 * @author/Professor: James Mwangi PhD. 
 * This is an original solution  created by Oghenerukevwe Akpoguma based on the provided problem statement and requirements
 */
import java.util.Scanner;

/**
 * Class to implement an inventory of food items
 * @author rukevwe
 *
 */
public class Inventory {
	/*
	 * instance variables
	 */
	private int numItems = 0;
	private static FoodItem [] inventory = new FoodItem[100];
	
	/**
	 * default constructor
	 */
	/*
	 * default constructor
	 */
	public Inventory() {}
	
	/*
	 * method to check whether an item code exists
	 */
	/**
	 * method to check whether an item code exists before adding it into inventory
	 * @param item checks item in the inventory array
	 * @return Returns the index of a FoodItem in the inventory array with the same itemCode as the FoodItem object in the parameter list, else returns -1
	 */
	public int alreadyExists(FoodItem item) {
	    if (inventory == null) { // checks if inventory is null, no items exist yet
	        return -1; 
	    } 
	    for (int i = 0; i < inventory.length; i++) { //iterates through inventory
	        FoodItem newItem = inventory[i]; //creates new item
	        if (newItem != null && item.itemCode == newItem.itemCode) { //checks if item codes are equal
	            return i;
	        }
	    } 
	    return -1; // Item code doesn't exist in the inventory
	}

	/*
	 * Method to add an item to the inventory array –
	 */
	/**
	 * Method to add an item to the inventory array 
	 * @param scanner Scanner object that reads in variables
	 * @return true/false if method is successful or not
	 */
	public boolean addItem (Scanner scanner) {
		 boolean validInput = false;
	        String itemChoice;
	        FoodItem item;
	        do {
	        	// asks user which food item they want to add
	            System.out.print("Do you wish to add a fruit(f), vegetable(v), preserve(p), or a meat(m)? ");
	            itemChoice = scanner.nextLine();
	            if (itemChoice.equalsIgnoreCase("f") || itemChoice.equalsIgnoreCase("v") || itemChoice.equalsIgnoreCase("p") ||  itemChoice.equalsIgnoreCase("m")) {
	                validInput = true;
	            } else {
	                System.out.println("Invalid entry");
	            }
	        } while (!validInput);
	       if(itemChoice.equalsIgnoreCase("f")) { //if food item is a fruit, creates new fruit
	    	   item = new Fruit();
	    	   item.addItem(scanner);
	       }else if (itemChoice.equalsIgnoreCase("v")) { //if food item is a vegetable, creates new vegetable
	    	   item = new Vegetable();
	    	   item.addItem(scanner);
	       }else if (itemChoice.equalsIgnoreCase("p")) { //if food item is a preserve, creates new preserve
	    	   item = new Preserve();
	    	   item.addItem(scanner);
	       }else if (itemChoice.equalsIgnoreCase("m")){ //if food item is a meat, creates new preserve
	    	   item = new Meat();
	    	   item.addItem(scanner);
	       }else { //default if it is neither
	    	   item = new FoodItem(); 
	    	   item.addItem(scanner);
	       }
	       inventory[numItems] = item;  // Add the item to the inventory array
           numItems++; 
		return validInput;	
	}
	
	/*
	 * 	Updates item quantity by the input quantity entered through the Scanner
	 */
	/**
	 * Updates item quantity by the input quantity entered through the Scanner
	 * @param scanner Scanner object that reads in quantity to change by
	 * @param buyOrSell boolean to check whether it is buy or sell
	 * @return returns true/false on whether update was successful or not
	 */
	public boolean updateQuantity (Scanner scanner, boolean buyOrSell) {
		 if (numItems == 0 && buyOrSell == true) { //checks if the array is item and the user wants to buy
		        System.out.println("Error...could not buy item");
		        buyOrSell = false;
		        return buyOrSell;
		    }else if (numItems == 0 && buyOrSell == false) { //checks if the array is item and the user wants to sell
		    	 System.out.println("Error...could not sell item");
			     buyOrSell = false;
			     return buyOrSell;
		    }
		 
		System.out.print("Enter valid item code:"); //enters item code
		int userChoice = scanner.nextInt();
		scanner.nextLine();
		if(buyOrSell) { // if the user wants to buy 
		  for (int i = 0; i < numItems; i++) { //iterates through array
			  FoodItem item = inventory[i]; //assigns inventory item to object
			 
			  if (item != null && item.itemCode == userChoice) { // if the item code is equal
				  System.out.print("Enter valid quantity to buy:"); //enters valid quantity
				  userChoice = scanner.nextInt();
				  scanner.nextLine();
				  if(userChoice > 0) { // checks if user choice is greather than 0
					  item.updateItem(userChoice);
				  }else {
					  System.out.println("Invalid quantity...");
					  System.out.println("Error...could not buy item");
				  }
				  return buyOrSell;
			  }
		  }
		  
		  System.out.println("not found in inventory...");
		  System.out.println("Error...could not buy item");
		  buyOrSell = false;
		  return buyOrSell;
		  
		}else if(!buyOrSell) { //checks if the user wants to sell
			  for (int i = 0; i < numItems; i++) { //iterates through array
				  FoodItem item = inventory[i];  //assigns inventory item to object
				  if (item != null && item.itemCode == userChoice) {
					  System.out.print("Enter valid quantity to sell:");
					  userChoice = scanner.nextInt();
					  if (userChoice > 0 && userChoice <= item.itemQuantityInStock) {
			                item.updateItem(-userChoice);
			                buyOrSell = true;
			            } else if (userChoice > item.itemQuantityInStock) {
			                System.out.println("Insufficient stock in inventory...");
			                System.out.println("Error...could not sell item");
					  }else {
						  System.out.println("Invalid quantity...");
						  System.out.println("Error...could not sell item");
					  }
				  }
			  }
		}
		System.out.println("not found in inventory...");
		System.out.println("Error...could not sell item");
		return buyOrSell;	
	}
	
	/**
	 * Displays the all data members in the class
	 */
	/*
	 * Displays the all data members in the class
	 */
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Inventory:\n");

	    for (int i = 0; i < numItems; i++) {
	        FoodItem item = inventory[i];
	        if (item instanceof Fruit) { //if the item is a fruit
	            Fruit fruit = (Fruit) item;
	            sb.append(fruit.toString()).append("\n");
	        } else if (item instanceof Vegetable) { //if the item is a vegetable
	            Vegetable vegetable = (Vegetable) item;
	            sb.append(vegetable.toString()).append("\n");
	        } else if (item instanceof Preserve) { //if the item is a preserve
	            Preserve preserve = (Preserve) item;
	            sb.append(preserve.toString()).append("\n");
	        }else if  (item instanceof Meat) { //if the item is a meat
	        	Meat meat = (Meat) item;
	            sb.append(meat.toString()).append("\n");
	        }
	    }
	    return sb.toString();
	}
	
}
