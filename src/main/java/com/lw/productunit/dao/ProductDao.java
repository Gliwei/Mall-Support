package com.lw.productunit.dao;

import org.springframework.stereotype.Repository;

import com.lw.core.dao.BaseDao;
import com.lw.productunit.entity.Product;

@Repository
public class ProductDao extends BaseDao<Product, Integer> {

	public ProductDao() {
		super(Product.class);
	}

}
