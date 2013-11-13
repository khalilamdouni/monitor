package org.monitor.services.impl;

import org.monitor.business.IDepartmentManager;
import org.monitor.models.Department;
import org.monitor.services.IISService;

public class ISService implements IISService {

	private static final long serialVersionUID = -1476611105234427424L;

	private IDepartmentManager departmentManager;
	
	@Override
	public Department saveDepartment(Department department) {
		return departmentManager.save(department);
	}

	public IDepartmentManager getDepartmentManager() {
		return departmentManager;
	}

	public void setDepartmentManager(IDepartmentManager departmentManager) {
		this.departmentManager = departmentManager;
	}
	
}
