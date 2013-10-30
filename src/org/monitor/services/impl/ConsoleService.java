package org.monitor.services.impl;

import org.apache.log4j.Logger;
import org.monitor.models.JVMStatusModel;
import org.monitor.services.IConsoleService;

/**
 * Business service of the console functionality
 * 
 * @author khalil.amdouni
 * 
 */
public class ConsoleService implements IConsoleService {

	private static final long serialVersionUID = -5366259534481462829L;
	private static transient final Logger logger = Logger.getLogger(ConsoleService.class);

	public JVMStatusModel getJVMStatus() {
		logger.info("Spring context is here :)");
		return null;
	}
}
