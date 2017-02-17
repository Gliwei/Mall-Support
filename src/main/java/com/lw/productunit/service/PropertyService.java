package com.lw.productunit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lw.core.dao.BaseDao;
import com.lw.core.service.BaseService;
import com.lw.productunit.dao.PropertyDao;
import com.lw.productunit.entity.Property;

@Service
public class PropertyService extends BaseService<Property, String>{
	@Autowired
	PropertyDao propertyDao;

	@Override
	protected BaseDao<Property, String> getEntityDao() {
		return propertyDao;
	}

	public List<Property> findByProductId(String id) {
		return propertyDao.findByProductId(id);
	}

}
