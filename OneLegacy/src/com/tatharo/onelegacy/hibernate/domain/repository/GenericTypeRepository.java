package com.tatharo.onelegacy.hibernate.domain.repository;

import org.hibernate.SessionFactory;

/**
 * 
 * Class containing general database transaction methods
 *
 * @param <T>
 */
public class GenericTypeRepository<T> {
	public GenericTypeRepository(SessionFactory sf) {
		this.sf = sf;
	}

	private final SessionFactory sf;

	/**
	 * Saves new object of Type T into the database
	 * 
	 * @param t
	 */
	public void saveObject(T t) {
		sf.getCurrentSession().save(t);
	}

	/**
	 * Updates object of Type T to the database
	 * 
	 * @param t
	 */
	public void updateObject(T t) {
		sf.getCurrentSession().update(t);
	}
}
