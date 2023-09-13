package com.test.demo.thread;

public class Reserve implements Runnable {
	
	int available =1;
	int wanted;
	
	public Reserve(int wanted) {
		this.wanted = wanted;
	}

	@Override
	public void run() {
		
		synchronized (this) {
			if(available>= wanted) {
				
				System.out.println("Ticket is booked for "+Thread.currentThread().getName());
				
				try {
					Thread.sleep(1500);
					
					available =  available - wanted;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}else {
				System.out.println("No seat available...!");
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		Reserve r1 = new Reserve(1);
		Thread t1 = new Thread(r1);
		t1.setName("First Person");
		
		Thread t2 = new Thread(r1);
		
		t2.setName("Second Person");
		
		
		t1.start();
		t2.start();
		
		
		
		
		
		
		
	}
	
	

}
