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
 * Subclass for FoodItem class
 * @author rukevwe
 */
/*
 * Subclass for FoodItem class
 */
public class Preserve extends FoodItem {
	private int jarSize; // added instance variable for preserve
	
	/*
	 * default constructor
	 */
	/**
	 * default constructor
	 */
	public Preserve() {}
	
	/**
	 * To create/add new Preserve item
	 * @param scanner Scanner object to read in data member
	 */
	/*
	 * To create/add new preserve item
	 */
	public boolean addItem(Scanner scanner) {
	    super.addItem(scanner); //calls FoodItem method
	    boolean validInput  = false;
	    do {
	    	System.out.print("Enter the size of the jar in millilitres: ");
            if (scanner.hasNextInt()) { //checks if quantity is an integer
            	jarSize = scanner.nextInt();
                scanner.nextLine();
                if (jarSize > 0) { //checks if quantity is greater than zero
                    validInput = true;
                } else {
                    System.out.println("Invalid entry");
                }
            } else {
                System.out.println("Invalid entry"); //error message if invalid input is entered
                scanner.nextLine();
            }
        } while (validInput == false);
	    return true;
	}
	
	/*
	 * Displays the all data members in the class
	 */
	/**
	 * Displays the all data members in the class
	 */
	public String toString() {
		String preserveInventory = super.toString() + " Size:" + jarSize;
		return preserveInventory;	
	}
	
}
