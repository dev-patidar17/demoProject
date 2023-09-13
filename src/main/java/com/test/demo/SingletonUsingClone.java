package com.test.demo;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;

public class SingletonUsingClone implements Cloneable{
	
	
	public static SingletonUsingClone sc = new SingletonUsingClone();
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return sc;
	}
	
	

	public static void main(String[] args) throws CloneNotSupportedException {
	
		SingletonUsingClone obj1 = SingletonUsingClone.sc;
		
		SingletonUsingClone obj2 = (SingletonUsingClone) SingletonUsingClone.sc.clone();
		
		System.out.println(obj1.hashCode()+"......."+obj2.hashCode());
		
		List<Double> lst = new ArrayList<>();
		lst.add(4.2);
	
		
	

	}
	
	
	public static void addNumberUpw( List<? extends Number> num) {
		
	}
	
	public static void addNumber1(List<? super Integer> num) {
		
	}
	
}
