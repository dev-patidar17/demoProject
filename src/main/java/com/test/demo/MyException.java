package com.test.demo;

public class MyException extends Exception{
	
	
	public MyException(String s) {
		super(s);
	}

	public static void main(String[] args)  {

		try {
			throw new MyException("Data not proper");
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
