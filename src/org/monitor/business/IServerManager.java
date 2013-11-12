package org.monitor.business;

import java.util.List;

import org.monitor.models.Server;

/**
 * Business interface providing Servers management methods
 * 
 * @author khalil.amdouni
 *
 */
public interface IServerManager extends IGenericManager<Server> {

	public List<Server> getServersByApp(long appId);
}
