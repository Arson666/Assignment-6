//Class: CMSC203 CRN 24307 
//Program: Assignment #6
//Instructor: Ping-Wei Tsai 
//Summary of Description: this program calculates order costs
//Due Date: 11/28/2021 
//Integrity Pledge: I pledge that I have completed the programming assignment independently. 
//I have not copied the code from a student or any source. 
//Student’s Name: Anna Downey 

class Customer {
	private String name;
	private int age;
	  
	public Customer(String n, int a) {
		name = n;
		age = a;
	}
	
	public Customer(Customer c) {
		name = c.getName();
		age = c.getAge();
	}
	  
	public String toString() {
		return name + ", " + age + "y/o";
	}

	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
		
	public int getAge() {
		return age;
	}
	 
	public void setAge(int a) {
		age = a;
	}
}