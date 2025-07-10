package com.elemica.supply.chain.assign01;

public class Main {

	public static void main(String[] args) {
		Product p1=new Product(1,"Mobile","Electronics",5000,10);
		Supplier s1=new Supplier(101,"ToolSupplier","Hyderabad");
		s1.addProducts(p1);
		s1.printProduct();
		Order o1=new Order(96,"11th july",p1,2,"confirmed");
		o1.displayOrder();
		
		

	}

}
