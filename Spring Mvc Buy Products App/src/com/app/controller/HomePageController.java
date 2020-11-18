package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
	public HomePageController() {
		System.out.println("in ctor of "+getClass().getName());
	}
	//add req handling method to map "/"
	@RequestMapping("/")
	public String showHomePage()
	{
		System.out.println("in show home page");
		return "/index";//rets logical view name
	}

}
