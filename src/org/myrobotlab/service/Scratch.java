package org.myrobotlab.service;

import org.myrobotlab.framework.Service;
import org.myrobotlab.logging.Level;
import org.myrobotlab.logging.LoggerFactory;
import org.myrobotlab.logging.Logging;
import org.myrobotlab.logging.LoggingFactory;
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
