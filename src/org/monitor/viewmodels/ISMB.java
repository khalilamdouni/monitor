package org.monitor.viewmodels;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.monitor.models.Department;
import org.monitor.services.IISService;

/**
 * Managed Bean for Information system management View
 * 
 * @author khalil.amdouni
 *
 */
@ManagedBean
@ViewScoped
public class ISMB implements Serializable {

	private static final long serialVersionUID = -4096125912045650243L;

	@ManagedProperty("#{isService}")
	private IISService isService;
	
	private List<Department> departments;
	
	private Department selectedDepartment;
	
	@PostConstruct
	private void init() {
		this.departments = isService.getDepartments();
	}

	public IISService getIsService() {
		return isService;
	}

	public void setIsService(IISService isService) {
		this.isService = isService;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public Department getSelectedDepartment() {
		return selectedDepartment;
	}

	public void setSelectedDepartment(Department selectedDepartment) {
		this.selectedDepartment = selectedDepartment;
	}

}
