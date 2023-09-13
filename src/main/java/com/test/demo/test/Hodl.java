package com.test.demo.test;

public class Hodl {
	
	int id;
	Hodl x;
	
	Hodl(int amount, Hodl h){
		id = amount;
		x = this;
		if(h != null) x=h;
		
	}
	void go(Hodl h2) {
		Hodl h3 = new Hodl(2, h2);
		Hodl h4 = new Hodl(2, h3);
		System.out.println(h4.x.x.id);
	}

	public static void main(String[] args) {
		
		Hodl h1 = new Hodl(1, null);
		h1.go(h1);

	}

	

}
