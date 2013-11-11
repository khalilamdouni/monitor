package org.monitor.dao;

import java.util.List;

import org.monitor.models.Server;

public interface IServerDao extends IGenericDao<Server> {
	
	public List<Server> getServersByApp(long appId);
	
}
