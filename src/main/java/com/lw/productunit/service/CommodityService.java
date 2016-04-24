package com.lw.productunit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lw.core.dao.BaseDao;
import com.lw.core.service.BaseService;
import com.lw.productunit.dao.CommodityDao;
import com.lw.productunit.entity.Commodity;

@Service
public class CommodityService extends BaseService<Commodity, String>{
	@Autowired
	CommodityDao commodityDao;

	@Override
	protected BaseDao<Commodity, String> getEntityDao() {
		return commodityDao;
	}
	
	@Override
	public void save(Commodity entity) {
		if(entity.isNew()){
			entity.setSku(System.currentTimeMillis()+""+(int)(Math.random()*10000)); // TODO SPU生成策略
		}
		super.save(entity);
	}
}
