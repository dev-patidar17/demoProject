package com.test.demo;

	class Bike{  
	 int speedlimit=90;  
	}  

	public class Honda3 extends Bike{  
	 int speedlimit=150;  
	  
	 public static void main(String args[]){  
	  
		 	Bike obj=new Honda3();  
		 	System.out.println(obj.speedlimit); 
	 }  
	}
