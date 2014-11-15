package org.myrobotlab.control;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import org.myrobotlab.logging.LoggerFactory;
import org.myrobotlab.scratch.ScratchPanel;
import org.myrobotlab.service.GUIService;
import org.myrobotlab.service._TemplateService;
import org.slf4j.Logger;

/**
 * based on _TemplateServiceGUI
 */
/**
 *
 * @author LunDev (github), Ma. Vo. (MyRobotlab)
 */
public class ScratchGUI extends ServiceGUI implements ActionListener {

	static final long serialVersionUID = 1L;
	public final static Logger log = LoggerFactory.getLogger(ScratchGUI.class
			.getCanonicalName());

	public ScratchGUI(final String boundServiceName,
			final GUIService myService, final JTabbedPane tabs) {
		super(boundServiceName, myService, tabs);
	}

	public void init() {

		display.setLayout(new BorderLayout());

		// scratch
		ScratchPanel p = new ScratchPanel();
		JScrollPane scrollPane = new JScrollPane(p);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());

		display.add(BorderLayout.CENTER, scrollPane);
	}

	public void getState(_TemplateService template) {
		// I think I should do something with this ...
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

			}
		});
	}

	@Override
	public void attachGUI() {
		// commented out subscription due to this class being used for
		// un-defined gui's

		// subscribe("publishState", "getState", _TemplateService.class);
		// send("publishState");
	}

	@Override
	public void detachGUI() {
		// commented out subscription due to this class being used for
		// un-defined gui's

		// unsubscribe("publishState", "getState", _TemplateService.class);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();

		// Button - Events
		// if (o == control_connect) {
		// myService
		// .send(boundServiceName, "control_connect", control_connect);
		// }
		myService.send(boundServiceName, "publishState");
	}
}
