package com.test.demo;

class Bicycle{
	  void run(){
		  System.out.println("running");
		  }
	}
public class Hero extends Bicycle{
	  void run(){
		  System.out.println("running safely with 10km");
		  }

	  public static void main(String args[]){
		  Bicycle b = new Hero();//upcasting 
		  b.run();
		 Hero h = (Hero) b;
		  h.run();
	   
	  }
	}
