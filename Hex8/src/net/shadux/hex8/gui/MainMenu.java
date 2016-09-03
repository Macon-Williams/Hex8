package net.shadux.hex8.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

import net.shadux.hex8.HexEight;
import net.shadux.hex8.gui.graphics.game.GameState;


public class MainMenu extends JFrame implements MouseListener, MouseMotionListener {
	
	public MainMenu(int width, int height) {
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(false);
		addMouseListener(this);
		setVisible(true);
	}
	
	public void play() {
		HexEight.GAMESTATE = GameState.RUNNING;
		this.dispose();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Point p = e.getPoint();
		
	}
}