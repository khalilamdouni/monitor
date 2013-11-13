package org.monitor.services;

import java.io.Serializable;

import org.monitor.models.Department;

/**
 * Service interface for Information System management 
 * 
 * @author khalil.amdouni
 *
 */
public interface IISService extends Serializable {
	
	public Department saveDepartment(Department department);
	
}
