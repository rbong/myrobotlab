package org.myrobotlab.scratch.elements.booleans;

import java.util.ArrayList;

import org.myrobotlab.scratch.Renderable;
import org.myrobotlab.scratch.ScratchUtils;
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

public class TrueBooleanObject extends BooleanMethodObject {
	public TrueBooleanObject() {
		super("wahr", ScratchUtils.DEF_TRUE, getParameter());
	}
	
	private static ArrayList<RType> getParameter() {
		ArrayList<RType> parameter = new ArrayList<RType>();
		return parameter;
	}

	@Override
	public Renderable clone() {
		TrueBooleanObject temp = new TrueBooleanObject();
		return temp;
	}
	
	@Override
	public void writeSourceCode(StringBuffer buffer, int layer, boolean comment, boolean needsReturn) {
		startLine(buffer, layer, comment);
		buffer.append("true");
	}
}
