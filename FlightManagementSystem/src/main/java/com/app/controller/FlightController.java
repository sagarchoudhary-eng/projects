package com.app.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.IFlightDao;
import com.app.pojos.Flight;

@Controller
@RequestMapping("/Airlines")
public class FlightController {

	@Autowired
	private IFlightDao flightDao;
	@GetMapping("/flightSearch")
	public String showFlightSearchPage()
	{
		System.out.println("in flight Search page");
		return "/Airlines/flightSearch";//actual view name : /WEB-INF/views/login.jsp
	}
	
	
	
	@PostMapping("/flightSearch")
	public String processFlights(@RequestParam String fromCity, @RequestParam String toCity,@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")Date departureDate,
			 Model modelMap,
			HttpSession hs)

	{
		System.out.println("in process login form " + toCity + " " + fromCity);

		try {
			List<Flight> flights = flightDao.getAllFlights(fromCity,toCity,departureDate);

			hs.setAttribute("flight_list", flights);

			return "/Airlines/flightDisplay";

		} catch (RuntimeException e) {
			System.out.println("err in flight controller " + e);
			
			modelMap.addAttribute("mesg", "No flights available for provided details , Pls retry!!!!!!");
			return "/Airlines/flightSearch";
			}

	}
	
	@GetMapping("/flightDisplay")
	public String showFlights()
	{
		System.out.println("in flight display page");
		return "/Airlines/flightDisplay";
	}
	

}
