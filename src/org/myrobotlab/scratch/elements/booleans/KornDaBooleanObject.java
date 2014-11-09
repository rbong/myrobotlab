package org.myrobotlab.scratch.elements.booleans;

import java.util.ArrayList;

import org.myrobotlab.scratch.Renderable;
import org.myrobotlab.scratch.elements.BooleanMethodObject;

/**
 * 
 * based on the Scratch-Interface in the "hamster-simulator"
 * -> http://www.java-hamster-modell.de/scratch.html
 * by Jürgen Boger
 * this file ???
 * @author LunDev (github), Ma. Vo. (MyRobotLab)
 *
 */

public class KornDaBooleanObject extends BooleanMethodObject {
	public KornDaBooleanObject() {
		super("kornDa", getParameter());
	}
	
	private static ArrayList<RType> getParameter() {
		ArrayList<RType> parameter = new ArrayList<RType>();
		return parameter;
	}

	@Override
	public Renderable clone() {
		KornDaBooleanObject temp = new KornDaBooleanObject();
		return temp;
	}
}
