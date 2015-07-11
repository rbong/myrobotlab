package org.myrobotlab.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.myrobotlab.framework.Service;
import org.myrobotlab.logging.Level;
import org.myrobotlab.logging.LoggerFactory;
import org.myrobotlab.logging.Logging;
import org.myrobotlab.logging.LoggingFactory;
import org.slf4j.Logger;

public class RemoteStreamInput extends Service {

	private static final long serialVersionUID = 1L;

	InputStream inputStream = null;
	URL url = null;

	public final static Logger log = LoggerFactory
			.getLogger(RemoteStreamInput.class);

	public static void main(String[] args) {
		LoggingFactory.getInstance().configure();
		LoggingFactory.getInstance().setLevel(Level.INFO);

		try {

			RemoteStreamInput template = (RemoteStreamInput) Runtime.start(
					"template", "_TemplateService");
			template.test();

			Runtime.start("gui", "GUIService");

		} catch (Exception e) {
			Logging.logError(e);
		}
	}

	public RemoteStreamInput(String n) {
		super(n);
	}

	@Override
	public String[] getCategories() {
		return new String[] { "communication" };
	}

	@Override
	public String getDescription() {
		return "remote stream input";
	}

	public void init(String u) {
		try {
			url = new URL (u);
			inputStream = url.openStream();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}
	
	public boolean isConnected() {
		return (inputStream != null);
	}
	
	public void close() {
		try {
			inputStream.close();
			inputStream = null;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}
}