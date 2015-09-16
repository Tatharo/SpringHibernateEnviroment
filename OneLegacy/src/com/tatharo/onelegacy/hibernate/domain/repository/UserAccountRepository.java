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
	public void updateUserAccount(UserAccount userAccount){
		sf.getCurrentSession().update(userAccount);
	}

	@Transactional
	public void saveUserAccount(UserAccount userAccount) {
		sf.getCurrentSession().save(userAccount);
	}

	@Transactional
	public boolean isEmailAvailable(String email) {
		String hql = "FROM UserAccount WHERE email=:email";
		Query query = sf.getCurrentSession().createQuery(hql);
		query.setString("email", email);
		@SuppressWarnings("unchecked")
		List<UserAccount> tempList = (List<UserAccount>) query.list();
		if (tempList.size() == 0)
			return false;
		return true;
	}

	@Transactional
	public boolean isUserNameAvailable(String userName) {
		String hql = "FROM UserAccount WHERE userName=:userName";
		Query query = sf.getCurrentSession().createQuery(hql);
		query.setString("userName", userName);
		@SuppressWarnings("unchecked")
		List<UserAccount> tempList = (List<UserAccount>) query.list();
		if (tempList.size() == 0)
			return false;
		return true;
	}

	@Transactional
	public UserAccount getByUserName(String userName) {
		String hql = "FROM UserAccount WHERE userName=:userName";
		Query query = sf.getCurrentSession().createQuery(hql);
		query.setString("userName", userName);
		@SuppressWarnings("unchecked")
		List<UserAccount> tempList = (List<UserAccount>) query.list();
		if (tempList.size() == 0)
			return null;
		return tempList.get(0);
	}
}
