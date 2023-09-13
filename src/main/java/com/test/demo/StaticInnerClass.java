package com.test.demo;

public class StaticInnerClass {
	
	
	
	
	public StaticInnerClass() {
		
	}

	public static class StaticClass{
		public static void display() {
			System.out.println("inside inner static method...!");
		}
		
		public void display2() {
			System.out.println("inner class method");
		}
		
	}

	public static void main(String[] args) {
		
		
		StaticInnerClass.StaticClass sc = new StaticInnerClass.StaticClass();
		
		StaticInnerClass.StaticClass.display();
		sc.display2();
	}

}
