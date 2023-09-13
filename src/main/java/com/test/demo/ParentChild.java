package com.test.demo;

enum Days{
	SUNDAY("SUNDAY"),
	MONDAY("Monday"),
	TUESDAY("TUESDAY");

	Days(String string) {
		
	}
	
};

class A{
	public void display(String s) {
		System.out.println("In class A..."+s);
	}
}
class C extends A{
	
	public void display(String s) {
		System.out.println("In class C..."+s);
	}
	
}
public class ParentChild {

	public static void main(String[] args) {
		
		C c = new C();
		c.display("Hello");
		String name = Days.MONDAY.name();
		
		System.out.println(name);
	}
	
}
