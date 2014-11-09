package org.myrobotlab.scratch.elements.booleans;

import java.util.ArrayList;

import org.myrobotlab.scratch.Renderable;
import org.myrobotlab.scratch.ScratchUtils;
import org.myrobotlab.scratch.elements.BooleanMethodObject;
import org.myrobotlab.scratch.elements.voids.FunctionResultException;

/**
 * 
 * based on the Scratch-Interface in the "hamster-simulator"
 * -> http://www.java-hamster-modell.de/scratch.html
 * by Jürgen Boger
 * this file ???
 * @author LunDev (github), Ma. Vo. (MyRobotLab)
 *
 */

public class NotBooleanObject extends BooleanMethodObject {
	public NotBooleanObject() {
		super("nicht", ScratchUtils.DEF_NOT, getParameter());
	}
	
	private static ArrayList<RType> getParameter() {
		ArrayList<RType> parameter = new ArrayList<RType>();
		parameter.add(RType.BOOLEAN);
		return parameter;
	}

	@Override
	public Renderable clone() {
		NotBooleanObject temp = new NotBooleanObject();
		return temp;
	}
	
	@Override
	public void writeSourceCode(StringBuffer buffer, int layer, boolean comment, boolean needsReturn) throws FunctionResultException {
		startLine(buffer, layer, comment);
		buffer.append("!");
		
		if (childs.get(0) == null)
			buffer.append("true");
		else
			childs.get(0).writeSourceCode(buffer, 0, false, false);
	}
}
