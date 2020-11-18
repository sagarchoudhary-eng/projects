package com.app.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.pojos.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
	public ProductController() {
		System.out.println("in product controller");
	}
	//product/show/10/mango/100/2020-05-15
	//URI variables represnted by template vars
	@GetMapping("/show/{pid}/{pName}/{price}/{expDate}")
	public @ResponseBody String testPathVars(@PathVariable int pid,@PathVariable(name = "pName") String prodName,
			@PathVariable double price,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate expDate) {
		System.out.println("in test path vars"+price+" "+expDate);
		return "Product Details:"+pid+" "+price;
	}
	
	@GetMapping("/show2/{pid}/{pName}/{price}/{expDate}")
	public @ResponseBody Product testPathVars1(@PathVariable int pid,@PathVariable(name = "pName") String prodName,
			@PathVariable double price,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate expDate) {
		System.out.println("in test path vars"+price+" "+expDate);
		return new Product(pid,prodName,price,expDate);
	}
}
