package com.test.demo;


class Member{
	
	int number;
	String name;
	
	public void chat() {
		
		System.out.println("In chating method...!");
	}
}

class Admin extends Member{
	
	public void addUser() {
		System.out.println("add user");
	}
}


public class ParantChild2 {

	public static void main(String[] args) {

		Member m = new Admin();
		m.chat();
		
		
		Admin ad = (Admin)m;
		ad.addUser();
		
	}

}
