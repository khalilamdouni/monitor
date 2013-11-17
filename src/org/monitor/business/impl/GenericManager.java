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

	private static final long serialVersionUID = 7366847178014224225L;

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
