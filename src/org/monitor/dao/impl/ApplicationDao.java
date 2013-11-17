package org.monitor.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.monitor.dao.IApplicationDao;
import org.monitor.models.Application;

/**
 * Dao implementation for Application entity
 * 
 * @author khalil.amdouni
 * 
 */
public class ApplicationDao extends GenericDao<Application> implements
		IApplicationDao {

	private static final long serialVersionUID = 7501938990500081935L;

	public ApplicationDao() {
		super(Application.class);
	}

	@Override
	public List<Application> getApplicationByDept(long deptId) {
		TypedQuery<Application> query = em.createNamedQuery(
				"Application.getApplicationByDept", Application.class);
		query.setParameter("deptId", deptId);
		return query.getResultList();
	}

}
