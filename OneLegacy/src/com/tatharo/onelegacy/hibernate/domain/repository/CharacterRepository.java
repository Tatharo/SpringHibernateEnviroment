package com.tatharo.onelegacy.hibernate.domain.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tatharo.onelegacy.hibernate.domain.model.Character;

@Repository
public class CharacterRepository{
	@Autowired
	public CharacterRepository(SessionFactory sf){
		this.sf = sf;
	}
	private SessionFactory sf;
	@Transactional
	public void saveCharacterToUserAccount(Character character){
		sf.getCurrentSession().save(character);
	}
	@Transactional
	public void updateCharacter(Character character){
		sf.getCurrentSession().update(character);
	}
	@Transactional
	public void updateCharacterGuildRank(Character character){
		//TODO: Consider HQL string to only update guild rank based on ID rather than whole object
	}
	
}
