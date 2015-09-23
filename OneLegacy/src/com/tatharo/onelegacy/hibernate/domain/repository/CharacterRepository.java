package com.tatharo.onelegacy.hibernate.domain.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tatharo.onelegacy.hibernate.domain.model.WoWCharacter;

@Repository
public class CharacterRepository{
	@Autowired
	public CharacterRepository(SessionFactory sf){
		this.sf = sf;
	}
	private final SessionFactory sf;
	@Transactional
	public void saveCharacterToUserAccount(WoWCharacter character){
		sf.getCurrentSession().save(character);
	}
	@Transactional
	public void updateCharacter(WoWCharacter character){
		sf.getCurrentSession().update(character);
	}
	@Transactional
	public void updateCharacterGuildRank(WoWCharacter character){
		//TODO: Consider HQL string to only update guild rank based on ID rather than whole object
	}
	
}
