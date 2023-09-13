package com.test.demo;

public class WaitNotify {
	
	int counter = 0;
	
	public void printEvenNumber() throws InterruptedException {
		synchronized (this) {
			while(counter <=10) {
				
				if(counter%2 == 0) {
					System.out.println("even no. :-"+counter);
					counter++;
					this.notify();
				}else {
					this.wait();
				}
			}
			
		}
	}
	
	public void printOddNumber() throws InterruptedException {
		
		synchronized (this) {
			while(counter <=10) {
				
				if(counter%2 != 0) {
					
					System.out.println("odd number :- "+counter);
					counter++;
					this.notify();
				}else {
					this.wait();
				}
				
			}
		}
		
	}

	public static void main(String[] args) {

		WaitNotify wn = new WaitNotify();
				
				Thread t1 = new Thread(new Runnable() {
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

	}

}
