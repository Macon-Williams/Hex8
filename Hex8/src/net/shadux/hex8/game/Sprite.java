package net.shadux.hex8.game;

import java.awt.Point;

import net.shadux.hex8.gui.graphics.Drawable;

public abstract class Sprite implements Drawable {

	protected double x;
	protected double y;
	protected boolean alive;
	
	public Sprite(double x, double y) {
		this.x = x;
		this.y = y;
		this.alive = true;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void setLocation(Point p) {
		this.x = p.x;
		this.y = p.y;
	}
	
	public void setLocation(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public boolean getAlive() {
		return alive;
	}
	
	public void kill() {
		alive = false;
	}
	
	public abstract void doTick();
}
