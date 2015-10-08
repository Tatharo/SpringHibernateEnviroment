package com.tatharo.onelegacy.hibernate.domain.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tatharo.onelegacy.hibernate.domain.model.AccountTriggers;
@Repository
public class AccountTriggersRepository extends GenericTypeRepository<AccountTriggers>{
	@Autowired
	public AccountTriggersRepository(SessionFactory sf) {
		super(sf);
	}
}
