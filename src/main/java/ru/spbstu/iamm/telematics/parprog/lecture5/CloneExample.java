package ru.spbstu.iamm.telematics.parprog.lecture5;

public class CloneExample {
	public static void main(String[] args) throws CloneNotSupportedException {
		ContainerObject o = new ContainerObject(1,.01, new ContainerObject(2,.2, null));
		System.out.println(o);
		foo();
		ContainerObject clone = (ContainerObject) o.clone();
		System.out.println();
		System.out.println(clone);
	}

	private static void foo() {
		System.out.println();
	}
}
