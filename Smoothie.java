//Class: CMSC203 CRN 24307 
//Program: Assignment #6
//Instructor: Ping-Wei Tsai 
//Summary of Description: this program calculates order costs
//Due Date: 11/28/2021 
//Integrity Pledge: I pledge that I have completed the programming assignment independently. 
//I have not copied the code from a student or any source. 
//Student’s Name: Anna Downey 

class Smoothie extends Beverage{
	private int fruit;
	private boolean protein;
	private double fruitCost = 0.5;
	private double proteinCost = 1.5;
	  
	public Smoothie(String n, SIZE s, int numFruit, boolean addProtein) {
		super(n, TYPE.SMOOTHIE, s);
		fruit = numFruit;
		protein = addProtein;
	}
	  
	public String toString() {
		String s = getBevName() + ", " + getSize() + " " + fruit + " Fruits";
		  
		if (protein) {
			s += " Protein powder";
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
		price += fruit * fruitCost;
		if (protein) {
			price += proteinCost;
		}
		return price;
	}
	
	public boolean equals(Smoothie s) {
		if (super.equals(s) && fruit == s.getNumOfFruits() && protein == s.getAddProtien()) {
			return true;
		}
		else {
			return false;
		}
	}
	  
	public int getNumOfFruits() {
		return fruit;
	}
	
	public void setNumOfFruits(int numFruit) {
		fruit = numFruit;
	}
	
	public boolean getAddProtien() {
		return protein;
	}
	
	public void setAddProtein(boolean addProtein) {
		protein = addProtein;
	}
	
	public double getFruitCost() {
		return fruitCost;
	}
	
	public double getProteinCost() {
		return proteinCost;
	}
}