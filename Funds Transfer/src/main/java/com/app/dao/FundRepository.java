package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Fund;

public interface FundRepository extends JpaRepository<Fund,Integer>{
	List<Fund> findByCompany(String compName);
}
