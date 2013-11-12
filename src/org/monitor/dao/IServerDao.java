package org.monitor.dao;

import java.util.List;

import org.monitor.models.Server;

/**
 * Dao interface for Server entity
 * 
 * @author khalil.amdouni
 *
 */
public interface IServerDao extends IGenericDao<Server> {
	
	public List<Server> getServersByApp(long appId);
	
}
