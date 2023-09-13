package com.test.demo.casting;

import static org.hamcrest.CoreMatchers.instanceOf;

class A{
	public void method() {
		System.out.println("Class A method clled");
	}
}
class B extends A{
	public void method() {
		System.out.println("Class B method called");
	}
}
class C extends B{
	public void method() {
		System.out.println("Class C method called");
	}
	
	public void methodTwo() {
		System.out.println("methodTwo of Class C called "); 
	}
}

public class Casting_Pro_One {

	public static void main(String[] args) {

		B c =  new C();
		c.method();
		
		A a = new C();
		a.method();
		
		if(a instanceof C) {
			a.method();
			C objC = (C) a;
			objC.methodTwo();
		}
		
		
	}

}
