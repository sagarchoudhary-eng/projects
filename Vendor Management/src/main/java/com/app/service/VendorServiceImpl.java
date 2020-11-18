package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IVendorDao;
import com.app.pojos.Role;
import com.app.pojos.Vendor;

@Service
@Transactional
public class VendorServiceImpl implements IVendorService{
	//dependency : DAO layer i/f
	@Autowired
	private IVendorDao dao;

	@Override
	public List<Vendor> listVendors() {
		// TODO Auto-generated method stub
		return dao.listVendors();
	}

	@Override
	public String deleteVendorDetails(int id) {
		// TODO Auto-generated method stub
		return dao.deleteVendorDetails(id);
	}

	@Override
	public String addVendorDetails(Vendor v) {
		v.setRole(Role.VENDOR);
		// TODO Auto-generated method stub
		return dao.addVendorDetails(v);
	}
	
	

}
