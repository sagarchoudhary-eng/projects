package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IFlightDao;
import com.app.dao.IPassengerDao;
import com.app.pojos.Flight;
import com.app.pojos.Passenger;

@Controller
public class PassengerController {
	@Autowired
	private IPassengerDao passDao;
	
	@Autowired
	private IFlightDao flightDao;
	
	

	@GetMapping("/passengerDetails")
	public String showPassengerRegPage(@RequestParam int flightId,Model map) {
		System.out.println("in passenger reg page");

		map.addAttribute("passenger", flightDao.flightSelected(flightId));

		return "/pass/passengerDetails";
	}
	
	 @PostMapping("/passengerDetails")
		public String processPassengerForm(@RequestParam String firstName,@RequestParam String email
				,@RequestParam String address,@RequestParam String passportNumber,@RequestParam String phoneNumber,@RequestParam int flightId,RedirectAttributes flashMap)
			{
		 Passenger p=new Passenger(firstName,email,address,passportNumber,phoneNumber);
		 Flight f= flightDao.flightSelected(flightId);
		
		 f.savePass(p);
		
			System.out.println("in process passenger form "+p);//populated vendor details (except id)
			// v : TRANSIENT
			//invoke service --dao -- persist
			flashMap.addFlashAttribute("savePassenger",passDao.addPassengerDetails(p));
			//after reg ---redirect clnt in the next req to display vendor list
			
			return "redirect:/pass/payment";
			}

	
	
	
}
