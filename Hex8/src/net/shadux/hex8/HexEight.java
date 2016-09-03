package net.shadux.hex8;

import net.shadux.hex8.game.entity.Triangle;
import net.shadux.hex8.gui.Window;
import net.shadux.hex8.gui.graphics.game.GameMap;
import net.shadux.hex8.gui.graphics.game.GameState;
import net.shadux.hex8.gui.graphics.game.menu.CloseButton;

public class HexEight {
	
	
	public static int GAMESTATE = GameState.STARTING;
	public static int WIDTH = 800; //Hexagons currently scale to the resolution of the game
	public static int HEIGHT = 600;
	public static Window window;
	public static GameMap gameMap;
	
	public HexEight() {
		window = new Window(WIDTH, HEIGHT);
		
		Thread thread = new Thread(new GameLoop());
		thread.start();
		
	}
	
	public static void setGameState(int gamestate) {
		GAMESTATE = gamestate;
	}
	
	public static void main(String[] args) {
		new HexEight();
	}
	
 class GameLoop extends Thread implements Runnable {
		
		@Override
		public void run() {
			gameMap = new GameMap(10, 20, window.getCanvas().getGraphics());
			//gameMap.addEntity(new CloseButton(WIDTH-10-CloseButton.WIDTH, 0));
			
			try {
				gameMap.addEntity(new Triangle(), 1, 0);	
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			GAMESTATE = GameState.RUNNING;
			
			gameloop();
			System.exit(0);
		}
		
		public void gameloop() {
			while(GAMESTATE == GameState.RUNNING) {
				try {
					gameMap.gameTick();
					window.repaint();
					
					Thread.sleep(20);
				} catch(Exception e) {
					System.out.println("Problem in main game loop!");
					e.printStackTrace();
				}
			}
		}
 }
}
