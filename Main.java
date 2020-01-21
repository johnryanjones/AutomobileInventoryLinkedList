import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//create Scanner objects for user input
		Scanner in = new Scanner(System.in);
		String userInput;
		
		//create a loop for the user to either enter more vehicle data or quit
		do {
			System.out.println("Would you like to add a vehicle into inventory?");
			System.out.print("Please type \"yes\" or \"quit\": ");
			userInput = in.next();
			
			//if the user enters "yes" then call the addVehicle method
			if (userInput.equalsIgnoreCase("yes")) {
			
					//Exception handling when calling the addVehicle method
					try {
						Vehicle.addVehicle();
					} catch (Exception e) {
						System.out.println();
						System.out.println(e.getMessage());
						System.out.println("Unable to add Vehicle.");
					}
						System.out.println();
						System.out.println("Here is the updated inventory list:");
						Vehicle.displayList();
						System.out.println();
			}
			
		} while (!userInput.equalsIgnoreCase("quit"));
		
		System.out.println();
		System.out.println("Thank you. Have a nice day!");
		System.out.println();
		
		//Call the sortByMPG method to sort the LinkedList by miles per gallon
		Vehicle.sortByMPG();
		
		//Once the data is sorted call the printFile method
		Vehicle.printFile();
		
		in.close();
	}

}
