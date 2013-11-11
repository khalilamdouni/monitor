package org.monitor.dao;

import java.util.List;

import org.monitor.models.Application;

public interface IApplicationDao extends IGenericDao<Application> {
	
	public List<Application> getApplicationByDept(long deptId);
	
}
