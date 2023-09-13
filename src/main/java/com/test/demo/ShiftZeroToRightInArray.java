package com.test.demo;

import java.util.Arrays;

public class ShiftZeroToRightInArray {

	public int[] shiftZero(int[] arr) {

		int count = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] != 0)
				arr[count++] = arr[i];
		}
		while (count < arr.length) {

			arr[count++] = 0;

		}
		return arr;

	}

	public static void main(String args[]) {
		ShiftZeroToRightInArray obj = new ShiftZeroToRightInArray();
				
		int arr[] = { 1, 0, 4, 2, 0, 5, 0, 5, 7, 0, 7, 0, 4 };

		int[] shiftZero = obj.shiftZero(arr);
		
		Arrays.stream(shiftZero).forEach(System.out::print);
		
	
	}

}
