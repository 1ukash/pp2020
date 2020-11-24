package ru.spbstu.iamm.telematics.parprog.lecture9;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadersAndWriters {
	
	private static Integer data = 0;
	private static ReadWriteLock lock = new ReentrantReadWriteLock();
	
	public static void main(String[] args) {
		// Writer
		for (int i = 0; i < 1; i++)
			new Thread(new Runnable() {
				Random r = new Random();
				Lock write = lock.writeLock();
	
				@Override
				public void run() {
					while (!Thread.currentThread().isInterrupted()) {
						int writeNum = r.nextInt(100);
						try {
							write.lock();
							System.out.println(Thread.currentThread().getName() + " starting writing at " + new Date());
							
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							data = writeNum;
						} finally {
							write.unlock();
						}
						
						System.out.println(Thread.currentThread().getName() + " writes num " + writeNum + " at " + new Date());
						
						try {
							Thread.sleep(500 + r.nextInt(5000));
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}
				}
	
			}).start();

		//Reader
		for (int i = 0; i < 8; i++)
			new Thread(new Runnable() {
				
				Lock read = lock.readLock();
				Random r = new Random();
	
				@Override
				public void run() {
					while (!Thread.currentThread().isInterrupted()) {
						int readNum;
						try {
							read.lock();
							readNum = data;
						} finally {
							read.unlock();
						}
						
						System.out.println(Thread.currentThread().getName() + " reads num " + readNum + " at " + new Date());
						
						try {
							Thread.sleep(500 + r.nextInt(500));
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
	
			}).start();		
	}


}
