package com.app.dao;

import java.util.List;

import com.app.pojos.Vendor;

public interface IVendorDao {
	List<Vendor> listVendors();
	String deleteVendorDetails(int id);
	String addVendorDetails(Vendor v);
}
