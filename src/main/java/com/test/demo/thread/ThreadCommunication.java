package com.test.demo.thread;

class Producer implements Runnable {

	StringBuffer sb;

	Producer() {
		sb = new StringBuffer();
	}

	@Override
	public void run() {

		synchronized (sb) {

			for (int i = 0; i < 10; i++) {

				sb.append(i + ":");
				System.out.println("appending");
			}
			sb.notifyAll();

		}
	}

}

class Consumer implements Runnable {

	Producer producer;

	Consumer(Producer producer) {
		this.producer = producer;
	}

	@Override
	public void run() {

		synchronized (producer.sb) {

			try {
				System.out.println("In waiting...!");
				producer.sb.wait();
				System.out.println("By Consumer First: "+producer.sb.toString().substring(0, producer.sb.toString().length()-1));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}

class ConsumerSecond implements Runnable {

	Producer producer;

	ConsumerSecond(Producer producer) {
		this.producer = producer;
	}

	@Override
	public void run() {

		synchronized (producer.sb) {

			try {
				System.out.println("In waiting...!");
				producer.sb.wait();
				//Thread.dumpStack();
				System.out.println("By Consumer Second: "+producer.sb.toString().substring(0, producer.sb.toString().length()-1));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}

public class ThreadCommunication {

	public static void main(String[] args) {

		Producer producer = new Producer();

		Consumer consumer = new Consumer(producer);
		ConsumerSecond consumerSecond = new ConsumerSecond(producer);
		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(consumer);
		Thread t3 = new Thread(consumerSecond);

		t3.start();
		t2.start();
		
		t1.start();

	}

}
