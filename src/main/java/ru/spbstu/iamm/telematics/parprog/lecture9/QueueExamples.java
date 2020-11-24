package ru.spbstu.iamm.telematics.parprog.lecture9;

import java.util.Date;
import java.util.Random;

public class QueueExamples {
	public static void main(String[] args) {
		
		final BlockingQueue<Integer> queue = new BlockingQueue<>(4);
		
		// Writer
		new Thread(new Runnable() {
			Random r = new Random();
			
			@Override
			public void run() {
				while (!Thread.currentThread().isInterrupted()) {
					int num = r.nextInt(100);
					queue.put(num);
					System.out.println(Thread.currentThread().getName() + " wrote num " + num + " at " + new Date() + ", state " + queue);
					try {
						Thread.sleep(400 + r.nextInt(500));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			}
			
		}).start();
		
		//Reader
		new Thread(new Runnable() {
			Random r = new Random();
			
			@Override
			public void run() {
				while (!Thread.currentThread().isInterrupted()) {
					int num = queue.get();
					System.out.println(Thread.currentThread().getName() + " read num " + num + " at " + new Date()+ ", state " + queue);
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
