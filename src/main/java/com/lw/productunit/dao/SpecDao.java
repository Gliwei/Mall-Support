package com.lw.productunit.dao;

import org.springframework.stereotype.Repository;

import com.lw.core.dao.BaseDao;
import com.lw.productunit.entity.Spec;

@Repository
public class SpecDao extends BaseDao<Spec, Integer> {

	public SpecDao() {
		super(Spec.class);
	}

}
