package com.tatharo.onelegacy.hibernate.domain.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.tatharo.onelegacy.hibernate.domain.model.AccountTriggers;

public class AccountTriggersRepository {
	@Autowired
	public AccountTriggersRepository(SessionFactory sf) {
		this.sf = sf;
	}

	private final SessionFactory sf;

	@Transactional
	public void saveAccountTriggers(AccountTriggers accountTriggers) {
		sf.getCurrentSession().save(accountTriggers);
	}

	@Transactional
	public void updateAccountTriggers(AccountTriggers accountTriggers) {
		sf.getCurrentSession().update(accountTriggers);
	}
}
