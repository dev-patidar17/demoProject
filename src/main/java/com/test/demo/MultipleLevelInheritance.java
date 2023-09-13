package com.test.demo;


interface One{
	public void display();
}
interface Two{
	public void displayTwo();
}

interface Three extends One, Two{
	public void displayThree();
}

public class MultipleLevelInheritance implements Three{
	
	@Override
	public void displayTwo() {
		System.out.println("two");
		
	}

	@Override
	public void display() {
		System.out.println("One");
		
	}

	@Override
	public void displayThree() {
		System.out.println("Three");
		
	}

	public static void main(String[] args) {

		MultipleLevelInheritance mi = new MultipleLevelInheritance();
		mi.display();
		mi.displayTwo();
		mi.displayThree();

	}

	

}
