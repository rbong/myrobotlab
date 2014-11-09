package org.myrobotlab.scratch;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import org.myrobotlab.scratch.Renderable.RType;
import org.myrobotlab.scratch.elements.BooleanMethodObject;
import org.myrobotlab.scratch.elements.VoidObject;
import org.myrobotlab.scratch.elements.booleans.AndBooleanObject;
import org.myrobotlab.scratch.elements.booleans.FalseBooleanObject;
import org.myrobotlab.scratch.elements.booleans.KornDaBooleanObject;
import org.myrobotlab.scratch.elements.booleans.MaulLeerBooleanObject;
import org.myrobotlab.scratch.elements.booleans.NotBooleanObject;
import org.myrobotlab.scratch.elements.booleans.OrBooleanObject;
import org.myrobotlab.scratch.elements.booleans.TrueBooleanObject;
import org.myrobotlab.scratch.elements.booleans.VornFreiBooleanObject;
import org.myrobotlab.scratch.elements.controls.DoWhileObject;
import org.myrobotlab.scratch.elements.controls.IfElseObject;
import org.myrobotlab.scratch.elements.controls.IfObject;
import org.myrobotlab.scratch.elements.controls.WhileObject;
import org.myrobotlab.scratch.elements.voids.GibVoidObject;
import org.myrobotlab.scratch.elements.voids.LinksUmVoidObject;
import org.myrobotlab.scratch.elements.voids.NimmVoidObject;
import org.myrobotlab.scratch.elements.voids.ReturnBooleanObject;
import org.myrobotlab.scratch.elements.voids.ReturnVoidObject;
import org.myrobotlab.scratch.elements.voids.VorVoidObject;
import org.myrobotlab.scratch.gui.InvalidIdentifierException;

/**
 * Die ScratchUtils bieten einige n[?]tliche statische Funktionen, so dass der
 * Sourcecode minimiert wird.
 * 
 * based on the Scratch-Interface in the "hamster-simulator"
 * -> http://www.java-hamster-modell.de/scratch.html
 * by Jürgen Boger
 * this file HackZ
 * @author LunDev (github), Ma. Vo. (MyRobotLab)
 *
 */
