package com.lw.productunit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lw.core.controller.BaseController;
import com.lw.core.service.BaseService;
import com.lw.productunit.entity.Brand;
import com.lw.productunit.service.BrandService;

@Controller
@RequestMapping("/brand")
public class BrandController extends BaseController<Brand, Integer> {
	
	@Autowired BrandService brandService;
	
	@Override
	protected BaseService<Brand, Integer> getService() {
		return brandService;
	}
	@Override
	protected String getEditPage() {
		return "productunit/brand";
	}
	@Override
	protected String getListPage() {
		return "productunit/brand-list";
	}
	
}
