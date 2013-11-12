package org.monitor.business;

import java.util.List;

import org.monitor.models.Department;

/**
 * Business interface providing Departments management methods
 * 
 * @author khalil.amdouni
 *
 */
public interface IDepartmentManager extends IGenericManager<Department> {

	public List<Department> getAllDepartments();
}
