package ru.spbstu.iamm.telematics.parprog.lecture7;

import java.util.Random;

public class DeadLockExample {
	
	static Object lockA = new Object();
	static Object lockB = new Object();
	static int intA = 0; 
	static int intB = 0;
	
	private static final class BlockingThread implements Runnable {
		@Override
		public void run() {
			Random r = new Random();
			while (!Thread.currentThread().isInterrupted()) {
				boolean nextLock = r.nextBoolean();
				//Object l1 = nextLock ? lockA : lockB;
				//Object l2 = nextLock ? lockB : lockA;
				Object l1 = lockA;
				Object l2 = lockB;
				
				synchronized (l1) {
					synchronized (l2) {
						if (nextLock) {
							intA += intB;
						} else {
							intB += intA;
						}
						System.out.println(Thread.currentThread().getName() + " interated over");
					}
				}
				
			}
			
		}
	}

	public static void main(String[] args) {
		
		new Thread(new BlockingThread()).start();
		new Thread(new BlockingThread()).start();
		
	}
	
}
