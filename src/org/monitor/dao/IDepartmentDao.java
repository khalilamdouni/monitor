package org.monitor.dao;

import java.util.List;

import org.monitor.models.Department;

/**
 * Dao interface for Department entity
 * 
 * @author khalil.amdouni
 *
 */
public interface IDepartmentDao extends IGenericDao<Department> {
	
	public List<Department> getAllDepartments();
	
}
