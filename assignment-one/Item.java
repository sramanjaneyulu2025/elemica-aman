package com.elemica.supply.chain.officialAssign01;

public class Item {
	 private String name;
	    private double price;
	    private int quantity;
	    private String type;
	    private double tax;
	    private double finalPrice;

	    public Item(String name, double price, int quantity, String type) {
	        this.name = name;
	        this.price = price;
	        this.quantity = quantity;
	        this.type = type.toLowerCase();
	        calculateTaxAndFinalPrice();
	    }

	    private void calculateTaxAndFinalPrice() {
	        double totalCost = price * quantity;
	        switch (type) {
	            case "raw":
	                tax = totalCost * 0.125;
	                break;
	            case "manufactured":
	                double baseTax = totalCost * 0.125;
	                tax = baseTax + 0.02 * (totalCost + baseTax);
	                break;
	            case "imported":
	                double importDuty = totalCost * 0.10;
	                double costWithDuty = totalCost + importDuty;
	                double surcharge;
	                if (costWithDuty <= 100) surcharge = 5;
	                else if (costWithDuty <= 200) surcharge = 10;
	                else surcharge = 0.05 * costWithDuty;
	                tax = importDuty + surcharge;
	                break;
	            default:
	                System.out.println("Invalid item type. Tax set to 0.");
	                tax = 0;
	        }
	        finalPrice = totalCost + tax;
	    }

	    public void displayDetails() {
	        System.out.println("Item Name: " + name);
	        System.out.println("Item Price: Rs. " + String.format("%.2f", price));
	        System.out.println("Item Quantity: " + quantity);
	        System.out.println("Item Type: " + type);
	        System.out.println("Sales Tax: Rs. " + String.format("%.2f", tax));
	        System.out.println("Final Price: Rs. " + String.format("%.2f", finalPrice));
	        System.out.println("-------------------------------------------------");
	    }

}
