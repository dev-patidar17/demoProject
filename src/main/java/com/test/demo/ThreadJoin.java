package com.test.demo;

public class ThreadJoin extends Thread{
	
	
	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName());
		
		System.out.println("in run method..."+Thread.currentThread().isAlive()); 
	}

	public static void main(String[] args) throws InterruptedException {


		Thread th = new Thread(new ThreadJoin());
		
		th.setName("Test join");
		
		th.start();
		
		th.join(10000);

		System.out.println("Is alive..?"+th.isAlive());
	}

}
