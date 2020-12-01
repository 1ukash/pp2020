package ru.spbstu.iamm.telematics.parprog.lecture10;

public class TimeMeasure {
	
	public static void main(String[] args) {
		long t = System.currentTimeMillis();
		// do some stuff
		System.out.println("execution time " + (System.currentTimeMillis() - t));
	}

}
