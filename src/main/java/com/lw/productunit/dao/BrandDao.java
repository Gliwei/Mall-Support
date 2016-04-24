package com.lw.productunit.dao;

import org.springframework.stereotype.Repository;

import com.lw.core.dao.BaseDao;
import com.lw.productunit.entity.Brand;

@Repository
public class BrandDao extends BaseDao<Brand, String> {

	public BrandDao() {
		super(Brand.class);
	}

}
