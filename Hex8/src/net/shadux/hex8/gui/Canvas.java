package net.shadux.hex8.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;


import javax.swing.JPanel;

public class Canvas extends JPanel {

	private BufferedImage bufferedImage;
	private Graphics2D g2d;
	
	public Canvas(int width, int height) {
		bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		g2d = bufferedImage.createGraphics();
		
	}
	
	public Graphics2D getGraphics() {
		return g2d;
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(bufferedImage, 0, 0, this);
		g2d.setColor(Color.white); //sets background color
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //Turns on antialiasing
		g2d.fillRect(0, 0, getWidth(), getHeight());
		
	}
}
