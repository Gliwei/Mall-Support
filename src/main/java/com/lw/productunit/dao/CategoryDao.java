package com.lw.productunit.dao;

import org.springframework.stereotype.Repository;

import com.lw.core.dao.BaseDao;
import com.lw.productunit.entity.Category;

@Repository
public class CategoryDao extends BaseDao<Category, Integer> {

	public CategoryDao() {
		super(Category.class);
	}

}
