package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Vendor;
import com.app.service.IVendorService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private IVendorService vendorService;

	public AdminController() {
		System.out.println("in admin controller ctor");
	}

	// req handling method to display the vendor list
	@GetMapping("/list")
	public String showVendorList(Model map) {
		System.out.println("in show vendor list");
		map.addAttribute("vendor_list", vendorService.listVendors());
		return "/admin/list";// server pull : logical view name

	}

	// req handling method to delete vendor details
	@GetMapping("/delete")
	public String deleteVendorDetails(@RequestParam int vid, RedirectAttributes flashMap) {
		System.out.println("in del vendor " + vid);
		// invoke service 's method
		flashMap.addFlashAttribute("status", vendorService.deleteVendorDetails(vid));
		return "redirect:/admin/list";
		// redirect view name : resp.sendRedirect(resp.encodeRedirectURL("/admin/list"))

	}

	// request handling method to show vendor reg form
	@GetMapping("/add")
	public String showVendorRegForm(Vendor v) {
		System.out.println("in show reg form" + v);// empty pojo chks for any matching rq para with pojo property name
		// simply create empty POJO instance n add it in model map #1 in form binding
		// map.addAttribute("vendor_details",new Vendor());
		// map.addAttribute("roles", Role.values());
		// map.addSttribute("vendor",new Vendor()); SC
		return "/admin/add";// actual view name /WEB-INF/views/admin/add.jsp
	}

	// request handling method : for processing the form
	@PostMapping("/add")
	public String processRegForm(Vendor v, RedirectAttributes flashMap) {
		System.out.println("in process reg form " + v);// populated vendor details (except id)
		// v : TRANSIENT
		// invoke service --dao -- persist
		flashMap.addFlashAttribute("status", vendorService.addVendorDetails(v));
		// after reg ---redirect clnt in the next req to display vendor list

		return "redirect:/admin/list";
	}

}
