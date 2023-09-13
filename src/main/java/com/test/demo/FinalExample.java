package com.test.demo;

class B {
	
	public static void method1() {
		 System.out.println("Method 1");
	}
	
}
public class FinalExample extends B{
	
	final int a;
	
	public FinalExample(int a) {
		this.a =a;
	}
	
	public static void method1() {
		 System.out.println("Method 2");
	}
	
	
	
	public static void main(String[] args) {
		
		
		FinalExample fe = new FinalExample(10);
		System.out.println(fe.a);
		
	}

}
