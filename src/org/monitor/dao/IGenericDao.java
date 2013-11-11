package org.monitor.dao;

/**
 * Generic dao interface
 * 
 * @author khalil.amdouni
 * 
 * @param <T>
 */
public interface IGenericDao<T> {

	public T save(T t);

	public T getById(Object id);

	public void delete(Object id);
}
