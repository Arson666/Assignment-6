//Class: CMSC203 CRN 24307 
//Program: Assignment #6
//Instructor: Ping-Wei Tsai 
//Summary of Description: this program calculates order costs
//Due Date: 11/28/2021 
//Integrity Pledge: I pledge that I have completed the programming assignment independently. 
//I have not copied the code from a student or any source. 
//Student’s Name: Anna Downey 

abstract class Beverage {
	private String name;
	private TYPE type;
	private SIZE size;
	private double basePrice = 2.0;
	private double sizePrice = 1.0;
	  
	public Beverage(String n, TYPE t, SIZE s) {
		name = n;
		type = t;
		size = s;
	}
	  
	public abstract double calcPrice();
	
	public String toString() {
		return name + ", " + size;
	}
	
	public boolean equals(Beverage b) {
		if (name.equals(b.getBevName()) && type == b.getType() && size == b.getSize()) {
			return true;
		}
		else {
			return false;
		}
	}
	  
	public String getBevName() {
		return name;
	}
	
	public void setBevName(String n) {
		name = n;
	}
	
	public TYPE getType() {
		return type;
	}
	
	public void setType(TYPE t) {
		type = t;
	}
	
	public SIZE getSize() {
		return size;
	}
	
	public void setSize(SIZE s) {
		size = s;
	}
	
	public double getBasePrice() {
	return basePrice;
	}
	
	public double getSizePrice() {
		return sizePrice;
	}
}