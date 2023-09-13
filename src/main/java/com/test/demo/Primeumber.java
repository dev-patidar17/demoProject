package com.test.demo;

import java.util.Iterator;

import org.springframework.aop.target.HotSwappableTargetSource;

public class Primeumber {
	
	public void findPrme(int num){
		int halfOfNum = num/2;
		boolean isPrime = true;
		if(num ==0 || num ==1) {
			isPrime = false;
		}else{
			
			for(int i=2; i<=halfOfNum; i++) {
				
				if(num % i == 0) {
					isPrime = false;
					break;
				}
			}
		}
		
		if(isPrime)
			System.out.println("Prime Number");
		else
			System.out.println("Not a Prime");
		
	}
	public static void swap(int num1, int num2) {
		
		num1 = num1+num2;
		num2 = num1-num2;
		num1 = num1-num2;
		System.out.println("num1.."+num1+"  num2..."+num2);
	}
	
	public static void palindrom(String str) {
		
		int length = str.length();
		//StringBuffer sb = new StringBuffer();
		StringBuilder sb1 = new StringBuilder();
		for(int i = length-1; i>=0; i--) {
			sb1.append(str.charAt(i));
		}
		String str2 = sb1.toString();
		if(str.equals(str2)) 
			System.out.println("A palindrome   "+str+"  "+str2);
		else
			System.out.println("Not a palindrome  "+str+"  "+str2);
	}
	
	public static void palindromNumber(int num) {
		int numTemp= num;
		int reminder = 0;
		int sum = 0;
		while(num>0) {
			
			reminder = num%10;
			
			sum = (sum*10)+reminder;
			num = num/10;
			
		}
		
		if(sum == numTemp) {
			System.out.println(sum+" is palindrome");
		}else {
			System.out.println(num+" is not palindrome");
		}
		
	}
	
	public static void fibonacci(int num){
		System.out.print(1+" ");
		int n1=0;
		int n2=1;
		int num3 = 0;
		
		for(int i = 0; i<10; i++) {
			
			num3 = n1+n2;
			n1= n2;
			n2 = num3;
			
			System.out.print(" "+num3);
			
			
		}
		//1,1,2,3,5,8,13...
		
	}
	
	public static void armstrongNumber(int num) {
		
		String strNum = Integer.toString(num);
		int sum =0;
		for(int i =0; i<strNum.length(); i++) {
			int singDigit = strNum.charAt(i) -'0';
			
			sum += Math.pow(singDigit, strNum.length());
		}
		System.out.println(sum);
		
	}

	public static void main(String[] args) {
		
		Primeumber prim = new Primeumber();
		prim.findPrme(101);
		
		swap(15,17);
		palindrom("nitin");
		fibonacci(10);
		
		palindromNumber(7997);
		
		armstrongNumber(1634);
		
	}

}
