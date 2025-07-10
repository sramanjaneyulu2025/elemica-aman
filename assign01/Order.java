package com.elemica.supply.chain.assign01;

public class Order {
     private int orderId;
     private String orderDate;
     private Product product;
     private int quantityOrdered;
     private String status;
     
     public Order(int orderId,String orderDate,Product product,int quantityOrdered,String status) {
    	 this.orderId=orderId;
    	 this.orderDate=orderDate;
    	 this.product=product;
    	 this.quantityOrdered=quantityOrdered;
    	 this.status=status;
    	 	 
     }
     public double calculateOrderValue() {
    	 return product.getPrice()*quantityOrdered;
    	 
     }
     public void displayOrder() {
    	 System.out.println("OrderId "+ orderId);
    	 System.out.println("Order Date: "+orderDate);
    	 System.out.println("Quantity Ordered: "+quantityOrdered);
    	 System.out.println("Status: "+status);
    	 System.out.println("Total order value: "+calculateOrderValue());
    	 
    	 
     }
}
