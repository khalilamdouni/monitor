package org.monitor.services.impl;

import org.apache.log4j.Logger;
import org.icefaces.ace.model.chart.CartesianSeries;
import org.monitor.business.IMonitoringEngine;
import org.monitor.models.JVMInstantStatusModel;
import org.monitor.models.JVMStatusModel;
import org.monitor.services.IConsoleService;

/**
 * @see org.monitor.services.IConsoleService
 * 
 * @author khalil.amdouni
 * 
 */
public class ConsoleService implements IConsoleService {

	private static final long serialVersionUID = -5366259534481462829L;
	private static transient final Logger logger = Logger.getLogger(ConsoleService.class);

	private IMonitoringEngine monitoringEngine;
	
	@Override
	public void updateJVMStatus(JVMStatusModel jvmStatusModel) {

		JVMInstantStatusModel instantStatus = monitoringEngine
				.getJVMProcessStatus();
		if (jvmStatusModel.getDatas().size() == 0) {
			jvmStatusModel.getDatas().add(new CartesianSeries());
		}
		jvmStatusModel.getDatas().get(0)
				.add(instantStatus.getTime(), instantStatus.getMemory());
		if (jvmStatusModel.getDatas().get(0).getData().size() > 10) {
			jvmStatusModel.getDatas().get(0).getData().remove(0);
		}
		jvmStatusModel.getxAxis().add(instantStatus.getTime());
		if (jvmStatusModel.getxAxis().size() > 10) {
			jvmStatusModel.getxAxis().remove(0);
		}
		
		jvmStatusModel.setProcessNumber(instantStatus.getProcessNumber());
		logger.info("Spring context is here :)");
	}

	public IMonitoringEngine getMonitoringEngine() {
		return monitoringEngine;
	}

	public void setMonitoringEngine(IMonitoringEngine monitoringEngine) {
		this.monitoringEngine = monitoringEngine;
	}
}
