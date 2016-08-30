package net.shadux.hex8.game;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class Entity extends Sprite {

	protected double xvel;
	protected double yvel;
	protected double width;
	protected double height;
	
	protected Rectangle bounds;
	
	public Entity(double x, double y, double width, double height) {
		super(x, y);
		this.xvel = 0;
		this.yvel = 0;
		this.width = width;
		this.height = height;
		updateBounds();
	}

	protected void updateBounds() {
		this.bounds = new Rectangle((int)x, (int)y, (int)width, (int)height);
	}
	
	@Override
	public void fill(Graphics2D g2d) { draw(g2d); }

	@Override
	public void doTick() {
		x += xvel;
		y += yvel;
		updateBounds();
	}

}
