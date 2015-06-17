package com.duyanh.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.duyanh.repository.TodoRepositoryCustom;

public class TodoRepositoryImpl implements TodoRepositoryCustom {
	
	@PersistenceContext
	private EntityManager em;

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	

}
