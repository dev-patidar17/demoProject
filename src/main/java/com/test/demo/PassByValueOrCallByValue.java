package com.test.demo;

public class PassByValueOrCallByValue {
	int a;
	public  PassByValueOrCallByValue(int a) {
		
		this.a= a;
	}
	public void hello(PassByValueOrCallByValue pv) {
		pv.a= 20;
	}

	public static void main(String[] args) {
	
		int a =10;
		PassByValueOrCallByValue pv = new PassByValueOrCallByValue(a);
		
		pv.hello(pv);
		
		System.out.println(pv.a);

	}
	
	

}
