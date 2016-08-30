package net.shadux.hex8.gui.graphics;

import net.shadux.hex8.game.Sprite;

public abstract class DrawableShape extends Sprite implements Drawable {

	public DrawableShape(double x, double y, double width, double height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	protected double width;
	protected double height;
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getWidth() {
		return width;
	}
}
