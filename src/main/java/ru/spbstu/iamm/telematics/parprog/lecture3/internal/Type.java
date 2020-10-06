package ru.spbstu.iamm.telematics.parprog.lecture3.internal;

public interface Type {
	static final int TYPE_BOT = 1;
	static final int TYPE_HUMAN = 2;
	
	int getType();
}
