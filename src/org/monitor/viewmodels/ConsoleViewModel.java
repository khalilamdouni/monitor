package org.monitor.viewmodels;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.icefaces.ace.component.chart.Axis;
import org.icefaces.ace.component.chart.AxisType;
import org.icefaces.ace.model.chart.CartesianSeries;
import org.monitor.models.JVMStatusModel;
import org.monitor.services.IConsoleService;

/**
 * Managed Bean of the console view
 * 
 * @author khalil.amdouni
 * 
 */
@ManagedBean
@SessionScoped
public class ConsoleViewModel implements Serializable {

	private static final long serialVersionUID = -940411728774481761L;

	@ManagedProperty(value = "#{consoleService}")
	private IConsoleService consoleService;
	
	private JVMStatusModel jvmStatusModel = new JVMStatusModel();
	
	public void launchGarbageCollector(ActionEvent event) {
		consoleService.launchGarbageCollector();
	}
	
	public List<CartesianSeries> getProcessLineData() {
		consoleService.updateJVMStatus(jvmStatusModel);
		return jvmStatusModel.getProcessDatas();
	}
	
	public List<CartesianSeries> getHeapUsageLineData() {
		consoleService.updateJVMStatus(jvmStatusModel);
		return jvmStatusModel.getHeapUsageDatas();
	}
	
	public List<CartesianSeries> getNonHeapUsageLineData() {
		consoleService.updateJVMStatus(jvmStatusModel);
		return jvmStatusModel.getNonHeapUsageDatas();
	}
	
	public List<CartesianSeries> getClassCountLineData() {
		consoleService.updateJVMStatus(jvmStatusModel);
		return jvmStatusModel.getClassCountDatas();
	}

	public Axis[] getyProcessAxes() {
		return new Axis[] { new Axis() {
			{
				setAutoscale(true);
				setTickInterval("5");
				setLabel("process");
			}
		} };
	}

	public Axis[] getyHeapUsageAxes() {
		return new Axis[] { new Axis() {
			{
				setAutoscale(true);
				setTickInterval("100000000");
				setLabel("Heap usage");
			}
		} };
	}

	public Axis[] getyNonHeapUsageAxes() {
		return new Axis[] { new Axis() {
			{
				setAutoscale(true);
				setTickInterval("10000000");
				setLabel("non heap usage");
			}
		} };
	}

	public Axis[] getyClassCountAxes() {
		return new Axis[] { new Axis() {
			{
				setAutoscale(true);
				setTickInterval("500");
				setLabel("class count");
			}
		} };
	}


	public Axis getxAxis() {
		
		return new Axis() {
			{
				String[] xAxis = new String[jvmStatusModel.getxAxis().size()];
				xAxis = jvmStatusModel.getxAxis().toArray(xAxis);
				setTicks(xAxis);
				setType(AxisType.CATEGORY);
			}
		};
	}

	public IConsoleService getConsoleService() {
		return consoleService;
	}

	public void setConsoleService(IConsoleService consoleService) {
		this.consoleService = consoleService;
	}

	public JVMStatusModel getJvmStatusModel() {
		return jvmStatusModel;
	}

	public void setJvmStatusModel(JVMStatusModel jvmStatusModel) {
		this.jvmStatusModel = jvmStatusModel;
	}

	public long getProcessNumber() {
		return jvmStatusModel.getProcessNumber();
	}
	
	public Date getServerDate() {
		return new Date(System.currentTimeMillis());
	}

}
