package com.lw.productunit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lw.core.dao.BaseDao;
import com.lw.core.service.BaseService;
import com.lw.productunit.dao.PropertyitemDao;
import com.lw.productunit.entity.Propertyitem;

@Service
public class PropertyitemService extends BaseService<Propertyitem, String>{
	@Autowired
	PropertyitemDao propertyitemDao;

	@Override
	protected BaseDao<Propertyitem, String> getEntityDao() {
		return propertyitemDao;
	}

}
