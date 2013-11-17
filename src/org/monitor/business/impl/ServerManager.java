package org.monitor.business.impl;

import java.util.List;

import org.monitor.business.IServerManager;
import org.monitor.dao.IGenericDao;
import org.monitor.dao.IServerDao;
import org.monitor.models.Server;

/**
 * @see org.monitor.business.IServerManager
 * 
 * @author khalil.amdouni
 * 
 */
public class ServerManager extends GenericManager<Server> implements
		IServerManager {

	private static final long serialVersionUID = -2178077499309332597L;
	private IServerDao serverDao;

	@Override
	public IGenericDao<Server> getDao() {
		return (IGenericDao<Server>) serverDao;
	}

	@Override
	public Server save(Server t) {
		return serverDao.save(t);
	}

	@Override
	public Server get(Object id) {
		return serverDao.getById(id);
	}

	@Override
	public void delete(Object id) {
		serverDao.delete(id);
	}

	@Override
	public List<Server> getServersByApp(long appId) {
		return serverDao.getServersByApp(appId);
	}

	public IServerDao getServerDao() {
		return serverDao;
	}

	public void setServerDao(IServerDao serverDao) {
		this.serverDao = serverDao;
	}

}
