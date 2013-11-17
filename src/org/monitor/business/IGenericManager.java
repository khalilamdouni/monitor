package org.monitor.business;

import java.io.Serializable;

import org.monitor.dao.IGenericDao;

/**
 * The interface of the Generic business manager
 * 
 * @author khalil.amdouni
 *
 * @param <T>
 */
public interface IGenericManager<T> extends Serializable {

	public IGenericDao<T> getDao();

	public T save(T t);

	public T get(Object id);

	public void delete(Object id);
}
