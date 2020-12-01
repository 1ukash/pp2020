package ru.spbstu.iamm.telematics.parprog.lecture10;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

public class AtomicsExamples {
	
	AtomicInteger val = new AtomicInteger(1);
	int plainVal = 1;
	ThreadLocal<Integer> loc = new ThreadLocal<>();
	
	public static void main(String[] args) {
		new AtomicsExamples().go();
	}
	
	private void go() {
		for (int i = 0; i < 4; i++) {
			generateThread().start();
		}
	}

	private Thread generateThread() {
		return new Thread(new Runnable() {
			@Override
			public void run() {
				while (!Thread.currentThread().isInterrupted()) {
					//synchronized(AtomicsExamples.this) {
					//	plainVal ++;
					//}
					if (loc.get() == null) {
						int incremented = val.incrementAndGet();
						loc.set(incremented);
					} else {
						System.out.println("My unique var is: " + loc.get());
					}
					
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			}
		});
	}

}
