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

public class ReturnVoidObject extends ReturnObject {
	public ReturnVoidObject() {
		super(ScratchUtils.DEF_VOID_RETURN, getParameter());
		next = null;
		nextDock = null;
	}

	private static ArrayList<RType> getParameter() {
		ArrayList<RType> parameter = new ArrayList<RType>();
		return parameter;
	}

	@Override
	public Renderable clone() {
		return new ReturnVoidObject();
	}

	@Override
	public void writeSourceCode(StringBuffer buffer, int layer,
			boolean comment, boolean needsReturn)
			throws FunctionResultException {
		startLine(buffer, layer, comment);

		buffer.append("return;" + NEWLINE);

		throw new FunctionResultException(true);
	}

	// @Override
	// public void writeSourceCode(StringBuffer buffer, int layer,
	// boolean comment, boolean needsReturn)
	// throws FunctionResultException {
	// startLine(buffer, layer, comment);
	// if (needsReturn)
	// buffer.append("return true;" + NEWLINE);
	// else
	// buffer.append("return;" + NEWLINE);
	//
	// throw new FunctionResultException(true);
	// }
}
