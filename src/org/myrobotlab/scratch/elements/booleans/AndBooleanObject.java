package org.myrobotlab.scratch.elements.booleans;

import java.awt.Graphics;

import org.myrobotlab.scratch.BoundingBox;
import org.myrobotlab.scratch.DockingBox;
import org.myrobotlab.scratch.Renderable;
import org.myrobotlab.scratch.ScratchUtils;
import org.myrobotlab.scratch.elements.BooleanObject;
import org.myrobotlab.scratch.elements.voids.FunctionResultException;

/**
 * 
 * based on the Scratch-Interface in the "hamster-simulator"
 * -> http://www.java-hamster-modell.de/scratch.html
 * by J[ue]rgen Boger
 * this file ???
 * @author LunDev (github), Ma. Vo. (MyRobotLab)
 *
 */

public class AndBooleanObject extends BooleanObject {
	public static int START_WIDTH = 8;
	public static int TEXT_SPACING = 6;
	public static int MIN_WIDTH = 25;
	public static int MIN_HEIGHT = 13;
	public static String TEXT = ScratchUtils.DEF_AND;

	private int textWidth;

	public AndBooleanObject() {
		super(false);

		this.textWidth = ScratchUtils.getTextWidth(AndBooleanObject.TEXT,
				BooleanObject.TEXT_FONT);

		this.maxChilds = 2;
		DockingBox leftBool = new DockingBox(AndBooleanObject.START_WIDTH, 2,
				AndBooleanObject.MIN_WIDTH, AndBooleanObject.MIN_HEIGHT,
				AndBooleanObject.START_WIDTH, 2, RType.BOOLEAN);
		this.dockings.put(0, leftBool);
		DockingBox rightBool = new DockingBox(0, 0, 0, 0, 0, 0, RType.BOOLEAN);
		this.dockings.put(1, rightBool);

		this.updateBounds();
	}

	@Override
	public String getName() {
		return "und";
	}

	@Override
	public void render(Graphics g) {
		super.render(g);

		g.setColor(BooleanObject.COLOR_TEXT);
		g.setFont(BooleanObject.TEXT_FONT);
		int textHeight = 7;
		g.drawString(AndBooleanObject.TEXT, this.bounding.getX()
				+ AndBooleanObject.START_WIDTH
				+ this.dockings.get(0).getWidth()
				+ AndBooleanObject.TEXT_SPACING, this.bounding.getY()
				+ textHeight + (this.bounding.getHeight() - textHeight) / 2);
	}

	@Override
	public void updateBounds() {
		int w = 2
				* (AndBooleanObject.START_WIDTH + AndBooleanObject.TEXT_SPACING)
				+ this.textWidth;
		int h = AndBooleanObject.MIN_HEIGHT;

		// Update breiten und H[?]hen der DockingBoxen
		for (int i = 0; i < this.maxChilds; i++) {
			if (this.childs.get(i) != null) {
				BoundingBox temp = this.childs.get(i).getGlobalBounding();
				w += temp.getWidth();
				h = h < temp.getHeight() + 4 ? temp.getHeight() + 4 : h;
				this.dockings.get(i).setSize(temp.getWidth(), temp.getHeight());
			} else {
				w += this.dockings.get(i).getType().getWidth();
				h = h < this.dockings.get(i).getType().getHeight() + 4 ? this.dockings
						.get(i).getType().getHeight() + 4
						: h;
				this.dockings.get(i).setSize(
						this.dockings.get(i).getType().getWidth(),
						this.dockings.get(i).getType().getHeight());
			}
		}

		// Position der rechten DockBox
		this.dockings.get(1).setPosition(
				AndBooleanObject.START_WIDTH + AndBooleanObject.TEXT_SPACING
						* 2 + this.textWidth + this.dockings.get(0).getWidth(),
				0);
		this.dockings.get(1).setDockX(
				AndBooleanObject.START_WIDTH + AndBooleanObject.TEXT_SPACING
						* 2 + this.textWidth + this.dockings.get(0).getWidth());

		// Verticale Ausrichtung der Dockings anpassen
		for (int i = 0; i < this.maxChilds; i++) {
			this.dockings.get(i).setPosition(this.dockings.get(i).getX(),
					(h - this.dockings.get(i).getHeight()) / 2);
			this.dockings.get(i).setDockY(
					(h - this.dockings.get(i).getHeight()) / 2);
		}

		this.bounding.setSize(w, h);

		if (this.parent != null) {
			this.parent.updateBounds();
		}
	}

	@Override
	public Renderable clone() {
		AndBooleanObject temp = new AndBooleanObject();
		return temp;
	}

	@Override
	public void writeSourceCode(StringBuffer buffer, int layer, boolean comment, boolean needsReturn) throws FunctionResultException {
		startLine(buffer, layer, comment);
		buffer.append("(");
		
		if (childs.get(0) == null)
			buffer.append("true");
		else
			childs.get(0).writeSourceCode(buffer, 0, false, false);
		
		buffer.append(" && ");
		
		if (childs.get(1) == null)
			buffer.append("true");
		else
			childs.get(1).writeSourceCode(buffer, 0, false, false);
		
		buffer.append(")");
	}
}
