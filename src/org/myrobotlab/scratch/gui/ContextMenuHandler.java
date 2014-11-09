package org.myrobotlab.scratch.gui;

import java.util.ArrayList;

/**
 * 
 * based on the Scratch-Interface in the "hamster-simulator"
 * -> http://www.java-hamster-modell.de/scratch.html
 * by Jürgen Boger
 * this file ???
 * @author LunDev (github), Ma. Vo. (MyRobotLab)
 *
 */

public interface ContextMenuHandler {
	abstract public void openContextMenu(ArrayList<MenuItem> menuItems, int x, int y);
}
