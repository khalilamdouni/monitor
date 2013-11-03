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
	public JVMInstantStatusModel getJVMStatus() {
		JVMInstantStatusModel jvmInstantStatusModel = new JVMInstantStatusModel();
		jvmInstantStatusModel.setTime(new Date().toString());
		
		updateProcessStatus(jvmInstantStatusModel);
		updateClassesCount(jvmInstantStatusModel);
		updateJITStatus(jvmInstantStatusModel);
		updateMemoryStatus(jvmInstantStatusModel);
		
		jvmInstantStatusModel.setMemory(ManagementFactory.getThreadMXBean()
				.getThreadCount());

		return jvmInstantStatusModel;
	}
	
	private void updateProcessStatus(JVMInstantStatusModel jvmInstantStatusModel) {
		jvmInstantStatusModel.setProcessNumber(ManagementFactory.getThreadMXBean()
				.getThreadCount());
	}
	
	private void updateClassesCount(JVMInstantStatusModel jvmInstantStatusModel) {
		jvmInstantStatusModel.setClassesCount(ManagementFactory.getClassLoadingMXBean().getTotalLoadedClassCount());
	}
	
	private void updateJITStatus(JVMInstantStatusModel jvmInstantStatusModel) {
		jvmInstantStatusModel.setJitCompilerName(ManagementFactory.getCompilationMXBean().getName());
		jvmInstantStatusModel.setJitCompilationTime(ManagementFactory.getCompilationMXBean().getTotalCompilationTime());
	}
	
	private void updateMemoryStatus(JVMInstantStatusModel jvmInstantStatusModel) {
		jvmInstantStatusModel.setHeapUsage(ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed());
		jvmInstantStatusModel.setNonHeapUsage(ManagementFactory.getMemoryMXBean().getNonHeapMemoryUsage().getUsed());
		jvmInstantStatusModel.setUnusedObjectNumber(ManagementFactory.getMemoryMXBean().getObjectPendingFinalizationCount());
	}

	@Override
	public void launchGarbageCollector() {
		ManagementFactory.getMemoryMXBean().gc();
	}

}
