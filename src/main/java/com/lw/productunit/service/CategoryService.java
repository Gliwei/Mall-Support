package com.lw.productunit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lw.core.util.Pageable;
import com.lw.productunit.dao.CategoryDao;
import com.lw.productunit.entity.Category;

@Service
public class CategoryService {
	@Autowired
	CategoryDao categoryDao;

	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	public void save(Category category) {
		categoryDao.saveOrUpdate(category);
	}
	
	public Pageable<Category> findByPage(int pageNo){
		Pageable<Category> pageable = new Pageable<Category>(pageNo);
		return categoryDao.findByPage(pageable);
	}

	public Category findById(Integer id) {
		return categoryDao.findById(id);
	}
}
