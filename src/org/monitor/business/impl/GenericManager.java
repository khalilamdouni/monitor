package org.monitor.business.impl;

import org.monitor.business.IGenericManager;

/**
 * @see org.monitor.business.IGenericManager
 * 
 * @author khalil.amdouni
 * 
 * @param <T>
 */
public abstract class GenericManager<T> implements IGenericManager<T> {

	@Override
	public T save(T t) {
		return getDao().save(t);
	}

	@Override
	public T get(Object id) {
		return getDao().getById(id);
	}

	@Override
	public void delete(Object id) {
		getDao().delete(id);
	}
}
