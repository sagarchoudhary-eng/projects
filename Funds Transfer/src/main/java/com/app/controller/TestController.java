package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dummy")
public class TestController {
	public TestController() {
		System.out.println("in ctor of test controller");
	}

	@GetMapping
	public List<String> test() {
		System.out.println("in test");
		return Arrays.asList("abc","454","vcnv456","tut");
	}
}
