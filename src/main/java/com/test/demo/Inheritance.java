package com.test.demo;

import org.junit.platform.commons.util.ToStringBuilder;

class Bycycle{
	
	int speed;
	int gear;
	
	public Bycycle(int speed, int gear) {
		this.speed =  speed;
		this.gear = gear;
	}
	
	
	public void applyBrea(int decreament) {
		speed -= decreament;
	}
	public void applyGear(int inceament) {
		speed += inceament;
	}
	 public String toString() {
		 return ("no. of gear are "+gear+ " speed   is "+speed);
	}
	 
	
	 
	 
	
}

class Bike1 extends Bycycle{
	
	
	public int seatHight;
	

	public Bike1(int speed, int gear, int seatHight) {
		super(speed, gear);
		this.seatHight = seatHight;
	}
	
	public void setHeight(int height) {
		
		seatHight = height;
		
	}
	
	@Override
	public String toString() {
		return (super.toString()+" seatHeight is "+seatHight +"cm");
		
	}
	
	
	 
}

public class Inheritance {

	public static void main(String[] args) { 

		Bike1 bk = new Bike1(100, 4, 55);
		System.out.println(bk.toString());
	}

}
