package org.monitor.viewmodels;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.monitor.business.IDepartmentManager;
import org.monitor.models.Department;

/**
 * Managed bean of the Department management view
 * 
 * @author khalil.amdouni
 * 
 */
@ManagedBean
@ViewScoped
public class DepartmentMB {

	@ManagedProperty(value = "#{consoleService}")
	private IDepartmentManager departmentManager;
	
	private Department department;

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

	public IDepartmentManager getDepartmentManager() {
		return departmentManager;
	}

	public void setDepartmentManager(IDepartmentManager departmentManager) {
		this.departmentManager = departmentManager;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public void save(ActionEvent event) {
		departmentManager.save(department);
	}

}
