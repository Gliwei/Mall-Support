package com.lw.productunit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lw.core.controller.BaseController;
import com.lw.core.service.BaseService;
import com.lw.productunit.entity.Spec;
import com.lw.productunit.service.SpecService;

@Controller
@RequestMapping("/spec")
public class SpecController extends BaseController<Spec, Integer>{
	
	@Autowired SpecService specService;

	@Override
	protected BaseService<Spec, Integer> getService() {
		return specService;
	}

	@Override
	protected String getEditPage() {
		return "productunit/spec";
	}

	@Override
	protected String getListPage() {
		return "productunit/spec-list";
	}

	@Override
	protected String getSelectPage() {
		return "productunit/spec-select";
	}
	
}
