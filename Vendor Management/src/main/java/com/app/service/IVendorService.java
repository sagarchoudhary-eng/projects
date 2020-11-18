package com.app.service;

import java.util.List;

import com.app.pojos.Vendor;

public interface IVendorService {
	List<Vendor> listVendors();
	String deleteVendorDetails(int id);
	String addVendorDetails(Vendor v);
}
