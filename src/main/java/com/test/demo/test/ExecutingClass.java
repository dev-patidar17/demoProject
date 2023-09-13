package com.test.demo.test;

class CustomException extends Exception{
	int num;
	public CustomException(int n) {
		num =n;
	}
	public String toString() {
		return Integer.toString(num);
	}
}

public class ExecutingClass {
	
	
	static void calculate(int n) throws CustomException {
		throw new CustomException(n);
	}

	public static void main(String[] args) {
		try {
			calculate(42);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			System.out.println("Catch22");
		}

	}

}
