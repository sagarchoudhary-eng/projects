package com.app.dao;

import java.util.List;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Product;

@Repository //to tell SC whatever follows : DAO layer : mandatory
//spring managed bean : singleton n eager : stateless
public class ProductDaoImpl implements IProductDao {
	//dependency : SF : instead of getting single SF from HibernateUtils : tell SC to inject the same 
	@Autowired //autowire=byType (SC tries to find is there any bean which has imple SF : YES , from hibernate perssitence xml )
	private SessionFactory sf;

	@Override
	public List<Product> listAllProducts() {
		String jpql="select p from Product p";
		return sf.getCurrentSession().createQuery(jpql, Product.class).getResultList();
	}

}
