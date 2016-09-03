package net.shadux.hex8.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;


public class MainMenu extends JFrame implements MouseListener, MouseMotionListener {
	
	private Image background;
	public MainMenu(int width, int height) {
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(false);
		addMouseListener(this);
		addMouseMotionListener(this);
		setVisible(true);
		
		background = Toolkit.getDefaultToolkit().createImage("background.png");
	}
	
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
	
	
	
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
}