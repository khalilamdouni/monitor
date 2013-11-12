package org.monitor.business.impl;

import java.util.List;

import org.monitor.business.IDepartmentManager;
import org.monitor.dao.IDepartmentDao;
import org.monitor.dao.IGenericDao;
import org.monitor.models.Department;

/**
 * @see org.monitor.business.IDepartmentManager
 * 
 * @author khalil.amdouni
 * 
 */
public class DepartmentManager extends GenericManager<Department> implements
		IDepartmentManager {

	private IDepartmentDao departmentDao;

	@Override
	public IGenericDao<Department> getDao() {
		return (IGenericDao<Department>) departmentDao;
	}

	@Override
	public Department save(Department t) {
		return departmentDao.save(t);
	}

	@Override
	public Department get(Object id) {
		return departmentDao.getById(id);
	}

	@Override
	public void delete(Object id) {
		departmentDao.delete(id);
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentDao.getAllDepartments();
	}

	public IDepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(IDepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

}
