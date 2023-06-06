/**
 * CET - CS Academic Level 3
 * Student Name: Oghenerukevwe Akpoguma
 * Student Number:  041075624
 * Course: CST8130 - Data Structures
 * Lab Section: 304
 * @author/Professor: James Mwangi PhD. 
 * This is an original solution  created by Oghenerukevwe Akpoguma based on the provided problem statement and requirements
 */

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is a super class for other food items that contains shared properties and methods
 * @author rukevwe
 *
 */
public class FoodItem {
	
	/*
	 * instance varaiables
	 */
	protected int itemCode; //item code for food item
	protected String itemName; //item name for food item
	protected float itemPrice; //price for food item
	protected int itemQuantityInStock; //quantity of food items in stock
	protected float itemCost; // cost of food item
	
	/*
	 * Default constructor
	 */
	/**
	 * Default constructor
	 */
	public FoodItem () {}

	/*
	 * Updates the quantity field by amount ;
	 */
	/**
	 * Updates the quantity field by amount (note amount could be positive or negative);
	 * @param amount amount the quantity field is either increased or decreased by
	 * @return returns true if successful, otherwise returns false
	 */
	public boolean updateItem (int amount) {
		itemQuantityInStock = itemQuantityInStock + amount;
		if(itemQuantityInStock < 0) {
			return false;
		}
		return true;
	}
	
	/*
	 * Method to determine if itemCode itemCode of the object being acted on and the item object parameter are the same value
	 */
	/**
	 * Method to determine if itemCode itemCode of the object being acted on and the item object parameter are the same value
	 * @param item food item being checked for item code
	 * @return returns true if the itemCode of the object being acted on and the item object parameter are the same value
	 */
	public boolean isEqual (FoodItem item) {
		if (item.itemCode == this.itemCode) { //checks if item codes are equal
			return true;
		}
		return false;	
	}
	
	/*
	 * Reads from the Scanner object passed in and fills the data member fields of the class with valid data
	 */
	/**
	 * 	
	 * Adds item to inventory by reading from the Scanner object passed in and fills the data member fields of the class with valid data
	 * @param scanner Scanner object to read in data members
	 * @return returns true if program successfully reads in all fields, otherwise returns false
	 */
	public boolean addItem(Scanner scanner) {
	    boolean validInput = false;
	    inputCode(scanner);
	    try {
	        System.out.print("Enter the name for the item:");
	        itemName = scanner.nextLine(); // enter item name
	        
	        do {
	            System.out.print("Enter the quantity for the item:");
	            if (scanner.hasNextInt()) { //checks if quantity is an integer
	                itemQuantityInStock = scanner.nextInt();
	                scanner.nextLine();
	                if (itemQuantityInStock > 0) { //checks if quantity is greater than zero
	                    validInput = true;
	                } else {
	                    System.out.println("Invalid entry");
	                }
	            } else {
	                System.out.println("Invalid entry"); //error message if invalid input is entered
	                scanner.nextLine();
	            }
	        } while (validInput == false);
	        
	        validInput = false; // resets boolean flag
	        
	        do {
	            System.out.print("Enter the cost of the item:");
	            if (scanner.hasNextFloat()) { //checks if cost is a float
	                itemCost = scanner.nextFloat();
	                scanner.nextLine();
	                if (itemCost > 0) { //checks if the cost is positive
	                    validInput = true;
	                } else {
	                    System.out.println("Invalid entry");
	                }
	            } else {
	                System.out.println("Invalid entry"); //error message
	                scanner.nextLine();
	            }
	        } while (validInput == false);
	        
	        validInput = false;
	        
	        do {
	            System.out.print("Enter the sales price of the item:");
	            if (scanner.hasNextFloat()) {  //checks if the price is a float
	                itemPrice = scanner.nextFloat();
	                scanner.nextLine();
	                if (itemPrice > 0) { //checks if the price is positive
	                    validInput = true;
	                } else {
	                    System.out.println("Invalid entry");
	                }
	            } else {
	                System.out.println("Invalid entry"); //error message
	                scanner.nextLine();
	            }
	        } while (validInput == false);
	        
	        validInput = true;
	    } catch (InputMismatchException e) {
	        System.out.println("Invalid entry");
	        scanner.nextLine(); // Consume the invalid input
	    }
	    
	    return validInput;
	}

	
	/*
	 * Reads a valid itemCode from the Scanner object and checks if it exists or not
	 */
	/**
	 * Reads a valid itemCode from the Scanner object and checks if it exists or not
	 * @param scanner Scanner object to read a valid itemCode
	 * @return returns true/false if successful
	 */
	public boolean inputCode(Scanner scanner) {
		boolean validInput = false;
		Inventory inventory = new Inventory();
		
		while (!validInput) { //boolean for while loop
			try {
				System.out.print("Enter the code for the item:");
				itemCode = scanner.nextInt(); // enters item code for food item
				scanner.nextLine();
				if (inventory.alreadyExists(this) != -1) {
					 System.out.println("Item code already exists");
				  } else {
		                validInput = true;
		           }
			}catch(InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid integer.");
				scanner.nextLine(); // Consume the invalid input
			}
		}
		return validInput;
	}
		
	/*
	 * 	Displays the all data members in the class
	 */
	/**
	 * 	Displays the all data members in the class
	 */
	public String toString() {
		DecimalFormat currencyFormatter = new DecimalFormat("$0.00"); //decimal formatter to format cost and price
		String foodItemInventory = "Items are: " + itemCode + " " + itemName + " " + itemQuantityInStock + " Price: " + currencyFormatter.format(itemPrice) +  " Cost: " + currencyFormatter.format(itemCost);
		return foodItemInventory;
	}
	
}
