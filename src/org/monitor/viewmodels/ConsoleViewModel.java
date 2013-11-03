package org.monitor.viewmodels;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.icefaces.ace.component.chart.Axis;
import org.icefaces.ace.component.chart.AxisType;
import org.icefaces.ace.event.DateSelectEvent;
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
	
	public List<CartesianSeries> getLineData() {
		consoleService.updateJVMStatus(jvmStatusModel);
		return jvmStatusModel.getDatas();
	}

	public Axis[] getyAxes() {
		return new Axis[] { new Axis() {
			{
				setAutoscale(true);
				setTickInterval("5");
				setLabel("process");
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
