package com.tatharo.hibernate.domain.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

<<<<<<< HEAD:OneLegacy/src/com/tatharo/onelegacy/hibernate/domain/repository/CharacterRepository.java
import com.tatharo.onelegacy.hibernate.domain.model.GuildRank;
import com.tatharo.onelegacy.hibernate.domain.model.UserAccount;
import com.tatharo.onelegacy.hibernate.domain.model.WoWCharacter;
=======
import com.tatharo.hibernate.domain.model.WoWCharacter;
>>>>>>> 13da0488a84839b6aac614be61dbda235ab06a8a:GameRecruitmentBackEnd/src/com/tatharo/hibernate/domain/repository/CharacterRepository.java

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
