package ru.spbstu.iamm.telematics.parprog.lecture3.internal;

public class ChessGame extends AbstractGame {

	public ChessGame(int turn) {
		super(turn);
	}

	@Override
	public int makeTurn() {
		return 0;
	}

	@Override
	protected void switchPlayer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean gameOvered() {
		// TODO Auto-generated method stub
		return false;
	}

}
