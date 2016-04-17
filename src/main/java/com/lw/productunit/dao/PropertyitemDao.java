package com.lw.productunit.dao;

import org.springframework.stereotype.Repository;

import com.lw.core.dao.BaseDao;
import com.lw.productunit.entity.Propertyitem;

@Repository
public class PropertyitemDao extends BaseDao<Propertyitem, Integer> {

	public PropertyitemDao() {
		super(Propertyitem.class);
	}

}
