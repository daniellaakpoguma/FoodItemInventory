/**
 * CET - CS Academic Level 3
 * Student Name: Oghenerukevwe Akpoguma
 * Student Number:  041075624
 * Course: CST8130 - Data Structures
 * Lab Section: 304
 * @author/Professor: James Mwangi PhD. 
 * This is an original solution  created by Oghenerukevwe Akpoguma based on the provided problem statement and requirements
 */
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Test Class for FoodItem and related classes
 * @author rukev
 *
 */
public class Assign1 {

	/**
	 * Method to display menu options
	 */
	public void displayMenu(){
		System.out.print ("Please select one of the following:\r\n"
				+ "1: Add Item to Inventory\r\n"
				+ "2: Display Current Inventory\r\n"
				+ "3: Buy Item(s)\r\n"
				+ "4: Sell Item(s)\r\n"
				+ "5: To Exit\r\n"
				+ ">");	
	}
	
	/**
	 * Entry point for the program
	 * @param args arguements 
	 */
	public static void main(String[] args) {
		boolean shouldContinue = true;
		Scanner keyboard = new Scanner(System.in); //new Scanner to read from keyboard
		Inventory inventory = new Inventory(); // new Inventory object
		
		do {
			Assign1 assign = new Assign1();
			assign.displayMenu(); //displays menu options
			try {
			int userInput = keyboard.nextInt(); //accepts user options
			keyboard.nextLine();
			
			switch (userInput) {
		    case 1:
		    	inventory.addItem(keyboard); //adds item from the keyboard
		    	break;
			case 2:
				System.out.println(inventory.toString()); // displays food items in inventory
				break;
			case 3:
				inventory.updateQuantity(keyboard, true); //updates quantity if user wants to buy
				break;
			case 4:
				inventory.updateQuantity(keyboard, false); //updates quantity if user wants to sell
				break;
			case 5:
				System.out.println("Exiting...");
				shouldContinue = false;
				break;
			default:
				System.out.println("...Invalid input, please try again...");
				break;
			}
		}catch(InputMismatchException e) {
			System.out.println("...Invalid input, please try again...");
			keyboard.nextLine();
		}
		}while(shouldContinue);
	}

}
