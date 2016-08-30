package net.shadux.hex8.gui.graphics.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import net.shadux.hex8.HexEight;
import net.shadux.hex8.game.Entity;
import net.shadux.hex8.gui.graphics.Clickable;

public abstract class Button extends Entity implements Clickable {

	
	protected boolean mousedOver;
	
	public Button(double x, double y, double width, double height) {
		super(x, y, width, height);
		HexEight.gameMap.addClickable(this);
		mousedOver = false;
	}

	@Override
	public boolean mouseOver(Point p) {
		if(bounds.contains(p)) {
			mousedOver = true;
		} else {
			mousedOver = false;
		}
		mousedOver();
		return mousedOver;
	}

	@Override
	public boolean clicked(Point p) {
		if(bounds.contains(p)) {
			clicked();
			return true;
		}
		return false;
	}
	
	public abstract void clicked();
	public abstract void mousedOver();
}
