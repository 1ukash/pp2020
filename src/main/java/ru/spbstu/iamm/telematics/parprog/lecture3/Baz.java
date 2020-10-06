package ru.spbstu.iamm.telematics.parprog.lecture3;

import ru.spbstu.iamm.telematics.parprog.lecture3.internal.AbstractGame;
import ru.spbstu.iamm.telematics.parprog.lecture3.internal.ChessGame;
import ru.spbstu.iamm.telematics.parprog.lecture3.internal.SuperFoo;

//import ru.spbstu.iamm.telematics.parprog.lecture3.internal.FooInternal;

public class Baz extends SuperFoo {
	
	public Baz(int someVal, int anotherVal) {
		super(someVal, anotherVal);
	}

	public static void main(String[] args) {
		Foo3 f = new Foo3(10);
		
		Baz baz = new Baz(10, 10);
		SuperFoo f1 = new SuperFoo(10, 10);
		SuperFoo f2 = new Baz(10,10);
		
		int x1 = baz.getPrivateVal();
		int x2 = f1.getPrivateVal();
		int x3 = f2.getPrivateVal();
		
		baz.bar();
		// causes error 
		//FooInternal f2 = new FooInternal(1);
		
		AbstractGame game = new ChessGame(1);
		ChessGame game2 = new ChessGame(1);
		//AbstractGame game3 = new AbstractGame(1);
		
	}

	private void bar() {
		int v = publicMorozoff();
	}

	@Override
	public int publicMorozoff() {
		return super.publicMorozoff();
	}

	@Override
	public int getPrivateVal() {
		return super.getPrivateVal() + 1;
	}

}
