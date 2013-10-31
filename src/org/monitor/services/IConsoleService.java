package org.monitor.services;

import java.io.Serializable;

import org.monitor.models.JVMStatusModel;

/**
 * Service interface for the monitoring console service
 * 
 * @author khalil.amdouni
 *
 */
public interface IConsoleService extends Serializable {

	public void updateJVMStatus(JVMStatusModel jvmStatusModel);
}
