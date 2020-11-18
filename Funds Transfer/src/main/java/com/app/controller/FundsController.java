package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Fund;
import com.app.service.IFundService;

@RestController
@RequestMapping("/funds")
public class FundsController {
	@Autowired
	private IFundService service;

	public FundsController() {
		System.out.println("in ctor of " + getClass().getName());
	}
//eg : http://host:port/funds/reliance : URI variable
	// eg : http://host:port/funds/cisco : URI variable

	// Objective : In case of populated list : send RespEntity : body : list . sts
	// code 200
	// In case of empty list : RespEntity : send only sts code HTTP sts 204
	// (NO_CONTENT)
	@GetMapping("/{companyName}") // template
	public ResponseEntity<?> getAllFundsByCompany(@PathVariable String companyName) {
		System.out.println("in get funds " + companyName);
		List<Fund> funds = service.listAllFunds(companyName);
		if (funds.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(funds, HttpStatus.OK);

		// @ResponseBody is added implicitly : corresponds to : status | Header/s | body
	}

	// end point to send all funds to the clnt
	@GetMapping
	public List<Fund> getAllFunds() {
		System.out.println("in get all funds");
		return service.getAllFunds();
	}
	//Objective : get fund's details by its id 
	//REST clnt (front end app : currently simulated by Postman) : fund id (how : path var)
	//ResponseEntity 
	@GetMapping("/id/{fundId}")
	public ResponseEntity<?> getFundById(@PathVariable int fundId)
	{
		System.out.println("in get fund id "+fundId);
		Optional<Fund> fund = service.getFundById(fundId);
		if(fund.isPresent())
		//if fund id is valid : ret resp ent + 200 
			 return new ResponseEntity<>(fund.get(),HttpStatus.OK);
		
		//o.w ret sts code 404
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
	}
	//Objective : Company wants to publish new fund in the market
	//Front end ---sends to back end ---json data represeting a resource(Fund) (marshalling/ serilaization)
	//Back end -- un marshalling / de- serial : @ReuqestBody
	@PostMapping
	public ResponseEntity<?> createNewFund(@RequestBody Fund newFund)
	{
		System.out.println("create new fund "+newFund);//transient
		try {
			//what is that u are getting from service layer ,in controller ? : DETACHED
			Fund fund = service.createNewFund(newFund);//changing the state of DETACHED pojo : will not reflect in DB
	//		fund.setPrice(fund.getPrice()+20);
			return new ResponseEntity<> (fund,HttpStatus.CREATED);
		} catch (RuntimeException e) {
			System.out.println("err in create fund"+e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
