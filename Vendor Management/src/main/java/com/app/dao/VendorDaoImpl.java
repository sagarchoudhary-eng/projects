package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Role;
import com.app.pojos.Vendor;

@Repository
public class VendorDaoImpl implements IVendorDao {
	// @PersistenceContext OR

	@Autowired
	private EntityManager mgr;

	@Override
	public List<Vendor> listVendors() {
		String jpql = "select v from Vendor v where v.role=:role";
		return mgr.createQuery(jpql, Vendor.class).setParameter("role", Role.VENDOR).getResultList();
	}

	@Override
	public String deleteVendorDetails(int id) {
		String mesg = "vendor details deletion failed";
		// get vendor details : persistent
		Vendor v = mgr.find(Vendor.class, id);
		if (v != null) {
			//v : PERSISTENT (MANAGED)
			mgr.remove(v);//v : marked for removal
			mesg = "vendor details deleted...";
		}
		return mesg;
	}

	@Override
	public String addVendorDetails(Vendor v) {
		String mesg="vendor registraion successful";
		mgr.persist(v);//v : PERSISTENT
		return mesg;
	}
	

}