public class ScratchUtils {
	/**
	 * L[?]dt die Ressource als Bild von der [?]bergebenen Position
	 * <tt>name</tt>.
	 * 
	 * @param name
	 *            Lokale Refferenz zu der Ressource.
	 * @return
	 */
	public static BufferedImage getImage(String name) {
		URL url = ClassLoader.getSystemResource("resource/" + name);
		if (url == null) {
			url = ScratchUtils.class.getClassLoader().getResource(
					"resource/" + name);
		}
		Image imgo = Toolkit.getDefaultToolkit().createImage(url);

		ImageIcon imgoic = new ImageIcon(imgo);

		Image img = imgoic.getImage();
		BufferedImage buffImg = new BufferedImage(img.getWidth(null),
				img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics g = buffImg.getGraphics();
		g.drawImage(img, 0, 0, null);
		return buffImg;

		// File imgFile = new File("resource/" + name);
		// try {
		// return ImageIO.read(imgFile);
		// } catch (IOException e) {
		// System.out.println("Bild '" + name +
		// "' konnten nicht geladen werden!");
		// e.printStackTrace();
		// }
		// return null;
	}

	/**
	 * Liefert die Breite zu dem [?]bergebenen Text mit der [?]bergebenen
	 * Schriftart.
	 * 
	 * @param text
	 *            Text zu dem die Breite gepr[?]ft werden soll.
	 * @param font
	 *            Schriftart, mit der der Text geschrieben wird.
	 * @return Breite in Pixeln.
	 */
	public static int getTextWidth(String text, Font font) {
		BufferedImage temp = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
		Graphics g = temp.getGraphics();
		FontMetrics metrics = g.getFontMetrics(font);
		return metrics.stringWidth(text);
	}

	/**
	 * Liefert die H[?]he zu dem [?]bergebenen Text mit der [?]bergebenen
	 * Schriftart.
	 * 
	 * @param text
	 *            Text zu dem die H[?]he gepr[?]ft werden soll.
	 * @param font
	 *            Schriftart, mit der der Text geschrieben wird.
	 * @return H[?]he in Pixeln.
	 */
	public static int getTextHeight(String text, Font font) {
		BufferedImage temp = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
		Graphics g = temp.getGraphics();
		FontMetrics metrics = g.getFontMetrics(font);
		return metrics.getHeight();
	}

	/**
	 * [?]berpr[?]ft, ob der [?]bergebene text allen Javaidentifier Konventionen
	 * entspricht.
	 * 
	 * @param text
	 *            text, der gepr[?]ft wird.
	 * @throws InvalidIdentifierException
	 *             Wird geworfen, falls der Bezeichner nicht den
	 *             Javakonventionen entspricht.
	 */
	public static void checkJavaIdentifier(String text)
			throws InvalidIdentifierException {
		if (text.equals(""))
			throw new InvalidIdentifierException(
					"Der Bezeichner darf nicht leer sein!");

		if (!isIdentifierChar(text.charAt(0)))
			throw new InvalidIdentifierException(
					"Der Bezeichner muss mit einem Buchstaben, Dollarzeichen oder Unterstrich beginnen!");

		for (int i = 1; i < text.length(); i++)
			if (!(isIdentifierChar(text.charAt(i)) || isNumeric(text.charAt(i))))
				throw new InvalidIdentifierException(
						"Der Bezeichner enth[?]lt unzul[?]ssige Zeichen!");
	}

	/**
	 * [?]berpr[?]ft, ob der Buchtabe in einem Javaidentifier vorkommen darf
	 * 
	 * @param c
	 *            Zu pr[?]fender Buchstabe.
	 * @return true, wenn der Buchtabe verwendet werden darf.
	 */
	public static boolean isIdentifierChar(char c) {
		if (c == '$')
			return true;

		if (c == '_')
			return true;

		if (c >= 'a' && c <= 'z')
			return true;

		if (c >= 'A' && c <= 'Z')
			return true;

		return false;
	}

	/**
	 * [?]berpr[?]ft, ob der Character numerisch ist
	 * 
	 * @param c
	 *            Zu pr[?]fender Character
	 * @return true, wenn der Character numerisch ist (0-9).
	 */
	public static boolean isNumeric(char c) {
		if (c >= '0' && c <= '9')
			return true;

		return false;
	}

	/**
	 * Erstellt ein Redenerable, das dem [?]bergebenen Namen entspricht und
	 * liefert diesen zur[?]ck.
	 * 
	 * @param name
	 *            Name des Renderables
	 * @param type
	 *            Typ des Renderables
	 * @return
	 */
	public static Renderable getRenderableByName(String name, String type) {
		// Feste voids
		if (name.equals("vor"))
			return new VorVoidObject();

		if (name.equals("linksUm"))
			return new LinksUmVoidObject();

		if (name.equals("nimm"))
			return new NimmVoidObject();

		if (name.equals("gib"))
			return new GibVoidObject();

		if (name.equals("return"))
			return new ReturnVoidObject();

		if (name.equals("returnB"))
			return new ReturnBooleanObject();

		// Feste booleans
		if (name.equals("vornFrei"))
			return new VornFreiBooleanObject();

		if (name.equals("kornDa"))
			return new KornDaBooleanObject();

		if (name.equals("maulLeer"))
			return new MaulLeerBooleanObject();

		if (name.equals("wahr"))
			return new TrueBooleanObject();

		if (name.equals("falsch"))
			return new FalseBooleanObject();

		if (name.equals("und"))
			return new AndBooleanObject();

		if (name.equals("oder"))
			return new OrBooleanObject();

		if (name.equals("nicht"))
			return new NotBooleanObject();

		// Controller
		if (name.equals("falls"))
			return new IfObject();

		if (name.equals("fallsSonst"))
			return new IfElseObject();

		if (name.equals("solange"))
			return new WhileObject();

		if (name.equals("tueSolange"))
			return new DoWhileObject();

		if (type.toUpperCase().equals("VOID"))
			return new VoidObject(name, new ArrayList<RType>());
		else
			return new BooleanMethodObject(name, new ArrayList<RType>());
	}

	public static Renderable getRenderableByName(String name, RType rType) {
		switch (rType) {
		case VOID:
			return ScratchUtils.getRenderableByName(name, "VOID");
		default:
			return ScratchUtils.getRenderableByName(name, "BOOLEAN");
		}
	}

	public static String DEF_NEW_PROCEDURE = "Neue Prozedur";
	public static String DEF_NEW_FUNCTION = "Neue Funktion";
	public static String DEF_VOID_RETURN = "verlasse";
	public static String DEF_BOOL_RETURN = "liefere";
	public static String DEF_TRUE = "wahr";
	public static String DEF_FALSE = "falsch";
	public static String DEF_AND = "und";
	public static String DEF_OR = "oder";
	public static String DEF_NOT = "nicht";
	public static String DEF_IF = "falls";
	public static String DEF_ELSE_IF = "falls";
	public static String DEF_ELSE = "sonst";
	public static String DEF_WHILE = "solange";
	public static String DEF_DO = "wiederhole";
	public static String DEF_DO_WHILE = "solange";
}
