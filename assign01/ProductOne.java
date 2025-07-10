package com.elemica.supply.chain.assign01;
 
public class ProductOne {
	
	String productName;
	private String serialNumber;
	int productPrice;
	
	public void display(String pName, String serNum, int prodPrice) {
		
		serialNumber = serNum + "1";
		System.out.println(pName);
		System.out.println(serNum);
		System.out.println(prodPrice);
		System.out.println(serialNumber);
		
		Supplier s=new Supplier();
		s.supplierName="Sajid";
		s.supplierId= 543;
		System.out.println(s.supplierName+" "+s.supplierId);
		s.setSupplierId(123);
		s.setSupplierName("Aman");
		System.out.println("supplier details are :"+s.getSupplierId()+" "+s.getSupplierName());
	}
 
}
