package com.test.demo;

import java.util.HashMap;
import java.util.Map;

public class ArraySort {

	public static void main(String[] args) {

		
		int[] arr = {7,5,9,3,9,2,18,13,11,70};
		
		for(int i=0; i< arr.length-1; i++) {
			
			for (int j = i+1; j< arr.length; j++) {
				
				if(arr[i]>arr[j]) {
					arr[i] = arr[i]+arr[j];
					arr[j] = arr[i]-arr[j];
					arr[i] = arr[i]-arr[j];
				}
				
			}
		}
		for (int i : arr) {
			System.out.println(i+", ");
		}
		
		//----------------//--------- Biggest
		int bigest = arr[0];
		for(int i=1; i< arr.length; i++) {
			
			if(bigest<arr[i]) {
				bigest =arr[i];
			}
			
		}
		System.out.println("Biggest is "+bigest);
		
		//----------------//--------- Second Biggest
		
		if(arr.length == 1) {
			
			System.out.println("Biggest is "+arr[0]);
		}
		if(arr.length == 2) {
			if(arr[0]<arr[1]) 
				System.out.println("Biggest is "+arr[1]);
			else
				System.out.println("Biggest is "+arr[0]);
		}
		int[] arr1 = {90,5,9,3,9,2,18,19,50,70};
		
		 bigest = 0;
		 int secondBiggest = 0;
		for(int i = 0; i<arr1.length; i++ ) {
			
			if(bigest<arr1[i] && secondBiggest < arr1[i]){
				secondBiggest = bigest;
				bigest = arr1[i];
			}else if( secondBiggest < arr[i]){
				secondBiggest = arr1[i];
			}
			
		}
		System.out.println("bigest..."+bigest +"secondBiggest..."+secondBiggest ); 
		System.out.println("Peak element..."); 
		for(int i =1; i< arr1.length; i++) {
			
			if(i != arr1.length-1) {
				if(arr1[i-1]<arr1[i] && arr1[i+1]>arr1[i]) {
					System.out.print(arr1[i] +" ,");
					
				}
			}else if(arr1[i]>arr1[i-1]) {
				System.out.print(arr1[i] );
			}
			
		}
		
		
		for(int i = 1 ; i<arr1.length; i++) {
			
			if(i != arr1.length-1) {
				if(arr1[i-1]<arr1[i] && arr1[i+1]>arr1[i]) {
					 System.out.print(arr1[i]+", ");
				}
			}else if(arr1[i]>arr[i-1]){
				 System.out.print(arr1[i]+", ");
			}
			
			
			
		}
		
		System.out.println("Occurance of element..."); 
		Map<Integer, Integer>  occuranceMap = new HashMap<>();
		for(int i = 0; i< arr1.length; i++) {
			
			
			if(occuranceMap.containsKey(arr1[i])) {
				occuranceMap.put(arr1[i], occuranceMap.get(arr1[i])+1);
			}else {
				occuranceMap.put(arr1[i], 1);
			}
			
			
			
		}
		occuranceMap.forEach((k,v)-> {
			System.out.println("element "+k+":- occurance "+v); 
		});
	}
	
	
	
	
	

}
