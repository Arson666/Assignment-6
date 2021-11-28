//Class: CMSC203 CRN 24307 
//Program: Assignment #6
//Instructor: Ping-Wei Tsai 
//Summary of Description: this program calculates order costs
//Due Date: 11/28/2021 
//Integrity Pledge: I pledge that I have completed the programming assignment independently. 
//I have not copied the code from a student or any source. 
//Student’s Name: Anna Downey 

class Alcohol extends Beverage{
	private boolean onWeekend;
	private double weekendExtra = .6;
	  
	public Alcohol(String n, SIZE s, boolean ow) {
		super(n, TYPE.ALCOHOL, s);
		onWeekend = ow;
	}
	
	public String toString() {
		String s = getBevName() + ", " + getSize();
		  
		if (onWeekend) {
			s += " Weekend";
		}
		s += ", $" + calcPrice();
		return s;
	}
	
	public boolean equals(Alcohol alc) {
		if (super.equals(alc) && onWeekend == alc.getOnWeekend()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public double calcPrice() {
		double price = super.getBasePrice();
		  
		if (super.getSize() == SIZE.MEDIUM) {
			price += super.getSizePrice();
		}
		else if (super.getSize() == SIZE.LARGE) {
			price += 2 * super.getSizePrice();
		}
		  
		if (onWeekend) {
			price += weekendExtra;
		}  
		return price;
	}
	
	public double getWeekendExtra() {
		return weekendExtra;
	}
	  
	public boolean getOnWeekend() {
		return onWeekend;
	}
	
	public void setOnWeekend(boolean is) {
		onWeekend = is;
	}
}