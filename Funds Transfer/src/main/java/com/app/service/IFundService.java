package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Fund;

public interface IFundService {
	List<Fund> listAllFunds(String company);
	List<Fund> getAllFunds();
	Optional<Fund> getFundById(int id);
	Fund createNewFund(Fund f);//i/p : transient POJO (represenation in JSON will be supplied front end)
	//o/p : persistent / managed pojo ref.
	
}
