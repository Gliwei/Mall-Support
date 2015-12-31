package com.lw.productunit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lw.core.controller.BaseController;
import com.lw.core.service.BaseService;
import com.lw.core.util.Pageable;
import com.lw.productunit.entity.Product;
import com.lw.productunit.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController extends BaseController<Product, Integer>{
	
	@Autowired ProductService productService;

	@Override
	protected BaseService<Product, Integer> getService() {
		return productService;
	}

	@Override
	protected String getEditPage() {
		return "productunit/product";
	}

	@Override
	protected String getListPage() {
		return "productunit/product-list";
	}

	@Override
	protected String getSelectPage() {
		return "productunit/product-select";
	}
	
}
