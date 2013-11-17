package org.monitor.viewmodels;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.monitor.models.Department;
import org.monitor.services.IISService;

/**
 * Managed bean of the Department management view
 * 
 * @author khalil.amdouni
 * 
 */
@ManagedBean
@ViewScoped
public class DepartmentMB implements Serializable {

	private static final long serialVersionUID = -3235698619863948876L;

	@ManagedProperty(value = "#{isService}")
	private IISService isService;
	
	private Department department;

	@PostConstruct
	private void init() {
		department = new Department();
	}
	
	public long getId() {
		return department.getId();
	}

	public void setId(long id) {
		department.setId(id);
	}

	public String getName() {
		return department.getName();
	}

	public void setName(String name) {
		department.setName(name);
	}

	public String getDescription() {
		return department.getDescription();
	}

	public void setDescription(String description) {
		department.setDescription(description);
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public void save(ActionEvent event) {
		isService.saveDepartment(department);
	}

	public IISService getIsService() {
		return isService;
	}

	public void setIsService(IISService isService) {
		this.isService = isService;
	}

}
