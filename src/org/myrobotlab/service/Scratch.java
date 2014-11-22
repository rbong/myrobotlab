package org.myrobotlab.service;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import org.myrobotlab.framework.Service;
import org.myrobotlab.logging.Level;
import org.myrobotlab.logging.LoggerFactory;
import org.myrobotlab.logging.Logging;
import org.myrobotlab.logging.LoggingFactory;
import org.myrobotlab.scratch.ScratchPanel;
import org.slf4j.Logger;

/**
 * based on _TemplateService
 */
/**
 *
 * @author LunDev (github), Ma. Vo. (MyRobotlab)
 */
public class Scratch extends Service {

	private static final long serialVersionUID = 1L;
	public final static Logger log = LoggerFactory.getLogger(Scratch.class);

	public Scratch(String n) {
		super(n);
		// intializing variables
		// Should do something useful here in future
	}

	@Override
	public void startService() {
		super.startService();
	}

	@Override
	public void stopService() {
		super.stopService();
	}

	@Override
	public String getDescription() {
		return "graphical programming interface";
	}

	public void top_exportcode(ScratchPanel middle) {
		String code = middle.getSourceCode();

		JFrame frame = new JFrame();
		JTextArea textarea = new JTextArea();
		textarea.setText(code);
		textarea.setEditable(false);
		textarea.setLineWrap(true);
		JScrollPane scrollpane = new JScrollPane(textarea);
		scrollpane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frame.add(scrollpane);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) throws InterruptedException {

		LoggingFactory.getInstance().configure();
		LoggingFactory.getInstance().setLevel(Level.INFO);
		try {

			Runtime.start("gui", "GUIService");
			Runtime.start("scratch", "Scratch");

		} catch (Exception e) {
			Logging.logException(e);
		}

	}

}
