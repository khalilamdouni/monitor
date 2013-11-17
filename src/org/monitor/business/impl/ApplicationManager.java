package org.monitor.business.impl;

import java.util.List;

import org.monitor.business.IApplicationManager;
import org.monitor.dao.IApplicationDao;
import org.monitor.dao.IGenericDao;
import org.monitor.models.Application;

/**
 * @see org.monitor.business.IApplicationManager
 * 
 * @author khalil.amdouni
 *
 */
public class ApplicationManager extends GenericManager<Application> implements
		IApplicationManager {

	private static final long serialVersionUID = 1773144579357623702L;
	private IApplicationDao applicationDao;
	
	@Override
	public IGenericDao<Application> getDao() {
		return (IGenericDao<Application>) applicationDao;
	}

	@Override
	public Application save(Application t) {
		return applicationDao.save(t);
	}

	@Override
	public Application get(Object id) {
		return applicationDao.getById(id);
	}

	@Override
	public void delete(Object id) {
		applicationDao.delete(id);
	}

	@Override
	public List<Application> getApplicationByDept(long deptId) {
		return applicationDao.getApplicationByDept(deptId);
	}

	public IApplicationDao getApplicationDao() {
		return applicationDao;
	}

	public void setApplicationDao(IApplicationDao applicationDao) {
		this.applicationDao = applicationDao;
	}

}
