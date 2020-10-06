package ru.spbstu.iamm.telematics.parprog.lecture3;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import ru.spbstu.iamm.telematics.parprog.lecture3.internal.AbstractGame;
import ru.spbstu.iamm.telematics.parprog.lecture3.internal.Color;

public class AnonymousObject {
	private static final class MyMouseHandler implements MouseListener {
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}

	private static Color color;

	public static void main(String[] args) {
		
		AbstractGame checkers = new AbstractGame() {

			@Override
			protected void switchPlayer() {
				// TODO Auto-generated method stub
				
			}

			@Override
			protected boolean gameOvered() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public int makeTurn() {
				// TODO Auto-generated method stub
				return 0;
			}
			
		};
		
		setColor(new Color() {
			@Override
			public int getColor() {
				return WHITE;
			}
		});
		
		JButton b = new JButton();
		b.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		b.addMouseListener(new MyMouseHandler());
		
	}
	
	static void setColor(Color c) {
		color = c;
	}
}
