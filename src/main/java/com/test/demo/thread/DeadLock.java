package com.test.demo.thread;

 class BookTicket extends Thread{
	
	Object train,compartment;
	
	public BookTicket(Object train, Object compartment) {
		this.train = train;
		this.compartment = compartment;
	}

	@Override
	public void run() {
		 synchronized (train) {
			 
			 
			 
			 System.out.println("BookTicket locked on train..!");
			 try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			 
			 System.out.println("Book ticket is now waiting for lock compartment..!");
			 
			 
			 synchronized (compartment) {
				System.out.println("BookTicket locked on compartment..!"); 
			}
			 
		}
		 
		
	}
}


class CancelTicket extends Thread{
	
	Object train,compartment;
	
	public CancelTicket(Object train, Object compartment) {
		this.train = train;
		this.compartment = compartment;
	}

	@Override
	public void run() {
		
		synchronized (train) {
			
			System.out.println("CancelTicket locked on train..!");
			
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("CancelTicket is now waiting for compartment");
			synchronized (compartment) {
				System.out.println("CancelTicket locked on compartment..!");
			}
			
		}
		
	}
	
}

public class DeadLock {
	
	public static void main(String[] args) {
		Object train = new Object();
		Object compartment = new Object();
		
		BookTicket bookTicket = new BookTicket(train, compartment);
		CancelTicket cancelTicket = new CancelTicket(train, compartment);
		
		Thread bookThread = new Thread(bookTicket);
		
		Thread cancelThread = new Thread(cancelTicket);
		
		bookThread.start();
		cancelThread.start();
		
		
	}
	
}
