package com.test.demo;



class Parant{
	
	public void show() {
		System.out.println("Parant class method");
	}
	
}

class Child extends Parant{
	
	@Override
	public void show() {
		System.out.println("Child Class method");
	}
	
}
public class ParantChild {

	public static void main(String[] args) {

		Child c = new Child();
		
		c.show();
		
		Parant p = new Child();
		
		p.show();
		
		Parant pc = new Child();
		
		Child cp = (Child)pc;
		cp.show();
		//Child cp = new Parant();
		
	}

}
