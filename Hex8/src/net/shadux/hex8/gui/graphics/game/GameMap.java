package net.shadux.hex8.gui.graphics.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import net.shadux.hex8.HexEight;
import net.shadux.hex8.game.Entity;
import net.shadux.hex8.game.HexaTile;
import net.shadux.hex8.game.Sprite;
import net.shadux.hex8.gui.graphics.Clickable;
import net.shadux.hex8.gui.graphics.Drawable;
import net.shadux.hex8.gui.graphics.DrawableHexagon;

public class GameMap {

	protected int width;
	protected int height;
	protected int HEX_SIZE = 20; //default
	protected GameMapData mapData;
	
	protected ArrayList<HexaTile> hexagons;
	protected ArrayList<Entity> entities;
	protected ArrayList<Clickable> clickables;
	
	protected ArrayList<EventHook> events;
	
	protected Graphics2D g2d;
	
	public GameMapData getMapData() {
		return mapData;
	}
	
	private void initMap() throws Exception {
		
		int xTileSize = (int)((HexEight.WIDTH)/((width+2)*3));//Make room for the excess 2 on either end and the spacing
		int yTileSize = (int)((HexEight.HEIGHT)/((height)/DrawableHexagon.getYTileFactor(1)));
		int smaller = yTileSize;
		if(xTileSize < yTileSize) { //figure out which is the smaller size (otherwise if the hexagon size is too big it'll bleed off that axis)
			smaller = xTileSize;
		}
		HEX_SIZE = smaller;
		///////////Determine offset
		DrawableHexagon centerhexagon = createHexagon(round(width, 2), round(height, 2), 0, 0);
		
		int xsign = 0;
		int ysign = 0; //if the center point and the center of the map are exactly the same then we don't need to offset
		
		double offsetx = Math.abs(HexEight.WIDTH/2 - centerhexagon.getX());
		double offsety = Math.abs(HexEight.HEIGHT/2 - centerhexagon.getY());
		
		if(HexEight.WIDTH/2 > centerhexagon.getX()) {
			xsign = 1; //positive
		} else if(HexEight.WIDTH/2 < centerhexagon.getX()) {
			xsign = -1; //offset needs to be negative, the center tile is further than the center of the screen
		}
		
		if(HexEight.HEIGHT/2 > centerhexagon.getY()) {
			ysign = 1;
		} else if(HexEight.HEIGHT < centerhexagon.getY()) {
			ysign = -1;
		}
		/////////////
		
		HexaTile tmpTile;
		for(int x = 0;x<width;x++) {
			for(int y = 0;y<height;y++) {
				tmpTile = createHexagon(x, y, (int)offsetx*xsign, (int)offsety*ysign);
				hexagons.add(tmpTile);
				mapData.setScreenPoint(x, y, (int)tmpTile.getX(), (int)tmpTile.getY());
			}
		}
		
		for(DrawableHexagon hex : hexagons) {
			clickables.add(hex);
		}
	}
	
	private int round(int a, int b) {
		double result = a/b;
		int fin = (int)Math.round(result);
		return fin;
	}
	
	
	private HexaTile createHexagon(int x, int y, int offsetx, int offsety) {
		
		double xcoord = x*DrawableHexagon.getXTileFactor(HEX_SIZE);
		double ycoord = y*DrawableHexagon.getYTileFactor(HEX_SIZE);
		
		if(y % 2 == 0) {
			xcoord += DrawableHexagon.getXTileOffset(HEX_SIZE); 
		}
		
		
		HexaTile hexagon = new HexaTile(xcoord + offsetx, ycoord + offsety, HEX_SIZE);
		return hexagon;
	}
	
	public GameMap(int width, int height, Graphics2D g2d) {
		this.width = width;
		this.height = height;
		this.g2d = g2d;
		mapData = new GameMapData(width, height);
		hexagons = new ArrayList<>();
		entities = new ArrayList<>();
		clickables = new ArrayList<>();
		events = new ArrayList<>();
		
		try {
			initMap();
		} catch(Exception e) {
			System.out.println("Cannot init map!");
			e.printStackTrace();
		}
	}
	
	public void gameTick() {
		clearDead();
		drawHexagons(g2d);
		drawEntities(g2d);
	}

	private void drawEntities(Graphics2D g2d) {
		for(Entity en : entities) {
			en.draw(g2d);
		}
	}
	
	private void drawHexagons(Graphics2D g2d) {
		int lastIndex = hexagons.size()-1;
		for(int i =0;i<hexagons.size();i++) {
			if(hexagons.get(i).getMousedOver()) {
				lastIndex = i;
			} else {
				hexagons.get(i).draw(g2d);
			}
		}
		hexagons.get(lastIndex).draw(g2d); //draw the hovered tile last so it appears "above" others
	}
	protected void clearDead() {
		for(int i = 0;i<entities.size();i++) {
			if(!entities.get(i).getAlive()) {
				entities.remove(i);
			}
		}
	}
		
	public void addEntity(Entity entity, int x, int y) throws Exception {
		entity.setLocation(mapData.getScreenPoint(x, y));
		entities.add(entity);
	}
	
	public void addEntity(Entity entity) {
		entities.add(entity);
	}
	public void addEventHook(EventHook hook) {
		events.add(hook);
	}

	public void addClickable(Clickable clickable) {
		clickables.add(clickable);
	}
	
	public ArrayList<Clickable> getClickables() {
		return clickables;
	}
	
	private void notifyClickHook(Clickable clickable) {
		for(EventHook hook : events) {
			hook.clickableClicked(clickable);
		}
	}
	
	private void notifyHoverHook(Clickable clickable) {
		for(EventHook hook : events) {
			hook.clickableHovered(clickable);
		}
	}
	
	public void checkClick(Point p) {
		Clickable clicked;
		for(int i = 0;i<clickables.size();i++) {
			clicked = clickables.get(i);
			if(clicked.clicked(p)) {
				notifyClickHook(clicked);
				return;
			}
		}
	}
	
	public void checkMouseOver(Point p) {
		Clickable clicked;
		for(int i = 0;i<clickables.size();i++) {
			clicked = clickables.get(i);
			if(clicked.mouseOver(p)) {
				notifyHoverHook(clicked);
			}
		}
	}
}
