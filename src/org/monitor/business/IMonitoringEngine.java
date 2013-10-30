package org.monitor.business;

import org.monitor.models.JVMInstantStatusModel;

/**
 * The interface of the JVM monitoring engine
 * 
 * @author khalil.amdouni
 *
 */
public interface IMonitoringEngine {
	
	public JVMInstantStatusModel getJVMProcessStatus();
}
