package net.shadux.hex8.gui.graphics.game.menu;

import java.awt.Color;
import java.awt.Graphics2D;

import net.shadux.hex8.HexEight;
import net.shadux.hex8.gui.graphics.game.Button;
import net.shadux.hex8.gui.graphics.game.GameState;

public class CloseButton extends Button {

	private Color color1;
	private Color color2;
	
	public static final int WIDTH = 60;
	public static final int HEIGHT = 40;
	
	
	public CloseButton(double x, double y) {
		super(x, y, WIDTH, HEIGHT);
		color1 = Color.red;
		color2 = Color.black;
	}

	@Override
	public void clicked() {
		HexEight.setGameState(GameState.STOPPING);
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(color1);
		g2d.fill(bounds);
		g2d.setColor(color2);
		g2d.draw(bounds);
		g2d.drawLine((int)(x + width/4), (int)(y + height/8), (int)(x+width*3/4), (int)(y+height*7/8));
		g2d.drawLine((int)(x+width/4), (int)(y+height*7/8), (int)(x+width*3/4), (int)(y+height/8));
		
	}

	@Override
	public void mousedOver() {
		if(mousedOver) {
			color1 = Color.black;
			color2 = Color.red;
		} else {
			color1 = Color.red;
			color2 = Color.black;
		}
	}

}
