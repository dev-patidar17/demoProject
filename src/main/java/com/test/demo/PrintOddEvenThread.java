package com.test.demo;

public class PrintOddEvenThread {
	
	int counter = 0;
	
	
	public void printOddNumbe() throws InterruptedException {
		
		synchronized (this) {
			
			while(counter<=10) {
				
				if(counter%2 != 0) {
					
					System.out.print(" "+counter);
					counter++;
					this.notify();
				}else {
					this.wait();
				}
			}
		}
	}
	
	public void printEvenNumber() throws InterruptedException {
		
		synchronized (this) {
			while(counter<=10) {
				
				if(counter%2 ==0) {
					System.out.print(" "+counter);
					counter++;
					this.notify();
				}else {
					this.wait();
				}
				
			}
			
		}
	}

	public static void main(String[] args) {
		
		PrintOddEvenThread pde = new PrintOddEvenThread();
		
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				try {
					pde.printEvenNumber();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {

			try {
				pde.printOddNumbe();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			}
		});
		
		t1.start();
		t2.start();

		
	}

}
