package org.monitor.business.impl;

import java.lang.management.ManagementFactory;
import java.util.Date;

import org.monitor.business.IMonitoringEngine;
import org.monitor.models.JVMInstantStatusModel;

/**
 * @see org.monitor.business.IMonitoringEngine
 * 
 * @author khalil.amdouni
 * 
 */
public class MonitoringEngine implements IMonitoringEngine {

	private static final long serialVersionUID = -779860388442551701L;

	@Override
	public JVMInstantStatusModel getJVMProcessStatus() {
		JVMInstantStatusModel jvmInstantStatusModel = new JVMInstantStatusModel();
		jvmInstantStatusModel.setX(new Date().toString());
		jvmInstantStatusModel.setY(ManagementFactory.getThreadMXBean()
				.getThreadCount());
		return jvmInstantStatusModel;
	}

}
