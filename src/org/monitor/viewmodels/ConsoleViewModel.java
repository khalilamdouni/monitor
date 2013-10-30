package org.monitor.viewmodels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.icefaces.ace.component.chart.Axis;
import org.icefaces.ace.component.chart.AxisType;
import org.icefaces.ace.event.DateSelectEvent;
import org.icefaces.ace.model.chart.CartesianSeries;
import org.monitor.services.impl.ConsoleService;

/**
 * Managed Bean of the console view
 * 
 * @author khalil.amdouni
 * 
 */
@ManagedBean
@ViewScoped
public class ConsoleViewModel implements Serializable {

	private static final long serialVersionUID = -940411728774481761L;

	@ManagedProperty(value = "#{consoleService}")
	private ConsoleService consoleService;

	private Date selectDateProperty = new Date(System.currentTimeMillis());

	public static final String BEAN_NAME = "chartLineBean";

	public List<CartesianSeries> getLineData() {
		return new ArrayList<CartesianSeries>() {
			{
				add(new CartesianSeries() {
					{
						add("Nickle", 28);
						add("Aluminum", 13);
						add("Xenon", 54);
						add("Silver", 47);
						add("Sulfur", 16);
						add("Silicon", 14);
						add("Vanadium", 23);
						setLabel("Time / Memory Space");
					}
				});
			}
		};
	}

	public Axis[] getyAxes() {
		return new Axis[] { new Axis() {
			{
				setAutoscale(true);
				setTickInterval("5");
				setLabel("ms");
			}
		} };
	}

	public Axis getxAxis() {
		return new Axis() {
			{
				setTicks(new String[] { "Nickle", "Aluminum", "Xenon",
						"Silver", "Sulfur", "Silicon", "Vanadium" });
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
		consoleService.getJVMStatus();
		setSelectDateProperty(event.getDate());
	}

	public ConsoleService getConsoleService() {
		return consoleService;
	}

	public void setConsoleService(ConsoleService consoleService) {
		this.consoleService = consoleService;
	}
}
