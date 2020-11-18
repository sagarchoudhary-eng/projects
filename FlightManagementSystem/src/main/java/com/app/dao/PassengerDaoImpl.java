package com.app.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Passenger;
import com.app.pojos.Payment;
@Repository
@Transactional
public class PassengerDaoImpl implements IPassengerDao {
	@Autowired
	private EntityManager mgr;

	@Override
	public Passenger addPassengerDetails(Passenger p) {
		
		String mesg="passenger registraion successful";
		mgr.persist(p);//v : PERSISTENT
		
		return p;
	}

	@Override
	public Passenger PassengerSelected(int id) {
		String jpql="select p from Passenger p where p.id=:id";
		return mgr.createQuery(jpql, Passenger.class).setParameter("id", id).getSingleResult();
		
	}




	@Override
	@Transactional
	public String confirmPayment(Payment c) {
		String mesg = "passenger payment successful";
		mgr.persist(c);// v : PERSISTENT 
		return mesg;
	}

	

}
