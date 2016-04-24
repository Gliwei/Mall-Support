package com.lw.productunit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lw.core.dao.BaseDao;
import com.lw.core.service.BaseService;
import com.lw.productunit.dao.ProductDao;
import com.lw.productunit.entity.Product;

@Service
public class ProductService extends BaseService<Product, String>{
	@Autowired
	ProductDao productDao;

	@Override
	protected BaseDao<Product, String> getEntityDao() {
		return productDao;
	}
	
	@Override
	public void save(Product entity) {
		if(entity.isNew()){
			entity.setSpu(System.currentTimeMillis()+""+(int)(Math.random()*1000)); // TODO SPU生成策略
		}
		super.save(entity);
	}

}
