package com.test.demo;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ArrayPro {
	
	public void biggestElement(int[] arr) {
		
		int biggest = arr[0];
		
		for(int i=1;i<arr.length; i++) {
			
			if(biggest<arr[i]) {
				biggest = arr[i];
			}
			
		}
		System.out.println("biggest element in array is "+biggest); 
		
	}
	
	public void secondBiggest(int[] arr) {
		
		int biggest = arr[0];
		int secondBiggest = 0;
		
		for(int i=1; i<arr.length; i++) {
			
			if(biggest<arr[i]) {
				secondBiggest = biggest;
				biggest = arr[i];
			}else if(secondBiggest<arr[i]) {
				secondBiggest = arr[i];
			}
		}
		System.out.println("Biggest element in the array is "+biggest+" Second biggest element is "+secondBiggest);
	}
	
	public void biggestAndSmallest(int[] arr) {
		
		int biggest = arr[0];
		int smallest = arr[0];
		
		for(int i=1; i<arr.length; i++) {
			
			if(biggest <arr[i]) 
				biggest = arr[i];
			if(smallest>arr[i])
				smallest = arr[i];
		}
		System.out.println("Biggest element in the array is "+biggest+" Smallest element is "+smallest);
	}
	
	public void sortArray(int[] arr) {
		
		for(int i=0; i<arr.length;i++) {
			for(int j=i+1; j<arr.length-1;j++) {
				if(arr[i]>arr[j]) {
					arr[i] = arr[i]+arr[j];
					arr[j]  = arr[i]-arr[j];
					arr[i] = arr[i]-arr[j];
				}
			}
		}
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+",");
		}
	}
	public void peakElement(int[] arr,int length) {
		System.out.print("Peak elements in array are ");
		for(int i=1; i<arr.length; i++) {
			
			if(i != arr.length-1) {
				if(arr[i-1]<arr[i] && arr[i]>arr[i+1]) {
					System.out.print(arr[i]+", ");
				}
			}else {
				if(arr[i]>arr[i-1]) {
					System.out.print(arr[i]+", ");
				}
			}
			
		}
		
	}
	
	public void reverseArray(int[] arr) {
		
		int length = arr.length;
		int halfArry = length/2;
		
		for(int i=0; i<halfArry;i++) {
			arr[i] = arr[i]+arr[length-(i+1)];
			arr[length-(i+1)] = arr[i]-arr[length-(i+1)];
			arr[i] = arr[i]-arr[length-(i+1)];
		}
		System.out.println("Reverse array...");
		List<Integer> collect = Arrays.stream(arr).boxed().collect(Collectors.toList());
		collect.forEach(obj -> System.out.print(obj+", ")); 
	}
	public void findKthSmallestElement(int[] arr) {
		
		
		int N = arr.length;
		int K = 4;

		// since counting starts from 0 so to find kth
		// element we need to reduce K by 1
		K--;

		// for storing elements in sorted form
		// in set we will use TreeSet
		Set<Integer> s = new TreeSet<Integer>();

		// Adding elements to set
		for (int i = 0; i < N; i++)
			s.add(arr[i]);

		// Use iterator method of Iterator
		// for the traversal
		Iterator<Integer> itr = s.iterator();

		while (K > 0) {
			itr.next();
			K--;
		} // itr points to the Kth element in the set

		System.out.println(itr.next());

	
		
	}

	public static void main(String[] args) {
	
		int[] arr = {50,240,60,30,10,70,20,100,110};
		ArrayPro obj = new ArrayPro();
		obj.biggestElement(arr);
		obj.secondBiggest(arr);
		obj.biggestAndSmallest(arr);
		System.out.println();
		obj.sortArray(arr);
		System.out.println();
		int[] arr1 = {50,240,60,30,10,70,20,100,110};
		obj.peakElement(arr1,arr1.length);
		obj.reverseArray(arr1);
		obj.findKthSmallestElement(arr1);
	}
	
	
	
	

}
