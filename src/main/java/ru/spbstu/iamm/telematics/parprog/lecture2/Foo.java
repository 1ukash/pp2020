package ru.spbstu.iamm.telematics.parprog.lecture2;

public class Foo {
	
	private static String name;

	static void initName() {
		name  = "Bar";
	}
	
	public static void main(String[] args) {
		
		if (name == null) {
			initName();
		}
		
		Baz bzz = new Baz(1, "Ivan");
		String n = bzz.getName();
		System.out.println(n);
		
		System.out.println("Hello again " + name);
	}

}
