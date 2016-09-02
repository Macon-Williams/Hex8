package net.shadux.hex8.gui.graphics.game;

import java.awt.Point;


import net.shadux.hex8.HexEight;
import net.shadux.hex8.game.Entity;
import net.shadux.hex8.gui.graphics.Clickable;

public abstract class Button extends Entity implements Clickable {

	
	protected boolean mousedOver;
	protected boolean clicked;
	
	public Button(double x, double y, double width, double height) {
		super(x, y, width, height);
		HexEight.gameMap.addClickable(this);
		mousedOver = false;
		clicked = false;
	}

	@Override
	public boolean mouseOver(Point p) {
		if(bounds.contains(p)) {
			mousedOver = true;
		} else {
			mousedOver = false;
		}
		
		return mousedOver;
	}

	@Override
	public boolean clicked(Point p) {
		if(bounds.contains(p)) {
			clicked = true;
		} else {
			clicked = false;
		}
		
		return clicked;
	}
	
}
