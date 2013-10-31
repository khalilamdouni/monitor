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

	private Date selectDateProperty = new Date(System.currentTimeMillis());

	public static final String BEAN_NAME = "chartLineBean";

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
				setTicks((String[])jvmStatusModel.getxAxis().toArray());
				setType(AxisType.CATEGORY);
			}
		};
	}

	public Date getSelectDateProperty() {
		selectDateProperty = new Date(System.currentTimeMillis());
		return selectDateProperty;
	}

	public void setSelectDateProperty(Date selectDateProperty) {
		this.selectDateProperty = selectDateProperty;
	}

	public void dateSelectListener(DateSelectEvent event) {
		consoleService.updateJVMStatus(jvmStatusModel);
		setSelectDateProperty(event.getDate());
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
	
}
