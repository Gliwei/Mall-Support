package com.lw.productunit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lw.core.dao.BaseDao;
import com.lw.core.service.BaseService;
import com.lw.productunit.dao.SpecitemDao;
import com.lw.productunit.entity.Specitem;

@Service
public class SpecitemService extends BaseService<Specitem, String>{
	@Autowired
	SpecitemDao specitemDao;

	@Override
	protected BaseDao<Specitem, String> getEntityDao() {
		return specitemDao;
	}

}
