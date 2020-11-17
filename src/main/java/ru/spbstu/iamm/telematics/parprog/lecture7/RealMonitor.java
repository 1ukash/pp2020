package ru.spbstu.iamm.telematics.parprog.lecture7;

public class RealMonitor {
	
	private int state;
	private boolean safe;
	
	public synchronized int getState() {
		return state;
	}
	public synchronized void setState(int state) {
		this.state = state;
	}
	public synchronized boolean isSafe() {
		return safe;
	}
	public synchronized void setSafe(boolean safe) {
		this.safe = safe;
	}
}
