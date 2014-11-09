package org.myrobotlab.scratch;

import java.util.ArrayList;

import org.myrobotlab.scratch.gui.NextMethodHandler;
import org.myrobotlab.scratch.gui.RefreshHandler;

/**
 * Ein ScratchProgramm beinhaltet eine Sequenz von Anweisungen (hier Statements)
 * 
 * based on the Scratch-Interface in the "hamster-simulator"
 * -> http://www.java-hamster-modell.de/scratch.html
 * by Jürgen Boger
 * this file dibo
 * @author LunDev (github), Ma. Vo. (MyRobotLab)
 * 
 */
public class ScratchProgram extends Thread {

	private StorageController program;
	private ArrayList<RefreshHandler> refreshHandler = new ArrayList<RefreshHandler>();
	private ArrayList<NextMethodHandler> nextMethodHandler = new ArrayList<NextMethodHandler>();

	public ScratchProgram() {
		super();
		this.program = new StorageController();
	}

	/**
	 * Liefert den Quellcode f[?]r das gesamte Programm, in Convention zum
	 * Hamster-Simulator, so dass dieser direkt als imperatives Programm
	 * verwendet werden darf.
	 * 
	 * @return
	 */
	public String getSourceCode() {
		StringBuffer buffer = new StringBuffer();
		this.program.writeSourceCode(buffer);
		return buffer.toString();
	}

	public StorageController getProgram() {
		return this.program;
	}

	public void addRefreshHandler(RefreshHandler handler) {
		this.refreshHandler.add(handler);
	}

	public void addNextMethodHandler(NextMethodHandler handler) {
		this.nextMethodHandler.add(handler);
	}
}
