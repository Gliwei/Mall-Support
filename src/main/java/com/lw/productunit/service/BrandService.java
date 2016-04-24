package com.lw.productunit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lw.core.dao.BaseDao;
import com.lw.core.service.BaseService;
import com.lw.productunit.dao.BrandDao;
import com.lw.productunit.entity.Brand;

@Service
public class BrandService extends BaseService<Brand, String>{
	@Autowired
	BrandDao barndDao;

	@Override
	protected BaseDao<Brand, String> getEntityDao() {
		return barndDao;
	}
	
}
