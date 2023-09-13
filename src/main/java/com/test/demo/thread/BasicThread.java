package com.test.demo.thread;

import java.io.IOException;

public class BasicThread implements Runnable {
	boolean flag = false;
	public static void main(String[] args) throws IOException {
	
		
		BasicThread bt = new BasicThread();
		
		Thread t1 = new Thread(bt);
		t1.start();
		
		t1.setName("First Thread");
		
		System.in.read();
		bt.flag = true;
		
	}

	@Override
	public void run() {
		
		for(int i =0 ; i<1000000;i++) {
			System.out.println(i);
			if(flag) {
				System.out.println("THread terminated..!");
				return;
			}
				
			
		}
		System.out.println("Name of the thread "+Thread.currentThread().getName());
		
	}

}
