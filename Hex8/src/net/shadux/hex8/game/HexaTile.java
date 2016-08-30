package net.shadux.hex8.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import net.shadux.hex8.gui.graphics.Drawable;
import net.shadux.hex8.gui.graphics.DrawableHexagon;

public class HexaTile extends DrawableHexagon {

	private boolean mousedOver;
	private Color hexColor;
	private boolean clicked;
	
	
	
	public HexaTile(double x, double y, double width) {
		super(x, y, width);
		mousedOver = false;
		hexColor = Color.black;
		clicked = false;
	}

	@Override
	public boolean clicked(Point p) {
		if(hexagon.contains(p)) {
			clicked = true;
			return true;
		}
		return false;
	}

	public boolean getMousedOver() {
		return mousedOver;
	}
	
	@Override
	public boolean mouseOver(Point p) {
		if(hexagon.contains(p)) {
			mousedOver = true;
		} else {
			mousedOver = false;
		}
		return mousedOver;
	}

	public void draw(Graphics2D g) {
		if(mousedOver && !clicked) {
			hexColor = Color.red;
		} else if (!mousedOver){
			hexColor = Color.black;
		} else if(clicked) {
			hexColor = Color.orange;
		}
		
		g.setColor(hexColor);
		super.draw(g);
	}

	@Override
	public void doTick() { }
}
