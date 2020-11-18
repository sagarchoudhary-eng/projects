package com.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Vendor;

@Repository
@Transactional
public class UserDaoImpl implements IUserDao {
	// dependency : javax.persistence.EntityManager
	//@PersistenceContext OR
	@Autowired
	private EntityManager mgr;

	@Override
	public Vendor authenticateUser(String email, String pass) {
		String jpql = "select v from Vendor v where v.email=:em and v.password=:pass";
		return mgr.createQuery(jpql, Vendor.class).setParameter("em", email).setParameter("pass", pass)
				.getSingleResult();
	}
	

}
