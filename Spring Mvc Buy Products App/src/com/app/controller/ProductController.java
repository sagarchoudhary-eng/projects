package com.app.controller;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Product;
import com.app.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	// dependency : service layer i/f
	@Autowired //field level D.I
	private IProductService service;// SC tries to locate : any class which has implemented IProductService : YES

	public ProductController() {
		System.out.println("in ctor of " + getClass().getName()+" "+service);//null
	}
	@PostConstruct
	public void myInit()
	{
		System.out.println("in init "+service);//not null
	}

	// what will be the entry in HandlerMapping bean ?
	// key : /product/add + method=get
	// value : com.app.controller.ProductController.testRequestParams +
	// dependencies(req params, model map)
	// product/add?name=pen&category=stationary&price=50.5&qty=3&creation_date=12/25/2010"
	// def date time pattern for SC : mon/day/yr
	// How to tell SC about actual date time format : @DateTimeFormat
	// req handling method
	// read req params --create a product instance --add it as a model attr -- rets
	// logical view name to D.S
	@GetMapping("/add") // @getMapping => @RequestMapping(method = RequestMethod.GET)
	public String testRequestParams(@RequestParam String name, @RequestParam(name = "category") String category123,
			@RequestParam double price, @RequestParam int qty,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate creation_date, Model modelMap)

	{
		System.out.println(
				"in test req params " + name + " " + category123 + " " + price + " " + qty + " " + creation_date);
		// create transient product POJO
		Product p1 = new Product(name, category123, price, creation_date, qty);
		// how to send this Product pojo to view layer : via model attribute
		modelMap.addAttribute("product_dtls", p1);
		return "/product/add";// what will be actual view name : /WEB-INF/views/product/add.jsp
	}

	// add new req handling method to display all products
	@GetMapping("/list")
	public String showProductList(Model modelMap) {
		System.out.println("in show products");
		//invoke service layer method -- save propduct list as model attr
		modelMap.addAttribute("product_list", service.listAllProducts());
		return "/product/list";//actual view name : WEB-INF/views/product/list.jsp
	}

}
