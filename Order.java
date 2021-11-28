//Class: CMSC203 CRN 24307 
//Program: Assignment #6
//Instructor: Ping-Wei Tsai 
//Summary of Description: this program calculates order costs
//Due Date: 11/28/2021 
//Integrity Pledge: I pledge that I have completed the programming assignment independently. 
//I have not copied the code from a student or any source. 
//Student’s Name: Anna Downey 

import java.util.ArrayList;
import java.util.Random;

class Order implements OrderInterface, Comparable<Order> {
	private int orderNo;
	private int orderTime;
	private DAY orderDay;
	private Customer customer;
	private ArrayList<Beverage> beverages;
	  
	public Order(int orderT, DAY orderD, Customer c) {
		orderNo = ranOrderNum();
		orderTime = orderT;
		orderDay = orderD;
		customer = c;
		beverages = new ArrayList<>();
	}
	
	public int ranOrderNum() {
		Random rand = new Random();
		int randInt = rand.nextInt(90000 - 10000) + 10000;
		return randInt;
	}
	
	public String toString() {
		String s = "__________________________________" + orderDay.toString() + ", " + orderTime + "\n" + customer.toString() + " Order Num: " + orderNo;
		  
		for (Beverage b : beverages) {
			s += "\n" + b.toString();
		}
		s += "\n Order Total: " + calcOrderTotal(); 
		return s;
	}
	
	public boolean isWeekend() {
		if (orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) {
			return true;
		}
		return false;
	}
	
	public Beverage getBeverage(int itemNum) {
		return beverages.get(itemNum);
	}
	
	public int compareTo1(Order ord) {
		if (orderNo == ord.getOrderNo()) {
			return 0;
		}
		else if (orderNo > ord.getOrderNo()) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	public double calcOrderTotal() {
		double orderTot = 0;
		  
		for (Beverage b : beverages) {
			orderTot += b.calcPrice();
		}
		  
		return orderTot;
	}
	
	public int findNumOfBeveType(TYPE type) {
		int count = 0;
		  
		for (Beverage b : beverages) {
			if (b.getType() == type) {
				count++;
			}
		}
		return count;
	}
	
	public int getTotalItems() {
		return beverages.size();
	}
	  
	public void addNewBeverage(String n, SIZE s, boolean extraShot, boolean extraSyrup) {
		Coffee c = new Coffee(n, s, extraShot, extraSyrup);
		beverages.add(c);
	}
	
	public void addNewBeverage(String n, SIZE s, int numOfFruits, boolean proteinPowder) {
		Smoothie sm = new Smoothie(n, s, numOfFruits, proteinPowder);
		beverages.add(sm);
	}
	
	public void addNewBeverage(String n, SIZE s) {
		boolean onWeekend = false;
		if (orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) {
			onWeekend = true;
		}
		Alcohol alc = new Alcohol(n, s, onWeekend);
		beverages.add(alc);
	}
	  
	public int getOrderNo() {
		return orderNo;
	}
	
	public int getOrderTime() {
		return orderTime;
	}
	
	public DAY getOrderDay() {
		return orderDay;
	}
	
	public Customer getCustomer() {
		return new Customer(customer);
	}
	
	public ArrayList<Beverage> getBeverages() {
		return beverages;
	}
	  
	public void setOrderNo(int orderN) {
		orderNo = orderN;
	}
	
	public void setOrderTime(int orderT) {
		orderTime = orderT;
	}
	
	public void setOrderDay(DAY orderD) {
		orderDay = orderD;
	}
	
	public void setCustomer(Customer c) {
		customer = c;
	}
	
	@Override
	public int compareTo(Order arg0) {
		return 0;
	}
}