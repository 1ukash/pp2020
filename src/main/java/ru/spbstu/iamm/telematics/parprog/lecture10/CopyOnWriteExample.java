package ru.spbstu.iamm.telematics.parprog.lecture10;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CopyOnWriteExample {

	static CopyOnWriteArrayList<Integer> sharedList = new CopyOnWriteArrayList<>();
	
	public static void main(String[] args) {
		//someExamples();
		
		generateWriterThread().start();
		for (int i = 0; i < 4; i++) {
			generateReaderThread().start();
		}
		
	}
	
	private static Thread generateReaderThread() {
		return new Thread(new Runnable() {
			@Override
			public void run() {
				while (!Thread.currentThread().isInterrupted()) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					StringBuilder b = new StringBuilder();
					b.append(Thread.currentThread().getName()).append(' ');
					for (Integer i: sharedList) {
						b.append(i).append(" ");
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println(b);
					
				}
			}
		});
	}
	
	private static Thread generateWriterThread() {
		return new Thread(new Runnable() {
			@Override
			public void run() {
				int i = 0;
				while (!Thread.currentThread().isInterrupted()) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					sharedList.add(i++);
				}
			}
		});
	}
	
}
