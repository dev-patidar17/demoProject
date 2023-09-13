package com.test.demo;


class MutliThread extends Thread{
	
	
	@Override
	public void run() {
	
			System.out.println(Thread.currentThread().getName());
			
	}
	
}

public class ThreadExample {

	public static void main(String[] args) {
		
		Thread t = new Thread(new MutliThread());
		
		t.setName("Hello Threading");
		
		t.start();
		
	}

}
