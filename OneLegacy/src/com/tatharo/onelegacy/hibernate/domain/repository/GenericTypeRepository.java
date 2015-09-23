package com.tatharo.onelegacy.hibernate.domain.repository;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class GenericTypeRepository<T> {
	public GenericTypeRepository(SessionFactory sf) {
		this.sf = sf;
	}

	private final SessionFactory sf;

	@Transactional
	public void saveObject(T t) {
		sf.getCurrentSession().save(t);
	}

	@Transactional
	public void updateObject(T t) {
		sf.getCurrentSession().update(t);
	}
}
