package com.lw.productunit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lw.core.dao.BaseDao;
import com.lw.core.service.BaseService;
import com.lw.productunit.dao.ProductDao;
import com.lw.productunit.entity.Product;

@Service
public class ProductService extends BaseService<Product, Integer>{
	@Autowired
	ProductDao productDao;

	@Override
	protected BaseDao<Product, Integer> getEntityDao() {
		return productDao;
	}
	
	@Override
	public void save(Product entity) {
		if(entity.isNew()){
			entity.setSpu(System.currentTimeMillis()+""); // TODO SPU生成策略
		}
		super.save(entity);
	}

}
