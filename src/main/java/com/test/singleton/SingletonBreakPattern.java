package com.test.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Singleton{
	 public static Singleton instance = null;
	 
	 public Singleton() {
		 
	 }
	 
	 public static Singleton singleTon() {
		 
		 if(instance == null) {
			 instance = new Singleton();
		 }
		 
		 return instance;
	 }
}

public class SingletonBreakPattern {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Singleton instance = Singleton.singleTon();
		Singleton instance2 = null;
		Constructor<?>[] constructors = Singleton.class.getConstructors();
		
		for (Constructor<?> constructor : constructors) {
			
			constructor.setAccessible(true);
			instance2 = (Singleton)constructor.newInstance(); 
			break;
		}
		
		
		System.out.println(instance.hashCode());
		System.out.println(instance2.hashCode());

	}

}
