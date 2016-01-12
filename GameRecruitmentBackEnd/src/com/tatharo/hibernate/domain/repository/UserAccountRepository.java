package com.tatharo.hibernate.domain.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tatharo.hibernate.domain.model.UserAccount;

@Repository
public class UserAccountRepository extends GenericTypeRepository<UserAccount> {
	/**
	 * Queries required for UserAccount Transactions
	 * 
	 * @param sf
	 */
	@Autowired
	public UserAccountRepository(SessionFactory sf) {
		super(sf);
		this.sf = sf;
	}

	private final SessionFactory sf;
/**
 * Checks if a userAccount with requested email already exists
 * 
 * @param email
 * @return
 */
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

	/**
	 * 
	 * Checks if userName is in use
	 * 
	 * @param userName
	 * @return
	 */
	//TODO: Query returns boolean instead of a userAccount?
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

	/**
	 * Search for a UserAccount with a specific userName
	 * 
	 * @param userName
	 * @return
	 */
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
