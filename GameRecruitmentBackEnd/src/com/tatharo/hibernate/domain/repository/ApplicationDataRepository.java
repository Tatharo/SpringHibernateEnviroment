package com.tatharo.hibernate.domain.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tatharo.hibernate.domain.model.ApplicationData;

@Repository
public class ApplicationDataRepository extends GenericTypeRepository<ApplicationData> {
	@Autowired
	public ApplicationDataRepository(SessionFactory sf) {
		super(sf);
	}
}
