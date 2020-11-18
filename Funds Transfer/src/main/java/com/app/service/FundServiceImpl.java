package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.FundRepository;
import com.app.pojos.Fund;

@Service
@Transactional
public class FundServiceImpl implements IFundService {
	@Autowired
	private FundRepository dao;// NO DAO imple class supplied by prog : Instead auto supplied by Spring Data
								// JPA

	@Override
	public List<Fund> getAllFunds() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<Fund> listAllFunds(String company) {
		return dao.findByCompany(company);
	}

	@Override
	public Optional<Fund> getFundById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Fund createNewFund(Fund f) {
		// service ---> FundRepo's inherited method (from CrudRepo)
		// public <T> T save(T t)

		Fund f2 = dao.save(f);// f2 : PERSISTENT
//		f2.setPrice(f.getPrice() + 50);// updating state of PERSISTENT pojo : hib performs auto dirty chking : upon
		// commit
		/*
		 * if (true) throw new RuntimeException("Some error!!!!!!!"); un comment to
		 * understand Tx
		 */
		return f2;
	}// transactional method rets : tx.commit() -- close session -- dirty chking --l1
		// cache destroyed --cn rets to pool

}
