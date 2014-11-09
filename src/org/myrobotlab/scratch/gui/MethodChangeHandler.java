package org.myrobotlab.scratch.gui;

/**
 * 
 * based on the Scratch-Interface in the "hamster-simulator"
 * -> http://www.java-hamster-modell.de/scratch.html
 * by Jürgen Boger
 * this file ???
 * @author LunDev (github), Ma. Vo. (MyRobotLab)
 *
 */

public interface MethodChangeHandler {
	public abstract void onDelete(TabButton button);
	public abstract void onRename(String name);
}
