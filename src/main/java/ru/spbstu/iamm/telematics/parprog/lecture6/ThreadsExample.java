package ru.spbstu.iamm.telematics.parprog.lecture6;

public class ThreadsExample {
	public static void main(String[] args) throws InterruptedException {
		
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				String myName = Thread.currentThread().getName();
				for (int i = 0; i < 10; i++) {
					System.out.println("Hello from " + myName + ", i=" + i);
				}
				int j = 0;
				while (!Thread.currentThread().isInterrupted()) {
					System.out.println("Hello forever! from " + myName + ", i=" + j++);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
						Thread.currentThread().interrupt();
					}
					
				}
				System.out.println("This thread is completed correctly");
				
 			}
			
		});
		
		t.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Just started a thread");
		
		t.interrupt();
		
		t.join();
		System.out.println("I was waiting when my new thread completes");
		
	}
}
