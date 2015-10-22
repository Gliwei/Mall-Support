package com.lw.productunit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lw.core.util.Pageable;
import com.lw.productunit.dao.CommodityDao;
import com.lw.productunit.entity.Commodity;

@Service
public class CommodityService {
	@Autowired
	CommodityDao commodityDao;

	public List<Commodity> findAll() {
		return commodityDao.findAll();
	}

	public void save(Commodity commodity) {
		commodityDao.saveOrUpdate(commodity);
	}
	
	public Pageable<Commodity> findByPage(int pageNo){
		Pageable<Commodity> pageable = new Pageable<Commodity>(pageNo);
		return commodityDao.findByPage(pageable);
	}
}
