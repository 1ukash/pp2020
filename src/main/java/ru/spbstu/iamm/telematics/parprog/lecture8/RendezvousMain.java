package ru.spbstu.iamm.telematics.parprog.lecture8;

public class RendezvousMain {
	
	public static void main(String[] args) {
		final RendezvousObject rndv = new RendezvousObject();
		
		new Thread(new Runnable() {
			int cnt = 1;
			@Override
			public void run() {
				while (!Thread.currentThread().isInterrupted()) {
					int result = rndv.getResult(cnt ++);
					//System.out.println("Thread " + Thread.currentThread().getName() + " recieved calculated value " + result);
				}
			}
			
		}).start();
		
		new Thread(new Runnable() {

			int data = 1000;
			@Override
			public void run() {
				while (!Thread.currentThread().isInterrupted()) {
					//System.out.println("Thread " + Thread.currentThread().getName() + " calculates with data=" + data);
					rndv.calculateResult(data--);
				}
			}
			
		}).start();
	}
	
	
	
}
