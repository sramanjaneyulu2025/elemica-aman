package com.elemica.supply.chain.assign01;
 
public class Product {
 
	private int productId;
	private String name;
	private String category;
	private double price;
	private int quantityInStock;
	
	public Product(int productId,String name, String category,double price, int quantityInStock) {
		this.productId=productId;
		this.name=name;
		this.category=category;
		this.price=price;
		this.quantityInStock=quantityInStock;
		
	}
	public Product() {
		productId=404;
		name="N/A";
		category="N/A";
		price=0;
		quantityInStock=0;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantityInStock() {
		return quantityInStock;
	}
	
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	
	public  void displayProductDetails() {
		System.out.println("ProductId: "+ productId);
		System.out.println("name: "+name);
		System.out.println("Category: "+category);
		System.out.println("Price: " + price);
		System.out.println("quantityInstock: "+quantityInStock);
	}
	
	
 
}