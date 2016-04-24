package com.lw.productunit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lw.core.dao.BaseDao;
import com.lw.core.service.BaseService;
import com.lw.productunit.dao.SpecDao;
import com.lw.productunit.entity.Spec;

@Service
public class SpecService extends BaseService<Spec, String>{
	@Autowired
	SpecDao specDao;

	@Override
	protected BaseDao<Spec, String> getEntityDao() {
		return specDao;
	}

	public List<Spec> findByCategoryId(String id) {
		return specDao.findByCategoryId(id);
	}

}
