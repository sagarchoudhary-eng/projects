package com.app.dao;


import com.app.pojos.Passenger;
import com.app.pojos.Payment;


public interface IPassengerDao {
	
	public Passenger addPassengerDetails(Passenger p) ;
	public Passenger PassengerSelected(int id);

	public String confirmPayment(Payment c);
}
