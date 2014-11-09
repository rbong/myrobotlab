package org.myrobotlab.scratch.gui;

/**
 * 
 * based on the Scratch-Interface in the "hamster-simulator"
 * -> http://www.java-hamster-modell.de/scratch.html
 * by J[ue]rgen Boger
 * this file ???
 * @author LunDev (github), Ma. Vo. (MyRobotLab)
 *
 */

public class DeleteMethodException extends Exception {

	private static final long serialVersionUID = 631728129944515016L;

	private String message;
	
	public DeleteMethodException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
