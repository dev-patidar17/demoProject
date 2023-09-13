package com.test.demo;

public class FinalizeClass {
	
	

	public static void main(String[] args) {
		
		FinalizeClass f = new FinalizeClass();
		
		//f.finalize();
		f=null;
		System.gc();
		System.out.println("Main class completed");
		

	}
	
	public void finalize() {
		System.out.println("finalize executed successfully..!"); 
		System.out.println(10/0);
		
	}

}
