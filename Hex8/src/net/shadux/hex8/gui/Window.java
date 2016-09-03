package net.shadux.hex8.gui;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


import javax.swing.JFrame;


import net.shadux.hex8.HexEight;

@SuppressWarnings("serial")
public class Window extends JFrame implements MouseListener, MouseMotionListener {

	private Canvas canvas;
	
	public Window(int width, int height) {
		
		canvas = new Canvas(width, height);
		add(canvas);
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(false); //Game blends better with OS with this set to false
		setResizable(false);
		addMouseListener(this);
		addMouseMotionListener(this);
		setVisible(true);
	}

	public Canvas getCanvas() {
		return canvas;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Point p = e.getPoint();
		HexEight.gameMap.checkClick(p);
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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Point p = e.getPoint();
		HexEight.gameMap.checkMouseOver(p);
	}
	
	
}
