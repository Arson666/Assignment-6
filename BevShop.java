//Class: CMSC203 CRN 24307 
//Program: Assignment #6
//Instructor: Ping-Wei Tsai 
//Summary of Description: this program calculates order costs
//Due Date: 11/28/2021 
//Integrity Pledge: I pledge that I have completed the programming assignment independently. 
//I have not copied the code from a student or any source. 
//Student’s Name: Anna Downey 

import java.util.ArrayList;

class BevShop implements BevShopInterface{
	private int numOfDrinks;
	private int orderIndex;
	private ArrayList<Order> orders;
	  
	public BevShop() {
		orders = new ArrayList<>();
	}
	  
	public String toString() {
		String s = "Monthly Orders\n";
		  
		for (Order ord : orders) {
			s += ord.toString();
		}
		s += "Total Sale: " +totalMonthlySale();
		return s;
	}
	  
	public boolean validTime(int time) {
		if ((time >= MIN_TIME) && (time <= MAX_TIME)) {
			return true;
		}
		return false;
	}
	
	public boolean eligibleForMore() {
		if (numOfDrinks < 3) {
			return true;
		}
		return false;
	}
	
	public boolean validAge(int age) {
		if (age > MIN_AGE_FOR_ALCOHOL) {
			return true;
		}
		return false;
	}
	
	public boolean isMaxFruit(int num) {
		if (num > MAX_FRUIT) {
			return true;
		}
		return false;
	}
	  
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		Customer customer = new Customer(customerName, customerAge);
		Order order = new Order(time, day, customer);
		orders.add(order);
		orderIndex = orders.indexOf(order);
		numOfDrinks = 0;
	}
	
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		orders.get(orderIndex).addNewBeverage(bevName, size, extraShot, extraSyrup);
	}
	
	public void processAlcoholOrder(String bevName, SIZE size) {
		orders.get(orderIndex).addNewBeverage(bevName, size);
		numOfDrinks++;
	}
	
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtein) {
		orders.get(orderIndex).addNewBeverage(bevName, size, numOfFruits, addProtein);
	}
	  
	public int findOrder(int orderNo) {
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getOrderNo() == orderNo) {
				return i;
			}
		}
		return -1;
	}
	
	public double totalOrderPrice(int orderNo) {
		double orderSale = 0;
		  
		for (Order ord : orders) {
			if (ord.getOrderNo() == orderNo) {
				for (Beverage b : ord.getBeverages()) {
					orderSale += b.calcPrice();
				}
			}
		}
		return orderSale;
	}
	
	public double totalMonthlySale() {
		double totalSale = 0;
		  
		for (Order ord : orders) {
			for (Beverage b : ord.getBeverages()) {
				totalSale += b.calcPrice();
			}
		}
		return totalSale;
	}
	
	public void sortOrders() {
		for (int i = 0; i < orders.size()-1; i++) {
			int minOrderNumIdx = i;
			for (int j = i+1; j < orders.size(); j++) {
				if (orders.get(j).getOrderNo() < orders.get(minOrderNumIdx).getOrderNo()) {
					minOrderNumIdx = j;
				}
			}
			Order temp = orders.get(minOrderNumIdx);
			orders.set(minOrderNumIdx, orders.get(i));
			orders.set(i, temp);
		}
	}
	
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}
	
	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}
	
	public Order getCurrentOrder() {
		return orders.get(orderIndex);
	}
	
	public int getNumOfAlcoholDrink() {
	return numOfDrinks;
	}
	
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}
	
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}
}