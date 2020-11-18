package com.app.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IFlightDao;
import com.app.dao.IPassengerDao;
import com.app.pojos.Passenger;
import com.app.pojos.Payment;

@Controller
@RequestMapping("/pass")
public class PaymentController {

	@Autowired
	private IPassengerDao passDao;
	
	@Autowired
	private IFlightDao flightDao;
	

	
	
	 @GetMapping("/payment")
	 public String showPaymentCard() {
		 System.out.println("in show payment :");
		 return "/pass/payment";
	 }
	 
	 @PostMapping("/payment")
		public String processPaymentCard(@RequestParam Integer cardNumber,@RequestParam String name,@RequestParam int id,
				@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate expDate,@RequestParam int cvv,RedirectAttributes flashMap)
			{
		 	
		 Payment c= new Payment(cardNumber, name, expDate, cvv);
		 Passenger a= passDao.PassengerSelected(id);
		
		a.savePayment(c);
			System.out.println("in process passenger form "+c);//populated vendor details (except id)
			// v : TRANSIENT
			//invoke service --dao -- persist
			flashMap.addFlashAttribute("status",passDao.confirmPayment(c));
			//after reg ---redirect clnt in the next req to display vendor list
			
			return "redirect:/User/status";
			}

	
	

}
