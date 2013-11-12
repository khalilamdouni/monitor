package org.monitor.business;

import java.util.List;

import org.monitor.models.Application;

/**
 * Business interface providing Applications management methods
 * 
 * @author khalil.amdouni
 *
 */
public interface IApplicationManager extends IGenericManager<Application> {

	public List<Application> getApplicationByDept(long deptId);
	
}
