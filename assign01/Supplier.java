package com.elemica.supply.chain.assign01;
import java.util.ArrayList;
public class Supplier {
     String supplierName;
     
    private int supplierId; 
 	private String name;
 	private String location;
 	private ArrayList<Product> suppliedProducts;
 	
 	public Supplier(int supplierId, String name, String location) {
		this.supplierId = supplierId;
		this.name = name;
		this.location = location;
		this.suppliedProducts = new ArrayList<>();
}
 	
 	public Supplier() {
 		supplierId = 404;
 		name = "Default name";
 		location = "Default Location";
 		this.suppliedProducts = new ArrayList<>();
 	}
 	public void addProducts(Product p) {
 		suppliedProducts.add(p);
 	}
    public void printProduct(){
    	System.out.println("SupplierID "+supplierId);
    	System.out.println("Name "+name);
    	System.out.println("Location "+location);
    	System.out.println("Supplied Products are:");
    	for(Product p:suppliedProducts) {
    		p.displayProductDetails();
    		System.out.println("--------");
    	}
    	
    }
}
