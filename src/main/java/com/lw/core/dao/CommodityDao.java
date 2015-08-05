package com.lw.core.dao;

import org.springframework.stereotype.Repository;

import com.lw.core.entity.Commodity;

@Repository
public class CommodityDao extends BaseDao<Commodity, Integer> {

	public CommodityDao() {
		super(Commodity.class);
	}

}
