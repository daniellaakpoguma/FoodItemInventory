import java.util.Scanner;

/**
 * Subclass for FoodItem class
 * @author rukevwe
 */
/*
 * Subclass for FoodItem class
 */
public class Meat extends FoodItem{
	private String livestockFarm; // added instance variable for meat
	
	/*
	 * default constructor
	 */
	/**
	 * default constructor
	 */
	public Meat() {}
	
	public boolean addItem(Scanner scanner) {
	    super.addItem(scanner); //calls FoodItem method
	    System.out.print("Enter the name of the livestock farm: ");
	    livestockFarm = scanner.nextLine();
	    return true;
	}
	
	/**
	 * Displays the all data members in the class
	 */
	/*
	 * Displays the all data members in the class
	 */
	public String toString() {
		String meatInventory = super.toString() + " Livestock farm: " + livestockFarm;
		return meatInventory;
	}

}
