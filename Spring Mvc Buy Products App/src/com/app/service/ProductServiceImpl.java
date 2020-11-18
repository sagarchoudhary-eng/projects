package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IProductDao;
import com.app.pojos.Product;

@Service //mandatory : to tell SC : whatever follows will contain B.L 
@Transactional //mandatory : to tell SC : manage the transactions automatically
public class ProductServiceImpl implements IProductService {
	//dependency : DAO layer i/f
	@Autowired
	private IProductDao dao;

	@Override
	public List<Product> listAllProducts() {
		// invoke dao's method
		return dao.listAllProducts();
	}

}
