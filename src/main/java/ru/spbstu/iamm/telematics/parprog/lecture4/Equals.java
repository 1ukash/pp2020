package ru.spbstu.iamm.telematics.parprog.lecture4;

public class Equals {
	
	public static void main(String[] args) {
		PojoObj o1, o2, o3, o4;
		o1 = new PojoObj(1, "X");
		o2 = new PojoObj(2, "Y");
		o3 = o1;
		o4 = new PojoObj(2, "Y");
		
		printInfo(o1);
		printInfo(o2);
		printInfo(o3);
		
		compareAndPrint(o1, o2);
		compareAndPrint(o1, o3);
		compareAndPrint(o2, o4);
	}

	private static void compareAndPrint(PojoObj o1, PojoObj o2) {
		if (o1.equals(o2)) {
			System.out.println("1 eq 2");
		} else {
			System.out.println("1 not eq 2");
		}
		if (o1 == o2) {
			System.out.println("1 = 2");
		} else {
			System.out.println("1 != 2");
		}
	}

	private static void printInfo(PojoObj o) {
		System.out.println("pojo info "+ o + " " + o.hashCode());
	}

}
