package ru.spbstu.iamm.telematics.parprog.lecture7;

public class VisibilityProblem {
	
	static int someVal = 0;
	
	public static void main(String[] args) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (!Thread.currentThread().isInterrupted()) {
					System.out.println("Read " + someVal);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}).start();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (!Thread.currentThread().isInterrupted()) {
					System.out.println("Write " + ++someVal);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}).start();
	}

}
