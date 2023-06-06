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
public class Vegetable extends FoodItem {
	private String farmName;// added instance variable for vegetable
	
	/*
	 * default constructor
	 */
	/**
	 * default constructor
	 */
	public Vegetable() {}
	
	/**
	 * To create/add new vegetable item
	 * @param scanner Scanner object to read in data member
	 */
	/*
	 * To create/add new vegetable item
	 */
	public boolean addItem(Scanner scanner) {
	    super.addItem(scanner); //calls FoodItem method
	    System.out.print("Enter the name of the farm supplier:");
	    farmName = scanner.nextLine();
	    return true;
	}
	
	/*
	 * Displays the all data members in the class
	 */
	/**
	 * Displays the all data members in the class
	 */
	public String toString() {
		String vegetableInventory = super.toString() + " Farm supplier:" + farmName;
		return vegetableInventory;
	}
}
