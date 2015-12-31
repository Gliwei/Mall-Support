package com.lw.productunit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lw.core.controller.BaseController;
import com.lw.core.service.BaseService;
import com.lw.core.util.Pageable;
import com.lw.productunit.entity.Category;
import com.lw.productunit.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController<Category, Integer>{
	
	@Autowired CategoryService categoryService;

	@RequestMapping("/select/{p}")
	public String select(Model m, @PathVariable("p") Integer pageNo, String f){
		Pageable<Category> pageable = categoryService.findByPage(pageNo);
		m.addAttribute("pageable", pageable);
		m.addAttribute("f", f);
		return "productunit/category-select";
	}
	
	
	@Override
	protected BaseService<Category, Integer> getService() {
		return categoryService;
	}

	@Override
	protected String getEditPage() {
		return "productunit/category";
	}

	@Override
	protected String getListPage() {
		return "productunit/category-list";
	}
	
}
