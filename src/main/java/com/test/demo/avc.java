package com.test.demo;

import java.time.LocalDate;

import net.bytebuddy.asm.Advice.Local;


public class avc {
	
	public void hello (String s) {
		System.out.println("String...."+s);
	}
	
	public void hello(Employee s) {
		System.out.println("int...."+s);
	}
 public void main(String args[]) {
	avc a = new avc();
	a.hello(null);
	
 }
}
