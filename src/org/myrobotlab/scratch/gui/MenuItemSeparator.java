package org.myrobotlab.scratch.gui;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * based on the Scratch-Interface in the "hamster-simulator"
 * -> http://www.java-hamster-modell.de/scratch.html
 * by Jürgen Boger
 * this file ???
 * @author LunDev (github), Ma. Vo. (MyRobotLab)
 *
 */

public class MenuItemSeparator extends MenuItem {
	public static Color PRIMARY = new Color(172, 172, 172);
	public static Color SECONDARY = new Color(206, 206, 206);
	
	public MenuItemSeparator() {
		super("", null);
		height = 2;
		enabled = false;
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(PRIMARY);
		g.drawLine(x, y, x + width, y);
		g.setColor(SECONDARY);
		g.drawLine(x, y + 1, x + width, y + 1);
	}
}
