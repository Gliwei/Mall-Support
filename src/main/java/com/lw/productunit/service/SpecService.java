package com.lw.productunit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lw.core.dao.BaseDao;
import com.lw.core.service.BaseService;
import com.lw.productunit.dao.SpecDao;
import com.lw.productunit.entity.Spec;

@Service
public class SpecService extends BaseService<Spec, Integer>{
	@Autowired
	SpecDao specDao;

	@Override
	protected BaseDao<Spec, Integer> getEntityDao() {
		return specDao;
	}

}
