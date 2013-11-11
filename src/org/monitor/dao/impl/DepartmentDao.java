package org.monitor.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.monitor.dao.IDepartmentDao;
import org.monitor.models.Department;

/**
 * Dao implementation for Department entity
 * 
 * @author khalil.amdouni
 * 
 */
public class DepartmentDao extends GenericDao<Department> implements
		IDepartmentDao {

	public DepartmentDao() {
		super(Department.class);
	}

	@Override
	public List<Department> getAllDepartments() {
		TypedQuery<Department> query = em.createNamedQuery(
				"Department.getAllDepartments", Department.class);
		return query.getResultList();
	}

}
