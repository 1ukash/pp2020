package ru.spbstu.iamm.telematics.parprog.lecture3.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class EntryPoint {
	public static void main(String[] args) {
		//noMemory();
		//NPE();
		
//		checkedException();
		try {
			longOperationRoutine();
		} catch (ICannotDoItAnymoreException e) {
			System.out.println("He cannot do it anymore!");
		}
		
	}

	private static void longOperationRoutine() throws ICannotDoItAnymoreException {
		Random r = new Random();
		for (int i = 0; i < 4; i ++) {
			int val = r.nextInt();
			if (val > 650000) {
				throw new ICannotDoItAnymoreException();
			}
		}
	}

	private static void checkedException() {
		try {
			FileInputStream fis = new FileInputStream(new File("/tmp/input"));
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("Provide another file");
		}
	}

	private static void NPE() {
		Object x = null;
		try {
			x.toString();
		} catch (NullPointerException e) {
			e.printStackTrace();
			x = new Object();
			System.out.println(x.toString());
		}
	}

	private static void noMemory() {
		int[] arr;
		try {
			arr = new int[1000000000];
		} catch (Throwable e) {
			e.printStackTrace();
			// give another try
			//arr = new int[1000000000];
			//will never happen
		}
	}
}
