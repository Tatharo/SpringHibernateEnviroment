package com.tatharo.onelegacy.hibernate.domain.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tatharo.onelegacy.hibernate.domain.model.GuildRank;
import com.tatharo.onelegacy.hibernate.domain.model.UserAccount;
import com.tatharo.onelegacy.hibernate.domain.model.WoWCharacter;

@Repository
public class CharacterRepository extends GenericTypeRepository<WoWCharacter> {
	@Autowired
	public CharacterRepository(SessionFactory sf) {
		super(sf);
		this.sf = sf;
	}

	private final SessionFactory sf;

//	@Transactional
//	 public List<WoWCharacter> GetNEWMEMBERWoWCharacterList(){
////		 String hql = "FROM WoWCharacter WHERE rank=:rank";
////		 Query query = sf.getCurrentSession().createQuery(hql);
////		 query.setLong("guildrank", GuildRank.NEWMEMBER);
//			return (List<WoWCharacter>) query.list();
//	 }
}
