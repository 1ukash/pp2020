package ru.spbstu.iamm.telematics.parprog.lecture3.internal;

public class SuperFoo {
	
	private int someVal;
	protected int anotherVal;

	public SuperFoo(int someVal, int anotherVal) {
		super();
		this.someVal = someVal;
		this.anotherVal = anotherVal;
	}
	
	protected int publicMorozoff() {
		return anotherVal;
	}
	
	public int getPrivateVal() {
		return someVal;
	}

}
