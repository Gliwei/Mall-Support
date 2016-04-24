package com.lw.productunit.dao;

import org.springframework.stereotype.Repository;

import com.lw.core.dao.BaseDao;
import com.lw.productunit.entity.Product;

@Repository
public class ProductDao extends BaseDao<Product, String> {

	public ProductDao() {
		super(Product.class);
	}

}
