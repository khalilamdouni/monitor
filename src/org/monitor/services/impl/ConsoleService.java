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
				.getJVMStatus();
		jvmStatusModel.getxAxis().add(instantStatus.getTime());
		if (jvmStatusModel.getxAxis().size() > 10) {
			jvmStatusModel.getxAxis().remove(0);
		}
		
		
		if (jvmStatusModel.getDatas().size() < 4) {
			
			CartesianSeries process = new CartesianSeries();
			CartesianSeries heapUsage = new CartesianSeries();
			CartesianSeries nonHeapUsage = new CartesianSeries();
			CartesianSeries classCount = new CartesianSeries();
			
			jvmStatusModel.getDatas().add(process);
			jvmStatusModel.getDatas().add(heapUsage);
			jvmStatusModel.getDatas().add(nonHeapUsage);
			jvmStatusModel.getDatas().add(classCount);
		}
		
		jvmStatusModel.getDatas().get(0)
				.add(instantStatus.getTime(), instantStatus.getProcessNumber());
		jvmStatusModel.getDatas().get(0).setLabel("Process count");
		if (jvmStatusModel.getDatas().get(0).getData().size() > 10) {
			jvmStatusModel.getDatas().get(0).getData().remove(0);
		}

		jvmStatusModel.getDatas().get(1)
				.add(instantStatus.getTime(), instantStatus.getHeapUsage());
		jvmStatusModel.getDatas().get(1).setLabel("Heap Usage");
		if (jvmStatusModel.getDatas().get(1).getData().size() > 10) {
			jvmStatusModel.getDatas().get(1).getData().remove(0);
		}
		
		jvmStatusModel.getDatas().get(2)
				.add(instantStatus.getTime(), instantStatus.getNonHeapUsage());
		jvmStatusModel.getDatas().get(2).setLabel("Non Heap Usage");
		if (jvmStatusModel.getDatas().get(2).getData().size() > 10) {
			jvmStatusModel.getDatas().get(2).getData().remove(0);
		}
		
		jvmStatusModel.getDatas().get(3)
				.add(instantStatus.getTime(), instantStatus.getClassesCount());
		jvmStatusModel.getDatas().get(3).setLabel("Class Count");
		if (jvmStatusModel.getDatas().get(3).getData().size() > 10) {
			jvmStatusModel.getDatas().get(3).getData().remove(0);
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
