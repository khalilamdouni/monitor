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

		JVMInstantStatusModel instantStatus = monitoringEngine.getJVMStatus();
		jvmStatusModel.getxAxis().add(instantStatus.getTime());
		if (jvmStatusModel.getxAxis().size() > 10) {
			jvmStatusModel.getxAxis().remove(0);
		}
		if (jvmStatusModel.getProcessDatas().size() == 0) {
			CartesianSeries process = new CartesianSeries();
			jvmStatusModel.getProcessDatas().add(process);
		}
		if (jvmStatusModel.getHeapUsageDatas().size() == 0) {
			CartesianSeries heapUsage = new CartesianSeries();
			jvmStatusModel.getHeapUsageDatas().add(heapUsage);
		}
		if (jvmStatusModel.getNonHeapUsageDatas().size() == 0) {
			CartesianSeries nonHeapUsage = new CartesianSeries();
			jvmStatusModel.getNonHeapUsageDatas().add(nonHeapUsage);
		}
		if (jvmStatusModel.getClassCountDatas().size() == 0) {
			CartesianSeries classCount = new CartesianSeries();
			jvmStatusModel.getClassCountDatas().add(classCount);
		}
		jvmStatusModel.getProcessDatas().get(0)
				.add(instantStatus.getTime(), instantStatus.getProcessNumber());
		jvmStatusModel.getProcessDatas().get(0).setLabel("Process count");
		if (jvmStatusModel.getProcessDatas().get(0).getData().size() > 10) {
			jvmStatusModel.getProcessDatas().get(0).getData().remove(0);
		}
		jvmStatusModel.getHeapUsageDatas().get(0)
				.add(instantStatus.getTime(), instantStatus.getHeapUsage());
		jvmStatusModel.getHeapUsageDatas().get(0).setLabel("Heap Usage");
		if (jvmStatusModel.getHeapUsageDatas().get(0).getData().size() > 10) {
			jvmStatusModel.getHeapUsageDatas().get(0).getData().remove(0);
		}
		jvmStatusModel.getNonHeapUsageDatas().get(0)
				.add(instantStatus.getTime(), instantStatus.getNonHeapUsage());
		jvmStatusModel.getNonHeapUsageDatas().get(0).setLabel("Non Heap Usage");
		if (jvmStatusModel.getNonHeapUsageDatas().get(0).getData().size() > 10) {
			jvmStatusModel.getNonHeapUsageDatas().get(0).getData().remove(0);
		}
		jvmStatusModel.getClassCountDatas().get(0)
				.add(instantStatus.getTime(), instantStatus.getClassesCount());
		jvmStatusModel.getClassCountDatas().get(0).setLabel("Class Count");
		if (jvmStatusModel.getClassCountDatas().get(0).getData().size() > 10) {
			jvmStatusModel.getClassCountDatas().get(0).getData().remove(0);
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

	@Override
	public void launchGarbageCollector() {
		monitoringEngine.launchGarbageCollector();
	}
}
