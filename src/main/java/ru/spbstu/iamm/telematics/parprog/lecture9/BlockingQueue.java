package ru.spbstu.iamm.telematics.parprog.lecture9;

import java.util.LinkedList;

public class BlockingQueue<T> {
	private final LinkedList<T> data = new LinkedList<>();
	private final int size;
	
	public BlockingQueue(int size) {
		super();
		this.size = size;
	}
	
	public void put(T obj) {
		
		synchronized(this) {
			while (data.size() == size) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			data.add(obj);
			notify();
		}
		
	}
	
	public T get() {
		T obj = null;
		
		synchronized (this) {
			while(data.isEmpty()) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			obj = data.removeFirst();
			notify();
		}
		
		return obj;
	}
	
	@Override
	public String toString() {
		return "Queue state " + data;
	}
	
	
	
}
