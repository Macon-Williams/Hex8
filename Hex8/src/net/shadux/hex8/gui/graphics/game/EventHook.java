package net.shadux.hex8.gui.graphics.game;

import net.shadux.hex8.game.HexaTile;
import net.shadux.hex8.gui.graphics.Clickable;

public interface EventHook {

	public void clickableClicked(Clickable tile);
	public void clickableHovered(Clickable tile);
}
