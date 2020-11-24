package ru.spbstu.iamm.telematics.parprog.lecture8;

public class InnerClasses {
	
	int a;
	
	class Inner {
		int b = a;
	}
	
	public static void main(String[] args) {
		//Inner i = new Inner();
		new InnerClasses().foor();
		InnerClasses ii = new InnerClasses();
		Inner iii = ii.new Inner();
	}

	private void foor() {
		Inner i = new Inner();
	}

}
