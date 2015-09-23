package com.tatharo.onelegacy.hibernate.domain.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tatharo.onelegacy.hibernate.domain.model.WoWCharacter;

@Repository
public class CharacterRepository extends GenericTypeRepository<WoWCharacter> {
	@Autowired
	public CharacterRepository(SessionFactory sf) {
		super(sf);
		// this.sf = sf;
	}
	// private final SessionFactory sf;

	// @Transactional
	// public List<WoWCharacter> GetNEWMEMBERWoWCharacterList(WoWCharacter
	// wowCharacter){
	// TODO Return List for Setting Ranks
	// }
}
