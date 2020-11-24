package ru.spbstu.iamm.telematics.parprog.lecture9;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreExample {
	
	static Lock l = new ReentrantLock();
	static Semaphore t = new Semaphore(1);
	
	public static void main(String[] args) {
		
		int data = 0;
		
		try {
			l.lock();
			data ++;
		} finally {
			l.unlock();
		}
		
		try {
			t.acquire();
			//....
			//... //some another thread calls t.release() then another 
					//thread may enter this section
			//...
			data ++;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			t.release();
		}
		
		System.out.println(data);
		
	}
	

}
