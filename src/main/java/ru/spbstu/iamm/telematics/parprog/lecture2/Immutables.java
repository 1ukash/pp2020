package ru.spbstu.iamm.telematics.parprog.lecture2;

public class Immutables {
	public static void main(String[] args) {
		
		String test1 = "it is a test";
		String oldTest = test1;
		
		test1 = test1 + " with a some addition";
		
		System.out.println(test1 == oldTest);
		
		checkEqualStrings(oldTest);
		checkEqualNumbers();
	}

	private static void checkEqualNumbers() {
		int a = 10;
		Integer anA = 10;
		
		System.out.println(a == anA);
		
		Integer val1 = 100;
		Integer val2 = 100;
		
		System.out.println(val1 == val2);
		
		val1 = 1000;
		val2 = 1000;
		System.out.println(val1 == val2);
	}

	private static void checkEqualStrings(String oldTest) {
		
		System.out.println("it is a test".equals(oldTest));
		
	}
}
