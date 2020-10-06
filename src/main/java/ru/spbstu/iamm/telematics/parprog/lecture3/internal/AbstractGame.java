package ru.spbstu.iamm.telematics.parprog.lecture3.internal;

public abstract class AbstractGame {
	
	private class Board {
		private int [][]field;
		
		int[][] getField() {
			return field;
		}
		
		void mutate() {
			turn ++;
		}
	}
	
	public static class TurnInfo {
		void foo() {
			
		}
	}
	
	private int turn = 0;

	public AbstractGame(int turn) {
		super();
		this.turn = turn;
		Board b = new Board();
	}
	
	public AbstractGame() {
		// TODO Auto-generated constructor stub
	}

	public void startGame() {
		while(!gameOvered()) {
			switchPlayer();
			makeTurn();
		}
	}
	
	protected abstract void switchPlayer();

	protected abstract boolean gameOvered();

	public abstract int makeTurn();
	
	private void veryLongMethod() {
		class Point {
			int x, y;
		}
		
		Point p = new Point();
		
	}
}
