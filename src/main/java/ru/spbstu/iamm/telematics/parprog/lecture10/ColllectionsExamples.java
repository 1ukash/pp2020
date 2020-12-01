package ru.spbstu.iamm.telematics.parprog.lecture10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ColllectionsExamples {
	
	static List<Integer> sharedList = new LinkedList<>();
	static ReadWriteLock rwl = new ReentrantReadWriteLock();

	
	public static void main(String[] args) {
		//someExamples();
		
		generateWriterThread().start();
		for (int i = 0; i < 4; i++) {
			generateReaderThread().start();
		}
		
	}
	
	private static Thread generateReaderThread() {
		return new Thread(new Runnable() {
			Lock l = rwl.readLock();
			@Override
			public void run() {
				while (!Thread.currentThread().isInterrupted()) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					try {
						l.lock();
						StringBuilder b = new StringBuilder();
						b.append(Thread.currentThread().getName()).append(' ');
						for (Integer i: sharedList) {
							b.append(i).append(" ");
						}
						System.out.println(b);
					}
					finally {
						l.unlock();
					}
					
				}
			}
		});
	}
	
	private static Thread generateWriterThread() {
		return new Thread(new Runnable() {
			Lock l = rwl.writeLock();
			@Override
			public void run() {
				int i = 0;
				while (!Thread.currentThread().isInterrupted()) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					try {
						l.lock();
						sharedList.add(i++);
					}
					finally {
						l.unlock();
					}
					
				}
			}
		});
	}

	private static void someExamples() {
		Vector<Integer> v = new Vector<>();
		ArrayList<Integer> l = new ArrayList<>();
		
		//thread safe
		v.add(10);// one thread
		v.add(11); // another thread
		
		//not thread safe
		l.add(10);// one thread
		l.add(11); // another thread
		
		List<Integer> sl = Collections.synchronizedList(l);
		//thread safe
		sl.add(10);// one thread
		sl.add(11); // another thread
		
		
		//where synchronized collections don't work
		
		// check if some number exists in list
		int magicNumber = 42;
		boolean exists = true;
		for (Integer i: sl) {
			if (i == magicNumber) {
				exists = true;
				break;
			}
		}
		//if (!exists) {
		if (sl.contains(magicNumber)) {
			sl.add(magicNumber);
		}
		
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		
		for(Integer i: l) {
			if (i == 3) {
				l.add(5);
			}
		}
	}
	
}
