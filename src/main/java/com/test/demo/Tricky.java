package com.test.demo;



public class Tricky {
	
	
	public String abc() {
		
		try {
		
		
		} catch (Exception e) {
			
		}finally {
			System.out.println("Finaly");
		}
		return "hello";
	}
	
	public static void main(String[] args) 
	{ 
		System.out.println(Math.min(Double.MIN_VALUE, 0.0d)); 
		Tricky t = new Tricky();
		
		t.abc();
		
	}



}
