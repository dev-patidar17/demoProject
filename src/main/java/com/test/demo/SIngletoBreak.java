package com.test.demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class SIngletoBreak {
	
	
	public static SIngletoBreak sb = new SIngletoBreak();
	String s= null;
	private SIngletoBreak() {
		s = "";
	}
	


	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Constructor<?>[] declaredConstructors2 = SIngletoBreak.class.getDeclaredConstructors();
		
		for(Constructor<?>  cons : declaredConstructors2) {
			cons.setAccessible(true);
			SIngletoBreak ss =	(SIngletoBreak) cons.newInstance();
			break;
		}
		
		
		SIngletoBreak sb2 = SIngletoBreak.sb;
		SIngletoBreak sb3 = null;
		Constructor<?>[] declaredConstructors = SIngletoBreak.class.getDeclaredConstructors();
		
		for (Constructor<?> constructor : declaredConstructors) {
			
			constructor.setAccessible(true);
			try {
				 sb3 =(SIngletoBreak)constructor.newInstance();
				 break;
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		SingletonUsingEnum instance = SingletonUsingEnum.INSTANCE;
		SingletonUsingEnum instance2 = SingletonUsingEnum.INSTANCE;
		
		System.out.println(sb2.hashCode()+"     "+sb3.hashCode());
		System.out.println(instance.hashCode()+"     "+instance2.hashCode());
		
		System.out.println(instance.welcome());
	}
	
	

}
