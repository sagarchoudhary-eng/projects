package com.app.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.User;

@Repository
@Transactional
public class UserDaoImpl implements IUserDao {
	// dependency : javax.persistence.EntityManager
	//@PersistenceContext OR
	@Autowired
	private EntityManager mgr;
	
	@Override
	public String addUser(User u) {
		String mesg="User registraion successful";
		mgr.persist(u);//v : PERSISTENT
		
		return mesg;
	}

	@Override
	public User authenticateUser(String email, String password) {
		String jpql = "select u from User u where u.email=:em and u.password=:pass";
		return mgr.createQuery(jpql, User.class).setParameter("em", email).setParameter("pass", password)
				.getSingleResult();
	}
	

	@Override
	public User userSelected(int id) {
		String jpql="select a from User a where a.id=:id";
		return mgr.createQuery(jpql, User.class).setParameter("id", id).getSingleResult();
	}
	
	

}
