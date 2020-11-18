package com.app.dao;

import java.util.Date;
import java.util.List;

import com.app.pojos.Flight;


public interface IFlightDao  {
	
		List<Flight> getAllFlights(String fromCity,String toCity,Date departureDate);
		public Flight flightSelected(int id);
}
