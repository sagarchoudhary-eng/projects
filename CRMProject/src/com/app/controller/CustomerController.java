package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.entity.Customer;
import com.app.service.IService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//need to inject the customer dao
	@Autowired
	private IService customerService;
	
	//@RequestMapping("/list")
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		//get customers from the dao
		List<Customer> theCustomers = customerService.getCustomers();
		//add the customers to the model
		
		theModel.addAttribute("customers",theCustomers);
		return "/list-customers";
	}
}
