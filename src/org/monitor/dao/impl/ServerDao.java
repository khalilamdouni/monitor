package org.monitor.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.monitor.dao.IServerDao;
import org.monitor.models.Server;

/**
 * Dao implementation for Application entity
 * 
 * @author khalil.amdouni
 * 
 */
public class ServerDao extends GenericDao<Server> implements IServerDao {

	private static final long serialVersionUID = -3676442020900088936L;

	public ServerDao() {
		super(Server.class);
	}

	@Override
	public List<Server> getServersByApp(long appId) {
		TypedQuery<Server> query = em.createNamedQuery(
				"Server.getServersByApp", Server.class);
		query.setParameter("appId", appId);
		return query.getResultList();
	}

}
