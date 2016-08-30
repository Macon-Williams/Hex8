package net.shadux.hex8.gui.graphics.game;

import java.awt.Point;
import java.util.ArrayList;

public class GameMapData {

	private ArrayList<MapPoint> mapPoints;
	
	public GameMapData(int tilesx, int tilesy) {
		mapPoints = new ArrayList<>();
		initMapData(tilesx, tilesy);
	}
	
	
	public Point getScreenPoint(int x, int y) throws Exception {
		return getMapPointByMapPoint(x, y).screenPoint;
	}
	
	public Point getMapPoint(int x, int y) throws Exception {
		return getMapPointByScreenPoint(x, y).mapPoint;
	}
	
	private MapPoint getMapPointByScreenPoint(int x, int y) throws Exception {
		for(int i = 0;i<mapPoints.size();i++) {
			MapPoint mapPoint = mapPoints.get(i);
			if(mapPoint.screenPoint.x == x && mapPoint.screenPoint.y == y) {
				return mapPoint;
			}
		}
		throw new Exception("No map point at point: " + x + ", " + y);
	}
	
	private MapPoint getMapPointByMapPoint(int x, int y) throws Exception {
		for(int i = 0;i<mapPoints.size();i++) {
			MapPoint mapPoint = mapPoints.get(i);
			if(mapPoint.mapPoint.x == x && mapPoint.mapPoint.y == y) {
				return mapPoint;
			}
		}
		throw new Exception("No map point at point: " + x + ", " + y);
	}
	
	private void initMapData(int tilesx, int tilesy) {
		for(int x = 0;x<tilesx;x++) {
			for(int y = 0;y<tilesy;y++) {
				mapPoints.add(new MapPoint(x, y, 0, 0));
			}
		}
	}
	
	public void setScreenPoint(int x, int y, int screenx, int screeny) throws Exception {
		getMapPointByMapPoint(x, y).setScreenPoint(screenx, screeny);
	}
	
	class MapPoint {
		public Point mapPoint;
		public Point screenPoint;
		
		public MapPoint(int x, int y, int screenx, int screeny) {
			mapPoint = new Point(x, y);
			screenPoint = new Point(screenx, screeny);
		}
		
		public void setScreenPoint(int screenx, int screeny) {
			screenPoint = new Point(screenx, screeny);
		}
	}
}
