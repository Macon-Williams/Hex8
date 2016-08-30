package net.shadux.hex8.game.entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import net.shadux.hex8.HexEight;
import net.shadux.hex8.game.Entity;
import net.shadux.hex8.game.HexaTile;
import net.shadux.hex8.gui.graphics.Clickable;
import net.shadux.hex8.gui.graphics.game.EventHook;

public class Triangle extends Entity implements EventHook {

	public static final int WIDTH = 20;
	public static final int HEIGHT = 20;
	
	public Triangle() {
		super(0, 0, WIDTH, HEIGHT);
		HexEight.gameMap.addEventHook(this);
	}

	@Override
	public void draw(Graphics2D g2d) {
		double a = width*Math.sin(Math.toRadians(60));
		g2d.drawLine((int)x, (int)(y-width), (int)(x+a), (int)(y+a));
		g2d.drawLine((int)(x+a), (int)(y+a), (int)(x-a), (int)(y+a));
		g2d.drawLine((int)(x-a), (int)(y+a), (int)x, (int)(y-width));
		
		g2d.setColor(Color.blue);
		//g2d.fillRect((int)x-2, (int)y-2, 4, 4);
	}

	@Override
	public void clickableClicked(Clickable clickable) {
		if(clickable instanceof HexaTile){
			HexaTile tile = (HexaTile)clickable;
			
			System.out.println("Hexagon clicked");
			
			Point p = new Point(0, 0);
			try {
				p = HexEight.gameMap.getMapData().getMapPoint((int)tile.getX(), (int)tile.getY());
				setLocation(tile.getX(), tile.getY());
				System.out.println("X: " + p.getX() + " Y: " + p.getY());
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		
	}

	@Override
	public void clickableHovered(Clickable clickable) {
//		if(clickable instanceof HexaTile) {
//			HexaTile tile = (HexaTile)clickable;
//
//			System.out.println("Hexagon hovered");
//			
//			Point p = new Point(0, 0);
//			try {
//				p = HexaEight.gameMap.getMapData().getMapPoint((int)tile.getX(), (int)tile.getY());
//				System.out.println("X: " + p.getX() + " Y: " + p.getY());
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
	}


}
