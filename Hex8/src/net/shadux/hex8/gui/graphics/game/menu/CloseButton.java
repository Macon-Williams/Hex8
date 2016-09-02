package net.shadux.hex8.gui.graphics.game.menu;

import java.awt.Graphics2D;
import java.awt.Image;
import java.net.URL;

import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import net.shadux.hex8.HexEight;
import net.shadux.hex8.gui.graphics.game.Button;
import net.shadux.hex8.gui.graphics.game.GameState;

public class CloseButton extends Button {

	private Image exButton, exHighlighted;
	//private Image exPressed;

	public static final int WIDTH = 30;
	public static final int HEIGHT = 20;

	public CloseButton(double x, double y) {
		super(x + 5, y + 5, WIDTH, HEIGHT);

		Toolkit tk = Toolkit.getDefaultToolkit();
		exButton = tk.getImage(getURL("ExitButton.png"));
		exHighlighted = tk.getImage(getURL("ExitHighlighted.png"));
		//exPressed = tk.getImage(getURL("ExitPressed.png")); Doesn't behave how I would like it to
	}

	private URL getURL(String filename) {
		URL url = null;
		try {
			url = this.getClass().getResource(filename);
		} catch (Exception e) {
		}
		return url;
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.drawImage(exButton, (int) x, (int) y, null);
		
		if(mousedOver) {
			g2d.drawImage(exHighlighted, (int) x, (int) y, null);
		} else {
			g2d.drawImage(exButton, (int) x, (int) y, null);
		}
		
		if(clicked) {
			//g2d.drawImage(exPressed, (int) x, (int) y, null); Doesn't behave how I would like it to
			int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit?", JOptionPane.YES_NO_OPTION);
			if (choice == 0) {
				HexEight.setGameState(GameState.STOPPING);
			}
			else {
				clicked = false;
			}
		}
	}
}
