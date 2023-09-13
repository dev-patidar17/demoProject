package com.test.demo;

import java.util.SortedSet;
import java.util.TreeSet;

public class ArrayProgram extends StaticBlock{
	
	public static void findLargest(int[] arr) {
		int largest = arr[0];
		for(int i=1; i<arr.length; i++) {
			
			if(largest<arr[i]) {
				largest = arr[i];
			}
			
		}
		System.out.println(largest);
		
	}
	
	
	public static void findSecondLargest(int[] arr) {
		
		
		int secondLarge =0;
		int largest = 0;
		
		for(int i = 0; i<arr.length;i++) {
			
			if(largest<arr[i] && secondLarge<arr[i]) {
				
				secondLarge = largest;
				largest = arr[i];
			}else if(largest<arr[i]){
				largest = arr[i];
			}else if(secondLarge<arr[i]){
				secondLarge = arr[i];
			}
		}
		
		System.out.println("largest : "+largest+" secondLarge : "+secondLarge);
	}
	
	public static void findLargestSmalest(int[] arr) {
		
		int smalest =arr[0];
		int largest =0;
		
		for(int i=0; i<arr.length;i++) {
			
			if(largest<arr[i]) {
				largest=arr[i];
			}
			if(smalest>arr[i])
				smalest=arr[i];
		}
		System.out.println("largest : "+largest+" smallest : "+smalest);
	}
	
	public static void sortArray(int[] arr) {
		
		
		for(int i=0; i<arr.length-1; i++) {
			
			
			for(int j = i+1; j<arr.length; j++) {
				
				if(arr[i]>arr[j]) {
					
					int n= arr[i];
					arr[i] = arr[j];
					arr[j]= n;
				}
			}
			
		}
		for(int i=0;i<arr.length; i++) {
			System.out.print(arr[i]+", ");
		}
	}
	
	public static void peakElement(int[] arr) {
		System.out.println("peak Element...!");
		for(int i=1;i<arr.length;i++) {
			
			if(i !=arr.length-1 ) {
				if(arr[i-1]<arr[i] && arr[i+1]<arr[i])
					System.out.print(arr[i]+" ,");
			}else {
				
				if(arr[i] > arr[i-1])
					System.out.print(arr[i]+" ,");
				
			}
			
		}
		
	}
	
	public static void reverseArray(int[]arr) {
		System.out.println("Reverse Array..");
		int halfLength = arr.length/2;
		int length = arr.length;
		for(int i= 0; i<halfLength; i++ ) {
			
			int temp = arr[i];
			arr[i] = arr[length-(1+i)];
			arr[length-(1+i)] = temp;
		}
		for(int i=0;i<length; i++) {
			System.out.print(arr[i]+", ");
		}
		
	}
	
	public static void findKthSmallestElement(int[]arr) {
		System.out.print("findKthSmallestElement...");
		SortedSet<Integer> setInt = new TreeSet<>();
		for(int i = 0; i< arr.length-1; i++) {
			
			for(int j =i+1; j< arr.length; j++) {
				if(arr[i]>arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					
				}
			}
			if(setInt.size() <3) {
				setInt.add(arr[i]);
			}else {
				break;
			}
			
		}
		//for(int i=0;i<setInt.size(); i++) {
			System.out.print(setInt);
		//}
		
	}
	
	public static void subArrayWithGivenSum(int[] arr, int sum) {
		boolean flag = false;
		int calculateSum = 0;
		int n1= 0;
		int n2= 0;
		
		for(int i=0; i< arr.length-1; i++) {
			 calculateSum = arr[i];
			 n1 = i;
			for(int j= i+1; j<arr.length; j++) {
				
				calculateSum += arr[j];
				if(sum == calculateSum ) {
					flag = true;
					n2=j;
					break;
				}else if(sum < calculateSum ) {
					break;
				}
				
			}
			if(flag)
				break;
		}
		
		if(flag) {
			System.out.print("sub array from.."+n1+" to "+n2+"   sum.."+sum);
		}else {
			System.out.println("No value founnd");
		}
		
	}

	public static void main(String[] args) {
		
		int[] arr = {100,20,93,5,41,87,129,30, 101,1,0,0};
		
		int[] arr1 = {100,20,93,5,41,87,129,30, 101,1,0,0};
		int[] arr2 = {100,20,93,5,41,87,129,30, 101,1,2,0};
		
		findLargest(arr);
		findLargestSmalest(arr);
		findSecondLargest(arr);
		sortArray(arr);
		
		peakElement(arr1);
		reverseArray(arr1);
		
		findKthSmallestElement(arr1);
		
		subArrayWithGivenSum(arr2,1);
		
		
	}


	@Override
	public int adding(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void hello() {
		// TODO Auto-generated method stub
		
	}

}
