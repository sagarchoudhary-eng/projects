package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vendor")
public class VendorController {
	public VendorController() {
		System.out.println("in controller");
	}
	//req method to forward clnt to vendor details page
	@GetMapping("/details")
	public String showVendorDetails() {
		System.out.println("in show vendor dtls");
		return "/vendor/details";	//actula view name:/WEB-INF/views/venodr/details.jsp
	}
}
