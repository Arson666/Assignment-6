//Class: CMSC203 CRN 24307 
//Program: Assignment #6
//Instructor: Ping-Wei Tsai 
//Summary of Description: this program calculates order costs
//Due Date: 11/28/2021 
//Integrity Pledge: I pledge that I have completed the programming assignment independently. 
//I have not copied the code from a student or any source. 
//Student’s Name: Anna Downey 

class Coffee extends Beverage{
	private boolean extraShot;
	private boolean extraSyrup;
	private double extra = 0.5;
	  
	public Coffee(String n, SIZE s, boolean shot, boolean syrup) {
		super(n, TYPE.COFFEE, s);
		extraShot = shot;
		extraSyrup = syrup;
	}
	  
	public String toString() {
		String s = getBevName() + ", " + getSize();
		  
		if (extraShot) {
			s += " Extra shot";
		}
		if (extraSyrup) {
			s += " Extra syrup";
		}
		  
		s += ", $" + calcPrice();
		return s;
	}
	
	public double calcPrice() {
		double price = super.getBasePrice();
		  
		if (super.getSize() == SIZE.MEDIUM) {
			price += super.getSizePrice();
		}
		else if (super.getSize() == SIZE.LARGE) {
			price += 2 * super.getSizePrice();
		}
		
		if (extraShot) {
			price += extra;
		}
		if (extraSyrup) {
			price += extra;
		}
		return price;
	}
	
	public boolean equals(Coffee c) {
		if (super.equals(c) && extraShot == c.getExtraShot() && extraSyrup == c.getExtraSyrup()) {
			return true;
		}
		else {
			return false;
		}
	}
	  
	public boolean getExtraShot() {
		return extraShot;
	}
	
	public void setExtraShot(boolean shot) {
		extraShot = shot;
	}
	
	public boolean getExtraSyrup() {
		return extraSyrup;
	}
	
	public void setExtraSyrup(boolean syrup) {
		extraSyrup = syrup;
	}
	
	public double getExtra() {
		return extra;
	}
	
	public void setExtra(double e) {
		extra = e;
	}
}