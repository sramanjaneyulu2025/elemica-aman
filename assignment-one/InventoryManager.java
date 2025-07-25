  package com.elemica.supply.chain.officialAssign01;


import java.util.*;

public class InventoryManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  List<Item> items = new ArrayList<>();
		     Scanner scanner = new Scanner(System.in);
		        String continueInput = "y";

		        while (continueInput.equalsIgnoreCase("y")) {
		            System.out.print("Enter item name: ");
		            String name = scanner.nextLine();

		            System.out.print("Enter item price: ");
		            double price = 0;
		            while (true) {
		                try {
		                    price =  scanner.nextDouble();
		                    scanner.nextLine();
		                    break;
		                } catch (NumberFormatException e) {
		                    System.out.print("Invalid price. Please enter a valid number: no.format ");
		                }
		                catch (InputMismatchException e) {
		                    System.out.print("Invalid price. Please enter a valid number1: ");
		                    scanner.nextLine(); // Clear invalid input
		                }
		            }

		            System.out.print("Enter item quantity: ");
		            int quantity = 0;
		            while (true) {
		                try {
		                    quantity = Integer.parseInt(scanner.nextLine());
		                    break;
		                } catch (NumberFormatException e) {
		                    System.out.print("Invalid quantity. Please enter a valid integer: ");
		                }
		            }

		            System.out.print("Enter item type: ");
		            String type = scanner.nextLine();

		            System.out.println("\nItem details:");
		            System.out.println("Name: " + name);
		            System.out.println("Price: " + price);
		            System.out.println("Quantity: " + quantity);
		            System.out.println("Type: " + type);

		            System.out.print("\nDo you want to enter another item? (y/n): ");
		            continueInput = scanner.nextLine();
	                // Validations
	                if (name.isEmpty() || type.isEmpty()) {
	                    System.out.println("Error: Missing mandatory fields (name/type).");
	                    continue;
	                }

	                if (price < 0 || quantity <= 0) {
	                    System.out.println("Error: Invalid price or quantity.");
	                    continue;
	                }

	                Item item = new Item(name, price, quantity, type);
	                items.add(item);

	               // System.out.print("Do you want to enter details of any other item (y/n): ");
	                //continueInput = reader.readLine().trim();
	            }

	            System.out.println("\n********* Final Inventory Summary *********");
	            for (Item item : items) {
	                item.displayDetails();
	            }

	        } 

	}


