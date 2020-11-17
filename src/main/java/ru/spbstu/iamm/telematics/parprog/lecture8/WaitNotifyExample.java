package ru.spbstu.iamm.telematics.parprog.lecture8;

import java.util.Date;

public class WaitNotifyExample {
	
	static Object lock = new Object();
	
	static int val = 41;
	
	public static void main(String[] args) throws InterruptedException {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (!Thread.currentThread().isInterrupted()) {
					synchronized (lock) {
						val++;
						System.out.println("Going to wait " + new Date());
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("Woke up " + new Date());
					}
				}
			}
		}).start();
		
		while (!Thread.currentThread().isInterrupted()) {
			System.out.println("Main thread is just sleeping for one second");
			Thread.sleep(1000);
			
			System.out.println("Main thread read value " + val);
			
			synchronized (lock) {
				lock.notify();
				//lock.notifyAll();
			}
		}
		
	}
	
	void foo() throws InterruptedException {
		//calc
		
		// need some more info
		
		boolean calcReady = false;
		while (!calcReady ) {
			Thread.yield();
		}
		
	}
}
