package org.monitor.business;

import java.io.Serializable;

import org.monitor.models.JVMInstantStatusModel;

/**
 * The interface of the JVM monitoring engine
 * 
 * @author khalil.amdouni
 *
 */
public interface IMonitoringEngine extends Serializable {
	
	public JVMInstantStatusModel getJVMProcessStatus();
}
