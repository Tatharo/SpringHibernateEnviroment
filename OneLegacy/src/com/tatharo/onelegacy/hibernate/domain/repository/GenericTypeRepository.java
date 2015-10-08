package com.tatharo.onelegacy.hibernate.domain.repository;

import org.hibernate.SessionFactory;

public class GenericTypeRepository<T> {
	public GenericTypeRepository(SessionFactory sf) {
		this.sf = sf;
	}

	private final SessionFactory sf;

	public void saveObject(T t) {
		sf.getCurrentSession().save(t);
	}

	
	public void updateObject(T t) {
		sf.getCurrentSession().update(t);
	}
}
