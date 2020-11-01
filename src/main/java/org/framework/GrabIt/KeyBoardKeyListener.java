package org.framework.GrabIt;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardKeyListener implements KeyListener{

	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode()==KeyEvent.VK_A) {
			System.out.println("Key Pressed");
		}
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String args[])
	{
		
	}
}
