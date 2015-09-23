package com.tatharo.onelegacy.hibernate.domain.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.tatharo.onelegacy.hibernate.domain.model.ApplicationData;

public class ApplicationDataRepository {
	@Autowired
	public ApplicationDataRepository(SessionFactory sf) {
		this.sf = sf;
	}

	private final SessionFactory sf;

	@Transactional
	public void saveApplicationData(ApplicationData applicationData) {
		sf.getCurrentSession().save(applicationData);
	}

	@Transactional
	public void updateAccountTriggers(ApplicationData applicationData) {
		sf.getCurrentSession().update(applicationData);
	}
}
