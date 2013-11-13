package org.monitor.viewmodels;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.monitor.models.Application;

/**
 * Managed bean of the Application management view
 * 
 * @author khalil.amdouni
 *
 */
@ManagedBean
@ViewScoped
public class ApplicationMB {
	
	private Application application;
	
	public long getId() {
		return application.getId();
	}

	public void setId(long id) {
		application.setId(id);
	}

	public String getName() {
		return application.getName();
	}

	public void setName(String name) {
		application.setName(name);
	}

	public String getDescription() {
		return application.getDescription();
	}

	public void setDescription(String description) {
		application.setDescription(description);
	}
	
}
