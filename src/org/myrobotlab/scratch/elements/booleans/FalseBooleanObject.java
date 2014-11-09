package org.myrobotlab.scratch.elements.booleans;

import java.util.ArrayList;

import org.myrobotlab.scratch.Renderable;
import org.myrobotlab.scratch.ScratchUtils;
import org.myrobotlab.scratch.elements.BooleanMethodObject;

/**
 * 
 * based on the Scratch-Interface in the "hamster-simulator"
 * -> http://www.java-hamster-modell.de/scratch.html
 * by J[ue]rgen Boger
 * this file ???
 * @author LunDev (github), Ma. Vo. (MyRobotLab)
 *
 */

public class FalseBooleanObject extends BooleanMethodObject {
	public FalseBooleanObject() {
		super("falsch", ScratchUtils.DEF_FALSE, getParameter());
	}
	
	private static ArrayList<RType> getParameter() {
		ArrayList<RType> parameter = new ArrayList<RType>();
		return parameter;
	}

	@Override
	public Renderable clone() {
		FalseBooleanObject temp = new FalseBooleanObject();
		return temp;
	}
	
	@Override
	public void writeSourceCode(StringBuffer buffer, int layer, boolean comment, boolean needsReturn) {
		startLine(buffer, layer, comment);
		buffer.append("false");
	}
}
