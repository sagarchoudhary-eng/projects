package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Customer;


@Repository
public class CustomerDaoImpl implements ICustomerDao{
	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	
	public List<Customer> getCustomers() {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//create query
		String jpql ="select c from Customer c";
		Query<Customer> theQuery = currentSession.createQuery(jpql,Customer.class);
		//execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		//return results
		
		return customers;
	}
	
}
