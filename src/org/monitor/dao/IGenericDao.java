package org.monitor.dao;

import java.io.Serializable;

/**
 * Generic dao interface
 * 
 * @author khalil.amdouni
 * 
 * @param <T>
 */
public interface IGenericDao<T> extends Serializable {

	public T save(T t);

	public T getById(Object id);

	public void delete(Object id);
}
