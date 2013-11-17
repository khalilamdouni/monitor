package org.monitor.services;

import java.io.Serializable;
import java.util.List;

import org.monitor.models.Department;

/**
 * Service interface for Information System management 
 * 
 * @author khalil.amdouni
 *
 */
public interface IISService extends Serializable {
	
	public Department saveDepartment(Department department);
	
	public List<Department> getDepartments();
	
}
