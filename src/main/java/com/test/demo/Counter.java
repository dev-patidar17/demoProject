package com.test.demo;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter  implements Runnable{
	
	AtomicInteger count;
	
	/*
	 * public Counter() { count = new AtomicInteger(); }
	 */
	
	@Override
	public void run() {
		
		int max = 1_000_00_000;
		
		for(int i =0; i< max; i++) {
			count.addAndGet(1);
		}
		
	}


	public static void main(String[] args) throws InterruptedException {
	
		Counter c = new Counter();
		
		Thread t = new Thread(c, "T1");
		Thread t2 = new Thread(c, "T2");
		
		t.start();
		t2.start();
		
		t.join();
		t2.join();
		System.out.println(c.count);

	}

	
}
