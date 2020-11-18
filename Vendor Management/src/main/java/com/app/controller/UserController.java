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
import com.app.pojos.Role;
import com.app.pojos.Vendor;
import com.app.service.IVendorService;

@Controller
@RequestMapping("/user")
public class UserController {
	//dependency
	@Autowired //autowire=byType
	private IUserDao userDao;
	
	
	public UserController() {
		System.out.println("in user controller ctor "+userDao);
	}
	
	@GetMapping("/login")
	public String showLoginForm()
	{
		System.out.println("in show login form");
		return "/user/login";
	}
	//request handling method : to process form (user validation)
	//key : /user/login +method=post
		//val : UserController.processLoginForm()
	@PostMapping("/login") //@PostMapping=@RequestMapping + request method=post
	public String processLoginForm(@RequestParam String email,
			@RequestParam String password,Model modelMap,HttpSession hs,RedirectAttributes flashMap)
	//4 dependencies injected by SC
	{
		System.out.println("in process login form "+email+" "+password);
		//invoke dao's method for User validation.
		try {
		Vendor authenticateUser = userDao.authenticateUser(email, password);
		//valid login : remember validated user details till logout
		//add it under session scope
		hs.setAttribute("valid_user", authenticateUser);
		//chk role --vendor --forward clnt --details page
		if(authenticateUser.getRole().equals(Role.VENDOR)) {
			flashMap.addFlashAttribute("status", "Vendor Login Successful");
			return "redirect:/vendor/details"; //forward view : actual view name : /WEB-INF/views/vendor/details.jsp
			//SC :response.sendRedirect(response.encodeRedirectURL("/vendor/details"))
			//clnt browser --sends a new req : ... /vendor/details,method=get
		
		}
		//role admin -- redirect clnt --vendor list page (via admin controller ) in the next request
		flashMap.addFlashAttribute("status", "Admin Login Successful");
		return "redirect:/admin/list";//replaces server pull by clnt pull.(to avoid submission)
		//PRG : post---redirect--get
		//UserController ---> redirect view name to ---> D.S
		//D.S : response.sendRedirect(response.encodeRedirectURL("/admin/list"));
		//D.S (WC) ---sends temp redirect resp : SC 302 | location=/admin/list | body : EMPTY
		//Clnt browser sends a NEW request : http://host:port/day14/admin/list : method =get
		
		} catch (RuntimeException e) {
			System.out.println("err in user controller "+e);
			//in case of invalid login : forward the clnt to login form , with suitable err mesg
			modelMap.addAttribute("mesg", "Invalid Login , Pls retry!!!!!!");
			return "/user/login";//forward view (logical) : actual view :  /WEB-INF/views/user/login.jsp
		}
	
		
	}
	//request handling method for user's(admin/vendor) logout
	@GetMapping("/logout")
	public String userLogout(HttpSession session,Model modelMap,HttpServletRequest request,HttpServletResponse resp)
	{
		System.out.println("in logout");
		//How to maintain user details ? : before invalidating the session , store user details under curnt req scope (model)
		modelMap.addAttribute("user_dtls",session.getAttribute("valid_user"));
		//discard HttpSession
		session.invalidate(); //HS object from WC' heap will be marked for GC
	
		
		//how to navigate the clnt auto from logout page  to welcome/index page
		//set refresh header  :  resp header
		//How : HttpServletResponse method : setHeader(nm,val)
		System.out.println("ctx path "+request.getContextPath());
		resp.setHeader("refresh","5;url='"+request.getContextPath()+"/'");//eg : /day15
		//forward the clnt logout.jsp (logical view name) : forward
		return "/user/logout";
		
	}

}
