import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Vehicle implements Comparable<Vehicle> {

	//create our private fields for the Vehicle objects
	private String make;
	private String model;
	private double mpg;
	
	//create our LinkedList object and Scanner object for user input
	static LinkedList<Vehicle> vehicleList = new LinkedList<Vehicle>();
	private static Scanner addInput = new Scanner(System.in);
	
	//Vehicle constructor for instantiating Vehicle objects
	public Vehicle(String make, String model, double mpg) {
		this.make = make;
		this.model = model;
		this.mpg = mpg;
	}
	//getter method to access our private field
	public double getMpg() {
		return mpg;
	}
	
	 //This method will prompt the user for input and validate that input If the
	 //input is invalid the method with throw an exception If an exception is thrown
	 //it will kick back to Main where it was called
	 
	public static void addVehicle() throws Exception {

				System.out.println();
				System.out.print("Please enter the make of the vehicle: ");
				String make = addInput.next();
				System.out.print("Please enter the model: ");
				String model = addInput.next();
				double mpg = 0;
				System.out.print("Please enter the miles per gallon: ");
				if(addInput.hasNextDouble()) {
					mpg = addInput.nextDouble();
					Vehicle.vehicleList.add(new Vehicle(make, model, mpg));
				} else {
					addInput.next();
					throw new Exception("Invalid entry.");
				}
		}
	//Override the toString method in order to display the object's data in a specific way
	  public String toString() { return "Make: " + make + ", " + "Model: " + model
	  + ", " + "MPG: " + mpg; }
	 
	//This method will iterate through the LinkedList printing the object data to the console
	public static void displayList() {
		for (Vehicle vehicles : vehicleList) {
			System.out.println(vehicles);
		}
	}

	/*
	 * This method will take the LinkedList and write it to a text file The method
	 * also incorporates exception handling
	 */
	public static void printFile() {
		
		FileOutputStream fileByteStream = null;
		PrintWriter outFS = null;
		
		try {
			fileByteStream = new FileOutputStream("vehiclelist.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		outFS = new PrintWriter(fileByteStream);
			
		outFS.println(Vehicle.vehicleList);
		outFS.flush();
		
		try {
			fileByteStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Successfully printed to file.");
	}
	
	@Override
	public int compareTo(Vehicle o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * This method iterates through the mpg field of the linked list objects then
	 * sorts the data in ascending order
	 */
	public static void sortByMPG() {
		vehicleList.sort(Comparator.comparingDouble(Vehicle::getMpg));
	}	
}
