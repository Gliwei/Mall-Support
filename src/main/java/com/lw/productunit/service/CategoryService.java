package com.lw.productunit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lw.core.dao.BaseDao;
import com.lw.core.service.BaseService;
import com.lw.productunit.dao.CategoryDao;
import com.lw.productunit.entity.Category;

@Service
public class CategoryService extends BaseService<Category, Integer>{
	@Autowired
	CategoryDao categoryDao;

	@Override
	protected BaseDao<Category, Integer> getEntityDao() {
		return categoryDao;
	}

}
