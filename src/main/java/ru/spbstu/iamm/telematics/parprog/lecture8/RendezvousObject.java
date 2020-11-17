package ru.spbstu.iamm.telematics.parprog.lecture8;

public class RendezvousObject {
	
	private Integer inputParam = null;
	private Integer outputResult = null;
	private int iter = 0;
	
	//for Thread 1
	public int getResult(int inputParam) {
		
		this.inputParam = inputParam;
		
		synchronized(this) {
			notify();
		}
		
		System.out.println(iter + ": " + "Thread " + Thread.currentThread().getName() + " is submitted input" + inputParam);
		synchronized(this) {
			while(outputResult == null) {
				try {
					System.out.println(iter + ": " + "Thread " + Thread.currentThread().getName() + " is going to wait for calculation");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(iter + ": " + "Thread " + Thread.currentThread().getName() + " woke up and returning outputResult " + outputResult);
		
		int result = outputResult;
		outputResult = null;
		iter++;
		return result;
	}
	
	// for Thread 2
	public void calculateResult(int data) {
		
		synchronized (this) {
			while (inputParam == null) {
				try {
					System.out.println(iter + ": " + "Thread " + Thread.currentThread().getName() + " going to wait for inputParam");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		outputResult = inputParam * data;
		inputParam = null;
		
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println(iter + ": " + "Thread " + Thread.currentThread().getName() + " woke up and calculated result=" + outputResult);
		synchronized(this) {
			notify();
		}
	}

}
