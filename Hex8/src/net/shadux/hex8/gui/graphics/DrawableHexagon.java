package net.shadux.hex8.gui.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Stroke;

public abstract class DrawableHexagon extends DrawableShape implements Clickable {

	protected Polygon hexagon;
	
	public DrawableHexagon(double x, double y, double width) {
		super(x, y, width, width);
		hexagon = new Polygon();
		resetCoords();
	}
	
	public void setHeight(double height) {
		super.setHeight(height);
		resetCoords();
	}
	
	public void setWidth(double width) {
		super.setWidth(width);
		resetCoords();
	}
	
	public void setX(double x) {
		super.setX(x);
		resetCoords();
	}
	
	public void setY(double y) {
		super.setY(y);
		resetCoords();
	}
	protected void resetCoords() {
		double[] xcoords = new double[6];
		xcoords[0] = x-width;
		xcoords[1] = x-Math.cos(Math.toRadians(60))*width;
		xcoords[2] = x+Math.cos(Math.toRadians(60))*width;
		xcoords[3] = x+width;
		xcoords[4] = x+Math.cos(Math.toRadians(60))*width;
		xcoords[5] = x-Math.cos(Math.toRadians(60))*width;
		
		double[] ycoords = new double[6];
		ycoords[0] = y;
		ycoords[1] = y-Math.sin(Math.toRadians(60))*width;
		ycoords[2] = y-Math.sin(Math.toRadians(60))*width;
		ycoords[3] = y;
		ycoords[4] = y+Math.sin(Math.toRadians(60))*width;
		ycoords[5] = y+Math.sin(Math.toRadians(60))*width;
		
		for(int i = 0;i<6;i++) {
			hexagon.addPoint((int)xcoords[i], (int)ycoords[i]);
		}
	}

	public static double getXTileFactor(double length) {
		return length*3;
	}
	
	public static double getYTileFactor(double length) {
		return getSinSize()*length;
	}
	
	public static double getXTileOffset(double length) {
		return length*3/2;
	}
	
	public static double getYTileOffset(double length) {
		return 0;
	}
	
	public static double getSinSize() {
		return Math.sin(Math.toRadians(60));
	}
	
	public static double getCosSize() {
		return Math.cos(Math.toRadians(60));
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.setStroke(new BasicStroke(5));
		g2d.drawPolygon(hexagon.xpoints, hexagon.ypoints, 6);
	}
	
	public void fill(Graphics2D g2d) {
		g2d.fillPolygon(hexagon.xpoints, hexagon.ypoints, 6);
	}

}
