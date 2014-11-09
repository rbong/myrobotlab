package org.myrobotlab.scratch.elements.voids;

import java.util.ArrayList;

import org.myrobotlab.scratch.Renderable;
import org.myrobotlab.scratch.ScratchUtils;
import org.myrobotlab.scratch.elements.ReturnObject;

/**
 * 
 * based on the Scratch-Interface in the "hamster-simulator"
 * -> http://www.java-hamster-modell.de/scratch.html
 * by J[ue]rgen Boger
 * this file ???
 * @author LunDev (github), Ma. Vo. (MyRobotLab)
 *
 */

public class ReturnBooleanObject extends ReturnObject {
	public ReturnBooleanObject() {
		super(ScratchUtils.DEF_BOOL_RETURN, getParameter());
		next = null;
		nextDock = null;
	}
	
	private static ArrayList<RType> getParameter() {
		ArrayList<RType> parameter = new ArrayList<RType>();
		parameter.add(RType.BOOLEAN);
		return parameter;
	}
	
	@Override
	public String getName() {
		return "returnB";
	}
	
	@Override
	public Renderable clone() {
		return new ReturnBooleanObject();
	}
	
	@Override
	public void writeSourceCode(StringBuffer buffer, int layer, boolean comment, boolean needsReturn) throws FunctionResultException {
		startLine(buffer, layer, comment);
		buffer.append("return ");
		
		if (childs.get(0) == null)
			buffer.append("true");
		else
			childs.get(0).writeSourceCode(buffer, 0, false, false);
		
		buffer.append(";" + NEWLINE);
		
		throw new FunctionResultException(true);
	}
}
