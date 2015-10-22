package com.lw.productunit.dao;

import org.springframework.stereotype.Repository;

import com.lw.core.dao.BaseDao;
import com.lw.productunit.entity.Commodity;

@Repository
public class CommodityDao extends BaseDao<Commodity, Integer> {

	public CommodityDao() {
		super(Commodity.class);
	}

}
