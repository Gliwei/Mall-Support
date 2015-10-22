package com.lw.productunit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lw.core.util.Pageable;
import com.lw.productunit.dao.BrandDao;
import com.lw.productunit.entity.Brand;

@Service
public class BrandService {
	@Autowired
	BrandDao barndDao;

	public List<Brand> findAll() {
		return barndDao.findAll();
	}

	public void save(Brand Brand) {
		barndDao.saveOrUpdate(Brand);
	}
	
	public Pageable<Brand> findByPage(int pageNo){
		Pageable<Brand> pageable = new Pageable<Brand>(pageNo);
		return barndDao.findByPage(pageable);
	}
	
	public void delete(String brandId){
		// TODO add is visible field
	}
}
