package ru.spbstu.iamm.telematics.parprog.lecture3;

//import ru.spbstu.iamm.telematics.parprog.lecture3.internal.AbstractGame.Board;
import ru.spbstu.iamm.telematics.parprog.lecture3.internal.AbstractGame.TurnInfo;
import ru.spbstu.iamm.telematics.parprog.lecture3.internal.ChessGame;

class Foo3 {
	
	private int aField;
	private TurnInfo f = new TurnInfo();
	private ChessGame game = new ChessGame(10);

	public Foo3(int aField) {
		super();
		this.aField = aField;
		//Board b = game.new Board();
	}

	public int getaField() {
		return aField;
	}

	public void setaField(int aField) {
		this.aField = aField;
	}
	
	
}
