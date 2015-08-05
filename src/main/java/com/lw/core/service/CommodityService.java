package com.lw.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lw.core.dao.CommodityDao;
import com.lw.core.entity.Commodity;

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
}
