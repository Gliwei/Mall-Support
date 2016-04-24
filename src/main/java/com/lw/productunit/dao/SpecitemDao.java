package com.lw.productunit.dao;

import org.springframework.stereotype.Repository;

import com.lw.core.dao.BaseDao;
import com.lw.productunit.entity.Specitem;

@Repository
public class SpecitemDao extends BaseDao<Specitem, String> {

	public SpecitemDao() {
		super(Specitem.class);
	}

}
