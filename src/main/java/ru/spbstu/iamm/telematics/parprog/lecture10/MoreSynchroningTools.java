package ru.spbstu.iamm.telematics.parprog.lecture10;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MoreSynchroningTools {

	static CyclicBarrier barrier = new CyclicBarrier(4);
	static final Random r = new Random();
	static CountDownLatch l = new CountDownLatch(4);
	
	public static void main(String[] args) {
		countDownExample();
	}

	private static void barrierExample() {
		for (int i = 0; i < 4; i++) {
			Thread t = generateBarrierThread();
			t.start();
		}		
	}
	
	private static void countDownExample() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					l.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(new Date() + "Thread " + Thread.currentThread().getName() + " done some important operation");
			} 
		
		}).start();
		for (int i = 0; i < 4; i++) {
			Thread t = generateCountDownThread();
			t.start();
		}		
	}

	private static Thread generateCountDownThread() {
		return new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (!Thread.currentThread().isInterrupted()) {
					long time = r.nextInt(4000) + 1000;
					try {
						Thread.sleep(time);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(new Date() + "Thread " + Thread.currentThread().getName() + " is completed important operation");
					l.countDown();
				}
			}
		});
	}
	
	private static Thread generateBarrierThread() {
		return new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (!Thread.currentThread().isInterrupted()) {
					long time = r.nextInt(4000) + 1000;
					try {
						Thread.sleep(time);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(new Date() + "Thread " + Thread.currentThread().getName() + " is reached barrier");
					try {
						barrier.await();
					} catch (InterruptedException | BrokenBarrierException e) {
						e.printStackTrace();
					}
					System.out.println(new Date() + "Thread " + Thread.currentThread().getName() + " is left barrier");
					
				}
			}
		});
	}
	
}
