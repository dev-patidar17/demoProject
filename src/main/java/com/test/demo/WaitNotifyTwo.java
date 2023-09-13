package com.test.demo;

public class WaitNotifyTwo {
	
	int count =0;
	
	
	public void printEvenNumber() throws InterruptedException {
		
		synchronized (this) {
			while(count<=10) {
				 if(count%2 == 0) {
					 System.out.println("Even number "+count);
					 count++;
					 this.notify();
				 }else {
					 this.wait();
				 }
			}
		}
		
	}
	
	public void printOddNumber() throws InterruptedException {
		synchronized (this) {
			while(count<=10) {
				if(count % 2 != 0) {
					System.out.println("Odd number "+count);
					count++;
					this.notify();
				}else {
					this.wait();
				}
			}		
		}
	}
	
	public static void main(String[] args) {
		try {
			WaitNotifyTwo wn =	new WaitNotifyTwo();
			Thread t1 = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						wn.printEvenNumber();
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
						wn.printOddNumber();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			
			t1.start();
			t2.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
