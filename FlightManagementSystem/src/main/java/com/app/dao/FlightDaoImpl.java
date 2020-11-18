package com.app.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Flight;

@Repository
@Transactional
public class FlightDaoImpl implements IFlightDao {
	
	@Autowired
	private EntityManager mgr;


	@Override
	public List<Flight> getAllFlights(String fromCity, String toCity,Date departureDate) {
		String jpql = "select f from Flight f where f.fromCity=:fromCity and f.toCity=:toCity and f.departureDate=:departureDate";//and f.departureDate=departureDate";
		List<Flight> flight = mgr.createQuery(jpql, Flight.class).setParameter("fromCity", fromCity).setParameter("toCity", toCity).setParameter("departureDate", departureDate).getResultList();
		return flight;
	}


	@Override
	public Flight flightSelected(int id) {
		String jpql="select a from Flight a where a.id=:id";
		return mgr.createQuery(jpql, Flight.class).setParameter("id", id).getSingleResult();
	}
	

}
