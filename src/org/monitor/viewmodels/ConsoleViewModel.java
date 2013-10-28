package org.monitor.viewmodels;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.icefaces.ace.event.DateSelectEvent;
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

	public Date getSelectDateProperty() {
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
