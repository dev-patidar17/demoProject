package com.test.demo;


interface AMulti{
	
	public void method_A();
}

interface BMulti {
	public void method_B();
}

class TestMlti implements AMulti,BMulti{

	@Override
	public void method_B() {
		System.out.println("In Method B");
		
	}

	@Override
	public void method_A() {

		System.out.println("In Method A");
		
	}

}


public class MultipleInheritance {

	
	public static void main(String args[]) {
		
		TestMlti t = new TestMlti();
		t.method_A();
		t.method_B();
		
	}
	
}

