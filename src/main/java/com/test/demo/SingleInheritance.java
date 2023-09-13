package com.test.demo;


class One1{
	
	public void printGreek() {
		System.out.println("Greek");
	}
	
}


class Two1 extends One1{
	
	public void printFor() {
		
		System.out.println("for greek");
	}
	
	
}
public class SingleInheritance {

	public static void main(String[] args) {
		
		Two1 t = new Two1();
		
		t.printFor();
		t.printGreek();
		t.printFor();
	}

}
