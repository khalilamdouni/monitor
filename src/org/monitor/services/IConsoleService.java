package org.monitor.services;

import java.io.Serializable;

import org.monitor.models.JVMStatusModel;

public interface IConsoleService extends Serializable {
	public JVMStatusModel getJVMStatus();
}
