package com.tatharo.onelegacy.hibernate.domain.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tatharo.onelegacy.hibernate.domain.model.UserAccount;
@Repository
public class UserAccountRepository {
	@Autowired
	private SessionFactory sf;

	@Transactional
	public void saveUserAccount(UserAccount object) {
		sf.getCurrentSession().save(object);
	}
	
	@Transactional
	public boolean isEmailAvailable(String object) {
		String hql = "FROM UserAccount WHERE email=:email";
        Query query = sf.getCurrentSession().createQuery(hql);
        query.setString("email", object);
        List<UserAccount> tempList = (List<UserAccount>) query.list();
		return (tempList.get(0) == null);
	}
	
}
