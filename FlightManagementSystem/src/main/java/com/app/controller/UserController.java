package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IUserDao;
import com.app.pojos.*;

@Controller
@RequestMapping("/User")
public class UserController {
	@Autowired
	private IUserDao userDao;
	
	@GetMapping("/signUp")
	public String showUserRegForm(User u) {
		System.out.println(" in show Reg form");
		
		return"/User/signUp";
	}
	
	@PostMapping("/signUp")
	public String processUserRegForm(User u,RedirectAttributes flashMap)
	{
		System.out.println("in process reg form "+u);//populated vendor details (except id)
		// v : TRANSIENT
		//invoke service --dao -- persist
		flashMap.addFlashAttribute("status", userDao.addUser(u));
		//after reg ---redirect clnt in the next req to display vendor list
		
		return "/index";
	}

	@GetMapping("/login")
	public String showLoginPage() {
		System.out.println("in login page");
		return "/User/login";
	}

	@PostMapping("/login")
	public String processLoginForm(@RequestParam String email, @RequestParam String password, Model modelMap,
			HttpSession hs, RedirectAttributes flashMap)

	{
		System.out.println("in process login form " + email + " " + password);

		try {
			User authenticateUser = userDao.authenticateUser(email, password);

			hs.setAttribute("valid_user", authenticateUser);

			flashMap.addFlashAttribute("status", "User Login Successful");
			return "redirect:/Airlines/flightSearch";

		} catch (RuntimeException e) {
			System.out.println("err in user controller " + e);
			
			modelMap.addAttribute("mesg", "Invalid Login , Pls retry!!!!!!");
			return "/User/login";
			}

	}
	
	@GetMapping("/status")
	public String userLogout(HttpSession session,Model modelMap,HttpServletRequest request,HttpServletResponse resp)
	{
		System.out.println("in status page");
		//How to maintain user details ? : before invalidating the session , store user details under curnt req scope (model)
		modelMap.addAttribute("valid_user",session.getAttribute("valid_user"));
		//discard HttpSession
		session.invalidate(); //HS object from WC' heap will be marked for GC
	
		
		//how to navigate the clnt auto from logout page  to welcome/index page
		//set refresh header  :  resp header
		//How : HttpServletResponse method : setHeader(nm,val)
		System.out.println("ctx path "+request.getContextPath());
		resp.setHeader("refresh","5;url='"+request.getContextPath()+"/'");//eg : /day15
		//forward the clnt logout.jsp (logical view name) : forward
		return "/User/status";
		
	}
}
