package com.test.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
	  
			public String reverseString(String str){
				
				int length = str.length();
				StringBuilder sb = new StringBuilder();
				for(int i = length-1; i>=0; i-- ) {
					
					sb.append(str.charAt(i));
				}
					System.out.println(sb.toString());
				return null;
				
			}
			
			
			public void firstOccurance(String str) {
				List<Character> chList = new ArrayList<>();
				for(int i = 0; i< str.length(); i++) {
					
					if(!chList.contains(str.charAt(i))) {
						chList.add(str.charAt(i));
						System.out.println("First Occurance of "+str.charAt(i) + " is "+i); 
					}
				}
				
			}
			int num = 0;
			int num1 = 1;
			public void fibonacci(int value,int num3){
				
				
			if(value>=0) {	
				 
					num3 = num+num1;
					num=num1;
					num1= num3;
					
					
					System.out.print(num3+", ");
					
					
					
					fibonacci(value-1,num3);
			}
				
			}
	        
	        public static void main(String args[])
	        {
	        	Test t1 = new Test();
	        	String str = "I am Developer";
	        	t1.reverseString(str);
	        	t1.firstOccurance(str);
	        	System.out.print(1+", ");
	        	t1.fibonacci(6,0);
	        }
	    }  

	  