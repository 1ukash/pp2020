package ru.spbstu.iamm.telematics.parprog.lecture9;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockBlockingQueue<T> {
	
	private final LinkedList<T> data = new LinkedList<>();
	private final int size;
	
	private Lock lock = new ReentrantLock();
	private Condition c = lock.newCondition();
	
	// from C world
	// mutex_t lock
	// from one thread:
	// lock(lock) -- first time
	// lock(lock) -- second time
	
	public LockBlockingQueue(int size) {
		super();
		this.size = size;
	}
	
	public void put(T obj) {
		
		try {
			
			while(!lock.tryLock()) {
				Thread.yield();
			}
			
			while (data.size() == size) {
				try {
					c.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			data.add(obj);
			c.signal();
		} finally {
			lock.unlock();
		}
		
	}
	
	public T get() {
		T obj = null;
		
		try {
			lock.lock();
			while(data.isEmpty()) {
				try {
					c.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			obj = data.removeFirst();
			c.signal();
		} finally {
			lock.unlock();
		}
		
		return obj;
	}
	
	@Override
	public String toString() {
		return "Queue state " + data;
	}
	
	
	
}
