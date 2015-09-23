package com.tatharo.onelegacy.hibernate.domain.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tatharo.onelegacy.hibernate.domain.model.ApplicationData;

public class ApplicationDataRepository extends GenericTypeRepository<ApplicationData>{
	@Autowired
	public ApplicationDataRepository(SessionFactory sf) {
		super(sf);
	}
}
