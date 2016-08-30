package net.shadux.hex8.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JPanel;

import net.shadux.hex8.HexEight;
import net.shadux.hex8.gui.graphics.DrawableHexagon;
import net.shadux.hex8.gui.graphics.game.GameMap;

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
		
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		
		g2d.setColor(Color.black);
		
	}
}
